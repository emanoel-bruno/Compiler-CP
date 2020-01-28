# Compiler-CP

## Language 

### Grammar

![  ](doc/Grammar.png)

### Improved Grammar

![  ](doc/Grammar_2.png)

## First and Follow Table

* Groups: *mulop*, *relop*, *type*


| **Nonterminal Symbols** |||
| :--- | :---: | :---: |
| Symbol | First  | Follow |
| program | *[ start ]* | *[ $ ]* |
| decl-list | *[ int ]* *[ float ]* *[ string ]* | **stmt-list:**   *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* |
| decl | *[ int ]* *[ float ]* *[ string ]*  | **decl-list:**    *[ int ]* *[ float ]* *[ string ]* **stmt-list:**   *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* |
| ident-list | *[ identifier ]* | **decl:**:    *[ ; ]* |
| ident-list-asterisk |*[ , ]* | **ident-list:**    *[ ; ]* |
| stmt-list | *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* | **program:**  *[ exit ]*  **if-stmt-asterisk:**    *[ end ]* *[ else ]*    **stmt-sufix:**  *[ while ]*|
| stmt | *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* | **stmt-asterisk:** *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* **program:**  *[ exit ]*  **if-stmt-asterisk:**    *[ end ]* *[ else ]*    **stmt-sufix:**  *[ while ]* |
| stmt-asterisk | *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* | **program:**  *[ exit ]*  **if-stmt-asterisk:**    *[ end ]* *[ else ]*    **stmt-sufix:**  *[ while ]* |
| assign-stmt | *[ identifier ]* | **stmt:** *[ ; ]* |
| if-stmt | *[ if ]* | **stmt-asterisk:** *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* **program:**  *[ exit ]*  **if-stmt-asterisk:**    *[ end ]* *[ else ]*    **stmt-sufix:**  *[ while ]* |
| while-stmt | *[ do ]* | **stmt-asterisk:** *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* **program:**  *[ exit ]*  **if-stmt-asterisk:**    *[ end ]* *[ else ]*    **stmt-sufix:**  *[ while ]* |
| read-stmt | *[ scan ]* |  **stmt:** *[ ; ]* |
| write-stmt | *[ print ]* | **stmt:** *[ ; ]* |
| if-stmt* |*[ end ]* *[ else ]* | **stmt-asterisk:** *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* **program:**  *[ exit ]*  **if-stmt-asterisk:**    *[ end ]* *[ else ]*    **stmt-sufix:**  *[ while ]* |
| condition | *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* | **stmt-sufix:** *[ end ]* **if-stmt:** *[ then ]* |
| stmt-sufix | *[ while ]* | **stmt-asterisk:** *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* **program:**  *[ exit ]*  **if-stmt-asterisk:**    *[ end ]* *[ else ]*    **stmt-sufix:**  *[ while ]* |
| writable | *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* | **write-stmt:** *[ ) ]* |
| expression | *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* | **stmt-sufix:** *[ end ]* **if-stmt:** *[ then ]* **factor:** *[ ) ]* |
| expression-asterisk |  *[ == ]* *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]* | **stmt-sufix:** *[ end ]* **if-stmt:** *[ then ]* **factor:** *[ ) ]* |
| simple-expr | *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* |  **stmt-sufix:** *[ end ]* **if-stmt:** *[ then ]* **factor:** *[ ) ]* **write-stmt:** *[ ) ]*  **expression-asterisk:**  *[ == ]* *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]* **assign-stmt:** *[ ; ]* |
| simple-expr-asterisk | *[ + ]* *[ - ]* *[ or ]* |  **stmt-sufix:** *[ end ]* **if-stmt:** *[ then ]* **factor:** *[ ) ]* **write-stmt:** *[ ) ]*  **expression-asterisk:**  *[ == ]* *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]* **assign-stmt:** *[ ; ]* |
| term | *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* | **simple-expr-asterisk:** *[ + ]* *[ - ]* *[ or ]* **stmt-sufix:** *[ end ]* **if-stmt:** *[ then ]* **factor:** *[ ) ]* **write-stmt:** *[ ) ]*  **expression-asterisk:**  *[ == ]* *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]* **assign-stmt:** *[ ; ]*  |
| term-asterisk | *[ * ]* *[ / ]* *[ and ]* | **simple-expr-asterisk:** *[ + ]* *[ - ]* *[ or ]* **stmt-sufix:** *[ end ]* **if-stmt:** *[ then ]* **factor:** *[ ) ]* **write-stmt:** *[ ) ]*  **expression-asterisk:**  *[ == ]* *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]* **assign-stmt:** *[ ; ]* |
| factor-a | *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* | **term-asterisk:** *[ * ]* *[ / ]* *[ and ]* **simple-expr-asterisk:** *[ + ]* *[ - ]* *[ or ]* **stmt-sufix:** *[ end ]* **if-stmt:** *[ then ]* **factor:** *[ ) ]* **write-stmt:** *[ ) ]*  **expression-asterisk:**  *[ == ]* *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]* **assign-stmt:** *[ ; ]* |
| factor | *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* | **term-asterisk:** *[ * ]* *[ / ]* *[ and ]* **simple-expr-asterisk:** *[ + ]* *[ - ]* *[ or ]* **stmt-sufix:** *[ end ]* **if-stmt:** *[ then ]* **factor:** *[ ) ]* **write-stmt:** *[ ) ]*  **expression-asterisk:**  *[ == ]* *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]* **assign-stmt:** *[ ; ]* |

