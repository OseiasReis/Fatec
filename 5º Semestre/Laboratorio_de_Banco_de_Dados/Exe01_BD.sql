CREATE TABLE DEPTO(
    CODDEPTO NUMBER(5),
    NOMEDEPTO VARCHAR(40)
);

CREATE TABLE PROFESSOR(
    CODPROF NUMBER(4),
    CODDEPTO NUMBER(5),
    NOMEPROF VARCHAR(40),
    CODTIT NUMBER(4)
);

CREATE TABLE DISCIPLINA (
    CODDEPTO NUMBER(5),
    NUMDISC NUMBER(4),
    NOMEDISC VARCHAR(10),
    CREDITODISC NUMBER(4)
);

CREATE TABLE PREREQ (
    CODDEPTOPREREQ CHAR(5),
    NUMDISCPREREQ NUMBER(4),
    CODDEPTO NUMBER(5),
    NUMDISC NUMBER(4)
);

CREATE TABLE TURMA(
    ANOSEM NUMBER(5),
    CODDEPTO NUMBER(5),
    NUMDISC NUMBER(4),
    SIGLATUR CHAR(2),
    CAPACTUR NUMBER(4)
);

CREATE TABLE HORARIO(
    ANOSEM NUMBER(5),
    CODDEPTO NUMBER(5),
    NUMDISC NUMBER(4),
    SIGLATUR CHAR(2),
    DIASEM NUMBER(4),
    HORAINICIO NUMBER(4),
    NUMSALA NUMBER(4),
    CODPRED NUMBER(5),
    NUMHORAS NUMBER(4)
);

CREATE TABLE SALA(
    CODPRED NUMBER(4),
    NUMSALA NUMBER(4),
    DESCRICAOSALA VARCHAR(40),
    CAPACSALA NUMBER(4)
);

CREATE TABLE PREDIO(
    CODPRED NUMBER(4),
    NOMEPRED VARCHAR(40)
);

CREATE TABLE PROFTURMA(
    ANOSEM NUMBER(5),
    CODDEPTO NUMBER(5),
    NUMDISC NUMBER(4),
    SIGLATUR CHAR(2),
    CODPROF NUMBER(4)
);

CREATE TABLE TITULACAO(
    CODTIT NUMBER(4),
    NOMETIT VARCHAR(40)
);

/*PRIMARY*/
ALTER TABLE PROFESSOR ADD CONSTRAINT PK_CODPROF PRIMARY KEY (CODPROF);
ALTER TABLE DISCIPLINA ADD CONSTRAINT PK_NUMDISC PRIMARY KEY (NUMDISC);
ALTER TABLE DEPTO ADD CONSTRAINT PK_CODDEPTO PRIMARY KEY(CODDEPTO);
ALTER TABLE TURMA ADD CONSTRAINT PK_TURMA PRIMARY KEY (ANOSEM,SIGLATUR);
ALTER TABLE HORARIO ADD CONSTRAINT PK_HORARIO PRIMARY KEY (DIASEM,HORAINICIO);
ALTER TABLE SALA ADD CONSTRAINT PK_SALA PRIMARY KEY (NUMSALA);
ALTER TABLE PREDIO ADD CONSTRAINT PK_PREDIO PRIMARY KEY (CODPRED);
ALTER TABLE TITULACAO ADD CONSTRAINT PK_TITULACAO PRIMARY KEY (CODTIT);
ALTER TABLE PREREQ ADD CONSTRAINT PK_CODDEPTOPREREQ PRIMARY KEY(CODDEPTOPREREQ, NUMDISCPREREQ);

