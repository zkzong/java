CREATE database mybatis;

use mybatis;

CREATE TABLE t_users(
  id int auto_increment primary key,
  name varchar(20),
  age int
);

insert into t_users(name, age) VALUES ('zong', 30);
