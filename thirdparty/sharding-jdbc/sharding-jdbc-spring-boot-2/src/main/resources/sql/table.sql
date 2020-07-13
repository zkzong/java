create database demo_ds;

CREATE TABLE IF NOT EXISTS t_user_0 (
	user_id INT NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(200),
	user_name_plain VARCHAR(200),
	pwd VARCHAR(200),
	assisted_query_pwd VARCHAR(200),
	PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS t_user_1 (
	user_id INT NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(200),
	user_name_plain VARCHAR(200),
	pwd VARCHAR(200),
	assisted_query_pwd VARCHAR(200),
	PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS t_user_no_sharding (
	user_id INT NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(200),
	user_name_plain VARCHAR(200),
	pwd VARCHAR(200),
	assisted_query_pwd VARCHAR(200),
	PRIMARY KEY (user_id)
);