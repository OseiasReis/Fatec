      ******************************************************************
      * Author: OSÉIAS P. REIS
      * Date: 12/11
      ******************************************************************
       IDENTIFICATION DIVISION.
       PROGRAM-ID. CADVEN.
       ENVIRONMENT DIVISION.
        INPUT-OUTPUT SECTION.
       FILE-CONTROL.
         SELECT VENDAS ASSIGN TO 'VENDAS.DAT'
         ORGANIZATION INDEXED
         ACCESS MODE IS RANDOM
         FILE STATUS IS VENDAS-STATUS
         RECORD KEY CODCLI.
       DATA DIVISION.
       FILE SECTION.

       FD VENDAS.
       01 VENDAS-REG.
           05 CODCLI      PIC 9(09).
           05 PROD         PIC X(09).
           05 NVENDA       PIC 9(04).
           05 UNID         PIC 9(04).
           05 PRECOCUSTO   PIC X(10).
           05 PRECOVENDA   PIC X(10).
           05 QTD          PIC 9(05).
           05 VALORVENDA   PIC X(10).



       WORKING-STORAGE SECTION.
           77 VENDAS-STATUS      PIC 9(02).
           77 WRK-MODULO         PIC X(25).
           77 WRK-OPCAO          PIC X(02).
           77 WRK-TECLA          PIC X(01).
           77 WRK-MSGERRO        PIC X(30).

           SCREEN SECTION.
           01 TELA.
             05 LIMPA-TELA.
               10 BLANK SCREEN.
               10 LINE 01 COLUMN 01 PIC X(20) ERASE EOL
                 BACKGROUND-COLOR 3.

                10 LINE 01 COLUMN 25 PIC X(20)
                BACKGROUND-COLOR 3 FOREGROUND-COLOR 0
                FROM 'SISTEMA VENDAS'.

               10 LINE 03 COLUMN 01 PIC X(25) ERASE EOL
                 BACKGROUND-COLOR 1 FROM WRK-MODULO.
           01 MENU.
             05 LINE 07 COLUMN 15 VALUE '1 - INCLUIR'.
             05 LINE 08 COLUMN 15 VALUE '2 - CONSULTAR'.
             05 LINE 09 COLUMN 15 VALUE '3 - EXCLUIR'.
             05 LINE 12 COLUMN 15 VALUE 'X - SAIR'.
             05 LINE 13 COLUMN 15 VALUE 'OPCAO: ' .
             05 LINE 13 COLUMN 22 USING WRK-OPCAO.

           01 TELA-REGISTRO.
               05 CHAVE FOREGROUND-COLOR 2.
                 10 LINE 10 COLUMN 10 VALUE 'CODIGO CLIENTE'.
                 10 COLUMN PLUS 2 PIC 9(09) USING CODCLI
                   BLANK WHEN ZEROS.

               05 SS-DADOS.
                 10 LINE 11 COLUMN 10 VALUE 'CLIENTE: '.
                 10 COLUMN PLUS 2 PIC X(20) USING CODCLI.
                 10 LINE 12 COLUMN 10 VALUE 'PRODUTO: '.
                 10 COLUMN PLUS 2 PIC X(20) USING PROD.
                 10 LINE 13 COLUMN 10 VALUE 'NÚMERO DE VENDA: '.
                 10 COLUMN PLUS 2 PIC X(20) USING NVENDA.
                 10 LINE 14 COLUMN 10 VALUE 'UNIDADE: '.
                 10 COLUMN PLUS 2 PIC X(20) USING UNID.
                 10 LINE 15 COLUMN 10 VALUE 'PREÇO CUSTO: '.
                 10 COLUMN PLUS 2 PIC X(20) USING PRECOCUSTO.
                 10 LINE 16 COLUMN 10 VALUE 'PREÇO VENDA: '.
                 10 COLUMN PLUS 2 PIC X(20) USING PRECOVENDA.
                 10 LINE 17 COLUMN 10 VALUE 'QUANTIDADE: '.
                 10 COLUMN PLUS 2 PIC X(20) USING QTD.
                 10 LINE 18 COLUMN 10 VALUE 'VALOR DE VENDA : '.
                 10 COLUMN PLUS 2 PIC X(20) USING VALORVENDA.


           01 MOSTRA-ERRO.
               02 MSG-ERRO.
                 10 LINE 16 COLUMN 01 ERASE EOL
                 BACKGROUND-COLOR 3.
                 10 LINE 16 COLUMN 10 PIC X(30)
                 BACKGROUND-COLOR 3 FROM WRK-MSGERRO.
                 10 COLUMN PLUS 2 PIC X(01)
                 BACKGROUND-COLOR 3 USING WRK-TECLA.

           PROCEDURE DIVISION.
      ******MOSTRA DADOS
           001-PRINCIPAL SECTION.
             PERFORM 1000-INICIAR THRU 1100-MONTATELA.
             PERFORM 2000-PROCESSAR UNTIL WRK-OPCAO = 'X'.
             PERFORM 3000-FINALIZAR.
             STOP RUN.

           1000-INICIAR.
             OPEN I-O VENDAS
             IF VENDAS-STATUS = 35 THEN
               OPEN OUTPUT VENDAS
               CLOSE VENDAS
               OPEN I-O VENDAS
              END-IF.

           1100-MONTATELA.
            DISPLAY TELA.
            ACCEPT MENU.

           2000-PROCESSAR.
             MOVE SPACES TO PROD PRECOCUSTO PRECOVENDA
             VALORVENDA WRK-MSGERRO.
             MOVE ZEROS TO CODCLI NVENDA UNID QTD
             WRK-MSGERRO.
             EVALUATE WRK-OPCAO
             WHEN 1
               PERFORM 5000-INCLUIR
             WHEN 2
               PERFORM 6000-CONSULTAR
             WHEN 3
               PERFORM 7000-EXCLUIR
             WHEN OTHER
               IF WRK-OPCAO NOT EQUAL 'X'
                   DISPLAY 'OPCAO INVALIDA'
               END-IF
             END-EVALUATE.
               PERFORM 1100-MONTATELA.

           3000-FINALIZAR.
               CLOSE VENDAS.

           5000-INCLUIR.
             MOVE 'MODULO - INCLUSAO' TO WRK-MODULO.
             DISPLAY TELA.
             ACCEPT TELA-REGISTRO.
              WRITE VENDAS-REG
               INVALID KEY
                 MOVE 'JA EXISTE!(N)OVO REGISTRO?' TO WRK-MSGERRO
                 ACCEPT MOSTRA-ERRO
                   IF WRK-TECLA = 'N' OR WRK-TECLA = 'n'
                     MOVE ZEROS TO CODCLI
                     PERFORM 5000-INCLUIR
                    END-IF
               END-WRITE.

           6000-CONSULTAR.
             MOVE 'MODULO - CONSULTA ' TO WRK-MODULO.
             DISPLAY TELA.
               DISPLAY TELA-REGISTRO.
               ACCEPT CHAVE.
               READ VENDAS
                 INVALID KEY
                   MOVE 'NAO ENCONTRADO' TO WRK-MSGERRO
                 NOT INVALID KEY
                     DISPLAY SS-DADOS
               END-READ.
                 ACCEPT MOSTRA-ERRO.

           7000-EXCLUIR.
             MOVE 'MODULO - EXCLUSAO ' TO WRK-MODULO.
             DISPLAY TELA.
               DISPLAY TELA-REGISTRO.
               ACCEPT CHAVE.
               READ VENDAS
                 INVALID KEY
                   MOVE 'NAO ENCONTRADO' TO WRK-MSGERRO
                 NOT INVALID KEY
                   MOVE 'ENCONTRADO (S/N)?' TO WRK-MSGERRO
                     DISPLAY SS-DADOS
               END-READ.
                  ACCEPT MOSTRA-ERRO.
                   IF WRK-TECLA = 'S' AND VENDAS-STATUS = 0
                     DELETE VENDAS
                         INVALID KEY
                         MOVE 'NAO EXCLUIDO' TO WRK-MSGERRO
                         ACCEPT MOSTRA-ERRO
                     END-DELETE
                   END-IF.

       END PROGRAM CADVEN.
