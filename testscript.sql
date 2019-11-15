drop table if exists client;
create table client(ID serial primary key not null,name varchar(50) not null,address varchar(100) not null,telephone varchar(50) not null,email varchar(50));

insert into client(name,address,telephone,email) values('Dennis Christy', 'Burkina','0275876542', 'francis@gmail.com');
insert into client(name,address,telephone,email) values('Bill Christy','Achimota', '0244-2723-23-123', 'tcms@yahoo.com');