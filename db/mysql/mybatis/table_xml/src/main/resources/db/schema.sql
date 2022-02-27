-- drop database if exists mybatis;
-- CREATE database mybatis;
-- use mybatis;

drop table if exists t_users;
CREATE TABLE t_users(
  id int auto_increment primary key,
  user_name varchar(20),
  age int
);