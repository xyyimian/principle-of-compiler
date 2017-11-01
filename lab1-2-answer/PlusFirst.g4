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
	exp Plus exp #Plus
    | exp Multiply exp #Mult
    | (Plus | Minus) exp #prefix
    | LeftParen exp RightParen #Paren
    | Number #Num
;