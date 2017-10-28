drop database angung;
create database angung;

use angung;

create table pessoa(codigo int primary key auto_increment, nome varchar(50), sexo enum('m','f'), idade int);

insert into pessoa values (null, 'Luis', 'm', 20);
insert into pessoa values (null, 'Juliana', 'f', 16);
insert into pessoa values (null, 'Minimim', 'm', 30);
insert into pessoa values (null, 'Feio', 'm', 44);
insert into pessoa values (null, 'Ilan', 'm', 39);

commit;