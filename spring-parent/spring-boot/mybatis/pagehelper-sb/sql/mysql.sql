CREATE database mybatis;

CREATE TABLE users(
  id int auto_increment primary key,
  name varchar(20),
  age int
);

insert into users(name, age) VALUES ('zong', 30);