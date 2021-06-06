create database PrestaServ;
use PrestaServ;

create table Empresa (
codigo_empresa int(6),
cnpj int(11) not null,
razao_social varchar(35) not null,
nome_fantasia varchar(35) not null,
inscricao_estadual varchar(15),
email varchar(25),
telefone varchar(15) not null,
codigo_endereco varchar(50)
);

create table Ordem (
codigo_ordem int(6),
codigo_cliente int(6) not null,
data_ordem date,
prestador varchar(20),
observacoes varchar(80),
situacao varchar(15)
);

create table OrdemServico (
codigo_ordem int(6),
codigo_servico int(6),
quantidade int(4)
);

create table Servico (
codigo_servico int(6),
descricao varchar(80),
valor decimal(5,9)   
);



ALTER TABLE localizacao ADD CONSTRAINT pk_localizacao PRIMARY KEY (cep);

ALTER TABLE cliente ADD CONSTRAINT pk_cliente PRIMARY KEY (registro_cliente);

ALTER TABLE acervo ADD CONSTRAINT pk_acervo PRIMARY KEY (cod_acervo);

ALTER TABLE classificacao ADD CONSTRAINT pk_classificacao PRIMARY KEY (cod_classificacao);

ALTER TABLE exemplar ADD CONSTRAINT pk_exemplar PRIMARY KEY (cod_exemplar);
ALTER TABLE exemplar CHANGE cod_exemplar cod_exemplar BIGINT AUTO_INCREMENT;

ALTER TABLE emprestimo ADD CONSTRAINT pk_emprestimo PRIMARY KEY (cod_emprestimo);
ALTER TABLE emprestimo CHANGE cod_emprestimo cod_emprestimo BIGINT AUTO_INCREMENT;

ALTER TABLE operador ADD CONSTRAINT pk_operador PRIMARY KEY (registro_operador);




ALTER TABLE acervo ADD CONSTRAINT fk_acervo FOREIGN KEY (cod_classificacao) REFERENCES classificacao (cod_classificacao);

ALTER TABLE cliente ADD CONSTRAINT fk_cliente FOREIGN KEY (cep) REFERENCES localizacao (cep);

ALTER TABLE exemplar ADD CONSTRAINT fk_exemplar FOREIGN KEY (cod_acervo) REFERENCES acervo (cod_acervo);

ALTER TABLE emprestimo ADD CONSTRAINT fk_emprestimo1 FOREIGN KEY (registro_cliente) REFERENCES cliente (registro_cliente);

ALTER TABLE emprestimo ADD CONSTRAINT fk_emprestimo2 FOREIGN KEY (registro_operador) REFERENCES operador (registro_operador);

ALTER TABLE emprestimo ADD CONSTRAINT fk_emprestimo3 FOREIGN KEY (cod_exemplar) REFERENCES exemplar (cod_exemplar);

ALTER TABLE devolucao ADD CONSTRAINT fk_devolucao1 FOREIGN KEY (cod_emprestimo) REFERENCES emprestimo (cod_emprestimo);

ALTER TABLE devolucao ADD CONSTRAINT fk_devolucao2 FOREIGN KEY (registro_operador) REFERENCES operador (registro_operador);

ALTER TABLE operador ADD CONSTRAINT fk_operador FOREIGN KEY (cep) REFERENCES localizacao (cep);




ALTER TABLE cliente MODIFY COLUMN ativo boolean DEFAULT TRUE;

ALTER TABLE cliente MODIFY COLUMN multa_pendente decimal (7,2) DEFAULT 0;


