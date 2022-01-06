DROP TABLE IF EXISTS `customer_ticket`;

create table `customer_ticket`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT,
    `account_id`   bigint(20) not null,
    `order_number` varchar(50)  not null,
    `description`  varchar(100) not null,
    `create_time`  timestamp    not null DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);
