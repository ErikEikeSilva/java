create database sistema_clientes;
use sistema_clientes;

create table clientes (
id int auto_increment primary key,
nome varchar(100) not null,
email varchar(100) not null

);

select * from clientes;