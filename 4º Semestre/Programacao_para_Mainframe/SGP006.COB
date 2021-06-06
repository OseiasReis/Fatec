       IDENTIFICATION DIVISION.
       PROGRAM-ID. SGP006.
       AUTHOR. OSEIAS REIS
      ****************************************
      *   MANUTENCAO DO CADASTRO DE PEDIDO   *
      ****************************************
      *----------------------------------------------------------------
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       SPECIAL-NAMES.
                          DECIMAL-POINT IS COMMA.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
           SELECT CADPED ASSIGN TO DISK
                    ORGANIZATION IS INDEXED
                    ACCESS MODE IS DYNAMIC
                    RECORD KEY IS PEDIDO
                    FILE STATUS IS ST-ERRO.

           SELECT CADCLI ASSIGN TO DISK
                    ORGANIZATION IS INDEXED
                    ACCESS MODE IS DYNAMIC
                    RECORD KEY IS CPF
                    FILE STATUS IS ST-ERRO
                    ALTERNATE RECORD KEY IS CPF
                                                      WITH DUPLICATES.
           SELECT CADPRO ASSIGN TO DISK
                    ORGANIZATION IS INDEXED
                    ACCESS MODE IS DYNAMIC
                    RECORD KEY IS CODIGO
                    FILE STATUS IS ST-ERRO
                    ALTERNATE RECORD KEY IS CODIGO
                                                      WITH DUPLICATES.
      *
      *----------------------------------------------------------------
       DATA DIVISION.
       FILE SECTION.
       FD CADPED
             LABEL RECORD IS STANDARD
             VALUE OF FILE-ID IS "CADPED.DAT".
       01 REGPED.
                03 CHAVE.
                    05 PEDIDO       PIC 9(05).
                    05 CODCLI       PIC 9(11).
                    05 PRODUTO      PIC 9(05).
                03 QUANTIDADE       PIC 9(05)V99.
                03 VALOR            PIC 9(09)V99.
       FD CADCLI
             LABEL RECORD IS STANDARD
             VALUE OF FILE-ID IS "CADCLI.DAT".
       01 REGCLI.
                03 CPF                 PIC 9(11).
                03 NOME                PIC X(40).
                03 CEP                 PIC 9(08).
                03 NUMERO              PIC 9(04).
                03 COMPLEMENTO         PIC X(12).
                03 TELEFONE            PIC 9(09).
                03 TELEFONE2           PIC 9(09).
                03 DDD                 PIC 9(02).
                03 DDD2                PIC 9(02).
                03 EMAIL               PIC X(40).
                03 SITUACAO            PIC X(01).
       FD CADPRO
             LABEL RECORD IS STANDARD
             VALUE OF FILE-ID IS "CADPRO.DAT".
       01 REGPRO.
                03 CODIGO           PIC 9(05).
                03 DESCRICAO        PIC X(30).
                03 UNIDADE          PIC X(02).
                03 UNIDEXTENSO      PIC X(18).
                03 PRECOCUSTO       PIC 9(06)V99.
                03 PRECOVENDA       PIC 9(06)V99.
                03 CLASSIFICACAO    PIC 9(01).
                03 SITUACAO         PIC X(01).
      *
      *----------------------------------------------------------------
       WORKING-STORAGE SECTION.
       01 MASC1           PIC ZZZ.ZZ9,99.
       01 MASC2           PIC ZZZZ.ZZZ.ZZ9,99.
       77 W-SEL           PIC 9(01) VALUE ZEROS.
       77 W-CONT          PIC 9(06) VALUE ZEROS.
       77 W-OPCAO         PIC X(01) VALUE SPACES.
       77 ST-ERRO         PIC X(02) VALUE "00".
       77 W-ACT           PIC 9(02) VALUE ZEROS.
       77 MENS            PIC X(50) VALUE SPACES.
       77 LIMPA           PIC X(50) VALUE SPACES.
       01 VAR             PIC 9(07) VALUE ZEROS.
       01 VAR2            PIC 9(07) VALUE ZEROS.

      *
       SCREEN SECTION.
        01  TELAPEDIDOS.
           05  BLANK SCREEN.
           05  LINE 01  COLUMN 01
               VALUE  "                              CADASTRO D".
           05  LINE 01  COLUMN 41
               VALUE  "E PEDIDO".
           05  LINE 04  COLUMN 01
               VALUE  "PEDIDO:".
           05  LINE 06  COLUMN 01
               VALUE  "CLIENTE CPF:".
           05  LINE 08  COLUMN 01
               VALUE  "PRODUTO:".
           05  LINE 10  COLUMN 01
               VALUE  "UNIDADE:".
           05  LINE 12  COLUMN 01
               VALUE  "PRECO VENDA:".
           05  LINE 14  COLUMN 01
               VALUE  "QUANTIDADE:".
           05  LINE 16  COLUMN 01
               VALUE  "VALOR PEDIDO:".
           05  TELAPEDIDO
               LINE 04  COLUMN 08  PIC 9(06)
               USING  PEDIDO
               HIGHLIGHT.
           05  TELACPF
               LINE 06  COLUMN 13  PIC 9(11)
               USING  CODCLI.
           05  TELACLIENTE
               LINE 06  COLUMN 25  PIC X(40)
               USING  NOME
               HIGHLIGHT.
           05  TELAPRODUTO
               LINE 08  COLUMN 09  PIC 9(05)
               USING  PRODUTO.
           05  TELADESC
               LINE 08  COLUMN 19  PIC X(30)
               USING  DESCRICAO
               HIGHLIGHT.
           05  TELAUNIDADE
               LINE 10  COLUMN 09  PIC X(02)
               USING  UNIDADE
               HIGHLIGHT.
           05  TELAUNI
               LINE 10  COLUMN 12  PIC X(18)
               USING  UNIDEXTENSO
               HIGHLIGHT.
           05  TELAPRECO
               LINE 12  COLUMN 13  PIC 9(06)
               USING  PRECOVENDA
               HIGHLIGHT.
           05  TELAQUANTIDADE
               LINE 14  COLUMN 12  PIC 9(05)
               USING  QUANTIDADE
               HIGHLIGHT.
           05  TELAVALOR
               LINE 16  COLUMN 14  PIC 9(09)
               USING  VALOR
               HIGHLIGHT.

      *----------------------------------------------------------------
       PROCEDURE DIVISION.
       INICIO.
      *
       INC-OP0.
           OPEN I-O CADPED
           IF ST-ERRO NOT = "00"
              IF ST-ERRO = "30"
                    OPEN OUTPUT CADPED
                    CLOSE CADPED CADPRO CADCLI
                    MOVE "*** ARQUIVO CADPED SENDO CRIADO ***" TO MENS
                     PERFORM ROT-MENS THRU ROT-MENS-FIM
                     GO TO INC-OP0
              ELSE
                    MOVE "ERRO NA ABERTURA DO ARQUIVO CADPED" TO MENS
                    PERFORM ROT-MENS THRU ROT-MENS-FIM
                    GO TO ROT-FIM
              ELSE
                    NEXT SENTENCE.
           OPEN I-O CADCLI
           IF ST-ERRO NOT = "00"
              MOVE "**ARQUIVO CADCLI NAO FOI ENCONTRADO**" TO MENS
              PERFORM ROT-MENS THRU ROT-MENS-FIM
              GO TO ROT-FIM.
           OPEN I-O CADPRO
           IF ST-ERRO NOT = "00"
              MOVE "**ARQUIVO CADPRO NAO FOI ENCONTRADO**" TO MENS
              PERFORM ROT-MENS THRU ROT-MENS-FIM
              GO TO ROT-FIM.
       INC-001.
              MOVE SPACES TO UNIDADE.
              MOVE ZEROS TO PEDIDO PRODUTO CODCLI QUANTIDADE VALOR
              PRECOVENDA.
              DISPLAY TELAPEDIDOS.
       INC-002.
                ACCEPT TELAPEDIDO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02
                CLOSE CADPED
                GO TO ROT-FIM.
                IF CHAVE = ZEROS
                   MOVE "*** PEDIDO INVALIDO ***" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-002.
       INC-003.
                ACCEPT TELACPF
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02
                CLOSE CADPED
                GO TO ROT-FIM.
                IF CHAVE = ZEROS
                   MOVE "*** CPF INVALIDO ***" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-003.
       INC-003A.
                MOVE CODCLI TO CPF
                READ CADCLI
                IF ST-ERRO NOT = "00"
                    MOVE " ARQUIVO CADCLI NAO FOI ENCONTRADO " TO MENS
                    PERFORM ROT-MENS THRU ROT-MENS-FIM
                    GO TO INC-003.
                DISPLAY TELAPEDIDOS.
       INC-004.
                ACCEPT TELAPRODUTO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02
                   CLOSE CADPED
                   GO TO ROT-FIM.
                IF CHAVE = ZEROS
                   MOVE "*** COD PRODUTO INVALIDO ***" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-004.
       INC-004A.
                MOVE PRODUTO TO CODIGO
                READ CADPRO
                IF ST-ERRO NOT = "00"
                    MOVE " ARQUIVO CADPRO NAO FOI ENCONTRADO " TO MENS
                    PERFORM ROT-MENS THRU ROT-MENS-FIM
                    GO TO INC-004.
                DISPLAY TELAPEDIDOS.

       INC-006.
                ACCEPT TELAQUANTIDADE
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02
                CLOSE CADPED
                GO TO ROT-FIM.
                IF CHAVE = ZEROS
                   MOVE "*** QUANTIDADE INVALIDA ***" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-006.
       INC-007.
                MULTIPLY PRECOVENDA BY QUANTIDADE GIVING VAR.
                MOVE VAR TO VALOR.
                DISPLAY TELAPEDIDOS.
      *
       INC-008.
                IF W-SEL = 1
                  GO TO ALT-OPC.
       INC-OPC.
               MOVE "S" TO W-OPCAO
               DISPLAY 23, 40 "DADOS OK (S/N) : ".
               ACCEPT  W-OPCAO WITH UPDATE
               ACCEPT W-ACT FROM ESCAPE KEY
               IF W-ACT = 02 GO TO INC-001.
               IF W-OPCAO = "N" OR "n"
                  MOVE " * DADOS RECUSADOS PELO OPERADOR * " TO MENS
                  PERFORM ROT-MENS THRU ROT-MENS-FIM
                  GO TO INC-001.
                IF W-OPCAO NOT = "S" AND "s"
                   MOVE "*** DIGITE APENAS S=SIM E N=NAO ****" TO MENS
                   GO TO INC-OPC.
        INC-WR1.
                WRITE REGPED
                IF ST-ERRO = "00" OR "02"
                        MOVE "*** DADOS GRAVADOS *** " TO MENS
                        PERFORM ROT-MENS THRU ROT-MENS-FIM
                        GO TO INC-001.
                IF ST-ERRO = "22"
                        MOVE "*** PRODUTO JA EXISTE *** " TO MENS
                        PERFORM ROT-MENS THRU ROT-MENS-FIM
                        GO TO INC-001
                ELSE
                   MOVE "ERRO NA GRAVACAO DO ARQUIVO DE CADPED" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO ROT-FIM.
       ACE-001.
                DISPLAY 23, 12
                        "F1=NOVO REGISTRO F2=ALTERAR  F3=EXCLUIR"
                ACCEPT  W-OPCAO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT NOT = 02 AND W-ACT NOT = 03 AND W-ACT NOT = 04
                    GO TO ACE-001.
                MOVE SPACES TO MENS
                DISPLAY 23, 12 MENS
                IF W-ACT = 02
                   MOVE 02 TO W-SEL
                   GO TO INC-001.
                IF W-ACT = 03
                   MOVE 01 TO W-SEL
                   GO TO INC-003.
      *
       EXC-OPC.
                DISPLAY 23, 40 "EXCLUIR (S/N) : ".
                ACCEPT  W-OPCAO
                IF W-OPCAO = "N" OR "n"
                   MOVE "*** REGISTRO NAO EXCLUIDO ***" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-001.
                IF W-OPCAO NOT = "S" AND "s"
                   MOVE "* DIGITE APENAS S=SIM E N=NAO *" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO EXC-OPC.
       EXC-DL1.
                DELETE CADPED RECORD
                IF ST-ERRO = "00"
                   MOVE "*** REGISTRO EXCLUIDO *** " TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-001.
                MOVE "ERRO NA EXCLUSAO DO REGISTRO " TO MENS
                PERFORM ROT-MENS THRU ROT-MENS-FIM
                GO TO ROT-FIM.
      *
       ALT-OPC.
                DISPLAY 23, 40 "ALTERAR (S/N) : ".
                ACCEPT W-OPCAO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-006.
                IF W-OPCAO = "N" OR "n"
                    MOVE "*** INFORMACOES NAO ALTERADAS *** " TO MENS
                    PERFORM ROT-MENS THRU ROT-MENS-FIM
                    GO TO INC-001.
                IF W-OPCAO NOT = "S" AND "s"
                    MOVE "* DIGITE APENAS S=SIM e N=NAO *" TO MENS
                    PERFORM ROT-MENS THRU ROT-MENS-FIM
                    GO TO ALT-OPC.
       ALT-RW1.
                REWRITE REGPED
                IF ST-ERRO = "00" OR "02"
                    MOVE "*** REGISTRO ALTERADO *** " TO MENS
                    PERFORM ROT-MENS THRU ROT-MENS-FIM
                    GO TO INC-001.
                MOVE "ERRO NA EXCLUSAO DO REGISTRO PRODUTO" TO MENS
                PERFORM ROT-MENS THRU ROT-MENS-FIM
                GO TO ROT-FIM.
        ROT-FIM.
                EXIT PROGRAM.
        ROT-FIMP.
                EXIT PROGRAM.
        ROT-FIMS.
                STOP RUN.
        ROT-MENS.
                 MOVE ZEROS TO W-CONT.
        ROT-MENS1.
                 DISPLAY 23, 12 MENS.
        ROT-MENS2.
                 ADD 1 TO W-CONT
                 IF W-CONT < 3000
                    GO TO ROT-MENS2
                 ELSE
                    DISPLAY 23, 12 LIMPA.
        ROT-MENS-FIM.
                 EXIT.
        FIM-ROT-TEMPO.
