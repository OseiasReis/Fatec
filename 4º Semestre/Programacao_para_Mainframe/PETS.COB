       IDENTIFICATION DIVISION.
       PROGRAM-ID. CADASTRO-PET.
      ****************************
      * AUTHOR - OSEIAS P. REIS
      ****************************
       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
         SELECT PETS ASSIGN TO 'PETSHOPSYSTEM.DAT'
         ORGANIZATION INDEXED
         ACCESS MODE IS RANDOM
         FILE STATUS IS PETS-STATUS
         RECORD KEY PETS-KEY.
       DATA DIVISION.
       FILE SECTION.
       FD PETS.
       01 PETS-REG.
           05 PETS-KEY.
              10 PETS-TEL  PIC 9(09).
           05 PETS-NOME    PIC X(30).
           05 PETS-CLIENTE PIC X(30).

       WORKING-STORAGE SECTION.
           77 PETS-STATUS        PIC 9(02).
           77 MODULO             PIC X(25).
           77 TECLA              PIC X(01).
           77 OPCAO              PIC X(02).
           77 ERRO               PIC X(30).

           SCREEN SECTION.
           01 TELA.
             05 TELA-CLEAR.
               10 BLANK SCREEN.
               10 LINE 01 COLUMN 01 PIC X(20) ERASE EOL
                 BACKGROUND-COLOR 6.
               10 LINE 01 COLUMN 25 PIC X(20)
               BACKGROUND-COLOR 6 FOREGROUND-COLOR 0
               FROM 'PETSHOP SOFTWARE'.
               10 LINE 02 COLUMN 01 PIC X(25) ERASE EOL
                 BACKGROUND-COLOR 6 FROM MODULO.
           01 MENU.
             05 LINE 08 COLUMN 45 VALUE '1-ACRESCENTAR'.
             05 LINE 09 COLUMN 45 VALUE '2-BUSCAR'.
             05 LINE 10 COLUMN 45 VALUE '3-EXCLUIR'.
             05 LINE 11 COLUMN 45 VALUE '4-SAIR'.
             05 LINE 14 COLUMN 45 VALUE 'OPCAO: ' .
             05 LINE 14 COLUMN 52 USING OPCAO.

           01 TELA-REG.
               05 CHAVE FOREGROUND-COLOR 2.
                 10 LINE 10 COLUMN 10 VALUE 'TELEFONE'.
                 10 COLUMN PLUS 2 PIC 9(09) USING PETS-TEL
                   BLANK WHEN ZEROS.
               05 SS-DADOS.
                 10 LINE 11 COLUMN 10 VALUE 'NOME DO PET: '.
                 10 COLUMN PLUS 2 PIC X(20) USING PETS-NOME.
                 10 LINE 12 COLUMN 10 VALUE 'NOME DO CLIENTE: '.
                 10 COLUMN PLUS 2 PIC X(20) USING PETS-CLIENTE.

           01 ERRORMENS.
               02 MSGERRO.
                 10 LINE 16 COLUMN 01 ERASE EOL BACKGROUND-COLOR 3.
                 10 LINE 16 COLUMN 10 PIC X(30) BACKGROUND-COLOR 3
                 FROM ERRO.
                 10 COLUMN PLUS 2 PIC X(01) BACKGROUND-COLOR 3
                 USING TECLA.

           PROCEDURE DIVISION.
           001-TELA SECTION.
             PERFORM 1000-INICIAR THRU 1500-SCREEN.
             PERFORM 2000-GERARDADOS UNTIL OPCAO = '4'.
             PERFORM 3000-ENCERRAR.
             STOP RUN.

           1000-INICIAR.
             OPEN I-O PETS
             IF PETS-STATUS = 35 THEN
               OPEN OUTPUT PETS
               CLOSE PETS
               OPEN I-O PETS
              END-IF.

           1500-SCREEN.
            DISPLAY TELA.
            ACCEPT MENU.

           2000-GERARDADOS.
             MOVE SPACES TO PETS-NOME PETS-CLIENTE ERRO.
             MOVE ZEROS TO PETS-TEL ERRO.
             EVALUATE OPCAO
             WHEN 1 PERFORM 5000-ACRESCENTAR
             WHEN 2 PERFORM 6000-BUSCAR
             WHEN 3 PERFORM 7000-EXCLUIR
             WHEN 4 PERFORM 3000-ENCERRAR
             WHEN OTHER
                DISPLAY 'OPCAO INVALIDA'
             END-EVALUATE.
               PERFORM 1500-SCREEN.

           3000-ENCERRAR.
               CLOSE PETS.

           5000-ACRESCENTAR.
             MOVE 'INCLUSAO' TO MODULO.
             DISPLAY TELA.
             ACCEPT TELA-REG.
              WRITE PETS-REG
               INVALID KEY
                 MOVE 'JA EXISTE, NOVO REGISTRO?' TO ERRO
                 ACCEPT ERRORMENS
                   IF TECLA = 'N' OR TECLA = 'n'
                     MOVE ZEROS TO PETS-TEL
                     PERFORM 5000-ACRESCENTAR
                    END-IF
               END-WRITE.

           6000-BUSCAR.
             MOVE 'CONSULTA' TO MODULO.
             DISPLAY TELA.
             DISPLAY TELA-REG.
             ACCEPT CHAVE.
               READ PETS
                 INVALID KEY
                   MOVE 'NAO ENCONTRADO' TO ERRO
                 NOT INVALID KEY
                     DISPLAY SS-DADOS
               END-READ.
                 ACCEPT ERRORMENS.

           7000-EXCLUIR.
             MOVE 'EXCLUSAO ' TO MODULO.
             DISPLAY TELA.
             DISPLAY TELA-REG.
             ACCEPT CHAVE.
               READ PETS
                 INVALID KEY
                   MOVE 'NAO ENCONTRADO' TO ERRO
                 NOT INVALID KEY
                   MOVE 'ENCONTRADO S ou N?' TO ERRO
                     DISPLAY SS-DADOS
               END-READ.
                  ACCEPT ERRORMENS.
                   IF TECLA = 'S' AND PETS-STATUS = 0
                     DELETE PETS
                         INVALID KEY
                         MOVE 'NAO EXCLUIDO' TO ERRO
                         ACCEPT ERRORMENS
                     END-DELETE
                   END-IF.
