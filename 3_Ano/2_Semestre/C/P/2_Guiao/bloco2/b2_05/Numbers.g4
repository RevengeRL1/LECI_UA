grammar Numbers;

file: line+ EOF;

line: Number '-' Word NEWLINE;

Number: [0-9]+;
Word: [a-zA-Z]+;
NEWLINE: '\r'? '\n' -> skip;
WS: [ \t]+ -> skip;