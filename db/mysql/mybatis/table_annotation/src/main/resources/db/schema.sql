-- drop database if exists mybatis;
-- CREATE database mybatis;
-- use mybatis;

drop table if exists t_users;
CREATE TABLE t_users(
  id int auto_increment primary key,
  user_name varchar(20),
  age int
);

drop table if exists city;
CREATE TABLE city(
    id int auto_increment primary key,
    province_id int(10),
    city_name varchar(100),
    description varchar(100)
);