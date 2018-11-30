create database mantenimiento2
go
use mantenimiento2
go
create table producto(
id int identity(1,1) primary key,
nombre varchar(30) not null,
categoria varchar(30) not null,
descripcion varchar(50) not null,
precio decimal(8,2) not null,
stock decimal(5,2) not null,
estado int not null
)
go

insert into producto values('coca cola','bebidas','500ml',2.50,40,1)
go

insert into producto values('inka cola','bebidas','500ml',3.00,60,1)
go
insert into producto values('oreo','galletas','sabor mani',1.00,37,0)
go
insert into producto values('morocha','galletas','chocolate',1.00,44,1)
go
insert into producto values('casino','galletas','sabor menta',0.80,54,1)
go


select * from producto

create table estado(
valor int not null
)
insert into estado values(1)
select * from estado