
#include "syntax_tree_builder.h"
#include <memory>
#include <vector>
using namespace c1_recognizer;
using namespace c1_recognizer::syntax_tree;
using namespace std;

syntax_tree_builder::syntax_tree_builder(error_reporter &_err) : err(_err) {
    
}


antlrcpp::Any syntax_tree_builder::visitCompilationUnit(C1Parser::CompilationUnitContext *ctx)
{
    //cout << "compilation down" <<endl;
    auto result = new assembly;
    result->line = ctx->getStart()->getLine();
    result->pos = ctx->getStart()->getCharPositionInLine();
    int i,j;
    auto childs = ctx->children;
    for(auto child:childs){
        if(auto dchild = dynamic_cast<C1Parser::DeclContext*>(child)){
            auto sb = visit(dchild).as<ptr_list<var_def_stmt_syntax>>();
            //cout << "decl finished1" <<endl;
            for(auto subsb:sb){
                result->global_defs.emplace_back(subsb);
            }
        }
        else if(auto fchild = dynamic_cast<C1Parser::FuncdefContext *>(child)){
            //cout << "funcdef!" << endl;
            result->global_defs.emplace_back(visit(fchild).as<func_def_syntax *>());
            //cout << "funcdef finished1" <<endl;
        }
    }
    return result;
}

antlrcpp::Any syntax_tree_builder::visitDecl(C1Parser::DeclContext *ctx)
{   
    //cout << "decl down" <<endl;
    ptr_list<var_def_stmt_syntax> result;
    if(ctx->constdecl()){
        auto constdecls = visit(ctx->constdecl()).as<vector<var_def_stmt_syntax *>>();
        //cout << "constdecl finished1" <<endl;
        for(auto subconstdecl:constdecls){
            result.emplace_back(subconstdecl);
        }
    }
    else if(ctx->vardecl()){
        auto vardecls = visit(ctx->vardecl()).as<ptr_list<var_def_stmt_syntax>>();
        //cout << "valdecl finished1" <<endl;
        for(auto subvardecl:vardecls){
            result.emplace_back(subvardecl);
        }
    }
    return result;
}

antlrcpp::Any syntax_tree_builder::visitConstdecl(C1Parser::ConstdeclContext *ctx)
{
    //cout << "constdecl down" <<endl;
    vector<var_def_stmt_syntax *> result;
    auto constdefs = ctx->constdef();
    for(auto subconstdef : constdefs){
        result.emplace_back(visit(subconstdef).as<var_def_stmt_syntax *>());
        //cout << "constdef finished1" <<endl;
    }
    
    return result; 
}

antlrcpp::Any syntax_tree_builder::visitConstdef(C1Parser::ConstdefContext *ctx)
{
    //cout << "consdef down" <<endl;
    auto result = new var_def_stmt_syntax;
    result->line = ctx->getStart()->getLine();
    result->pos = ctx->getStart()->getCharPositionInLine();
    if(ctx->Int()==nullptr){
        cout << "Warning at position "+result->line+':'+result->pos+" Concrete type missing for const declaration; integer assumed.";
    }
    auto exps = ctx->exp();
    auto commas = ctx->Comma();
    result->name = ctx->Identifier()->getSymbol()->getText();
    result->is_constant = true;
    if(ctx->LeftBrace()){
        if(exps.size()-commas.size() == 1){
            auto len = new literal_syntax ;
            len->number = exps.size();
            result->array_length.reset(len);
            for (auto subexp:exps){
                ptr<expr_syntax> temp;
                temp.reset(visit(subexp).as<expr_syntax *>());
                //cout << "exp finished1" <<endl;
                result->initializers.push_back(temp);
            }
        }
        else{//without init
            result->array_length.reset(visit(exps[0]).as<expr_syntax *>());
            //cout << "exp finished1" <<endl;
        }
    }

    
    return static_cast<var_def_stmt_syntax *>(result); 
}

antlrcpp::Any syntax_tree_builder::visitVardecl(C1Parser::VardeclContext *ctx)
{
    //cout << "vardecl down" <<endl;
    auto vars = ctx->vardef();
    ptr_list<var_def_stmt_syntax> result;
    for(auto subvar:vars){
        result.emplace_back(visit(subvar).as<var_def_stmt_syntax *>());
        //cout << "var_def finished1" <<endl;
    }
    
    return result;
}

