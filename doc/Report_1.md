# Test Lexical Analyser
        14:30 $ ./cp test
        -- Compiling Teste1...
        start
        int
        a
        ,
        b
        ;
        int
        result
        ;
        float
        a
        ,
        x
        ,
        total
        ;
        start
        a
        =
        2
        ;
        x
        =
        .
        1
        ;
        scan
        (
        b
        )
        ;
        scan
        (
        y
        )
        result
        =
        (
        a
        *
        b
        +
        +
        1
        )
        /
        2
        ;
        print
        "Resultado: "
        ;
        print
        (
        result
        )
        ;
        print
        (
        "Total: "
        )
        ;
        total
        =
        y
        /
        x
        ;
        print
        (
        "Total: "
        ;
        print
        (
        total
        )
        ;
        exit
        -- Teste1 compilation finished  :) 

        -- Compiling Teste2...
        start
        int
        - Lexical Exception: 
        UnknownCharacter: :| line: 3

        -- Teste2 compilation finished  :(

        -- Compiling Teste3...
        int
        pontuacao
        ,
        pontuacaoMaxina
        ,
        disponibilidade
        ;
        string
        pontuacaoMinima
        ;
        disponibilidade
        =
        "Sim"
        ;
        pontuacaoMinima
        =
        50
        ;
        pontuacaoMaxima
        =
        100
        ;
        /
        *
        Entrada
        de
        dados
        Verifica
        aprovação
        de
        candidatos
        do
        print
        (
        "Pontuacao Candidato: "
        )
        ;
        scan
        (
        pontuacao
        )
        ;
        print
        (
        "Disponibilidade Candidato: "
        )
        ;
        scan
        (
        disponibilidade
        )
        ;
        if
        (
        (
        pontuação
        >
        pontuacaoMinima
        )
        and
        (
        disponibilidade
        ==
        =
        "Sim"
        )
        then
        out
        (
        "Candidato aprovado"
        )
        ;
        else
        out
        (
        "Candidato reprovado"
        )
        end
        while
        (
        pontuação
        >=
        =
        0
        )
        end
        exit
        -- Teste3 compilation finished  :) 

        -- Compiling Teste4...
        start
        Int
        a
        ,
        aux
        - Lexical Exception: 
        UnknownCharacter: $| line: 2

        -- Teste4 compilation finished  :(

        -- Compiling Teste5...
        start
        int
        a
        ,
        b
        ,
        c
        ,
        maior
        ,
        outro
        ;
        do
        print
        (
        "A"
        )
        ;
        scan
        (
        a
        )
        ;
        print
        (
        "B"
        )
        ;
        scan
        (
        b
        )
        ;
        print
        (
        "C"
        )
        ;
        scan
        (
        c
        )
        ;
        /
        /
        Realizacao
        do
        teste
        if
        (
        (
        a
        >
        b
        )
        - Lexical Exception: 
        UnknownCharacter: &| line: 12

        -- Teste5 compilation finished  :(

        -- Compiling Teste6...
        -- Teste6 compilation finished  :) 