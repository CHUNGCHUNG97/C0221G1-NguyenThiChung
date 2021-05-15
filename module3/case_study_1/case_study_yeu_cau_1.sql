CREATE DATABASE case_study;
use case_study;
create table part
(
    id_part   int primary key auto_increment not null,
    name_part varchar(45)
);
insert into part(name_part)
values ('kế toán'),
       ('thiết kế'),
       ('hồ sơ');
create table level
(
    id_level int primary key auto_increment not null,
    level    varchar(45)
);
insert into level(level)
values ('đại học'),
       ('cao đẳng'),
       ('trung cấp');
create table position
(
    id_position   int primary key auto_increment not null,
    name_position varchar(45)
);

insert into position (name_position)
values ('trưởng phòng'),
       ('phó phòng'),
       ('nhân viên');

create table staff
(
    id_staff      int not null primary key auto_increment,
    name_staff    varchar(45),
    id_position   int,
    id_level      int,
    id_part       int,
    birthday      date,
    identity_card varchar(45),
    salary        varchar(45),
    number_phone  varchar(45),
    email         varchar(45),
    address       varchar(45),
    foreign key (id_part) references part (id_part),
    foreign key (id_level) references level (id_level),
    foreign key (id_position) references position (id_position)
);
insert into staff (name_staff, id_position, id_level, id_part, birthday, identity_card, salary, number_phone, email,
                   address)
values ('hoàng ngọc thạch', 1, 1, 1, '1993-06-01', '218 246 282', '20.000.000', '036 252 126', 'thach@gmail.com',
        'thanh khê,đà nẵng'),
       ('sỹ phú', 2, 3, 3, '1993-09-11', '210 556 555', '14000000', '0985 445 444', 'syphu@gmail.com', 'Quảng Trị'),
       ('ngọc trinh', 3, 2, 1, '1998-6-14', '211 466 555', 10000000, '095 4664 333', 'trinh@gmail.com', 'Quảng Ngãi');
create table type_customer
(
    id_type_customer   int primary key auto_increment not null,
    name_type_customer varchar(45)
);
insert into type_customer (name_type_customer)
values ('Diamond'),
       ('VIP'),
       ('Normal');
create table customer
(
    id_customer           int primary key auto_increment not null,
    id_type_customer      int,
    name_customer         varchar(45),
    birthday_customer     date,
    identity_cardCustomer varchar(45),
    number_phone_customer varchar(45),
    email_customer        varchar(45),
    address_customer      varchar(45),
    foreign key (id_type_customer) references type_customer (id_type_customer)
);
insert into customer(id_type_customer, name_customer, birthday_customer, identity_cardCustomer, number_phone_customer,
                     email_customer, address_customer)
values (1, 'Nguyễn Thị Chung', '1997-07-11', '212 486 009', '036 252 1226', 'chung@gmail.com', 'thanh khê ,đà nẵng'),
       (3, 'Thu Hiền', '1993-2-23', '216 333 666', '095 5654 235', 'thuhien@gmail.com', 'hoàng văn thái, đà nẵng'),
       (2, 'văn thanh', '1996-8-2', '216 456 756', '095 6563 111', 'vanthanh@gmail.com', 'hoàng văn thái, đà nẵng');
create table type_rental
(
    id_type_rental   int primary key not null auto_increment,
    name_type_rental varchar(45),
    price            int
);
insert into type_rental (name_type_rental, price)
values ('theo giờ', 80000),
       ('theo ngày', 200000),
       ('theo tháng', 20000000);
create table type_service
(
    id_type_service   int primary key not null auto_increment,
    name_type_service varchar(45)
);
insert into type_service (name_type_service)
values ('hồ bơi'),
       ('spa'),
       ('casino');
create table services
(
    id_service      int primary key not null auto_increment,
    name_service    varchar(45),
    area            int,
    floors          int,
    max_people      varchar(45),
    rental_costs    varchar(45),
    id_type_rental  int,
    id_type_service int,
    status          varchar(45),
    foreign key (id_type_rental) references type_rental (id_type_rental),
    foreign key (id_type_service) references type_service (id_type_service)
);
insert into services(name_service, area, floors, max_people, rental_costs, id_type_rental, id_type_service, status)
values ('villa', 100, 2, '10', '15000000', 1, 1, 'đang hoạt động'),
       ('house', 50, 2, '6', '10000000', 3, 2, 'đang hoạt động'),
       ('room', 30, 1, 2, 5000000, 2, 1, 'đang hoạt động');
create table Service_extra
(
    id_service_extra    int primary key not null auto_increment,
    name_service_extra  varchar(45),
    price               int,
    unit                int,
    status_availability varchar(45)
);
insert into Service_extra (name_service_extra, price, unit, status_availability)
values ('massage', 200000, 2, 'đang hoạt động'),
       ('gym', 100000, 1, 'đang hoạt động'),
       ('ăn sáng', 150000, 4, 'đang hoạt động');
create table contract
(
    id_contract int primary key auto_increment not null,
    id_staff    int,
    id_customer int,
    id_service  int,
    date_start  date,
    date_end    date,
    deposits    int,
    total       int,
    foreign key (id_staff) references staff (id_staff),
    foreign key (id_customer) references customer (id_customer),
    foreign key (id_service) references services (id_service)
);
insert into contract(id_staff, id_customer, id_service, date_start, date_end, deposits, total)
VALUES (1, 2, 1, '2021-05-13', '2021-05-16', 5000000, 20000000),
       (3, 2, 3, '2021-01-14', '2021-01-18', 2000000, 7000000),
       (2, 3, 1, '2021-01-14', '2021-01-18', 5000000, 15000000);
create table Contract_details
(
    id_contract_detail int primary key not null auto_increment,
    id_contract        int,
    id_service_extra   int,
    amount             int,
    foreign key (id_contract) references contract (id_contract),
    foreign key (id_service_extra) references service_extra (id_service_extra)
);
insert into Contract_details(id_contract, id_service_extra, amount)
VALUES (1, 2, 2),
       (3, 2, 1),
       (2, 3, 2);