antlrcpp::Any syntax_tree_builder::visitVardef(C1Parser::VardefContext *ctx)
{
    //cout << "vardef down" <<endl;
    auto result = new var_def_stmt_syntax;
    result->is_constant = false;
    result->name = ctx->Identifier()->getSymbol()->getText();
    if(ctx->LeftBrace()){//initializer
        auto exps = ctx->exp();
        auto commas = ctx->Comma();
        if(exps.size()-commas.size() == 1){ //no explicitly declaration the length
            auto len = new literal_syntax ;
            len->number = exps.size();
            //cout << "watch0" << endl;
            result->array_length.reset(len);
            //cout << "watch1" << endl;
            for(auto subexp:exps){
                result->initializers.emplace_back(visit(subexp).as<expr_syntax *>());
                //cout << "watch2" << endl;
            }
        }
        else{
            //cout << "watch3" << endl;
            result->array_length.reset(visit(exps[0]).as<expr_syntax *>());
            //cout << "watch4" << endl;
            for(int i = 1; i < exps.size(); ++i){
                result->initializers.emplace_back(visit(exps[i]).as<expr_syntax *>());
            }
        }
    }
    else if(ctx->LeftBracket()){//array without  init
        result->array_length.reset(visit(ctx->exp()[0]).as<expr_syntax *>());
    }
    else if(ctx->Assign()){
        result->initializers.emplace_back(visit(ctx->exp()[0]).as<expr_syntax *>());
    }
    result->line = ctx->getStart()->getLine();
    result->pos = ctx->getStart()->getCharPositionInLine();
    //cout << "2" << endl;
    return static_cast<var_def_stmt_syntax *>(result); 
}

antlrcpp::Any syntax_tree_builder::visitFuncdef(C1Parser::FuncdefContext *ctx)
{
    //cout << "funcdef down" <<endl;
    auto result = new func_def_syntax;
    result->name = ctx->Identifier()->getSymbol()->getText();
    result->body.reset(visit(ctx->block()).as<block_syntax *>());
    //cout << "funcdef finished1" <<endl;
    result->line = ctx->getStart()->getLine();
    result->pos = ctx->getStart()->getCharPositionInLine();
    return static_cast<func_def_syntax *>(result); 
}

antlrcpp::Any syntax_tree_builder::visitBlock(C1Parser::BlockContext *ctx)
{
    //cout << "block down" <<endl;
    auto result = new block_syntax;
    auto childs = ctx->children;
    for(auto child:childs){
        if(auto dchild = dynamic_cast<C1Parser::DeclContext*>(child)){
            auto temp = visit(dchild).as<ptr_list<var_def_stmt_syntax>>();
            for(auto subtemp:temp){
                result->body.emplace_back(subtemp);
            }
        }
        if(auto schild = dynamic_cast<C1Parser::StmtContext*>(child)){
            result->body.emplace_back(visit(schild).as<stmt_syntax *>());
        }
    }
    result->line = ctx->getStart()->getLine();
    result->pos = ctx->getStart()->getCharPositionInLine();
    //cout << "block finished" <<endl;
    return static_cast<block_syntax *>(result); 
}

antlrcpp::Any syntax_tree_builder::visitStmt(C1Parser::StmtContext *ctx)
{   
    //cout << "stmt down" <<endl;
    if(ctx->Assign()){//assing stmt
        //cout << "assign down" <<endl;
        auto result = new assign_stmt_syntax;
        result->target.reset(visit(ctx->lval()).as<lval_syntax *>());
        result->value.reset(visit(ctx->exp()).as<expr_syntax *>());
        result->line = ctx->getStart()->getLine();
        result->pos = ctx->getStart()->getCharPositionInLine();
        //cout << "assign finished" <<endl;
        return static_cast<stmt_syntax *>(result);
    }
    else if(ctx->Identifier()){//fun_call
        //cout << "fun call down" <<endl;
        auto result = new func_call_stmt_syntax;
        result->name = ctx->Identifier()->getSymbol()->getText();
        result->line = ctx->getStart()->getLine();
        result->pos = ctx->getStart()->getCharPositionInLine();
        
        return static_cast<stmt_syntax *>(result);
    }
    else if(ctx->block()){//block
        //cout << "block stmt down" <<endl;
        auto result = new block_syntax;
        auto temp = visit(ctx->block()).as<block_syntax *>();
        //cout << "block finished1" <<endl;
        for(auto subtemp:temp->body){
            result->body.emplace_back(subtemp);
        }
        result->line = ctx->getStart()->getLine();
        result->pos = ctx->getStart()->getCharPositionInLine();
        
        return static_cast<stmt_syntax *>(result);
    }
    else if(ctx->If()){
        //cout << "if stmt down" <<endl;
        auto result = new if_stmt_syntax;
        auto substmt = ctx->stmt();
        result->pred.reset(visit(ctx->cond()).as<cond_syntax *>());
        result->then_body.reset(visit(substmt[0]).as<stmt_syntax *>());
        if(ctx->Else()){
            result->else_body.reset(visit(substmt[1]).as<stmt_syntax *>());
        }
        else result->else_body = nullptr;
        result->line = ctx->getStart()->getLine();
        result->pos = ctx->getStart()->getCharPositionInLine();
        
        return static_cast<stmt_syntax *>(result);
    }
    else if(ctx->While()){
        //cout << "while stmt down" <<endl;
        auto result = new while_stmt_syntax;
        result->pred.reset(visit(ctx->cond()).as<cond_syntax *>());
        //cout << "fuck" << endl;
        result->body.reset(visit(ctx->stmt()[0]).as<stmt_syntax *>());
        result->line = ctx->getStart()->getLine();
        result->pos = ctx->getStart()->getCharPositionInLine();
        
        return static_cast<stmt_syntax *>(result);
    }
    else {
        //cout << "empty stmt down" <<endl;
        auto result = new empty_stmt_syntax;
        result->line = ctx->getStart()->getLine();
        result->pos = ctx->getStart()->getCharPositionInLine();
        
        return static_cast<stmt_syntax *>(result);
    }
}

