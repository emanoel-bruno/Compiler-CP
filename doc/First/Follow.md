# First and Follow Table

| Token | First  | Follow |
| :--- | :---: | :---: |
| caractere | **[caractere]** | **[;]** |
| digit | **[digit]** |  |
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
| term | **[letter]** **[digit]** **[literal]** **[(]** **[not]** **[-]**  |  |
