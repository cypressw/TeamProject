CREATE SCHEMA `battleship`;
CREATE TABLE `battleship`.`users` (
  `username` VARCHAR(30) NOT NULL,
  `password` VARBINARY(64) NOT NULL,
  PRIMARY KEY (`username`, `password`));