/*FOREIGN*/
ALTER TABLE DISCIPLINA ADD CONSTRAINT FK_CODDEPTO1 FOREIGN KEY (CODDEPTO) REFERENCES DEPTO(CODDEPTO);
ALTER TABLE PROFESSOR ADD CONSTRAINT FK_PROFESSOR_RELATION_DEPTO FOREIGN KEY(CODDEPTO) REFERENCES DEPTO(CODDEPTO);
ALTER TABLE PROFESSOR ADD CONSTRAINT FK_PROFESSOR_RELATION_TITULACAO FOREIGN KEY(CODTIT) REFERENCES TITULACAO(CODTIT);
ALTER TABLE PREREQ ADD CONSTRAINT FK_PREREQ_EH_PRE_DEPTO FOREIGN KEY(CODDEPTO) REFERENCES DEPTO(CODDEPTO);
ALTER TABLE PREREQ ADD CONSTRAINT FK_PREFEQ_TEM_PRE_DISCIPLI FOREIGN KEY(NUMDISC) REFERENCES DISCIPLINA(NUMDISC);
ALTER TABLE TURMA ADD CONSTRAINT FK_CODDEPTO2 FOREIGN KEY (CODDEPTO) REFERENCES DEPTO(CODDEPTO);
ALTER TABLE TURMA ADD CONSTRAINT FK_TURMA_RELATION_DISCIPLI FOREIGN KEY (NUMDISC) REFERENCES DISCIPLINA(NUMDISC);
ALTER TABLE HORARIO ADD CONSTRAINT FK_HORARIO_RELATION_TURMA FOREIGN KEY (ANOSEM) REFERENCES TURMA(ANOSEM);
ALTER TABLE HORARIO ADD CONSTRAINT FK_CODDEPTO3 FOREIGN KEY (CODDEPTO) REFERENCES DEPTO(CODDEPTO);
ALTER TABLE HORARIO ADD CONSTRAINT FK_NUMDISC1 FOREIGN KEY (NUMDISC) REFERENCES DISCIPLINA(NUMDISC);
ALTER TABLE HORARIO ADD CONSTRAINT FK_SIGLATUR1 FOREIGN KEY (SIGLATUR) REFERENCES TURMA(SIGLATUR);
ALTER TABLE HORARIO ADD CONSTRAINT FK_HORARIO_RELATION_SALA FOREIGN KEY (NUMSALA) REFERENCES SALA(NUMSALA);
ALTER TABLE HORARIO ADD CONSTRAINT FK_CODPRED1 FOREIGN KEY (CODPRED) REFERENCES PREDIO(CODPRED);
ALTER TABLE SALA ADD CONSTRAINT FK_SALA_RELATION_PREDIO FOREIGN KEY (CODPRED) REFERENCES PREDIO(CODPRED);
ALTER TABLE PROFTURMA ADD CONSTRAINT FK_PROFTURN_PROFTURMA_TURMA FOREIGN KEY (ANOSEM) REFERENCES TURMA(ANOSEM);
ALTER TABLE PROFTURMA ADD CONSTRAINT FK_CODDEPTO4 FOREIGN KEY (CODDEPTO) REFERENCES DEPTO(CODDEPTO);
ALTER TABLE PROFTURMA ADD CONSTRAINT FK_NUMDISC2 FOREIGN KEY (NUMDISC) REFERENCES DISCIPLINA(NUMDISC);
ALTER TABLE PROFTURMA ADD CONSTRAINT FK_PROFTURN_PROFTURMA_TURMAST FOREIGN KEY (SIGLATUR) REFERENCES TURMA(SIGLATUR);
ALTER TABLE PROFTURMA ADD CONSTRAINT FK_PROFTURM_PROFTURMA_PROFESSOR FOREIGN KEY (CODPROF) REFERENCES PROFESSOR(CODPROF);


CREATE SEQUENCE SQ01
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOMAXVALUE;


CREATE OR REPLACE PROCEDURE PROC01 
AS AUX number(4);
BEGIN
    FOR AUX IN 1 .. 5000 LOOP
        INSERT INTO DEPTO(CODDEPTO, NOMEDEPTO) VALUES
                (AUX,'INSERI O' || AUX || ' REGISTRO!');
    END LOOP;
    COMMIT;
END;

/*
CREATE OR REPLACE PROCEDURE PROC01 
AS
BEGIN
DECLARE VARIAVEL VARCHAR(50);
    FOR i .. 5000 LOOP
        INSERT INTO DEPTO(CODDEPTO, NOMEDEPTO) VALUES
                (i,'Informatica'||i);
    END LOOP;
    SELECT NOMEDEPTO INTO :VARIAVEL FROM DEPTO WHERE CODDEPTO = i;
END;*/



/*EXECUTE PROC01;*/
/*BEGIN
    PROC01
END;
*/



DECLARE
    CURSOR cPROF 
    IS
    SELECT NOMEPROF FROM PROFESSOR WHERE PROFESSOR.CODTIT != 3;
    
    vNOME PROFESSOR.NOMEPROF%TYPE;
    
BEGIN
    OPEN cPROF;
    LOOP
        FETCH cPROF INTO vNOME;
        EXIT WHEN cPROF%NOTFOUND;
        SYS.DBMS_OUTPUT.PUT_LINE(vNOME);
    END LOOP;
    CLOSE cPROF;
END;


execute PROC01;
select * from DEPTO;




INSERT INTO predio(CODPRED, NOMEPRED) VALUES (01,'Informática - aulas');
INSERT INTO PREDIO(CODPRED, NOMEPRED) VALUES (02,'Polimeros - aulas');
INSERT INTO PREDIO(CODPRED, NOMEPRED) VALUES (03,'Comex - aulas');

