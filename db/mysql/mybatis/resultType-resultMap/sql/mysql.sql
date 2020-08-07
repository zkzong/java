CREATE database mybatis;

CREATE TABLE t_users(
  id int auto_increment primary key,
  user_name varchar(20),
  sex tinyint default 1 comment '性别：1-男，2-女'
);

insert into t_users(user_name, sex) VALUES ('zong', 1);