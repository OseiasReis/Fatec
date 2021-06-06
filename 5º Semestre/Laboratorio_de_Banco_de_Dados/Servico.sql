create database PrestaServ;
use PrestaServ;

create table Cliente(
codigo_cliente int(6),
nome varchar(40),
tipo varchar(2),
cnpj_cpf varchar(14),
telefone varchar(11),
email varchar(50),
codigo_endereco varchar(50)
);
    
create table Funcionario(
codigo_funcionario int(6),
nome varchar(50),
cpf varchar(11),
telefone varchar(11),
email varchar(50),
codigo_endereco varchar(50)
);

create table Endereco(
codigo_endereco int(6),
cep varchar (8),
bairro varchar (60),
logradouro varchar (50),
estado varchar(2),
cidade varchar(30),
numero int(6),
complemento varchar(5)
);

create table Empresa (
codigo_empresa int(6),
cnpj int(11),
razao_social varchar(35),
nome_fantasia varchar(35),
inscricao_estadual varchar(15),
email varchar(25),
telefone varchar(15),
codigo_endereco varchar(50)
);

create table Ordem (
codigo_ordem int(6),
codigo_cliente int(6),
codigo_empresa int(6),
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
valor decimal(9,2),
tipo_un varchar(15)
);



ALTER TABLE Empresa ADD CONSTRAINT pk_empresa PRIMARY KEY (codigo_empresa);
ALTER TABLE Empresa CHANGE codigo_empresa codigo_empresa BIGINT AUTO_INCREMENT;

ALTER TABLE Ordem ADD CONSTRAINT pk_ordem PRIMARY KEY (codigo_ordem);
ALTER TABLE Ordem CHANGE codigo_ordem codigo_ordem BIGINT AUTO_INCREMENT;

ALTER TABLE Servico ADD CONSTRAINT pk_servico PRIMARY KEY (codigo_servico);
ALTER TABLE Servico CHANGE codigo_servico codigo_servico BIGINT AUTO_INCREMENT;

ALTER TABLE Cliente ADD CONSTRAINT pk_cliente PRIMARY KEY (codigo_cliente);
ALTER TABLE Cliente CHANGE codigo_cliente codigo_cliente BIGINT AUTO_INCREMENT;

ALTER TABLE Funcionario ADD CONSTRAINT pk_funcionario PRIMARY KEY (codigo_funcionario);
ALTER TABLE Funcionario CHANGE codigo_funcionario codigo_funcionario BIGINT AUTO_INCREMENT;

ALTER TABLE Endereco ADD CONSTRAINT pk_endereco PRIMARY KEY (codigo_endereco);
ALTER TABLE Endereco CHANGE codigo_endereco codigo_endereco BIGINT AUTO_INCREMENT;





ALTER TABLE Ordem ADD CONSTRAINT fk_ordem FOREIGN KEY (codigo_cliente) REFERENCES Cliente (codigo_cliente);

ALTER TABLE OrdemServico ADD CONSTRAINT fk_servico_ordem FOREIGN KEY (codigo_ordem) REFERENCES Ordem (codigo_ordem);

ALTER TABLE OrdemServico ADD CONSTRAINT fk_servico_servico FOREIGN KEY (codigo_servico) REFERENCES Servico (codigo_servico);

ALTER TABLE OrdemServico ADD CONSTRAINT fk_servico_empresa FOREIGN KEY (codigo_empresa) REFERENCES Empresa (codigo_empresa);

ALTER TABLE Cliente ADD CONSTRAINT fk_endereco_cliente FOREIGN KEY (codigo_endereco) REFERENCES Endereco(codigo_endereco);

ALTER TABLE Funcionario ADD CONSTRAINT fk_endereco_funcionario FOREIGN KEY (codigo_endereco) REFERENCES Endereco(codigo_endereco);

ALTER TABLE Empresa ADD CONSTRAINT fk_endereco_empresa FOREIGN KEY (codigo_endereco) REFERENCES Endereco(codigo_endereco);

