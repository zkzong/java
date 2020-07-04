create table t_user(
    f_id bigint not null primary key auto_increment,
    f_user_name varchar(50) not null,
    f_age int(3) not null,
    f_address varchar(200) not null,
    f_create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    f_update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);