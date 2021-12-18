drop table if exists t_user;
CREATE TABLE t_user(
  id int auto_increment primary key,
  name varchar(20),
  age int
);

drop table if exists t_person;
CREATE TABLE t_person(
  id int auto_increment primary key,
  name varchar(20),
  age int
);