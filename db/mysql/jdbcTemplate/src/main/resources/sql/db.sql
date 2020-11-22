create table user_key_auto(
    id int unsigned not null auto_increment,
    user_id bigint(64) not null default 0,
    user_name varchar(64) not null default '',
    sex int(2) not null,
    address varchar(255) not null default '',
    city varchar(64) not null default '',
    email varchar(64) not null default '',
    state int(6) not null default 0,
    primary key(id),
    key user_name_key(user_name)
);

create table user_uuid(
    id varchar(36) not null,
    user_id bigint(64) not null default 0,
    user_name varchar(64) not null default '',
    sex int(2) not null,
    address varchar(255) not null default '',
    city varchar(64) not null default '',
    email varchar(64) not null default '',
    state int(6) not null default 0,
    primary key(id),
    key user_name_key(user_name)
);

create table user_random_key(
    id bigint(64) not null default 0,
    user_id bigint(64) not null default 0,
    user_name varchar(64) not null default '',
    sex int(2) not null,
    address varchar(255) not null default '',
    city varchar(64) not null default '',
    email varchar(64) not null default '',
    state int(6) not null default 0,
    primary key(id),
    key user_name_key(user_name)
);
