grammar SuffixCalculator;
program:
    stat* EOF; // Zero or more repetitions of stat

stat:
    expr? NEWLINE; // Optative expr followed by an end of line

expr:
      expr expr op=('*'|'/'|'+'|'-') #ExprSuffix
    | Number #ExprNumber; 

Number: [0-9]+('.'[0-9]+)?; // Fixed point real number
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;