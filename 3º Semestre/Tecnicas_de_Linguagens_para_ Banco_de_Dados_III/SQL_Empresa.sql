
CREATE DATABASE Empresa;
USE Empresa;

CREATE TABLE Departamento(
Cod_dep int not null,
DescD varchar(50) not null,
Localiz varchar(30) not null
);

CREATE TABLE Funcionario(
Cod_func int not null,
Nome varchar(50) not null,
Dt_nasc date,
Cod_dep int
);

CREATE TABLE Projeto(
Cod_proj int not null,
Nome varchar(50) not null,
Orcamento float not null,
Dt_ini date not null,
Dt_prev_term date not null
);

CREATE TABLE Funcao(
Cod_funcao int not null,
Nome varchar(50) not null,
Sal float not null
);

CREATE TABLE Trabalha(
Cod_func int not null,
Cod_proj int not null,
Cod_funcao int not null,
Dt_ent date not null,
Dt_sai date
);


ALTER TABLE Departamento ADD CONSTRAINT pk_departamento PRIMARY KEY (Cod_dep);
ALTER TABLE Funcionario ADD CONSTRAINT pk_funcionario PRIMARY KEY (Cod_func);
ALTER TABLE Projeto ADD CONSTRAINT pk_projeto PRIMARY KEY (Cod_proj);
ALTER TABLE Funcao ADD CONSTRAINT pk_funcao PRIMARY KEY (Cod_funcao);


ALTER TABLE Funcionario ADD CONSTRAINT fk_funcionario foreign key (Cod_dep) references Departamento (Cod_dep);
ALTER TABLE Trabalha ADD CONSTRAINT fk_trabalha0 foreign key (Cod_func) references Funcionario (Cod_func);
ALTER TABLE Trabalha ADD CONSTRAINT fk_trabalha1 foreign key (Cod_proj) references Projeto (Cod_proj);
ALTER TABLE Trabalha ADD CONSTRAINT fk_trabalha2 foreign key (Cod_funcao) references Funcao (Cod_funcao);


INSERT INTO Departamento ( Cod_dep , DescD , Localiz ) VALUES
('1', 'Informatica', '3 - Andar');
INSERT INTO Departamento ( Cod_dep , DescD , Localiz ) VALUES
('2', 'Juridico', '4 - Andar');
INSERT INTO Departamento ( Cod_dep , DescD , Localiz ) VALUES
('3', 'Logistica', '6 - Andar');
INSERT INTO Departamento ( Cod_dep , DescD , Localiz ) VALUES
('4', 'Direito', '5 - Andar');
INSERT INTO Departamento ( Cod_dep , DescD , Localiz ) VALUES
('5', 'Administracao', '2 - Andar');
INSERT INTO Departamento ( Cod_dep , DescD , Localiz ) VALUES
('6', 'Recursos Humanos', '1 - Andar');
INSERT INTO Departamento ( Cod_dep , DescD , Localiz ) VALUES
('7', 'Engenharia', '7 - Andar');
INSERT INTO Departamento ( Cod_dep , DescD , Localiz ) VALUES
('8', 'Arquitetura', '9 - Andar');
INSERT INTO Departamento ( Cod_dep , DescD , Localiz ) VALUES
('9', 'Contabilidade', '8 - Andar');


INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('001', 'Oseias', '1999-05-10' , '1');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('002', 'Sara', '1999-06-11' , '2');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('003', 'Julia', '1999-05-24' , '3');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('004', 'Isabella', '1999-05-09' , '4');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('005', 'Gabriella', '1999-10-25' , '5');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('006', 'Bianca', '1999-03-31' , '6');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('007', 'Giovana', '1999-01-21' , '7');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('008', 'Jessica', '1999-03-15' , '8');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('009', 'Sabrina', '1998-08-18' , '9');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('010', 'Nicole', '1999-04-12' , '1');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('011', 'Nagila', '1998-11-13' , '2');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('012', 'Ingrid', '1999-02-12' , '3');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('013', 'Pamela', '1997-06-22' , '4');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('014', 'Paloma', '1999-09-28' , '5');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('015', 'Nayara', '1998-03-31' , '6');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('016', 'Mayra', '1999-04-26' , '7');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('017', 'Mayara', '1999-05-14' , '8');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('018', 'Pricila', '1998-08-19' , '9');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('019', 'Karina', '1999-12-13' , '1');
INSERT INTO Funcionario ( Cod_func , Nome , Dt_nasc , Cod_dep ) VALUES
('020', 'Larissa', '1997-11-17' , '2');


