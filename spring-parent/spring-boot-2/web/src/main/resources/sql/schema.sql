-- drop database if exists sb2;
-- CREATE database sb2;
-- use sb2;

drop table if exists t_user;
create table t_user(
  id int(10) auto_increment primary key,
  name varchar(20),
  age int
);