INSERT INTO sala(CODPRED, NUMSALA, DESCRICAOSALA, CAPACSALA)
VALUES (01,101,'Sala Comum',20);
INSERT INTO sala(CODPRED, NUMSALA, DESCRICAOSALA, CAPACSALA)
VALUES (01,102,'Sala Comum',20);
INSERT INTO sala(CODPRED, NUMSALA, DESCRICAOSALA, CAPACSALA)
VALUES (01,103,'Laboratorio',30);
INSERT INTO sala(CODPRED, NUMSALA, DESCRICAOSALA, CAPACSALA)
VALUES (01,104,'Laboratorio',50);
INSERT INTO sala(CODPRED, NUMSALA, DESCRICAOSALA, CAPACSALA)
VALUES (02,10,'Sala Comum',30);
INSERT INTO sala(CODPRED, NUMSALA, DESCRICAOSALA, CAPACSALA)
VALUES (02,11,'Sala Comum',30);
INSERT INTO sala(CODPRED, NUMSALA, DESCRICAOSALA, CAPACSALA)
VALUES (02,20,'Laboratorio',60);
INSERT INTO sala(CODPRED, NUMSALA, DESCRICAOSALA, CAPACSALA)
VALUES (02,21,'Laboratorio',60);
INSERT INTO sala(CODPRED, NUMSALA, DESCRICAOSALA, CAPACSALA)
VALUES (03,1,'Sala Comum',30);
INSERT INTO sala(CODPRED, NUMSALA, DESCRICAOSALA, CAPACSALA)
VALUES (03,2,'Sala Comum',30);
INSERT INTO sala(CODPRED, NUMSALA, DESCRICAOSALA, CAPACSALA)
VALUES (03,3,'Sala Comum',30);
INSERT INTO sala(CODPRED, NUMSALA, DESCRICAOSALA, CAPACSALA)
VALUES (03,4,'Laboratorio',60);


INSERT INTO depto(CODDEPTO, NOMEDEPTO)
VALUES (01,'Informatica');
INSERT INTO depto(CODDEPTO, NOMEDEPTO)
VALUES (02,'Polimeros');
INSERT INTO depto(CODDEPTO, NOMEDEPTO)
VALUES(03,'COMEX');


INSERT INTO disciplina(CODDEPTO, NUMDISC, NOMEDISC, CREDITODISC) 
VALUES (01, 1 ,'Eng1',2);
INSERT INTO disciplina(CODDEPTO, NUMDISC, NOMEDISC, CREDITODISC) 
VALUES(01, 2 ,'Eng2',2);
INSERT INTO disciplina(CODDEPTO, NUMDISC, NOMEDISC, CREDITODISC) 
VALUES(01, 3 ,'Log1',2);
INSERT INTO disciplina(CODDEPTO, NUMDISC, NOMEDISC, CREDITODISC) 
VALUES(03, 4 ,'Ing1',1);
INSERT INTO disciplina(CODDEPTO, NUMDISC, NOMEDISC, CREDITODISC) 
VALUES(03, 5 ,'Ing2',1);
INSERT INTO disciplina(CODDEPTO, NUMDISC, NOMEDISC, CREDITODISC) 
VALUES(03, 6 ,'Ing3',1);
INSERT INTO disciplina(CODDEPTO, NUMDISC, NOMEDISC, CREDITODISC) 
VALUES(02, 7 ,'Cal1',2);
INSERT INTO disciplina(CODDEPTO, NUMDISC, NOMEDISC, CREDITODISC) 
VALUES(02, 8 ,'Cal2',2);
INSERT INTO disciplina(CODDEPTO, NUMDISC, NOMEDISC, CREDITODISC) 
VALUES(01, 9 ,'Eng3',3);
INSERT INTO disciplina(CODDEPTO, NUMDISC, NOMEDISC, CREDITODISC) 
VALUES(01, 10 ,'Eng4',6);


INSERT INTO titulacao(CODTIT, NOMETIT)
VALUES(1,'Doutor');
INSERT INTO titulacao(CODTIT, NOMETIT)
VALUES(2,'Mestre');
INSERT INTO titulacao(CODTIT, NOMETIT)
VALUES(3,'Coordenador');
INSERT INTO titulacao(CODTIT, NOMETIT)
VALUES(4,'Especialista');


