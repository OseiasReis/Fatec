       IDENTIFICATION DIVISION.
       PROGRAM-ID. SGP002.
       AUTHOR. OSEIAS.
      **************************************
      *       CADASTRO DE PRODUTO           *
      **************************************
      *----------------------------------------------------------------
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       SPECIAL-NAMES.
                         DECIMAL-POINT IS COMMA.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
       SELECT PRODUTO ASSIGN TO DISK
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
       FD PRODUTO
               LABEL RECORD IS STANDARD
               VALUE OF FILE-ID IS "PRODUTO.DAT".
       01 REGAMG.
                03 CODIGO              PIC 9(08).
                03 DESCRICAO           PIC X(30).
                03 UNIDADE             PIC X(02).
                03 PRECOCUSTO          PIC 9(06).
                03 PRECOVENDA          PIC 9(06).
                03 CLASSIFICACAO       PIC 9(01).
                03 SITUACAO            PIC X(01).
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
       01 PRODUTOEXTENSO    PIC X(10) VALUE SPACES.
       01 CLASSEXTENSO      PIC X(10) VALUE SPACES.
       01 SITUEXTENSO       PIC X(10) VALUE SPACES.

       01 TABUNIDADEX.
          03 FILLER   PIC X(12) VALUE "PCPECA      ".
          03 FILLER   PIC X(12) VALUE "LTLITRO       ".
          03 FILLER   PIC X(12) VALUE "LALATA      ".
          03 FILLER   PIC X(12) VALUE "P2PET2LITROS".
          03 FILLER   PIC X(12) VALUE "P6PET 600   ".
          03 FILLER   PIC X(12) VALUE "CXCAIXA     ".
          03 FILLER   PIC X(24) VALUE "UNUNIDADE   ".

       01 TABUNIDADEAUX REDEFINES TABUNIDADEX.
          03 TABUNIDADE  PIC X(12) OCCURS 08 TIMES.
       01 ALFATP.
           03 ALFATP1 PIC X(02).
           03 ALFATP2 PIC X(10).

       01 TABCLASSIFICAOX.
          03 FILLER  PIC X(12) VALUE "ASSADO    ".
          03 FILLER  PIC X(12) VALUE "FRITO     ".
          03 FILLER  PIC X(12) VALUE "REFRI     ".
          03 FILLER  PIC X(12) VALUE "CERVEJA   ".
          03 FILLER  PIC X(12) VALUE "DOCE      ".
          03 FILLER  PIC X(12) VALUE "A         ".
          03 FILLER  PIC X(24) VALUE "B         ".
          03 FILLER  PIC X(12) VALUE "C         ".
          03 FILLER  PIC X(12) VALUE "D         ".

       01 TABCLASSIFICAOAUX REDEFINES TABCLASSIFICAOX.
          03 TABCLASSIFICAO   PIC X(12) OCCURS 09 TIMES.


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
       01  TELAPRODUTO.
           05  LINE 02  COLUMN 01
               VALUE  "                             CADASTRO DE".
           05  LINE 02  COLUMN 41
               VALUE  " PRODUTO".
           05  LINE 04  COLUMN 01
               VALUE  "    CODIGO:".
           05  LINE 06  COLUMN 01
               VALUE  "    DESCRICAO:".
           05  LINE 08  COLUMN 01
               VALUE  "    UNIDADE:".
           05  LINE 10  COLUMN 01
               VALUE  "    PRECOCUSTO".
           05  LINE 12  COLUMN 01
               VALUE  "    PRECOVENDA:".
           05  LINE 14  COLUMN 01
               VALUE  "    CLASSIFICACAO:".
           05  LINE 16  COLUMN 01
               VALUE  "    SITUACAO:".
           05  TCODIGO
               LINE 04  COLUMN 12  PIC 9(05)
               USING  CODIGO.
           05  TDESCRICAO
               LINE 06  COLUMN 15  PIC X(30)
               USING  DESCRICAO.
           05  TUNIDADE
               LINE 08  COLUMN 13  PIC X(02)
               USING  UNIDADE.
           05  TUNEXTENSO
               LINE 08  COLUMN 16  PIC X(12)
               USING PRODUTOEXTENSO.
           05  TPRECOCUSTO
               LINE 10  COLUMN 15  PIC ZZZ.ZZ9,99
               USING  PRECOCUSTO.
           05  TPRECOVENDA
               LINE 12  COLUMN 16  PIC ZZZ.ZZ9,99
               USING  PRECOVENDA.
           05  TCLASSIFICACAO
               LINE 14  COLUMN 19  PIC 9(01)
               USING  CLASSIFICACAO.
           05  TUCLASS
               LINE 14  COLUMN 22  PIC X(12)
               USING CLASSEXTENSO.
           05  TSITUACAO
               LINE 16  COLUMN 14  PIC X(01)
               USING  SITUACAO.
           05  TUSITU
               LINE 16  COLUMN 16  PIC X(12)
               USING SITUEXTENSO.

      *-----------------------------------------------------------------
       PROCEDURE DIVISION.
       INICIO.
      *
       INC-OP0.
           OPEN I-O PRODUTO
           IF ST-ERRO NOT = "00"
               IF ST-ERRO = "30"
                      OPEN OUTPUT PRODUTO
                      CLOSE PRODUTO
                      MOVE "*** ARQUIVO PRODUTO SENDO CRIADO **" TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO INC-OP0
                   ELSE
                      MOVE "ERRO NA ABERTURA DO ARQUIVO PRODUTO" TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO ROT-FIM
                ELSE
                    NEXT SENTENCE.
       INC-001.
                MOVE ZEROS TO CODIGO PRECOCUSTO PRECOVENDA CLASSIFICACAO.
                MOVE SPACES TO DESCRICAO UNIDADE SITUACAO.
                DISPLAY TELAPRODUTO.
       INC-002.
                ACCEPT TCODIGO
                ACCEPT W-ACT FROM ESCAPE KEY
                 IF W-ACT = 02
                   CLOSE PRODUTO
                   GO TO ROT-FIM.
                IF CODIGO  = ZEROS
                   MOVE "*** PRODUTO INVALIDO ***" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-002.
       LER-PRODUTO01.
                MOVE 0 TO W-SEL
                READ PRODUTO
                IF ST-ERRO NOT = "23"
                   IF ST-ERRO = "00"
              PERFORM INC-004A
              PERFORM INC-009
              PERFORM INC-010A
                      DISPLAY TELAPRODUTO
                      MOVE "*** PRODUTO JA CADASTRAD0 ***" TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      MOVE 1 TO W-SEL
                      GO TO ACE-001
                   ELSE
                      MOVE "ERRO NA LEITURA ARQ. PRODUTO"   TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO ROT-FIM
                ELSE
                   NEXT SENTENCE.
       INC-003.
                ACCEPT TDESCRICAO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-002.
       INC-004.
                ACCEPT TUNIDADE
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-003.
       INC-004A.
                MOVE 1 TO IND.
       INC-005.
            MOVE TABUNIDADE(IND) TO ALFATP

            IF UNIDADE NOT = ALFATP1
                      IF IND < 08
                          ADD 1 TO IND
                          GO TO INC-005
                      ELSE
                          MOVE SPACES TO PRODUTOEXTENSO
                          MOVE "PRODUTO INVALIDO!" TO MENS
                          PERFORM ROT-MENS THRU ROT-MENS-FIM
                          MOVE 1 TO IND
                          GO TO INC-004
            ELSE
                      MOVE ALFATP2 TO PRODUTOEXTENSO
                      DISPLAY TELAPRODUTO.
       INC-006.
                ACCEPT TPRECOCUSTO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-004.
       INC-007.
                ACCEPT TPRECOVENDA
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-006.
       INC-008.
                ACCEPT TCLASSIFICACAO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-007.
            IF CLASSIFICACAO = 0
                   MOVE "* DIGITE NUMEROS DE 1 A 9 *" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-008.
                MOVE CLASSIFICACAO TO IND.
       INC-009.
            MOVE TABCLASSIFICAO(IND) TO CLASSEXTENSO.

       INC-010.
                ACCEPT TSITUACAO
                ACCEPT W-ACT FROM ESCAPE KEY
                IF W-ACT = 02 GO TO INC-008.
       INC-010A.
                MOVE 1 TO IND.
       INC-011.
            MOVE TABSITUACAO(IND) TO ALFATP02
            IF SITUACAO NOT = ALFATP5
                      IF IND < 03
                          ADD 1 TO IND
                          GO TO INC-011
                      ELSE
                          MOVE SPACES TO PRODUTOEXTENSO
                          MOVE "PRODUTO INVALIDO!" TO MENS
                          PERFORM ROT-MENS THRU ROT-MENS-FIM
                          MOVE 1 TO IND
                          GO TO INC-010
            ELSE
                      MOVE ALFATP6 TO SITUEXTENSO.
            DISPLAY TELAPRODUTO.

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
                      MOVE "*** PRODUTO JA EXISTE ***       " TO MENS
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
                ACCEPT  W-OPCAO
                IF W-OPCAO = "N" OR "n"
                   MOVE "*** REGISTRO NAO EXCLUIDO ***" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO INC-001.
                IF W-OPCAO NOT = "S" AND "s"
                   MOVE "* DIGITE APENAS S=SIM  e  N=NAO *" TO MENS
                   PERFORM ROT-MENS THRU ROT-MENS-FIM
                   GO TO EXC-OPC.
       EXC-DL1.
                DELETE PRODUTO RECORD
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
                MOVE "ERRO NA EXCLUSAO DO REGISTRO PRODUTO"   TO MENS
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
                   DISPLAY 23, 12 LIMPA.
       ROT-MENS-FIM.
                EXIT.
       FIM-ROT-TEMPO.
