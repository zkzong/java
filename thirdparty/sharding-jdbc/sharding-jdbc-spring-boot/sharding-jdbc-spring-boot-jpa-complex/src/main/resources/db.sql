CREATE TABLE `t_sharding_0` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `app_id` VARCHAR(10) NOT NULL,
  `num` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `t_sharding_1` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `app_id` VARCHAR(10) NOT NULL,
  `num` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `t_sharding_2` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `app_id` VARCHAR(10) NOT NULL,
  `num` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `t_sharding_3` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `app_id` VARCHAR(10) NOT NULL,
  `num` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `t_other` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(10) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`));