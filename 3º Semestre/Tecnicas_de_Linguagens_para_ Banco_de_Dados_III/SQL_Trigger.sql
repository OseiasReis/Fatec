Create database Empresa;
use Empresa;

create Table Produto(
Id_Prod int not null auto_increment primary key,
Nome_Prod varchar(45),
Preco_Prod decimal(10,2),
Preco_Desconto decimal(10,2)
);


CREATE TRIGGER tr_desconto before insert 
on Produto 
for each row 
set new.Preco_Desconto = (new.Preco_Prod * 0.90);



INSERT INTO produto ( Nome_Prod , Preco_Prod , Preco_Desconto ) VALUES ( 'Ingrid' , 1000000.00 , null );
INSERT INTO produto ( Nome_Prod , Preco_Prod , Preco_Desconto ) VALUES ( 'Monitor' , 250.00 , null );
INSERT INTO produto ( Nome_Prod , Preco_Prod , Preco_Desconto ) VALUES ( 'Gabinete' , 170.00 , null );
INSERT INTO produto ( Nome_Prod , Preco_Prod , Preco_Desconto ) VALUES ( 'Teclado' , 80.00 , null );
INSERT INTO produto ( Nome_Prod , Preco_Prod , Preco_Desconto ) VALUES ( 'Mouse' , 20.00 , null );
INSERT INTO produto ( Nome_Prod , Preco_Prod , Preco_Desconto ) VALUES ( 'Placa de Video' , 1700.00 , null );
INSERT INTO produto ( Nome_Prod , Preco_Prod , Preco_Desconto ) VALUES ( 'Processador' , 1250.00 , null );
INSERT INTO produto ( Nome_Prod , Preco_Prod , Preco_Desconto ) VALUES ( 'Cooler' , 50.00 , null );
INSERT INTO produto ( Nome_Prod , Preco_Prod , Preco_Desconto ) VALUES ( 'Fonte' , 170.00 , null );
INSERT INTO produto ( Nome_Prod , Preco_Prod , Preco_Desconto ) VALUES ( 'Disco Rigido' , 800.00 , null );



create Table Viatura(
matricula int not null auto_increment primary key,
nome varchar(45),
estado varchar(30)
);


create Table auditar_viatura(
matricula int not null auto_increment primary key,
data_modif varchar(45),
descr varchar(30)


INSERT INTO Viatura ( nome , estado ) VALUES ( 'Policia Civil' , 'Amazonas' );
INSERT INTO Viatura ( nome , estado ) VALUES ( 'Policia Rota' , 'Sao Paulo' );
INSERT INTO Viatura ( nome , estado ) VALUES ( 'Policia Militar' , 'Bahia' );
INSERT INTO Viatura ( nome , estado ) VALUES ( 'Policia Estadual' , 'Parana' );
INSERT INTO Viatura ( nome , estado ) VALUES ( 'Policia Municipal' , 'Rio de Janeiro' );

INSERT INTO auditar_viatura ( data_modif , descr ) VALUES ( '10/05/1999' , 'Caveirao' );
INSERT INTO auditar_viatura ( data_modif , descr ) VALUES ( '29/04/2016' , 'Tropa de Elite' );
INSERT INTO auditar_viatura ( data_modif , descr ) VALUES ( '15/06/2010' , 'Batalhao' );
INSERT INTO auditar_viatura ( data_modif , descr ) VALUES ( '20/09/2000' , 'Rambo' );
INSERT INTO auditar_viatura ( data_modif , descr ) VALUES ( '01/01/2012' , 'Mercenarios' );


CREATE TRIGGER antes_manut_viatura 
after update 
on Viatura
for each row 
begin
insert into auditar_viatura
set action = 'insert'
Matricula = OLD.matricula
data_modif = NOW() descr=NEW.descr
END