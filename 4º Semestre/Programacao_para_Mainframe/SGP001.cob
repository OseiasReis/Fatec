       IDENTIFICATION DIVISION.
       PROGRAM-ID. SGP001.
       AUTHOR. OSEIAS RES
      **************************************
      *       CADASTRO DE CEP           *
      **************************************
      *----------------------------------------------------------------
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       SPECIAL-NAMES.
                         DECIMAL-POINT IS COMMA.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
       SELECT CEP ASSIGN TO DISK
                    ORGANIZATION IS INDEXED
                    ACCESS MODE  IS DYNAMIC
                    RECORD KEY   IS CODIGO
                    FILE STATUS  IS ST-ERRO
                    ALTERNATE RECORD KEY IS CODIGO
                                                      WITH DUPLICATES.
      *
      *-----------------------------------------------------------------
       DATA DIVISION.
       FILE SECTION.
       FD CEP
               LABEL RECORD IS STANDARD
               VALUE OF FILE-ID IS "CEP.DAT".
       01 REGAMG.
                03 CODIGO              PIC 9(08).
                03 LOGRADOURO          PIC X(40).
                03 BAIRRO              PIC X(20).
                03 CIDADE              PIC X(20).
                03 UF                  PIC X(02).
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
       01 IND          PIC 9(02) VALUE ZEROS.
       01 UFEXTENSO    PIC X(10) VALUE SPACES.

       01 TABUNIDADEFEDERACAO.
          03 T1   PIC X(12) VALUE "ACACRE      ".
          03 T2   PIC X(12) VALUE "AMAMAPA     ".
          03 T3   PIC X(12) VALUE "SPSAO PAULO ".
          03 T4   PIC X(12) VALUE "RJR.JANEIRO ".
          03 T5   PIC X(12) VALUE "DFDISTR.FED.".
          03 T6   PIC X(12) VALUE "PRPARANA    ".
          03 T7   PIC X(24) VALUE "RSRIO G.SUL  MGM. GERAIS".
          03 T8   PIC X(12) VALUE "RNRIO G.NORT".

       01 TABUFAUX REDEFINES TABUNIDADEFEDERACAO.
          03 TABUF   PIC X(12) OCCURS 08 TIMES.
       01 ALFATP.
           03 ALFATP1 PIC X(02).
           03 ALFATP2 PIC X(10).

       SCREEN SECTION.
       01  TELACEP.
           05  LINE 01  COLUMN 01
               VALUE  "                             CADASTRO DE".
           05  LINE 01  COLUMN 41
               VALUE  " CEP".
           05  LINE 04  COLUMN 01
               VALUE  "    CODIGO:".
           05  LINE 06  COLUMN 01
               VALUE  "    LOGRADOURO:".
           05  LINE 08  COLUMN 01
               VALUE  "    BAIRRO:".
           05  LINE 10  COLUMN 01
               VALUE  "    CIDADE:".
           05  LINE 12  COLUMN 01
               VALUE  "    UF:".
           05  TCODIGO
               LINE 04  COLUMN 13  PIC 99999.999
               USING  CODIGO.
           05  TLOGRADOURO
               LINE 06  COLUMN 17  PIC X(40)
               USING  LOGRADOURO.
           05  TBAIRRO
               LINE 08  COLUMN 13  PIC X(20)
               USING  BAIRRO.
           05  TCIDADE
               LINE 10  COLUMN 13  PIC X(20)
               USING  CIDADE.
           05  TUF
               LINE 12  COLUMN 09  PIC X(02)
               USING  UF.

      *-----------------------------------------------------------------
       PROCEDURE DIVISION.
       INICIO.
      *
       INC-OP0.
           OPEN I-O CEP
           IF ST-ERRO NOT = "00"
               IF ST-ERRO = "30"
                      OPEN OUTPUT CEP
                      CLOSE CEP
                      MOVE "*** ARQUIVO CEP SENDO CRIADO **" TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO INC-OP0
                   ELSE
                      MOVE "ERRO NA ABERTURA DO ARQUIVO CEP" TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO ROT-FIM
                ELSE
                    NEXT SENTENCE.
       INC-001.
                MOVE ZEROS  TO CODIGO.
                MOVE SPACES TO LOGRADOURO BAIRRO CIDADE UF.
                DISPLAY TELACEP.
       INC-002.
                ACCEPT TCODIGO
                ACCEPT W-ACT FROM ESCAPE KEY
                 IF W-ACT = 02
                   CLOSE CEP
                   GO TO ROT-FIM.
                IF CODIGO  = ZEROS
                   MOVE "*** CEP INVALIDO ***" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-002.
       LER-CEP01.
                MOVE 0 TO W-SEL
                READ CEP
                IF ST-ERRO NOT = "23"
                   IF ST-ERRO = "00"
                      DISPLAY TELACEP
                      MOVE "*** CEP JA CADASTRAD0 ***" TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      MOVE 1 TO W-SEL
                      GO TO ACE-001
                   ELSE
                      MOVE "ERRO NA LEITURA ARQ. CEP"   TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO ROT-FIM
                ELSE
                   NEXT SENTENCE.
       INC-003.
                ACCEPT TLOGRADOURO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-002.
       INC-004.
                ACCEPT TBAIRRO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-003.
       INC-004A.
                ACCEPT TCIDADE
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-004.
       INC-005.
                ACCEPT TUF
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-004A.
                MOVE 1 TO IND.
       INC-006.
            MOVE TABUF(IND) TO ALFATP
            IF UF NOT = ALFATP1
                      IF IND < 09
                          ADD 1 TO IND
                          GO TO INC-006
                      ELSE
                          MOVE SPACES TO UFEXTENSO
                          MOVE "UF INVALIDO!" TO MENS
                          PERFORM ROT-MENS THRU ROT-MENS-FIM
                          MOVE 1 TO IND
                          GO TO INC-005
            ELSE
                      MOVE ALFATP2 TO UFEXTENSO.
            DISPLAY TELACEP.

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
                      MOVE "*** CEP JA EXISTE ***       " TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO INC-001
                ELSE
                      MOVE "ERRO NA GRAVACAO DO ARQUIVO" TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO ROT-FIM.
      *
      *****************************************
      * ROTINA DE CONSULTA/ALTERACAO/EXCLUSAO *
      *****************************************
      *
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
                DISPLAY 23, 40 "EXCLUIR   (S/N) : ".
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
                DELETE CEP RECORD
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
                MOVE "ERRO NA EXCLUSAO DO REGISTRO CEP"   TO MENS
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
