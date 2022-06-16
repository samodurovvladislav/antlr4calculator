grammar Calculator;

MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
NUMBER: '-'?[0-9]+;
WHITESPACE: [ \r\n\t]+ -> skip;

start : expression;

expression
   : left=expression operator=(MUL|DIV) right=expression  # MultiplicationOrDivision
   | left=expression operator=(ADD|SUB) right=expression  # AdditionOrSubtraction
   | '(' inner=expression ')'                             # Parentheses   
   | NUMBER                                               # Number
   ;