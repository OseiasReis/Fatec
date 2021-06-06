       IDENTIFICATION DIVISION.
       PROGRAM-ID. OCP038.
      *********************
      * AUTOR OSÉIAS REIS *
      *  CONSULTA DE CEP  *
      *********************
      *----------------------------------------------------------------
       ENVIRONMENT DIVISION.
       CONFIGURATION SECTION.
       SPECIAL-NAMES.
                    DECIMAL-POINT IS COMMA.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
      *
           SELECT CADCEP ASSIGN TO 'CEPSYSTEM.DAT'
               ORGANIZATION INDEXED
               ACCESS MODE  IS DYNAMIC
               RECORD KEY   IS CEP
               FILE STATUS  IS ST-ERRO
               ALTERNATE RECORD KEY IS LOGR WITH DUPLICATES.
      *
      *-----------------------------------------------------------------
       DATA DIVISION.
       FILE SECTION.
      *
       FD CADCEP
              LABEL RECORD IS STANDARD
              VALUE OF FILE-ID IS W-CADCEP.
       01 OCR001.
           03 CEP.
              05 OCC00101      PIC 9(08).
           03 LOGR.
              05 OCC00102      PIC X(40).
           03 ESTADO.
              05 OCC00103      PIC X(2).
       03 BAIRRO           PIC X(20).
           03 UF            PIC X(02).
       03 UFEXTENSO        PIC X(20).
           03 FILLER           PIC X(21).
      *
      *-----------------------------------------------------------------
       WORKING-STORAGE SECTION.
       01 W-SEL        PIC 9(01) VALUE ZEROS.
       01 W-CONT       PIC 9(04) VALUE ZEROS.
       01 W-OPCAO      PIC X(01) VALUE SPACES.
       01 ST-ERRO      PIC X(02) VALUE "00".
       01 W-ACT        PIC 9(02) VALUE ZEROS.
       01 MENS         PIC X(50) VALUE SPACES.
       01 LIMPA        PIC X(55) VALUE SPACES.
       01 SOLIC        PIC X(20) VALUE SPACES.
       01 W-CADCEP     PIC X(40) VALUE "CADCEP.DAT                    ".
       01 CONLIN       PIC 9(03) VALUE 001.
       01 LIN          PIC 9(03) VALUE 001.
       01 OCW03801     PIC 9(08) VALUE ZEROS.
       01 OCW03802     PIC X(40) VALUE SPACES.
       01 OCW03803     PIC X(12) VALUE SPACES.
       01 OCW03810     PIC 9(15) VALUE ZEROS.
       01 W-EMPRESA    PIC X(20) VALUE "FATEC ZL".
      *-----------------------------------------------------------------
      *              *** CAMPOS PARA TRATAMENTO DE DATA ***
       01 DATA-EQ.
          03 ANO-EQ    PIC 99.
          03 MES-EQ    PIC 99.
          03 DIA-EQ    PIC 99.
       01 DATA-N.
          03 DIA       PIC 99.
          03 MES       PIC 99.
          03 ANO       PIC 99.
       01 DATA-INV.
          03 ANO-INV   PIC 99.
          03 MES-INV   PIC 99.
          03 DIA-INV   PIC 99.
       01 DATA-FOR.
          03 DIA-FOR   PIC 99.
          03 BR1-FOR   PIC X(01) VALUE "/".
          03 MES-FOR   PIC 99.
          03 BR2-FOR   PIC X(01) VALUE "/".
          03 ANO-FOR   PIC 99.
       01 W-01         PIC 9(04).
       01 FLAG1        PIC 9(01).
      *-----------------------------------------------------------------
      *
      ******************
      * REPORT SECTION *
      ******************
      *
       01 DET2.
          03 FILLER    PIC X(11) VALUE SPACES.
          03 DET21     PIC 99999.999.
          03 FILLER    PIC X(04) VALUE SPACES.
          03 DET22     PIC X(40) VALUE SPACES.
      *
      ******************
      * ROTINA DE TELA *
      ******************
      *
       SCREEN SECTION.
       01  OCT038.
           05  BLANK SCREEN.
           05  LINE 01  COLUMN 01
               VALUE  "ÉÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ".
           05  LINE 01  COLUMN 41
               VALUE  "ÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ»".
           05  LINE 02  COLUMN 01
               VALUE  "º                      *** CONSULTA DE C".
           05  LINE 02  COLUMN 41
               VALUE  "EP ***                                 º".
           05  LINE 03  COLUMN 01
               VALUE  "ÇÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ".
           05  LINE 03  COLUMN 41
               VALUE  "ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ¶".
           05  LINE 04  COLUMN 01
               VALUE  "º               CEP                   LO".
           05  LINE 04  COLUMN 41
               VALUE  "GRADOURO                               º".
           05  LINE 05  COLUMN 01
               VALUE  "º            ---------  ----------------".
           05  LINE 05  COLUMN 41
               VALUE  "------------------------               º".
           05  LINE 06  COLUMN 01
               VALUE  "º".
           05  LINE 06  COLUMN 41
               VALUE  "                                       º".
           05  LINE 07  COLUMN 01
               VALUE  "º".
           05  LINE 07  COLUMN 41
               VALUE  "                                       º".
           05  LINE 08  COLUMN 01
               VALUE  "º".
           05  LINE 08  COLUMN 41
               VALUE  "                                       º".
           05  LINE 09  COLUMN 01
               VALUE  "º".
           05  LINE 09  COLUMN 41
               VALUE  "                                       º".
           05  LINE 10  COLUMN 01
               VALUE  "º".
           05  LINE 10  COLUMN 41
               VALUE  "                                       º".
           05  LINE 11  COLUMN 01
               VALUE  "º".
           05  LINE 11  COLUMN 41
               VALUE  "                                       º".
           05  LINE 12  COLUMN 01
               VALUE  "º".
           05  LINE 12  COLUMN 41
               VALUE  "                                       º".
           05  LINE 13  COLUMN 01
               VALUE  "º".
           05  LINE 13  COLUMN 41
               VALUE  "                                       º".
           05  LINE 14  COLUMN 01
               VALUE  "º".
           05  LINE 14  COLUMN 41
               VALUE  "                                       º".
           05  LINE 15  COLUMN 01
               VALUE  "º".
           05  LINE 15  COLUMN 41
               VALUE  "                                       º".
           05  LINE 16  COLUMN 01
               VALUE  "º".
           05  LINE 16  COLUMN 41
               VALUE  "                                       º".
           05  LINE 17  COLUMN 01
               VALUE  "º".
           05  LINE 17  COLUMN 41
               VALUE  "                                       º".
           05  LINE 18  COLUMN 01
               VALUE  "º".
           05  LINE 18  COLUMN 41
               VALUE  "                                       º".
           05  LINE 19  COLUMN 01
               VALUE  "º".
           05  LINE 19  COLUMN 41
               VALUE  "                                       º".
           05  LINE 20  COLUMN 01
               VALUE  "º".
           05  LINE 20  COLUMN 41
               VALUE  "                                       º".
           05  LINE 21  COLUMN 01
               VALUE  "º".
           05  LINE 21  COLUMN 41
               VALUE  "                                       º".
           05  LINE 22  COLUMN 01
               VALUE  "ÇÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ".
           05  LINE 22  COLUMN 41
               VALUE  "ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÂÄÄÄÄÄÄÄÄ¶".
           05  LINE 23  COLUMN 01
               VALUE  "ºMENSAGEM :".
           05  LINE 23  COLUMN 41
               VALUE  "                              ³ OCP038 º".
           05  LINE 24  COLUMN 01
               VALUE  "ÈÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ".
           05  LINE 24  COLUMN 41
               VALUE  "ÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÏÍÍÍÍÍÍÍÍ¼".
           05  T-EMPRESA
               LINE 02  COLUMN 02  PIC X(20)
               USING  W-EMPRESA
               HIGHLIGHT.
           05  DATELA
               LINE 02  COLUMN 69  PIC XX/XX/XX
               USING  DATA-EQ
               HIGHLIGHT.
       01 OCT038T.
           05  OCT03801
               LINE 06  COLUMN 13  PIC ZZZZZ.ZZZ
               USING  OCW03801.
           05  OCT03802
               LINE 06  COLUMN 25  PIC X(40)
               USING  OCW03802.
      *-----------------------------------------------------------------
       PROCEDURE DIVISION.
       INICIO.
      *
           ACCEPT DATA-EQ FROM DATE.
      *
       ROT-INC.
           MOVE   DATA-EQ TO DATA-INV.
           PERFORM INVNOR.
           MOVE DATA-N TO DATA-EQ.
       INC-OP1.
           OPEN INPUT CADCEP
           IF ST-ERRO NOT = "00"
              IF ST-ERRO = "35"
      *           MOVE "ARQUIVO DE CENTROS DE CUSTOS NAO EXISTE" TO MENS
      *           PERFORM ROT-MENS THRU ROT-MENS-FIM
      *           GO TO ROT-FIM2
                  OPEN OUTPUT CADCEP
                  MOVE "ARQUIVO CRIADO COM SUCESSO" TO MENS
                  GO TO INC-001
              ELSE
                 MOVE "ERRO NA ABERTURA DO ARQUIVO  " TO MENS
                 PERFORM ROT-MENS THRU ROT-MENS-FIM
                 GO TO ROT-FIM2
           ELSE
               NEXT SENTENCE.
      *
       INC-001.
           DISPLAY  OCT038.
       INC-001A.
           DISPLAY 23, 13
            "SOLIC.=> F1=ENCERRA CONSULTA   F2=CONSULTA P/LOGR."
           ACCEPT OCT03801
           ACCEPT W-ACT FROM ESCAPE KEY
           IF W-ACT = 02
                      CLOSE CADCEP
                      GO TO ROT-FIM.
           IF W-ACT = 03
                      GO TO INC-001B.
           IF W-ACT > 03
                      MOVE "*** FUNCAO NAO DEFINIDA ***" TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO INC-001A.
           MOVE OCW03801 TO OCC00101
           START CADCEP KEY IS NOT LESS CEP INVALID KEY
                 MOVE "*** FIM DE PROCESSAMENTO ***" TO MENS
                 PERFORM ROT-MENS THRU ROT-MENS-FIM
                 GO TO INC-001.
           GO TO INC-RD2.
       INC-001B.
           DISPLAY 23, 13
            "SOLIC.=> F1=ENCERRA CONSULTA     F2=CONSULTA P/CEP "
           ACCEPT OCT03802
           ACCEPT W-ACT FROM ESCAPE KEY
           IF W-ACT = 02
                      CLOSE CADCEP
                      GO TO ROT-FIM.
           IF W-ACT = 03
                      GO TO INC-001A.
           IF W-ACT > 03
                      MOVE "*** FUNCAO NAO DEFINIDA ***" TO MENS
                      PERFORM ROT-MENS THRU ROT-MENS-FIM
                      GO TO INC-001A.
           MOVE OCW03802 TO OCC00102
           START CADCEP KEY IS NOT LESS LOGR INVALID KEY
                 MOVE "*** FIM DE PROCESSAMENTO ***" TO MENS
                 PERFORM ROT-MENS THRU ROT-MENS-FIM
                 GO TO INC-001B.
       INC-RD2.
           DISPLAY 23, 13 LIMPA
           READ CADCEP NEXT
           IF ST-ERRO NOT = "00"
              IF ST-ERRO = "10"
                 MOVE "*** FIM DE PROCESSAMENTO ***" TO MENS
                 PERFORM ROT-MENS THRU ROT-MENS-FIM
                 GO TO NOV-SOL
              ELSE
                 MOVE ST-ERRO TO MENS
                 PERFORM ROT-MENS THRU ROT-MENS-FIM
                 GO TO ROT-FIM
           ELSE
              NEXT SENTENCE.
       ROT-MONTAR.
           MOVE OCC00101 TO DET21
           MOVE OCC00102 TO DET22
           COMPUTE LIN = CONLIN + 5
           DISPLAY LIN, 02 DET2
           ADD 1 TO CONLIN
           IF CONLIN < 17
                  GO TO INC-RD2.
      *
       ROT-SOL.
           DISPLAY 23, 13 " *** CONTINUA CONSULTA : . ***"
           MOVE "S" TO W-OPCAO
           ACCEPT W-OPCAO  WITH UPDATE
           IF W-OPCAO = "S"
                  MOVE 01 TO CONLIN
                  DISPLAY OCT038
                  GO TO INC-RD2.
           IF W-OPCAO NOT = "N"
                  MOVE "*** DIGITE S=SIM   N=NAO ***" TO MENS
                  PERFORM ROT-MENS THRU ROT-MENS-FIM
                  GO TO ROT-SOL.
           MOVE 01 TO CONLIN.
           GO TO INC-001.
      *
       NOV-SOL.
           DISPLAY 23, 13 " *** NOVA CONSULTA : . ***"
           MOVE "S" TO W-OPCAO
           ACCEPT  W-OPCAO WITH UPDATE
           IF W-OPCAO = "S"
                  MOVE 01 TO CONLIN
                  MOVE ZEROS  TO OCW03801
                  MOVE SPACES TO OCW03802
                  GO TO INC-001.
           IF W-OPCAO NOT = "N"
                  MOVE "*** DIGITE S=SIM   N=NAO ***" TO MENS
                  PERFORM ROT-MENS THRU ROT-MENS-FIM
                  GO TO NOV-SOL.
      *
      **********************
      * ROTINA DE FIM      *
      **********************
      *
       ROT-FIM.
           CLOSE CADCEP.
       ROT-FIM2.
           EXIT PROGRAM.
       ROT-FIM3.
           STOP RUN.
      *
      **********************
      * ROTINA DE MENSAGEM *
      **********************
      *
       ROT-MENS.
           MOVE ZEROS TO W-CONT.
       ROT-MENS1.
           DISPLAY 23, 13 MENS.
       ROT-MENS2.
           ADD 1 TO W-CONT
           IF W-CONT < 1000
              GO TO ROT-MENS2
           ELSE
              DISPLAY 23, 12 LIMPA.
       ROT-MENS-FIM.
           EXIT.
       FIM-ROT-MENS.
      *
      ************************************
      *      *** ROTINA DE DATA ***      *
      ************************************
      *
      *
      *
       FORNOR.
           MOVE DIA-FOR TO DIA
           MOVE MES-FOR TO MES
           MOVE ANO-FOR TO ANO.
      *
      * FUNCAO : CONVERTE DATA FORMATADA EM NORMAL
      *
       NORINV.
           MOVE DIA     TO DIA-INV DIA-FOR
           MOVE MES     TO MES-INV MES-FOR
           MOVE ANO     TO ANO-INV ANO-FOR.
      *
      * FUNCAO : CONVERTE DATA NORMAL P/INVERTIDA E FORMATADA
      *
       INVNOR.
           MOVE DIA-INV TO DIA DIA-FOR
           MOVE MES-INV TO MES MES-FOR
           MOVE ANO-INV TO ANO ANO-FOR.
      *
      * FUNCAO : CONVERTE DATA INVERTIDA PARA NORMA
      *
       VALDATA.
           MOVE 0 TO FLAG1.
           GO TO D31 D28 D31 D30 D31 D30 D31 D31 D30 D31 D30 D31
                                          DEPENDING ON MES
           MOVE 1 TO FLAG1
           GO TO VALDATA-FIM.
       D31.
           IF DIA > 31
              MOVE 2 TO FLAG1
              GO TO VALDATA-FIM.
       D30.
           IF DIA > 30
              MOVE 2 TO FLAG1
              GO TO VALDATA-FIM.
       D28.
           COMPUTE W-01 = ANO / 4
           COMPUTE W-01 = W-01 * 4
           COMPUTE W-01 = ANO - W-01
           IF W-01 = ZEROS
                IF DIA > 29
                  MOVE 2 TO FLAG1
                  GO TO VALDATA-FIM
                ELSE
                  IF DIA > 28
                    MOVE 2 TO FLAG1
                    GO TO VALDATA-FIM.
       VALDATA-FIM.
      *
      *---------------------*** FIM DE PROGRAMA ***--------------------*