INSERT INTO Projeto ( Cod_proj , Nome , Orcamento , Dt_ini , Dt_prev_term ) VALUES
('001', 'Info Para Todos', '5000' , '2016-06-10' , '2017-12-31');
INSERT INTO Projeto ( Cod_proj , Nome , Orcamento , Dt_ini , Dt_prev_term ) VALUES
('002', 'Ambiente Sustentavel', '100' , '2016-07-15' , '2018-11-30');
INSERT INTO Projeto ( Cod_proj , Nome , Orcamento , Dt_ini , Dt_prev_term ) VALUES
('003', 'Emprego Ja', '15000' , '2016-08-20' , '2018-10-29');
INSERT INTO Projeto ( Cod_proj , Nome , Orcamento , Dt_ini , Dt_prev_term ) VALUES
('004', 'Ajudar o Mundo', '500' , '2016-09-25' , '2018-09-28');
INSERT INTO Projeto ( Cod_proj , Nome , Orcamento , Dt_ini , Dt_prev_term ) VALUES
('005', 'Jamaica', '500000' , '2016-10-30' , '2018-08-27');


INSERT INTO Funcao ( Cod_funcao , Nome , Sal ) VALUES
('001', 'Programador', '1200');
INSERT INTO Funcao ( Cod_funcao , Nome , Sal ) VALUES
('002', 'Organizador', '1900');
INSERT INTO Funcao ( Cod_funcao , Nome , Sal ) VALUES
('003', 'Administrador', '800');
INSERT INTO Funcao ( Cod_funcao , Nome , Sal ) VALUES
('004', 'Contador', '4000');
INSERT INTO Funcao ( Cod_funcao , Nome , Sal ) VALUES
('005', 'Diretor', '8000');
INSERT INTO Funcao ( Cod_funcao , Nome , Sal ) VALUES
('006', 'Analista', '3200');
INSERT INTO Funcao ( Cod_funcao , Nome , Sal ) VALUES
('007', 'Marketing', '2500');
INSERT INTO Funcao ( Cod_funcao , Nome , Sal ) VALUES
('008', 'Supervisor', '2600');
INSERT INTO Funcao ( Cod_funcao , Nome , Sal ) VALUES
('009', 'Gerente', '4500');
INSERT INTO Funcao ( Cod_funcao , Nome , Sal ) VALUES
('010', 'DBA', '3000');


INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('001', '001', '001' , '2016-06-10' , '2017-12-31');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('002', '002', '002' , '2016-07-15' , '2018-11-30');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('003', '003', '003' , '2016-08-20' , '2018-10-29');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('004', '004', '004' , '2016-09-25' , '2018-09-28');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('005', '005', '005' , '2016-10-30' , '2018-08-27');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('006', '001', '001' , '2016-06-11' , '2017-12-30');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('007', '002', '002' , '2016-07-16' , '2017-11-29');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('008', '003', '003' , '2016-08-21' , '2017-10-28');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('009', '004', '004' , '2016-09-26' , '2017-09-27');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('010', '005', '005' , '2016-10-31' , '2017-08-26');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('011', '001', '001' , '2016-06-12' , '2017-12-29');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('012', '002', '002' , '2016-07-17' , '2017-11-28');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('013', '003', '003' , '2016-08-22' , '2017-10-27');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('014', '004', '004' , '2016-09-27' , '2017-09-26');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('015', '005', '005' , '2016-11-01' , '2017-08-25');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('016', '001', '001' , '2016-06-13' , '2017-12-28');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('017', '002', '002' , '2016-07-18' , '2017-11-27');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('018', '003', '003' , '2016-08-23' , '2017-10-26');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('019', '004', '004' , '2016-09-28' , '2017-09-25');
INSERT INTO Trabalha ( Cod_func , Cod_proj , Cod_funcao , Dt_ent , Dt_sai ) VALUES
('020', '005', '005' , '2016-11-02' , '2017-08-24');


/*
--------------------------------------------------------------------------------------------
Sintaxe JOIN
--------------------------------------------------------------------------------------------
SELECT a.nome, m.id_curso, m.ano
FROM alunos a
JOIN matriculas m ON a.id_aluno = m.id_aluno;
*/
SELECT f.Nome, p.Nome, fu.Nome
FROM Trabalha t
JOIN Funcionario f ON t.Cod_func = f.Cod_func
JOIN Projeto p ON t.Cod_proj = p.Cod_proj
JOIN Funcao fu ON t.Cod_funcao = fu.Cod_funcao;

SELECT f.Nome, fu.Sal, p.Orcamento
FROM Trabalha t
JOIN Funcionario f ON t.Cod_func = f.Cod_func
JOIN Projeto p ON t.Cod_proj = p.Cod_proj
JOIN Funcao fu ON t.Cod_funcao = fu.Cod_funcao;

SELECT f.Cod_func, p.Cod_proj, fu.Cod_funcao
FROM Trabalha t
JOIN Funcionario f ON t.Cod_func = f.Cod_func
JOIN Projeto p ON t.Cod_proj = p.Cod_proj
JOIN Funcao fu ON t.Cod_funcao = fu.Cod_funcao;

SELECT f.Nome, d.DescD
FROM Funcionario f, Departamento d
WHERE f.Cod_dep = d.Cod_dep;

SELECT p.Dt_ini, t.Dt_ent
FROM Projeto p, Trabalha t
WHERE p.Cod_proj = t.Cod_proj;