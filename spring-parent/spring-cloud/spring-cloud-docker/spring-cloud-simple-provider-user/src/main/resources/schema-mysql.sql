drop table if exists user;
create table user (id bigint auto_increment, username varchar(40), name varchar(20), age int(3), balance decimal(10,2), primary key (id));