drop table if exists city;
create table city
(
    id          int auto_increment
        primary key,
    province_id int         null,
    city_name   varchar(50) null,
    description varchar(50) null
);