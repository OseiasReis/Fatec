       IDENTIFICATION DIVISION.
       PROGRAM-ID. SGP003.
       AUTHOR. OSEIAS REIS
      **************************************
      *       CADASTRO DE CLIENTE           *
      **************************************
      *----------------------------------------------------------------
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       SPECIAL-NAMES.
                         DECIMAL-POINT IS COMMA.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
       SELECT CLIENTE ASSIGN TO DISK
                    ORGANIZATION IS INDEXED
                    ACCESS MODE  IS DYNAMIC
                    RECORD KEY   IS CPF
                    FILE STATUS  IS ST-ERRO
                    ALTERNATE RECORD KEY IS CPF
                                                      WITH DUPLICATES.
      *
      *-----------------------------------------------------------------
       DATA DIVISION.
       FILE SECTION.
       FD CLIENTE
               LABEL RECORD IS STANDARD
               VALUE OF FILE-ID IS "CLIENTE.DAT".
       01 REGAMG.
                03 CPF              PIC 9(12).
                03 NOME             PIC X(40).
                03 CEP              PIC 9(08).
                03 LOGRADOURO       PIC X(30).
                03 NUMERO           PIC 9(04).
                03 COMPLEMENTO      PIC X(12).
                03 BAIRRO           PIC X(20).
                03 CIDADE           PIC X(20).
                03 UF               PIC X(02).
                03 TELEFONE         PIC 9(09).
                03 DDD              PIC 9(02).
                03 EMAIL            PIC X(40).
                03 SITUACAO         PIC X(01).
      *
      *-----------------------------------------------------------------
       WORKING-STORAGE SECTION.
       77 W-SEL        PIC 9(02) VALUE ZEROS.
       77 W-CONT       PIC 9(06) VALUE ZEROS.
       77 W-OPCAO      PIC X(01) VALUE SPACES.
       77 ST-ERRO      PIC X(02) VALUE "00".
       77 W-ACT        PIC 9(02) VALUE ZEROS.
       77 MENS         PIC X(50) VALUE SPACES.
       77 LIMPA        PIC X(50) VALUE SPACES.
       01 IND          PIC 9(09) VALUE ZEROS.
       01 CLIENTEEXTENSO    PIC X(10) VALUE SPACES.
       01 SITUEXTENSO       PIC X(10) VALUE SPACES.

       01 TABUFX.
          03 FILLER   PIC X(12) VALUE "ACACRE      ".
          03 FILLER   PIC X(12) VALUE "ALALAGOAS   ".
          03 FILLER   PIC X(12) VALUE "APAMAPA     ".
          03 FILLER   PIC X(12) VALUE "AMAMAZONAS  ".
          03 FILLER   PIC X(12) VALUE "BABAHIA     ".
          03 FILLER   PIC X(12) VALUE "CECEARA     ".
          03 FILLER   PIC X(12) VALUE "DFD FEDERAL ".
          03 FILLER   PIC X(12) VALUE "ESE SANTO   ".
          03 FILLER   PIC X(12) VALUE "GOGOIAS     ".
          03 FILLER   PIC X(12) VALUE "MAMARANHAO  ".
          03 FILLER   PIC X(12) VALUE "MTM GROSSO  ".
          03 FILLER   PIC X(12) VALUE "MSM.G DO SUL".
          03 FILLER   PIC X(12) VALUE "MGM GERAIS  ".
          03 FILLER   PIC X(12) VALUE "PAPARA      ".
          03 FILLER   PIC X(12) VALUE "PBPARAIBA   ".
          03 FILLER   PIC X(12) VALUE "PRPARANA    ".
          03 FILLER   PIC X(12) VALUE "PEPERNAMBUCO".
          03 FILLER   PIC X(12) VALUE "PIPIAUI     ".
          03 FILLER   PIC X(12) VALUE "RJRD JANEIRO".
          03 FILLER   PIC X(12) VALUE "RNRGDO NORTE".
          03 FILLER   PIC X(12) VALUE "RSRG DO SUL ".
          03 FILLER   PIC X(12) VALUE "RORONDONIA  ".
          03 FILLER   PIC X(12) VALUE "RRRORAIMA   ".
          03 FILLER   PIC X(12) VALUE "SCS CATARINA".
          03 FILLER   PIC X(12) VALUE "SPSAO PAULO ".
          03 FILLER   PIC X(12) VALUE "SESERGIPE   ".
          03 FILLER   PIC X(12) VALUE "TOTOCANTINS ".

       01 TAUFAUX REDEFINES TABUFX.
          03 TABUF  PIC X(12) OCCURS 26 TIMES.
       01 ALFATP.
           03 ALFATP1 PIC X(02).
           03 ALFATP2 PIC X(10).

       01 TABSITUACAOX.
          03 FILLER   PIC X(12) VALUE "AATIVO     ".
          03 FILLER   PIC X(12) VALUE "CCANCELADO ".
          03 FILLER   PIC X(12) VALUE "DDELETADO  ".
          03 FILLER   PIC X(12) VALUE "SSUSPENSO  ".

       01 TABSITUACAOAUX REDEFINES TABSITUACAOX.
          03 TABSITUACAO   PIC X(12) OCCURS 04 TIMES.
       01 ALFATP02.
           03 ALFATP5 PIC X(01).
           03 ALFATP6 PIC X(11).

       SCREEN SECTION.
        01  TELACLIENTE.
           05  LINE 01  COLUMN 01
               VALUE  "                             CADASTRO CL".
           05  LINE 01  COLUMN 41
               VALUE  "IENTE".
           05  LINE 03  COLUMN 01
               VALUE  "   CPF:".
           05  LINE 05  COLUMN 01
               VALUE  "   NOME:".
           05  LINE 07  COLUMN 01
               VALUE  "   CEP:".
           05  LINE 09  COLUMN 01
               VALUE  "   LOGRADOURO:".
           05  LINE 09  COLUMN 41
               VALUE  "  N:     COMPLEMENTO:".
           05  LINE 11  COLUMN 01
               VALUE  "   BAIRRO:                        CIDADE".
           05  LINE 11  COLUMN 41
               VALUE  ":                  UF:".
           05  LINE 13  COLUMN 01
               VALUE  "   TELEFONE:(  )".
           05  LINE 15  COLUMN 01
               VALUE  "   EMAIL:".
           05  LINE 17  COLUMN 01
               VALUE  "   SITUACAO:".
           05  TCPF
               LINE 03  COLUMN 08  PIC 999.999.999.99
               USING  CPF.
           05  TNOME
               LINE 05  COLUMN 09  PIC X(40)
               USING  NOME.
           05  TCEP
               LINE 07  COLUMN 08  PIC 99999.999
               USING  CEP.
           05  TLOGRADOURO
               LINE 09  COLUMN 15  PIC X(27)
               USING  LOGRADOURO.
           05  TN
               LINE 09  COLUMN 45  PIC 9999
               USING  NUMERO.
           05  TCOMPLEMENTO
               LINE 09  COLUMN 62  PIC X(12)
               USING  COMPLEMENTO.
           05  TBAIRRO
               LINE 11  COLUMN 11  PIC X(20)
               USING  BAIRRO.
           05  TCIDADE
               LINE 11  COLUMN 42  PIC X(17)
               USING  CIDADE.
           05  TUF
               LINE 11  COLUMN 63  PIC X(02)
               USING  UF.
           05  TDDD
               LINE 13  COLUMN 14  PIC 99
               USING  DDD.
           05  TTELEFONE
               LINE 13  COLUMN 18  PIC Z9999.9999
               USING  TELEFONE.
           05  TEMAIL
               LINE 15  COLUMN 10  PIC X(40)
               USING  EMAIL.
           05  TSITUACAO
               LINE 17  COLUMN 13  PIC X(01)
               USING  SITUACAO.
      *-----------------------------------------------------------------
       PROCEDURE DIVISION.
       INICIO.
      *
       INC-OP0.
           OPEN I-O CLIENTE
           IF ST-ERRO NOT = "00"
               IF ST-ERRO = "30"
                      OPEN OUTPUT CLIENTE
                      CLOSE CLIENTE
                      MOVE "*** ARQUIVO CLIENTE SENDO CRIADO **" TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO INC-OP0
                   ELSE
                      MOVE "ERRO NA ABERTURA DO ARQUIVO CLIENTE" TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO ROT-FIM
                ELSE
                    NEXT SENTENCE.
       INC-001.
                MOVE ZEROS TO CPF NUMERO DDD TELEFONE CEP
                MOVE SPACES TO NOME LOGRADOURO COMPLEMENTO BAIRRO CIDADE UF EMAIL SITUACAO
                DISPLAY TELACLIENTE.
       INC-002.
                ACCEPT CPF
                ACCEPT W-ACT FROM ESCAPE KEY
                 IF W-ACT = 02
                   CLOSE CLIENTE
                   GO TO ROT-FIM.
                IF CPF  = ZEROS
                   MOVE "*** CLIENTE INVALIDO ***" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-002.
       LER-CLIENTE01.
                MOVE 0 TO W-SEL
                READ CLIENTE
                IF ST-ERRO NOT = "23"
                   IF ST-ERRO = "00"
                      DISPLAY TELACLIENTE
                      MOVE "*** CLIENTE JA CADASTRAD0 ***" TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      MOVE 1 TO W-SEL
                      GO TO ACE-001
                   ELSE
                      MOVE "ERRO NA LEITURA ARQ. CLIENTE"   TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO ROT-FIM
                ELSE
                   NEXT SENTENCE.
       INC-003.
                ACCEPT NOME
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-002.
       INC-004.
                ACCEPT CEP
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-003.

       INC-005.
                ACCEPT LOGRADOURO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-004.

       INC-006.
                ACCEPT NUMERO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-005.

       INC-007.
                ACCEPT COMPLEMENTO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-006.

       INC-008.
                ACCEPT BAIRRO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-007.

       INC-009.
                ACCEPT CIDADE
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-008.

       INC-010A.
                ACCEPT UF
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-011.
                MOVE 1 TO IND
                GO TO INC-009.

       INC-010.
            MOVE TABUF(IND) TO ALFATP
            IF UF NOT = ALFATP1
                      IF IND < 08
                          ADD 1 TO IND
                          GO TO INC-010
                      ELSE
                          MOVE SPACES TO CLIENTEEXTENSO
                          MOVE "CLIENTE INVALIDO!" TO MENS
                          PERFORM ROT-MENS THRU ROT-MENS-FIM
                          MOVE 1 TO IND
                          GO TO INC-009
            ELSE
                      MOVE ALFATP2 TO CLIENTEEXTENSO
                      DISPLAY TELACLIENTE.

       INC-011.
                ACCEPT DDD
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-010.
       INC-012.
                ACCEPT TELEFONE
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-011.
       INC-013.
                ACCEPT EMAIL
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-012.

       INC-014A.
            ACCEPT SITUACAO
            ACCEPT W-ACT FROM ESCAPE KEY
            MOVE 1 TO IND
            IF W-ACT = 02 GO TO INC-013.

       INC-014.
            MOVE TABSITUACAO(IND) TO ALFATP02
            IF SITUACAO NOT = ALFATP5
                      IF IND < 03
                          ADD 1 TO IND
                          GO TO INC-014
                      ELSE
                          MOVE SPACES TO CLIENTEEXTENSO
                          MOVE "CLIENTE INVALIDO!" TO MENS
                          PERFORM ROT-MENS THRU ROT-MENS-FIM
                          MOVE 1 TO IND
                          GO TO INC-014A
            ELSE
                      MOVE ALFATP6 TO SITUEXTENSO.
            DISPLAY TELACLIENTE.

       INC-OPC.
                MOVE "S" TO W-OPCAO
                DISPLAY 23, 40 "DADOS OK (S/N) : ".
                ACCEPT W-OPCAO WITH UPDATE
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-005.
                IF W-OPCAO = "N" OR "n"
                   MOVE "* DADOS RECUSADOS PELO OPERADOR *" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-001.
                IF W-OPCAO NOT = "S" AND "s"
                   MOVE "*** DIGITE APENAS S=SIM e N=NAO ***" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-OPC.
       INC-WR1.
                WRITE REGAMG
                IF ST-ERRO = "00" OR "02"
                      MOVE "*** DADOS GRAVADOS *** " TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO INC-001.
                IF ST-ERRO = "22"
                      MOVE "*** CLIENTE JA EXISTE ***       " TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO INC-001
                ELSE
                      MOVE "ERRO NA GRAVACAO DO ARQUIVO" TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO ROT-FIM.

       ACE-001.
                DISPLAY 23, 12
                     "F1=NOVO REGISTRO   F2=ALTERAR   F3=EXCLUIR"
                ACCEPT W-OPCAO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT NOT = 02 AND W-ACT NOT = 03 AND W-ACT NOT = 04
                   GO TO ACE-001.
                MOVE SPACES TO MENS
                DISPLAY 23, 12 MENS
                IF W-ACT = 02
                   MOVE 02 TO W-SEL
                   GO TO INC-001.
                IF W-ACT = 03
                   GO TO INC-003.
      *
       EXC-OPC.
                DISPLAY 23, 40  "EXCLUIR   (S/N) : ".
                ACCEPT W-OPCAO
                IF W-OPCAO = "N" OR "n"
                   MOVE "*** REGISTRO NAO EXCLUIDO ***" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-001.
                IF W-OPCAO NOT = "S" AND "s"
                   MOVE "* DIGITE APENAS S=SIM  e  N=NAO *" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO EXC-OPC.
       EXC-DL1.
                DELETE CLIENTE RECORD
                IF ST-ERRO = "00"
                   MOVE "*** REGISTRO EXCLUIDO ***        " TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-001.
                MOVE "ERRO NA EXCLUSAO DO REGISTRO "   TO MENS
                PERFORM ROT-MENS THRU ROT-MENS-FIM
                GO TO ROT-FIM.
      *
       ALT-OPC.
                DISPLAY 23, 40 "ALTERAR  (S/N) : ".
                ACCEPT W-OPCAO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-005.
                IF W-OPCAO = "N" OR "n"
                   MOVE "*** INFORMACOES NAO ALTERADAS *** " TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-001.
                IF W-OPCAO NOT = "S" AND "s"
                   MOVE "* DIGITE APENAS S=SIM  e  N=NAO *" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO ALT-OPC.
       ALT-RW1.
                REWRITE REGAMG
                IF ST-ERRO = "00" OR "02"
                   MOVE "*** REGISTRO ALTERADO ***         " TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-001.
                MOVE "ERRO NA EXCLUSAO DO REGISTRO CLIENTE"   TO MENS
                PERFORM ROT-MENS THRU ROT-MENS-FIM
                GO TO ROT-FIM.
      *
      **********************
      * ROTINA DE FIM      *
      **********************
      *
       ROT-FIM.
                EXIT PROGRAM.
       ROT-FIMP.
                EXIT PROGRAM.

       ROT-FIMS.
                STOP RUN.
      *
      **********************
      * ROTINA DE MENSAGEM *
      **********************
      *
       ROT-MENS.
                MOVE ZEROS TO W-CONT.
       ROT-MENS1.
               DISPLAY 23, 12 MENS.
       ROT-MENS2.
                ADD 1 TO W-CONT
                IF W-CONT < 3000
                   GO TO ROT-MENS2
                ELSE
                   DISPLAY 23, 12  LIMPA.
       ROT-MENS-FIM.
                EXIT.
       FIM-ROT-TEMPO.
