/*
create database procedurebd;
use procedurebd;

create table pais(
id int AUTO_INCREMENT primary key,
nome varchar (20)
);

insert into pais(nome) values("Brasil");
insert into pais(nome) values("Suica");
insert into pais(nome) values("Dinamarca");
insert into pais(nome) values("Estados Unidos");
insert into pais(nome) values("Canada");
insert into pais(nome) values("Russia");
insert into pais(nome) values("Ucrania");
insert into pais(nome) values("Inglaterra");
insert into pais(nome) values("Alemanha");

DELIMITER $$
CREATE PROCEDURE listar_paises_f (IN _id INT)
BEGIN
 IF(_id IS NULL) THEN
        SELECT * FROM pais;
 ELSE
        SELECT *  FROM pais where id = _id;
 END IF;
 END $$
 DELIMITER ;
*/

DELIMITER $$
CREATE PROCEDURE listar_paises (IN _id INT)
BEGIN
        SELECT * FROM pais;
END $$
DELIMITER ;
