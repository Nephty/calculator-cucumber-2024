grammar calculator;

// Add "package back.parser;" to the generated files.
@header {
package back.parser;
}

prog: expression;

expression: infix
    | postfix
    | prefix;

imNumber: cartesian | polar | exponential;

angle: atom
    | atom op='/' atom
    ;

cartesian: real=atom op=('+' | '-') im=atom? I;
polar: r=atom '*'? '(' COS '(' theta1=angle  ')' '+' I SIN '(' theta2=angle ')' ')';
exponential: r=atom '*'? EXP '(' theta=angle I ')';

// With ANTLR, precedence is determined by the order of the rules
infix: ((MODULUS infix MODULUS) | ('modulus' '(' infix ')')) # ModulusInfix
    | imNumber                    # ImaginaryInfix
    | infix op=('*'| '/') infix   # MulDivInfix
    | infix op=('+' | '-') infix  # AddSubInfix
    | '(' infix ')'               # ParensInfix
    | imAtom                      # AtomImInfix
    | reAtom                      # AtomReInfix
    | SQRT '(' infix ')'          # SqrtInfix
    | EXP '(' infix ')'           # ExpInfix
    | COS '(' infix ')'           # CosInfix
    | SIN '(' infix ')'           # SinInfix
    | LN  '(' infix ')'            # LnInfix
    ;


// The second part of the rule is there to enforce that we cannot create an expression
// With both comma and space as separators.
prefix: ((MODULUS prefix MODULUS) | ('modulus' '(' prefix ')'))      # ModulusPrefix
    | op=('*' | '/') '(' prefix ( (',' prefix)+  | (prefix)+ ) ')'   # MulDivPrefix
    | op=('+' | '-') '(' prefix ( (',' prefix)+  | (prefix)+) ')'    # AddSubPrefix
    | '(' prefix ')'                                                 # ParensPrefix
    | imNumber                                                       # ImaginaryPrefix
    | imAtom                                                         # AtomImPrefix
    | reAtom                                                         # AtomRePrefix
    | SQRT '(' prefix ')'                                            # SqrtPrefix
    | EXP '(' prefix ')'                                             # ExpPrefix
    | COS '(' prefix ')'                                             # CosPrefix
    | SIN '(' prefix ')'                                             # SinPrefix
    | LN  '(' prefix ')'                                              # LnPrefix
    ;

postfix : ((MODULUS postfix MODULUS) | ('modulus' '(' postfix ')'))       # ModulusPostfix
    | '(' postfix ( (',' postfix)+  | (postfix)+ ) ')' op=('*' | '/')     # MulDivPostfix
    | '(' postfix ( (',' postfix)+  | (postfix)+) ')' op=('+' | '-')      # AddSubPostfix
    | '(' postfix ')'                                                     # ParensPostfix
    | imNumber                                                            # ImaginaryPostfix
    | imAtom                                                              # AtomImPostfix
    | reAtom                                                              # AtomRePostfix
    | SQRT '(' postfix ')'                                                # SqrtPostfix
    | EXP '(' postfix ')'                                                 # ExpPostfix
    | COS '(' postfix ')'                                                 # CosPostfix
    | SIN '(' postfix ')'                                                 # SinPostfix
    | LN  '(' postfix ')'                                                  # LnPostfix
    ;

// Atoms are only real numbers
atom:  SUB? val=(FLOAT|NUMBER) E (SUB?|ADD?) NUMBER # ENotationAtom
    |  SUB? val=FLOAT               # FloatAtom
    |  SUB? PI                      # PiAtom
    |  SUB? NUMBER                  # IntAtom
    ;

imAtom: atom? I;
reAtom: atom;

// Defined to reference as constants in the Java code
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
COMMA: ',';
MODULUS: '|';
DECIMAL: '.';
I: 'i';
E: 'E';
COS: 'cos';
SQRT: 'sqrt';
SIN: 'sin';
EXP: 'exp';
PI: 'pi';
LN: 'ln';
NUMBER:[0-9]+;
FLOAT: [0-9]+ '.' [0-9]+;
WS: [ \t\r\n]+ -> skip; // skip tabs, newlines