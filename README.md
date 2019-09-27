# Compiler-CP

## Language 

### Grammar

![](doc/Grammar.png)

## First and Follow Table

* Groups: *mulop*, *addlop*, *relop*, *type*

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
| addlop | **[+]** **[-]** **[or]** |  |
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
| type | **[int]** **[float]** **[string]** |  |
| ident-list | **[letter]** |  |
| decl | **[int]** **[float]** **[string]** |  |
| decl-list | **[int]** **[float]** **[string]** |  |
| start | **[start]** | |
| exit | **[exit]** | |
| if | **[if]** | |
| then | **[then]** | |
| else | **[else]** | |
| end | **[end]** | |
| do | **[do]** | |
| while | **[while]** | |
| scan | **[scan]** | |
| print | **[print]** | |
| not | **[not]** | |

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