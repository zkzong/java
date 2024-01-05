CREATE TABLE IF NOT EXISTS t_order_0 (
    order_id   BIGINT AUTO_INCREMENT,
    user_id    INT    NOT NULL,
    address_id BIGINT NOT NULL,
    status     VARCHAR(50),
    PRIMARY KEY (order_id)
);
CREATE TABLE IF NOT EXISTS t_order_1 (
    order_id   BIGINT AUTO_INCREMENT,
    user_id    INT    NOT NULL,
    address_id BIGINT NOT NULL,
    status     VARCHAR(50),
PRIMARY KEY (order_id)
);
CREATE TABLE IF NOT EXISTS t_order_item_0 (
    order_item_id BIGINT AUTO_INCREMENT,
    order_id      BIGINT,
    user_id       INT NOT NULL,
    status        VARCHAR(50),
    PRIMARY KEY (order_item_id)
);
CREATE TABLE IF NOT EXISTS t_order_item_1 (
    order_item_id BIGINT AUTO_INCREMENT,
    order_id      BIGINT,
    user_id       INT NOT NULL,
    status        VARCHAR(50),
    PRIMARY KEY (order_item_id)
);