INSERT INTO professor(CODPROF, CODDEPTO, CODTIT, NOMEPROF)
VALUES (1,01,1,'Antunes');
INSERT INTO professor(CODPROF, CODDEPTO, CODTIT, NOMEPROF)
VALUES (2,01,2,'Semaj');
INSERT INTO professor(CODPROF, CODDEPTO, CODTIT, NOMEPROF)
VALUES (3,01,3,'Ricardo');
INSERT INTO professor(CODPROF, CODDEPTO, CODTIT, NOMEPROF)
VALUES (4,03,1,'Irineu');
INSERT INTO professor(CODPROF, CODDEPTO, CODTIT, NOMEPROF)
VALUES (5,03,2,'Jailson');
INSERT INTO professor(CODPROF, CODDEPTO, CODTIT, NOMEPROF)
VALUES (6,03,3,'Mario');
INSERT INTO professor(CODPROF, CODDEPTO, CODTIT, NOMEPROF)
VALUES (7,02,1,'Joao');
INSERT INTO professor(CODPROF, CODDEPTO, CODTIT, NOMEPROF)
VALUES (8,02,2,'Marcelo');
INSERT INTO professor(CODPROF, CODDEPTO, CODTIT, NOMEPROF)
VALUES (9,02,3,'Manoel');
INSERT INTO professor(CODPROF, CODDEPTO, CODTIT, NOMEPROF)
VALUES (10,02,4,'Luis');

INSERT INTO turma(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CAPACTUR)
VALUES(20021,01,1,'1D',50);
INSERT INTO turma(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CAPACTUR)
VALUES(20021,01,3,'1D',50);
INSERT INTO turma(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CAPACTUR)
VALUES(20021,03,4,'1A',30);
INSERT INTO turma(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CAPACTUR)
VALUES(20021,02,7,'1B',30);
INSERT INTO turma(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CAPACTUR)
VALUES(20022,01,2,'1D',50);
INSERT INTO turma(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CAPACTUR)
VALUES(20022,03,5,'1A',30);
INSERT INTO turma(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CAPACTUR)
VALUES(20022,02,8,'1B',30);
INSERT INTO turma(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CAPACTUR)
VALUES(20031,03,6,'1A',30);


INSERT INTO PROFTURMA(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CODPROF)
VALUES (20021,01,1,'1D',1);
INSERT INTO PROFTURMA(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CODPROF)
VALUES (20021,01,3,'1D',2);
INSERT INTO PROFTURMA(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CODPROF)
VALUES (20021,03,4,'1A',4);
INSERT INTO PROFTURMA(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CODPROF)
VALUES (20022,03,5,'1A',5);
INSERT INTO PROFTURMA(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CODPROF)
VALUES (20031,03,6,'1A',6);
INSERT INTO PROFTURMA(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CODPROF)
VALUES (20021,02,7,'1B',7);
INSERT INTO PROFTURMA(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, CODPROF)
VALUES (20022,02,8,'1B',9);



INSERT INTO horario(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, DIASEM, HORAINICIO, NUMSALA, CODPRED, NUMHORAS)
VALUES (20021,01,1,'1D',2,19,101,43423,4);
INSERT INTO horario(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, DIASEM, HORAINICIO, NUMSALA, CODPRED, NUMHORAS)
VALUES (20021,01,3,'1D',3,19,102,43423,4);
INSERT INTO horario(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, DIASEM, HORAINICIO, NUMSALA, CODPRED, NUMHORAS)
VALUES (20021,03,4,'1A',2,19,1,43981,2);
INSERT INTO horario(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, DIASEM, HORAINICIO, NUMSALA, CODPRED, NUMHORAS)
VALUES (20022,03,5,'1A',4,19,2,43981,2);
INSERT INTO horario(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, DIASEM, HORAINICIO, NUMSALA, CODPRED, NUMHORAS)
VALUES (20031,03,6,'1A',5,19,3,43981,2);
INSERT INTO horario(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, DIASEM, HORAINICIO, NUMSALA, CODPRED, NUMHORAS)
VALUES (20021,02,7,'1B',3,19,10,43529,4);
INSERT INTO horario(ANOSEM, CODDEPTO, NUMDISC, SIGLATUR, DIASEM, HORAINICIO, NUMSALA, CODPRED, NUMHORAS)
VALUES (20022,02,8,'1B',6,19,11,43529,4);

INSERT INTO PREREQ(CODDEPTOPREREQ, NUMDISCPREREQ, CODDEPTO, NUMDISC)
VALUES(01,1,01,2);
INSERT INTO PREREQ(CODDEPTOPREREQ, NUMDISCPREREQ, CODDEPTO, NUMDISC)
VALUES(01,2,01,9);
INSERT INTO PREREQ(CODDEPTOPREREQ, NUMDISCPREREQ, CODDEPTO, NUMDISC)
VALUES(01,9,01,10);
INSERT INTO PREREQ(CODDEPTOPREREQ, NUMDISCPREREQ, CODDEPTO, NUMDISC)
VALUES(03,4,03,5);
INSERT INTO PREREQ(CODDEPTOPREREQ, NUMDISCPREREQ, CODDEPTO, NUMDISC)
VALUES(03,5,03,6);
INSERT INTO PREREQ(CODDEPTOPREREQ, NUMDISCPREREQ, CODDEPTO, NUMDISC)
VALUES(02,7,02,8);
