# Report Syntax Analyser

## Language 

### Grammar

![  ](../doc/Grammar.png)

### Improved Grammar

![  ](../doc/Grammar_2.png)

### Grammar Changes
* Added
  * one line comment support
  * multiple line comment support 
* **Removed left recursion**
  * term
  * simple-expr
  * term
* **Removed common prefix**
  * if-stmt
  * expression
* **Removed ambiguity**
  * program
  * writable
* **Removed loops**  
  * decl-list
  * ident-list
  * stmt-list

## Test 1

```c
start
    int a, b;
    int result;
    float a,x,total; start
    a = 2;
    x = .1;
    scan (b);
    scan (y)
    result = (a*b ++ 1) / 2;
    print “Resultado: ”;
    print (result);
    print (“Total: ”);
    total = y / x;
    print (“Total: ”;
    print (total);
exit
```
* **Result:**
  
## Test 2

```c
start

    int: a, c;
    float d, _e;
    a = 0; d = 3.5
    c = d / 1.2;
    Scan (a);
    Scan (c);
    b = a * a;
    c = b + a * (1 + a*c);
    print (“Resultado: ”);
    print c;
    d = 34.2
    e = val + 2.2;
    print (“E: ”);
    print (e);
    a = b + c + d)/2;
```
* **Result:**

## Test 3

```c
start
    int pontuacao, pontuacaoMaxina, disponibilidade;
    string pontuacaoMinima;

    disponibilidade = “Sim”;
    pontuacaoMinima = 50;
    pontuacaoMaxima = 100;

    /* Entrada de dados
        Verifica aprovação de candidatos

    do
        print(“Pontuacao Candidato: ”);
        scan(pontuacao);
        print(“Disponibilidade Candidato: ”);
        scan(disponibilidade);

        if ((pontuação > pontuacaoMinima) and (disponibilidade==“Sim”) then
            out(“Candidato aprovado”);
        else
            out(“Candidato reprovado”)
        end
    while (pontuação >= 0) end
exit
```
* **Result:**

## Test 4

```c
start
    Int a, aux$, b;
    string nome, sobrenome, msg;
    
    print(Nome: );
    scan (nome);
    print(“Sobrenome: ”);
    scan (sobrenome);
    msg = “Ola, ” + nome + “ ” +
sobrenome + “!”;
    msg = msg + 1;
    print (msg);

    scan (a);
    scan(b);
    if (a>b) then
    aux = b;
    b = a;
    a = aux;
    end;
    print (“Apos a troca: ”);
    out(a);
    out(b)
exit
```
* **Result:**

## Test 5

```c
start
    int a, b, c, maior, outro;
    do
        print(“A”);
        scan(a);
        print(“B”);
        scan(b);
        print(“C”);
        scan(c);
        //Realizacao do teste

        if ( (a>b) && (a>c)
            maior = a
        )
        else
            if (b>c) then
                maior = b;
                
            else
                maior = c;
            end
        end
        print(“Maior valor:””);
        print (maior);
        print (“Outro? ”);
        scan(outro);
    while (outro >= 0);
exit
```
* **Result:**

## Test 6

```c
start
    int a, b, c, maior, outro;
    do
        print(“A”);
        scan(a);
        print(“B”);
        scan(b);
        print(“C”);
        scan(c);
        //Realizacao do teste

        if ( (a>b) && (a>c)
            maior = a
        )
        else
            if (b>c) then
                maior = b;
                
            else
                maior = c;
            end
        end
        print(“Maior valor:””);
        print (maior);
        print (“Outro? ”);
        scan(outro);
    while (outro >= 0);
exit
```
* **Result:**