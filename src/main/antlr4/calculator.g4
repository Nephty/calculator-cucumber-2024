grammar calculator;

// Add "package parser;" to the generated files.
@header {
package back.parser;
}

prog: expression;

expression: infix
    | postfix
    | prefix;

// With ANTLR, precedence is determined by the order of the rules
infix: infix op=('*'| '/') infix  # MulDivInfix
    | infix op=('+' | '-') infix  # AddSubInfix
    | '(' infix ')'               # ParensInfix
    | SUB? NUMBER                      # NumberInfix
    ;


// The second part of the rule is there to enforce that we cannot create an expression
// With both comma and space as separators.
prefix: op=('*' | '/') '(' prefix ( (',' prefix)+  | (prefix)+ ) ')' # MulDivPrefix
    | op=('+' | '-') '(' prefix ( (',' prefix)+  | (prefix)+) ')'    # AddSubPrefix
    | '(' prefix ')'                                                 # ParensPrefix
    | SUB? NUMBER                                                         # NumberPrefix
    ;

postfix : '(' postfix ( (',' postfix)+  | (postfix)+ ) ')' op=('*' | '/') # MulDivPostfix
    | '(' postfix ( (',' postfix)+  | (postfix)+) ')' op=('+' | '-')      # AddSubPostfix
    | '(' postfix ')'                                                     # ParensPostfix
    | SUB? NUMBER                                                              # NumberPostfix
    ;

// Defined to reference as constants in the Java code
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
COMMA: ',';

NUMBER: [0-9]+;
WS: [ \t\r\n]+ -> skip; // skip tabs, newlines

