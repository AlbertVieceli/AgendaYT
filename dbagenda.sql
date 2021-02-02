create database dbagenda;
use dbagenda;
drop database dbagenda;

create table contatos (
	idcon int primary key auto_increment,
    nome varchar(50) not null,
    fone varchar(15) not null,
    email varchar(50)
);
show tables;
describe contatos;

/*CRUD create*/
insert into contatos (nome,fone,email) values ('Bill Gates', '99999-1111', 'bil@outlook.com');

/*CRUD read*/
select * from contatos;
select * from contatos order by nome;