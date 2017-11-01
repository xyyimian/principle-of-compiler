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