create table cliente(
	cpf varchar(11) primary key not null unique,
	nome text,
	email text,
	telefone varchar(20),
	fk_feedback int,
	foreign key (fk_feedback) references feedback(codigo)
)

create table funcionario(
	cpf varchar(11) primary key not null unique,
	matricula int unique not null,
	senha varchar(8) not null,
	nome text
)

create table equipamento (
	codigo int primary key not null unique,
	nome text
)

create table os (
	codigo int primary key not null unique,
	data text,
	valor float,
	descricao text,
	fk_equipamento int not null,
	foreign key (fk_equipamento) references equipamento(codigo),
	fk_cliente varchar,
	foreign key(fk_cliente) references cliente(cpf),
	fk_funcionario varchar,
	foreign key(fk_funcionario) references funcionario(cpf)
)


create table feedback(
	codigo serial primary key not null unique,
	data text,
	comentario text
)
insert into funcionario (cpf,matricula,nome,senha) values (1,111,'felipe',123)
insert into funcionario (cpf,matricula,nome,senha) values (2,222,'marina',321)

insert into equipamento (codigo,nome) values (1,'celular')
insert into equipamento (codigo,nome) values (2,'iphone 14')
insert into equipamento (codigo,nome) values (3,'moto g')
insert into equipamento (codigo,nome) values (4,'iphone 6')
insert into equipamento (codigo,nome) values (5,'samsung S22')

insert into cliente (cpf,nome,email,telefone) values (3,'carla','carla@gmail.com',123456789)
insert into cliente (cpf,nome,email,telefone) values (4,'alessandra','alessandra@gmail.com',987654321)

insert into os (codigo,data,valor,descricao,fk_equipamento) values (1,'22/06/2022',233,'quebrado e queimado',2)
insert into os (codigo,data,valor,descricao,fk_equipamento) values (2,'11/03/2015',500,'tiro',5)
insert into os (codigo,data,valor,descricao,fk_equipamento,fk_cliente) values (3,'01/02/2035',200,'agua',1,3)
insert into os (codigo,data,valor,descricao,fk_equipamento,fk_cliente) values (4,'04/08/2012',25,'comentario',1,4)
insert into os (codigo,data,valor,descricao,fk_equipamento,fk_cliente,fk_funcionario) values (6,'22/12/2012',125,'sei la',3,4,1)
insert into feedback(comentario,data) values ('perfeito','01/01/2001')
