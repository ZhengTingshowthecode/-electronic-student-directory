use classmatesmanager;

create table student(
sno char(8) not null primary key,
name varchar(20) not null primary key,
gender char(2) default '男',
phone varchar(20),
info varchar(100),
Birth varchar(20) not null
);


create table user(
id int not null,
username varchar(20) not null,
pwd varchar(20) not null,
realName varchar(20) default 'NULL'
);