| **Terminal Symbols** |||
| :--- | :---: | :---: |
| Symbol | First  | Follow |
| start | *[ start ]* | **program, decl-list:** *[ int ]* *[ float ]* *[ string ]* **program, stmt-list:** *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* |
| exit | *[ exit ]* | **program, program:** *[ EOF ]* |
| type | *[ int ]* *[ float ]* *[ string ]* | **decl, ident-list:** *[ identifier ]* |
| if | *[ if ]* | **if-stmt, condition:** *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* |
| then | *[ then ]* | **if-stmt, stmt-list:** *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* |
| else | *[ else ]* | **if-stmt-asterisk, stmt-list:** *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* |
| end | *[ end ]* | **stmt-sufix, end, stmt-asterisk:** *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* **stmt-sufix, end, program:**  *[ exit ]*  **stmt-sufix, end, if-stmt-asterisk:**    *[ end ]* *[ else ]*  **stmt-sufix, end, stmt-sufix:**  *[ while ]*  |
| do | *[ do ]* |  **while-stmt, stmt-list:** *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* |
| while | *[ while ]* |  **stmt-sufix, condition:** *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* |
| scan | *[ scan ]* | **read-stmt, read-stmt:**  *[ ( ]* |
| print | *[ print ]* | **write-stmt, write-stmt:** *[ ( ]* |
| not | *[ not ]* |  **factor-a, factor:** *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* |
| mulop | *[ * ]* *[ / ]* *[ and ]* | **term-asterisk, factor-a:** *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* |
| relop | *[ == ]* *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]* | **expression-asterisk, simple-expr:** *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* |
| minus | *[ - ]* | **factor-a, factor and simple-expr-asterisk, term:** *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* **simple-expr-asterisk, term:** *[ not ]* *[ - ]* |
| plus | *[ + ]* | **simple-expr-asterisk, term:** *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* |
| or | *[ or ]* |  **simple-expr-asterisk, term:** *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* |
| semicolon | *[ ; ]* | **decl, decl:** **-decl-list:**    *[ int ]* *[ float ]* *[ string ]* **-stmt-list:**   *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* **stmt, stmt:**  **-stmt-asterisk:** *[ print ]* *[ scan ]* *[ do ]* *[ if ]* *[ identifier ]* **-program:**  *[ exit ]*  **-if-stmt-asterisk:**    *[ end ]* *[ else ]*    **-stmt-sufix:**  *[ while ]*|
| coma | *[ , ]* | **ident-list-asterisk, identifier:** *[ identifier ]* |
| open-parenthesis | *[ ( ]* | **read-stmt, identifier:** *[ identifier ]* **write-stmt, writeable  and factor, expression:** *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]*|
| close-parenthesis | *[ ) ]* | **read-stmt, read-stmt:** **-stmt:** *[ ; ]* **write-stmt, write-stmt:** **-stmt:** *[ ; ]* **factor, factor:** **-term-asterisk:** *[ * ]* *[ / ]* *[ and ]* **-simple-expr-asterisk:** *[ + ]* *[ - ]* *[ or ]* **-stmt-sufix:** *[ end ]* **-if-stmt:** *[ then ]* **-factor:** *[ ) ]* *[ ; ]* **-write-stmt:** *[ ) ]*  **-expression-asterisk:**  *[ == ]* *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]*  |
| assign | *[ = ]* | **assign-stmt, simple-expr:** *[ identifier ]* *[ float_const ]* *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* |
| identifier | *[ identifier ]* | **assign-stmt, assign:** *[ = ]* **ident-list,ident-list: and ident-list-asterisk, ident-list-asterisk:**  **-decl:**:   *[ ; ]*   **ident-list,ident-list-asterisk:** *[ , ]* **factor-factor:**  **-term-asterisk:** *[ * ]* *[ / ]* *[ and ]* **-simple-expr-asterisk:** *[ + ]* *[ - ]* *[ or ]* **-stmt-sufix:** *[ end ]* **-if-stmt:** *[ then ]* **-factor:** *[ ) ]* **-write-stmt:** *[ ) ]*  **-expression-asterisk:**  *[ == ]* *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]* **-assign-stmt:** *[ ; ]* |
| literal | *[ literal ]* | **factor-factor:**  **-term-asterisk:** *[ * ]* *[ / ]* *[ and ]* **-simple-expr-asterisk:** *[ + ]* *[ - ]* *[ or ]* **-stmt-sufix:** *[ end ]* **-if-stmt:** *[ then ]* **-factor:** *[ ) ]* **-write-stmt:** *[ ) ]*  **-expression-asterisk:**  *[ == ]* *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]* **-assign-stmt:** *[ ; ]* |
| float_const | *[ float_const ]* | **factor-factor:**  **-term-asterisk:** *[ * ]* *[ / ]* *[ and ]* **-simple-expr-asterisk:** *[ + ]* *[ - ]* *[ or ]* **-stmt-sufix:** *[ end ]* **-if-stmt:** *[ then ]* **-factor:** *[ ) ]* **-write-stmt:** *[ ) ]*  **-expression-asterisk:**  *[ == ]* *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]* **-assign-stmt:** *[ ; ]* |
| integer_const | *[ integer_const ]* | **factor-factor:**  **-term-asterisk:** *[ * ]* *[ / ]* *[ and ]* **-simple-expr-asterisk:** *[ + ]* *[ - ]* *[ or ]* **-stmt-sufix:** *[ end ]* **-if-stmt:** *[ then ]* **-factor:** *[ ) ]* **-write-stmt:** *[ ) ]*  **-expression-asterisk:**  *[ == ]* *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]* **-assign-stmt:** *[ ; ]* |

## Reports

1. [Lexical](doc/Report_1.md)
2. [Syntax](doc/Report_2.md)

## Linux

To build or run is necessary be inside the folder of the project (Compiler-CP)

### Build

    ./cp build

### Execute
    
    ./cp run [ files ]

### Testar
    
    ./cp test

## Windows

To build or run is necessary be inside the folder of the project (Compiler-CP)

### Build

    cd compiler
    mvn clean package assembly:single

#### Execute
    
    java -cp compiler/target/compiler-1.0-jar-with-dependencies.jar compiler.App [ files ]

## Java

If you want run from the .jar just go to the releases folder
