CREATE TABLE t_order_0 (
	id BIGINT AUTO_INCREMENT,
	order_id BIGINT,
	user_id INT NOT NULL,
	status VARCHAR(50),
	PRIMARY KEY (id)
);

CREATE TABLE t_order_1 (
	id BIGINT AUTO_INCREMENT,
	order_id BIGINT,
	user_id INT NOT NULL,
	status VARCHAR(50),
	PRIMARY KEY (id)
);

CREATE TABLE t_order_item_0 (
	id BIGINT AUTO_INCREMENT,
	order_item_id BIGINT,
	order_id BIGINT,
	user_id INT NOT NULL,
	status VARCHAR(50),
	PRIMARY KEY (id)
);

CREATE TABLE t_order_item_1 (
	id BIGINT AUTO_INCREMENT,
	order_item_id BIGINT,
	order_id BIGINT,
	user_id INT NOT NULL,
	status VARCHAR(50),
	PRIMARY KEY (id)
);