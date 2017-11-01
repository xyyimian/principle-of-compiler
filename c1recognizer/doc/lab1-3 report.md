# lab1-3实验报告
## 实验要求
* 阅读Syntax.h,获取要使用的数据结构
* 阅读antlr生成的源代码，获取父类的数据结构以及ctx的结构
* 根据ctx结构，根据访问者模式编写syntax_tree_builder.cpp文件，填充各个函数，完成对ctx的访问，从结点中获取信息并返回结果
* 更改C1_recognizer.cpp，使antlr的分析从compliationUnit开始

## 实验设计和流程
* 首先看visitexp函数，得知访问者模式下需要完成的任务有：
** 根据ctx树的类型，获取ctx的子结点，其中ctx的接口函数和成员变量可以在C1Parser.cpp中找到（或在其更往上的父类中找到）
** 根据ctx的类型，进行预测分析操作，比如判断exp的不同情形，并new一个result相应的数据结构变量，保存ctx树上的信息
** 保存的信息有pos（字符位置），line（所在行）,对ctx的子结点，递归调用访问者模式获取信息
** 由于visit的返回结果是始终是一个公用体，用as提取出公用体的类型，并用reset或emplace_pushback进行share_ptr的赋值
** 如果visit返回的值是一个vector，注意要遍历vector获取元素信息，push到new的vector中
* 自下向上书写填充其余函数，需要注意的点有：
** 对于result类型的选取，要选能fit填充结点信息的
** 对于result返回值类型的选取，如果VISITxxx所调用的类型就是new的类型，直接返回，如果VISITxxx实际访问的是new的父类，强制转化为父类后返回
** 对于name，array_length等成员变量，查看ctx的父类中的接口函数getSymbol，getText获取信息
** ctx的子树是单个元素还是数组是取决于文法中产生式右边是否可能出现多个该元素（如stmt）。当右边只会有一个该种元素时，可以直接visit，否则就要遍历地visit
** 判断数组的长度是否显式声明的情形，根据逗号是否比exp少1，则数组非显式声明长度，否则数组显式声明长度，且为第一个exp，对于非显式声明长度的，用literal_syntax保存值后继承expr_syntax返回
**　助教给的visitexp缺少lval的访问，需要补充
** 对于子结点类型不同且可能交替出现的情况，比如complitionUnit，Decl和Fun_def可能交替出现，注意到ctx有成员变量children，其按文本上下文序存放这两种类型的变量，可以用dynamic_cast是否成功的方法鉴别节点类型，并保证visit访问的上下文顺序
** 对于结点的访问只需要调用visit，而不需要调用自己写的visitxxx，因为前者会被自动dispatch成后者
* 如何debug
** 先处理编译错误
** visit采用的方式为递归，可以在进入函数和返回函数各设置一个cout，这样在分析时异常即可定位
** 之后将自己生成的c1r_test来测试生成文件的输出，再用标准c1r_test测试文件，将两个文件diff，判别错误位置

##重点和难点及思考题
###和lab1-2 文法的关系
lab1-2中写的是parser文件，parser文件会给lab1-3生成parser.cpp等文件，这些为其生成ctx树，具体来说，
1. 文法的左部非终结符生成树的内部结点，右部产生式符号作为左边的子树结点
2. 标签来生成enter和exit，并且可以在其中定义遍历树时的操作
3. 所有的左部非终结符都作为右部非终结符的父类

##思考题
* ATN 全称Augmented Transition Network，ATN就是用上下文无关文法的扩充来实现上下文相关文法。ATN是自然语言语法的一种多功能表示及语言自动分析的一种崭新的方法，ANT对自然语言处理领域产生了重要影响，并曾成功地应用于有限领域的问题应答系统中，如LUNAR程序。
* SLL等价于LL，S表示simple，因为自上而下文法不支持左递归和二义，所以SLL和LL相同；ALL(*)是Adaptive ALL.
##异常处理
需要更改两处，首先将文法中const后面的声明符int设置为可选？；之后在constdef（）中

