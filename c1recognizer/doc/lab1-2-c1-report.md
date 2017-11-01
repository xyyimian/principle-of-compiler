# Lab1-2-c1 Report
## The answer to the questions
1. antlr4 supports the direct leftrecursive such as
```
exp : exp'a' | 'a'
```

2. antlr4 process the leftrecursive according to the sequence of the sign.
- for the first situation, the precedence of '\*' is higher than '+', so in the AST the level of '\*' is deeper than '+'
- for the second situation, the precedence of '+' is higher than '\*', so in the AST the level of '+' is deeper than '\*'

3. There are two types of leftrecursive which are direct leftrecursive and indirect recursive .
- The direct leftrecursive like``` exp : exp 'a' | 'a' ```can be analyzed but sentence like ``` exp : exp? 'a' ```can't be analyzed.
- The indirect leftrecursive can't be analyzed. For example
```
signa: 'a'signb | signb'b' ;

signb: signa'c' | 'd' ;
```
The complier prints "The following sets of rules are mutually left-recursive [ ]"

4. ANTLR rewrites left-recursive to be non-left recursive and unambiguous using semantic predicates. It established an array to store relations of expansion. Only high-precedence exp can be expanded into low-precedence exp and the precendence is determined by the sequenced they are listed. The former has higher precedence.


## Design
- Part 1
	The gitbook provides EBNF descriptions of C1 language. So we only need to translate EBNF expressions into g4 expressions and fill in the definitions.
- Part 2
	We need add additional three grammar files. We can amalgamate lexer and parser into one grammar file. The file consists of two parts: header "grammar Name" and the definitions of tokens.
	As for the UnsupportedLeftRecursive file, I can only think out two situations, which are listed above.

## The problems encountered
1. I found a mistake in my C1Lexer file. I add a token "Letter_" to help express token Identifier. 
```
Letter_ : [a-zA-Z_] ;
Identifier: Letter_(Letter_ | [0-9])*;
```
But I found the array name 'a' of "int a[ ]" is analyzed as Letter_ rather than Identifier!
That concludes that I can't let two tokens have something in common or else the complier will be puzzled.
2. When I compile MultFirst and PlusFirst files, the complier give an error. I delete all the intermediate files and recomplile the that succeeded.

## Results
All the test cases can be processed and the results showed in png is placed in ./pic
- PlusFirst.png, MultFirst.png are results use seperate grammar file to prceed prio_test.c1.
- simple1.png and right_sample.png shows results of processing simple.c1 and right_sample.c1 utilizing C1parser.g4
- ULR.png shows the error message when providing UnsupportedLeftRecursive.g4
