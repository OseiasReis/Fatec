drop database mercadoria;

create database mercadoria;
use mercadoria;

create table tabproduto(
cod_prod int,
nome varchar(30),
preco decimal(7,2),
genero varchar(30)
);

ALTER TABLE tabproduto ADD CONSTRAINT pk_cod_prod PRIMARY KEY (cod_prod);
ALTER TABLE tabproduto CHANGE cod_prod cod_prod INT AUTO_INCREMENT;

/*ALTER TABLE tabproduto ADD CONSTRAINT fk_cod_prod FOREIGN KEY (cod_prod) REFERENCES tabproduto2 (cod_prod);*/

/*drop table tabproduto;
drop database mercadoria;*/

INSERT INTO tabproduto (nome, preco, genero) VALUES ('Notebook',50000.00,'Informatica');
INSERT INTO tabproduto (nome, preco, genero) VALUES ('Computador',2500.00,'Informatica');
INSERT INTO tabproduto (nome, preco, genero) VALUES ('Teclado',235.00,'Periferico');
INSERT INTO tabproduto (nome, preco, genero) VALUES ('Mouse',50.00,'Periferico');
INSERT INTO tabproduto (nome, preco, genero) VALUES ('Mesa',700.00,'Movel');
INSERT INTO tabproduto (nome, preco, genero) VALUES ('Cadeira',499.99,'Movel');
INSERT INTO tabproduto (nome, preco, genero) VALUES ('Luminaria',70.00,'Decoracao');
INSERT INTO tabproduto (nome, preco, genero) VALUES ('Led',5.00,'Decoracao');
INSERT INTO tabproduto (nome, preco, genero) VALUES ('Pen Drive',79.90,'Acessorio');
INSERT INTO tabproduto (nome, preco, genero) VALUES ('Cabo de Rede',20.50,'Informatica');
INSERT INTO tabproduto (nome, preco, genero) VALUES ('Mousepad',5.89,'Periferico');

/*DELETE FROM tabproduto WHERE nome = 'Mousepad';*/

UPDATE tabproduto
SET genero = 'Decoracao'
WHERE nome = 'Mousepad';

select * from tabproduto;
select * from tabproduto where nome = 'Computador';
select * from tabproduto where preco >= 100;
select * from tabproduto where preco < 100;
select * from tabproduto where genero = 'Informatica';