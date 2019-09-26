# Compiler-CP

## Language 

### Grammar

![](doc/Grammar.png)

### Base

* digit: [0-9]
* letter: [A-Za-z]

### Rules

* caractere: ASCII except " and break line;
* integer_const: digit{digit}
* identifier: letter{letter|digit}
* float_const: digit{digit}.digit{digit}
* literal: "{caractere}"


### Keywords

* start
* exit
* int
* float
* string
* if
* then
* end
* else
* do
* while
* scan
* print

### Operators

* not
* or
* and
* =
* \==
* \>
* \>=
* <
* <=
* <>
* \+
* \*
* /
* \-
  
### Symbols

* ;
* ,
* (
* )
* .
* "

## How to run

### Build

    ./cp build

### Execute
    
    ./cp run [files]
    
### Fazer

1. Checar funcionamento
2. Implementar panic mode
3. Implementar Syntax Analyser
3. Implementar Semantic Analyser
3. Implementar Code Generator