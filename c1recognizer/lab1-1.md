## 1.problems and solutions
* The first problem is the process of CRLF. For windows, linux and mac they have three diffrent expressions of newline. For windows it is '\r\n',for linux '\n' and for max '\r'. So I design the regex ('\r\n' | '\n' | '\r') and so '\r\n' has higher priority. So if there is a '\n' just comes with '\r', it will matches.
* The second problem is the process of comment. The comment's type of "/**/" is easy because '/*' always matches with the first '*/', so let (.*?) before '*/' can solve that. As the comment "//", it has a attribution which is the effect scale continues with '\' as the last character and ends with the first newline it meeets. So the regex is as follows:(.*?)to match normal characters, and '\\'Newline(.*?) to neutralize the newline after '\\' and continue the effect scale. At the same time, '\\' can be many so the part of regex should be ('\\'Newline(.*?))*  .After that, the comment ends with Newline.
* The third bug I found is I forgot to add the sign before 'Number'. Syntactic units such as '+1', '-1' should pertain to 'Number'.
## 2.Some analysis and enlightments.
* The reason why the regex for commment is more complex is the effect scale of comment is larger. The lexer essentially partition the code text to diffrent tokens. So if you want to partition different sentences in a one line, you should use ';' like C; On the contrast if you want to omit ';', you should utilize newline to partition statements like python which means no two statements in one line.
* It seems that for C ';' ensures the statement is continuous. But in fact only if the token is complete and continuous in whole , the statement can be written in any form.

I tested a program as followed:
```

#include <stdio.h>
int main() {
int 
i
=
0
;
printf
(
"%d"
,
i
)
;
}

```

and it passed the complier.

## About the positive examples and counter-examples
* declarations.c1 tests the id of vars and array. And also some tokens like 'const'
* expr.c1 tests various oprands, the sign before a number and id as parameters.
* lexical_tokens.c1 tests about the comments, some tokens and a 16-based number as well as some oprands.
* simple.c1 is a simple example.
* The right example tests the comments and some tokens like 'while','if'and 'else'.
* The counter-example disobey some rules such as a ' ' between '//', to destroy a complete token. And there is often an 'id' after the tokens. If 'id' is identified, the tokens do not cause effect.