antlrcpp::Any syntax_tree_builder::visitLval(C1Parser::LvalContext *ctx)
{
    //cout << "lval down" <<endl;
    auto result = new lval_syntax;
    result->line = ctx->getStart()->getLine();
    result->pos = ctx->getStart()->getCharPositionInLine();

    if (ctx->LeftBracket()){
        result->name = ctx->Identifier()->getSymbol()->getText();
        result->array_index.reset(visit(ctx->exp()).as<expr_syntax*>());
    }
    else{
        result->name = ctx->Identifier()->getSymbol()->getText();
        result->array_index = nullptr;
    }
    //cout << "lval finished" <<endl;
    return static_cast<lval_syntax *>(result);
}

antlrcpp::Any syntax_tree_builder::visitCond(C1Parser::CondContext *ctx)
{
    //cout << "cond down" <<endl;
    auto Expressions = ctx->exp();
    auto result = new cond_syntax;
    result->line = ctx->getStart()->getLine();
    result->pos = ctx->getStart()->getCharPositionInLine();

    result->lhs.reset(visit(Expressions[0]).as<expr_syntax*>());
    result->rhs.reset(visit(Expressions[1]).as<expr_syntax*>());
    if(ctx->Equal()){
        result->op = relop::equal;
    }
    else if(ctx->NonEqual()){
        result->op = relop::non_equal;
    }
    else if(ctx->Less()){
        result->op = relop::less;
    }
    else if(ctx->Greater()){
        result->op = relop::greater;
    }
    else if(ctx->LessEqual()){
        result->op = relop::less_equal;
    }
    else if(ctx->GreaterEqual()){
        result->op = relop::greater_equal;
    }
    
    return static_cast<cond_syntax *>(result);
}

