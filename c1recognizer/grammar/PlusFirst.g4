grammar PlusFirst;

Plus: '+' ;
Minus: '-' ;
Multiply: '*' ;
Divide: '/' ;
Modulo: '%' ;

LeftParen: '(';
RightParen: ')';
Number: ('+' | '-')?[0-9]+ | '0x' [0-9a-fA-F]+ ;

WhiteSpace: [ \t\r\n]+ -> skip;

exp:
	exp (Plus | Minus) exp
    | exp (Multiply | Divide | Modulo) exp
    | (Plus | Minus) exp
    | LeftParen exp RightParen
    | Number
;