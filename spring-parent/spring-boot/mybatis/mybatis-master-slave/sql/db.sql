create table member (
	id int(10) not null primary key auto_increment,
	user_name varchar(100) not null,
	age int(3)
);


insert into member(user_name, age) VALUES('zong', 30);