// Returns antlrcpp::Any, which is constructable from any type.
// However, you should be sure you use the same type for packing and depacking the `Any` object.
// Or a std::bad_cast exception will rise.
// This function always returns an `Any` object containing a `expr_syntax *`.
antlrcpp::Any syntax_tree_builder::visitExp(C1Parser::ExpContext *ctx)
{
    //cout << "exp down" <<endl;
    // Get all sub-contexts of type `exp`.
    auto expressions = ctx->exp();
    // Two sub-expressions presented: this indicates it's a expression of binary operator, aka `binop`.
    if (expressions.size() == 2) 
    {
        auto result = new binop_expr_syntax;   
        // Set line and pos.
        result->line = ctx->getStart()->getLine(); 
        result->pos = ctx->getStart()->getCharPositionInLine();
        // visit(some context) is equivalent to calling corresponding visit method; dispatching is done automatically
        // by ANTLR4 runtime. For this case, it's equivalent to visitExp(expressions[0]).
        // Use reset to set a new pointer to a std::shared_ptr object. DO NOT use assignment; it won't work.
        // Use `.as<Type>()' to get value from antlrcpp::Any object; notice that this Type must match the type used in
        // constructing the Any object, awhich is constructed from (usually pointer to some derived class of
        // syntax_node, in this case) returning value of the visit call.
        result->lhs.reset(visit(expressions[0]).as<expr_syntax *>());   //left_recur 处理非终结符用visit，返回给左变量
        // Check if each token exists.
        // Returnd value of the calling will be nullptr (aka NULL in C) if it isn't there; otherwise non-null pointer.
        if (ctx->Plus())    //judge if the subtree has the op
            result->op = binop::plus;
        if (ctx->Minus())
            result->op = binop::minus;
        if (ctx->Multiply())
            result->op = binop::multiply;
        if (ctx->Divide())
            result->op = binop::modulo;
        result->rhs.reset(visit(expressions[1]).as<expr_syntax *>());   //  visit oprand of exp
        
        return static_cast<expr_syntax *>(result);  //change the result to the expr_syntax 
    }
    // Otherwise, if `+` or `-` presented, it'll be a `unaryop_expr_syntax`.
    if (ctx->Plus() || ctx->Minus())
    {
        //cout << "bin op down" <<endl;
        auto result = new unaryop_expr_syntax;
        result->line = ctx->getStart()->getLine();
        result->pos = ctx->getStart()->getCharPositionInLine();
        if (ctx->Plus())
            result->op = unaryop::plus;
        if (ctx->Minus())
            result->op = unaryop::minus;
        result->rhs.reset(visit(expressions[0]).as<expr_syntax *>());
        
        return static_cast<expr_syntax *>(result);
    }
    // In the case that `(` exists as a child, this is an expression like `'(' expressions[0] ')'`.
    if (ctx->LeftParen()){
        //cout << "paren exp down" <<endl;
        return visit(expressions[0]);
     } // Any already holds expr_syntax* here, no need for dispatch and re-patch with casting.
    // If `Number` exists as a child, we can say it's a literal integer expression.
    if (auto number = ctx->Number())
    {
        //cout << "number down" <<endl;
        auto result = new literal_syntax;
        result->line = number->getSymbol()->getLine();
        result->pos = number->getSymbol()->getCharPositionInLine();
        auto text = number->getSymbol()->getText();
        if (text[0] == '0' && text[1] == 'x')              // Hexadecimal
            result->number = std::stoi(text, nullptr, 16); // std::stoi will eat '0x'
        else                                               // Decimal
            result->number = std::stoi(text, nullptr, 10);
        
        return static_cast<expr_syntax *>(result);
    }
    if(ctx->lval()){
        //cout << "lval exp  down" <<endl;
        auto result = new lval_syntax;
        auto temp = visit(ctx->lval()).as<lval_syntax *>();
        result->name = temp->name;
        result->array_index = temp->array_index;
        result->line = temp->line;
        result->pos = temp->pos;
        
        return static_cast<expr_syntax *>(result);
    }
        
}

ptr<syntax_tree_node> syntax_tree_builder::operator()(antlr4::tree::ParseTree *ctx)
{
    auto result = visit(ctx);
    if (result.is<syntax_tree_node *>())
        return ptr<syntax_tree_node>(result.as<syntax_tree_node *>());
    if (result.is<assembly *>())
        return ptr<syntax_tree_node>(result.as<assembly *>());
    if (result.is<global_def_syntax *>())
        return ptr<syntax_tree_node>(result.as<global_def_syntax *>());
    if (result.is<func_def_syntax *>())
        return ptr<syntax_tree_node>(result.as<func_def_syntax *>());
    if (result.is<cond_syntax *>()) 
        return ptr<syntax_tree_node>(result.as<cond_syntax *>());
    if (result.is<expr_syntax *>())
        return ptr<syntax_tree_node>(result.as<expr_syntax *>());
    if (result.is<binop_expr_syntax *>())
        return ptr<syntax_tree_node>(result.as<binop_expr_syntax *>());
    if (result.is<unaryop_expr_syntax *>())
        return ptr<syntax_tree_node>(result.as<unaryop_expr_syntax *>());
    if (result.is<lval_syntax *>())
        return ptr<syntax_tree_node>(result.as<lval_syntax *>());
    if (result.is<literal_syntax *>())
        return ptr<syntax_tree_node>(result.as<literal_syntax *>());
    if (result.is<stmt_syntax *>())
        return ptr<syntax_tree_node>(result.as<stmt_syntax *>());
    if (result.is<var_def_stmt_syntax *>())
        return ptr<syntax_tree_node>(result.as<var_def_stmt_syntax *>());
    if (result.is<assign_stmt_syntax *>())
        return ptr<syntax_tree_node>(result.as<assign_stmt_syntax *>());
    if (result.is<func_call_stmt_syntax *>())
        return ptr<syntax_tree_node>(result.as<func_call_stmt_syntax *>());
    if (result.is<block_syntax *>())
        return ptr<syntax_tree_node>(result.as<block_syntax *>());
    if (result.is<if_stmt_syntax *>())
        return ptr<syntax_tree_node>(result.as<if_stmt_syntax *>());
    if (result.is<while_stmt_syntax *>())
        return ptr<syntax_tree_node>(result.as<while_stmt_syntax *>());
    return nullptr;
}
