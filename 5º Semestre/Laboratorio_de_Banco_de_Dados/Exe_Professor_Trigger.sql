create table Tabela_Log_Professor (
username varchar2(50),
chave varchar2(10),
instruction varchar2(10),
datas date
);

create or replace trigger trg_log
after insert or delete or update
on Professor
for each row
declare
    instruction varchar(10);
begin
    if inserting then
      instruction := 'INSERT';
    elsif updating then
      instruction := 'UPDATE';
    elsif deleting then
      instruction := 'DELETE';
    end if;
    
    insert into Tabela_Log_Professor values (USER, :new.CODPROF, instruction, to_char(sysdate,'dd/mm/yyyy hh:mi'));
end;


/*
Testes:
update Professor set NOMEPROF = 'Renato' where  NOMEPROF = 'Ricardo';
insert into Professor values (11, 3, 'Sanchez', 2);
*/