// Generated from C1Parser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class C1Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Comma=1, SemiColon=2, Assign=3, LeftBracket=4, RightBracket=5, LeftBrace=6, 
		RightBrace=7, LeftParen=8, RightParen=9, If=10, Else=11, While=12, Const=13, 
		Equal=14, NonEqual=15, Less=16, Greater=17, LessEqual=18, GreaterEqual=19, 
		Plus=20, Minus=21, Multiply=22, Divide=23, Modulo=24, Int=25, Void=26, 
		Identifier=27, Number=28, WhiteSpace=29, Newline=30, Comment=31;
	public static final int
		RULE_compilationUnit = 0, RULE_decl = 1, RULE_constdecl = 2, RULE_constdef = 3, 
		RULE_vardecl = 4, RULE_vardef = 5, RULE_funcdef = 6, RULE_block = 7, RULE_stmt = 8, 
		RULE_lval = 9, RULE_cond = 10, RULE_exp = 11;
	public static final String[] ruleNames = {
		"compilationUnit", "decl", "constdecl", "constdef", "vardecl", "vardef", 
		"funcdef", "block", "stmt", "lval", "cond", "exp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "';'", "'='", "'['", "']'", "'{'", "'}'", "'('", "')'", "'if'", 
		"'else'", "'while'", "'const'", "'=='", "'!='", "'<'", "'>'", "'<='", 
		"'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'int'", "'void'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Comma", "SemiColon", "Assign", "LeftBracket", "RightBracket", "LeftBrace", 
		"RightBrace", "LeftParen", "RightParen", "If", "Else", "While", "Const", 
		"Equal", "NonEqual", "Less", "Greater", "LessEqual", "GreaterEqual", "Plus", 
		"Minus", "Multiply", "Divide", "Modulo", "Int", "Void", "Identifier", 
		"Number", "WhiteSpace", "Newline", "Comment"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "C1Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public C1Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompilationUnitContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<FuncdefContext> funcdef() {
			return getRuleContexts(FuncdefContext.class);
		}
		public FuncdefContext funcdef(int i) {
			return getRuleContext(FuncdefContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).exitCompilationUnit(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(26);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Const:
				case Int:
					{
					setState(24);
					decl();
					}
					break;
				case Void:
					{
					setState(25);
					funcdef();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Int) | (1L << Void))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public ConstdeclContext constdecl() {
			return getRuleContext(ConstdeclContext.class,0);
		}
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Const:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				constdecl();
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				vardecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstdeclContext extends ParserRuleContext {
		public TerminalNode Const() { return getToken(C1Parser.Const, 0); }
		public TerminalNode Int() { return getToken(C1Parser.Int, 0); }
		public List<ConstdefContext> constdef() {
			return getRuleContexts(ConstdefContext.class);
		}
		public ConstdefContext constdef(int i) {
			return getRuleContext(ConstdefContext.class,i);
		}
		public TerminalNode SemiColon() { return getToken(C1Parser.SemiColon, 0); }
		public List<TerminalNode> Comma() { return getTokens(C1Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C1Parser.Comma, i);
		}
		public ConstdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).enterConstdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).exitConstdecl(this);
		}
	}

	public final ConstdeclContext constdecl() throws RecognitionException {
		ConstdeclContext _localctx = new ConstdeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(Const);
			setState(35);
			match(Int);
			setState(36);
			constdef();
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(37);
				match(Comma);
				setState(38);
				constdef();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstdefContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(C1Parser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(C1Parser.Assign, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode LeftBracket() { return getToken(C1Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(C1Parser.RightBracket, 0); }
		public TerminalNode LeftBrace() { return getToken(C1Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(C1Parser.RightBrace, 0); }
		public List<TerminalNode> Comma() { return getTokens(C1Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C1Parser.Comma, i);
		}
		public ConstdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).enterConstdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).exitConstdef(this);
		}
	}

	public final ConstdefContext constdef() throws RecognitionException {
		ConstdefContext _localctx = new ConstdefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constdef);
		int _la;
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(Identifier);
				setState(47);
				match(Assign);
				setState(48);
				exp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				match(Identifier);
				setState(50);
				match(LeftBracket);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LeftParen) | (1L << Plus) | (1L << Minus) | (1L << Identifier) | (1L << Number))) != 0)) {
					{
					setState(51);
					exp(0);
					}
				}

				setState(54);
				match(RightBracket);
				setState(55);
				match(Assign);
				setState(56);
				match(LeftBrace);
				setState(57);
				exp(0);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(58);
					match(Comma);
					setState(59);
					exp(0);
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				match(RightBrace);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(C1Parser.Int, 0); }
		public List<VardefContext> vardef() {
			return getRuleContexts(VardefContext.class);
		}
		public VardefContext vardef(int i) {
			return getRuleContext(VardefContext.class,i);
		}
		public TerminalNode SemiColon() { return getToken(C1Parser.SemiColon, 0); }
		public List<TerminalNode> Comma() { return getTokens(C1Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C1Parser.Comma, i);
		}
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).enterVardecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).exitVardecl(this);
		}
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_vardecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(Int);
			setState(70);
			vardef();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(71);
				match(Comma);
				setState(72);
				vardef();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardefContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(C1Parser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(C1Parser.Assign, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode LeftBracket() { return getToken(C1Parser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(C1Parser.RightBracket, 0); }
		public TerminalNode LeftBrace() { return getToken(C1Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(C1Parser.RightBrace, 0); }
		public List<TerminalNode> Comma() { return getTokens(C1Parser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(C1Parser.Comma, i);
		}
		public VardefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).enterVardef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).exitVardef(this);
		}
	}

	public final VardefContext vardef() throws RecognitionException {
		VardefContext _localctx = new VardefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_vardef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(Identifier);
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Assign:
				{
				setState(81);
				match(Assign);
				setState(82);
				exp(0);
				}
				break;
			case LeftBracket:
				{
				setState(83);
				match(LeftBracket);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LeftParen) | (1L << Plus) | (1L << Minus) | (1L << Identifier) | (1L << Number))) != 0)) {
					{
					setState(84);
					exp(0);
					}
				}

				setState(87);
				match(RightBracket);
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Assign) {
					{
					setState(88);
					match(Assign);
					setState(89);
					match(LeftBrace);
					setState(90);
					exp(0);
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(91);
						match(Comma);
						setState(92);
						exp(0);
						}
						}
						setState(97);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(98);
					match(RightBrace);
					}
				}

				}
				break;
			case Comma:
			case SemiColon:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncdefContext extends ParserRuleContext {
		public TerminalNode Void() { return getToken(C1Parser.Void, 0); }
		public TerminalNode Identifier() { return getToken(C1Parser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(C1Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(C1Parser.RightParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).enterFuncdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).exitFuncdef(this);
		}
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(Void);
			setState(105);
			match(Identifier);
			setState(106);
			match(LeftParen);
			setState(107);
			match(RightParen);
			setState(108);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(C1Parser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(C1Parser.RightBrace, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(LeftBrace);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SemiColon) | (1L << LeftBrace) | (1L << If) | (1L << While) | (1L << Const) | (1L << Int) | (1L << Identifier))) != 0)) {
				{
				setState(113);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Const:
				case Int:
					{
					setState(111);
					decl();
					}
					break;
				case SemiColon:
				case LeftBrace:
				case If:
				case While:
				case Identifier:
					{
					setState(112);
					stmt();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public TerminalNode Assign() { return getToken(C1Parser.Assign, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(C1Parser.SemiColon, 0); }
		public TerminalNode Identifier() { return getToken(C1Parser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(C1Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(C1Parser.RightParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode If() { return getToken(C1Parser.If, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode Else() { return getToken(C1Parser.Else, 0); }
		public TerminalNode While() { return getToken(C1Parser.While, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmt);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				lval();
				setState(121);
				match(Assign);
				setState(122);
				exp(0);
				setState(123);
				match(SemiColon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(Identifier);
				setState(126);
				match(LeftParen);
				setState(127);
				match(RightParen);
				setState(128);
				match(SemiColon);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				block();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(If);
				setState(131);
				match(LeftParen);
				setState(132);
				cond();
				setState(133);
				match(RightParen);
				setState(134);
				stmt();
				setState(137);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(135);
					match(Else);
					setState(136);
					stmt();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(139);
				match(While);
				setState(140);
				match(LeftParen);
				setState(141);
				cond();
				setState(142);
				match(RightParen);
				setState(143);
				stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(145);
				match(SemiColon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LvalContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(C1Parser.Identifier, 0); }
		public TerminalNode LeftBracket() { return getToken(C1Parser.LeftBracket, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(C1Parser.RightBracket, 0); }
		public LvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).enterLval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).exitLval(this);
		}
	}

	public final LvalContext lval() throws RecognitionException {
		LvalContext _localctx = new LvalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(Identifier);
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(149);
				match(LeftBracket);
				setState(150);
				exp(0);
				setState(151);
				match(RightBracket);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode Equal() { return getToken(C1Parser.Equal, 0); }
		public TerminalNode NonEqual() { return getToken(C1Parser.NonEqual, 0); }
		public TerminalNode Less() { return getToken(C1Parser.Less, 0); }
		public TerminalNode Greater() { return getToken(C1Parser.Greater, 0); }
		public TerminalNode LessEqual() { return getToken(C1Parser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(C1Parser.GreaterEqual, 0); }
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).exitCond(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			exp(0);
			setState(156);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Equal) | (1L << NonEqual) | (1L << Less) | (1L << Greater) | (1L << LessEqual) | (1L << GreaterEqual))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(157);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode Plus() { return getToken(C1Parser.Plus, 0); }
		public TerminalNode Minus() { return getToken(C1Parser.Minus, 0); }
		public TerminalNode LeftParen() { return getToken(C1Parser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(C1Parser.RightParen, 0); }
		public TerminalNode Number() { return getToken(C1Parser.Number, 0); }
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public TerminalNode Multiply() { return getToken(C1Parser.Multiply, 0); }
		public TerminalNode Divide() { return getToken(C1Parser.Divide, 0); }
		public TerminalNode Modulo() { return getToken(C1Parser.Modulo, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C1ParserListener ) ((C1ParserListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Plus:
			case Minus:
				{
				setState(160);
				_la = _input.LA(1);
				if ( !(_la==Plus || _la==Minus) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(161);
				exp(4);
				}
				break;
			case LeftParen:
				{
				setState(162);
				match(LeftParen);
				setState(163);
				exp(0);
				setState(164);
				match(RightParen);
				}
				break;
			case Number:
				{
				setState(166);
				match(Number);
				}
				break;
			case Identifier:
				{
				setState(167);
				lval();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(176);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(170);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(171);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Multiply) | (1L << Divide) | (1L << Modulo))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(172);
						exp(7);
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(173);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(174);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(175);
						exp(6);
						}
						break;
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00b8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\6\2\35\n\2\r\2\16\2\36\3\3\3\3\5\3#\n\3\3"+
		"\4\3\4\3\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\5\5\67\n\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5?\n\5\f\5\16\5B\13\5\3\5\3"+
		"\5\5\5F\n\5\3\6\3\6\3\6\3\6\7\6L\n\6\f\6\16\6O\13\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\5\7X\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7`\n\7\f\7\16\7c\13\7\3"+
		"\7\3\7\5\7g\n\7\5\7i\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\tt\n\t"+
		"\f\t\16\tw\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u008c\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0095"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\5\13\u009c\n\13\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ab\n\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r"+
		"\u00b3\n\r\f\r\16\r\u00b6\13\r\3\r\2\3\30\16\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\2\5\3\2\20\25\3\2\26\27\3\2\30\32\2\u00c6\2\34\3\2\2\2\4\"\3\2\2\2"+
		"\6$\3\2\2\2\bE\3\2\2\2\nG\3\2\2\2\fR\3\2\2\2\16j\3\2\2\2\20p\3\2\2\2\22"+
		"\u0094\3\2\2\2\24\u0096\3\2\2\2\26\u009d\3\2\2\2\30\u00aa\3\2\2\2\32\35"+
		"\5\4\3\2\33\35\5\16\b\2\34\32\3\2\2\2\34\33\3\2\2\2\35\36\3\2\2\2\36\34"+
		"\3\2\2\2\36\37\3\2\2\2\37\3\3\2\2\2 #\5\6\4\2!#\5\n\6\2\" \3\2\2\2\"!"+
		"\3\2\2\2#\5\3\2\2\2$%\7\17\2\2%&\7\33\2\2&+\5\b\5\2\'(\7\3\2\2(*\5\b\5"+
		"\2)\'\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7\4"+
		"\2\2/\7\3\2\2\2\60\61\7\35\2\2\61\62\7\5\2\2\62F\5\30\r\2\63\64\7\35\2"+
		"\2\64\66\7\6\2\2\65\67\5\30\r\2\66\65\3\2\2\2\66\67\3\2\2\2\678\3\2\2"+
		"\289\7\7\2\29:\7\5\2\2:;\7\b\2\2;@\5\30\r\2<=\7\3\2\2=?\5\30\r\2><\3\2"+
		"\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CD\7\t\2\2DF\3\2"+
		"\2\2E\60\3\2\2\2E\63\3\2\2\2F\t\3\2\2\2GH\7\33\2\2HM\5\f\7\2IJ\7\3\2\2"+
		"JL\5\f\7\2KI\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2"+
		"PQ\7\4\2\2Q\13\3\2\2\2Rh\7\35\2\2ST\7\5\2\2Ti\5\30\r\2UW\7\6\2\2VX\5\30"+
		"\r\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2Yf\7\7\2\2Z[\7\5\2\2[\\\7\b\2\2\\a\5"+
		"\30\r\2]^\7\3\2\2^`\5\30\r\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b"+
		"d\3\2\2\2ca\3\2\2\2de\7\t\2\2eg\3\2\2\2fZ\3\2\2\2fg\3\2\2\2gi\3\2\2\2"+
		"hS\3\2\2\2hU\3\2\2\2hi\3\2\2\2i\r\3\2\2\2jk\7\34\2\2kl\7\35\2\2lm\7\n"+
		"\2\2mn\7\13\2\2no\5\20\t\2o\17\3\2\2\2pu\7\b\2\2qt\5\4\3\2rt\5\22\n\2"+
		"sq\3\2\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2"+
		"xy\7\t\2\2y\21\3\2\2\2z{\5\24\13\2{|\7\5\2\2|}\5\30\r\2}~\7\4\2\2~\u0095"+
		"\3\2\2\2\177\u0080\7\35\2\2\u0080\u0081\7\n\2\2\u0081\u0082\7\13\2\2\u0082"+
		"\u0095\7\4\2\2\u0083\u0095\5\20\t\2\u0084\u0085\7\f\2\2\u0085\u0086\7"+
		"\n\2\2\u0086\u0087\5\26\f\2\u0087\u0088\7\13\2\2\u0088\u008b\5\22\n\2"+
		"\u0089\u008a\7\r\2\2\u008a\u008c\5\22\n\2\u008b\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u0095\3\2\2\2\u008d\u008e\7\16\2\2\u008e\u008f\7\n\2\2"+
		"\u008f\u0090\5\26\f\2\u0090\u0091\7\13\2\2\u0091\u0092\5\22\n\2\u0092"+
		"\u0095\3\2\2\2\u0093\u0095\7\4\2\2\u0094z\3\2\2\2\u0094\177\3\2\2\2\u0094"+
		"\u0083\3\2\2\2\u0094\u0084\3\2\2\2\u0094\u008d\3\2\2\2\u0094\u0093\3\2"+
		"\2\2\u0095\23\3\2\2\2\u0096\u009b\7\35\2\2\u0097\u0098\7\6\2\2\u0098\u0099"+
		"\5\30\r\2\u0099\u009a\7\7\2\2\u009a\u009c\3\2\2\2\u009b\u0097\3\2\2\2"+
		"\u009b\u009c\3\2\2\2\u009c\25\3\2\2\2\u009d\u009e\5\30\r\2\u009e\u009f"+
		"\t\2\2\2\u009f\u00a0\5\30\r\2\u00a0\27\3\2\2\2\u00a1\u00a2\b\r\1\2\u00a2"+
		"\u00a3\t\3\2\2\u00a3\u00ab\5\30\r\6\u00a4\u00a5\7\n\2\2\u00a5\u00a6\5"+
		"\30\r\2\u00a6\u00a7\7\13\2\2\u00a7\u00ab\3\2\2\2\u00a8\u00ab\7\36\2\2"+
		"\u00a9\u00ab\5\24\13\2\u00aa\u00a1\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00b4\3\2\2\2\u00ac\u00ad\f\b\2\2\u00ad"+
		"\u00ae\t\4\2\2\u00ae\u00b3\5\30\r\t\u00af\u00b0\f\7\2\2\u00b0\u00b1\t"+
		"\3\2\2\u00b1\u00b3\5\30\r\b\u00b2\u00ac\3\2\2\2\u00b2\u00af\3\2\2\2\u00b3"+
		"\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\31\3\2\2"+
		"\2\u00b6\u00b4\3\2\2\2\26\34\36\"+\66@EMWafhsu\u008b\u0094\u009b\u00aa"+
		"\u00b2\u00b4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}