create database sistema_login character set utf8mb4 collate utf8mb4 collate utf8mb4_unicode_ci;
use sistema_login;
 
 create table usuarios (
 id int auto_increment primary key,
 usuario varchar(50) not null unique,
 senha varchar(255) not null
 
 );
 
 insert into usuarios (usuario, senha) values ('erik', '123456');
 
 select * from usuarios;