CREATE DATABASE bai_tap;
USE bai_tap;
drop table class;
CREATE TABLE `bai_tap`.`class` (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(45) null
);
CREATE TABLE `bai_tap`.`teacher` (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(45) null,
`age` INT null,
`country` VARCHAR(45) null
);
drop table teacher;
INSERT INTO class(name)
VALUES
    ('XuanThuLab');
INSERT INTO teacher(name,age,country)
VALUES
    ('XuanThuLab','20','quang ngai');
    