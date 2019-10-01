# Compiler-CP

## Language 

### Grammar

![](doc/Grammar.png)

## First and Follow Table

* Groups: *mulop*, *relop*, *type*

| Token | First  | Follow |
| :--- | :---: | :---: |
| caractere | **[caractere]** |  |
| digit | **[digit]** | |
| letter | **[letter]** |  |
| identifier | **[letter]** |  |
| literal | **[literal]** |  |
| float_const | **[digit]** |  |
| integer_const | **[digit]** |  |
| constant | **[digit]** **[literal]** |  |
| mulop | **[*]** **[/]** **[and]** |  |
| relop | **[==]** **[>]** **[>=]** **[<]** **[<=]** **[<>]** |  |
| factor | **[letter]** **[digit]** **[literal]** **[(]** |  |
| factor-a | **[letter]** **[digit]** **[literal]** **[(]** **[not]** **[-]** |  |
| term | **[letter]** **[digit]** **[literal]** **[(]** **[not]** **[-]** |  |
| simple-expr | **[letter]** **[digit]** **[literal]** **[(]** **[not]** **[-]** |  |
| expression | **[letter]** **[digit]** **[literal]** **[(]** **[not]** **[-]** |  |
| writable | **[letter]** **[digit]** **[literal]** **[(]** **[not]** **[-]** |  |
| write-stmt | **[print]** |  |
| read-stmt | **[scan]** |  |
| stmt-sufix | **[while]** |  |
| while-stmt | **[do]** |  |
| condition | **[letter]** **[digit]** **[literal]** **[(]** **[not]** **[-]** |  |
| if-stmt | **[if]** |  |
| assign-stmt | **[letter]** |  |
| stmt | **[print]** **[scan]** **[while]** **[do]** **[if]** **[letter]** |  |
| stmt-list | **[print]** **[scan]** **[while]** **[do]** **[if]** **[letter]** |  |
| type | **[int]** **[float]** **[string]** | **[letter]** |
| ident-list | **[letter]** |  |
| decl | **[int]** **[float]** **[string]** |  |
| decl-list | **[int]** **[float]** **[string]** |  |
| start | **[start]** | **[int]** **[float]** **[string]** **[print]** **[scan]** **[while]** **[do]** **[if]** **[letter]** |
| exit | **[exit]** | |
| if | **[if]** | **[letter]** **[digit]** **[literal]** **[(]** **[not]** **[-]** |
| then | **[then]** | **[print]** **[scan]** **[while]** **[do]** **[if]** **[letter]** |
| else | **[else]** | **[print]** **[scan]** **[while]** **[do]** **[if]** **[letter]** |
| end | **[end]** | |
| do | **[do]** | **[print]** **[scan]** **[while]** **[do]** **[if]** **[letter]** |
| while | **[while]** | **[letter]** **[digit]** **[literal]** **[(]** **[not]** **[-]** |
| scan | **[scan]** | **[(]** |
| print | **[print]** | **[(]** |
| not | **[not]** | **[letter]** **[digit]** **[literal]** **[(]** |
| minus | **[-]** | **[letter]** **[digit]** **[literal]** **[(]** **[not]** **[-]** |
| plus | **[+]** | **[letter]** **[digit]** **[literal]** **[(]** **[not]** **[-]** |
| or | **[or]** | **[letter]** **[digit]** **[literal]** **[(]** **[not]** **[-]** |
| semicolon | **[;]** | |
| coma | **[,]** | **[letter]** |
| open-parenthesis | **[(]** | |
| close-parenthesis | **[)]** | |
| semicolon | **[;]** | |
| assign | **[=]** | |

## How to run

### Build

    ./cp build

### Execute
    
    ./cp run [files]

### Fazer

1. Checar funcionamento
2. Implementar panic mode
3. Implementar Syntax Analyser
4. Implementar Semantic Analyser
5. Implementar Code Generator