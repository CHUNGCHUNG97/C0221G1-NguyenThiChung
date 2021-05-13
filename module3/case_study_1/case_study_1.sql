CREATE DATABASE case_study;
use case_study;
create table part
(
    idPart   int primary key auto_increment not null,
    namePart varchar(45)
);
insert into part(namePart)
values ('kế toán'),
       ('thiết kế'),
       ('hồ sơ');
create table level
(
    idLevel int primary key auto_increment not null,
    level   varchar(45)
);
insert into level(level)
values ('đại học'),
       ('cao đẳng'),
       ('trung cấp');
create table position
(
    idPosition   int primary key auto_increment not null,
    namePosition varchar(45)
);

insert into position (namePosition)
values ('trưởng phòng'),
       ('phó phòng');

create table staff
(
    idStaff       int not null primary key auto_increment,
    nameStaff     varchar(45),
    idPosition    int,
    idLevel       int,
    idPart        int,
    birthday      date,
    identity_card varchar(45),
    salary        varchar(45),
    numberPhone   varchar(45),
    email         varchar(45),
    address       varchar(45),
    foreign key (idPart) references part (idPart),
    foreign key (idLevel) references level (idLevel),
    foreign key (idPosition) references position (idPosition)
);
insert into staff (nameStaff, idPosition, idLevel, idPart, birthday, identity_card, salary, numberPhone, email, address)
values ('hoàng ngọc thạch', 1, 1, 1, '1993-06-01', '218 246 282', '20.000.000', '036 252 126', 'thach@gmail.com',
        'thanh khê,đà nẵng');
create table typecustomer
(
    idTypeCustomer   int primary key auto_increment not null,
    nameTypeCustomer varchar(45)
);
insert into typecustomer (nameTypeCustomer)
values ('Viet Nam'),
       ('Nước ngoài');
create table customer
(
    idCustomer            int primary key auto_increment not null,
    idTypeCustomer        int,
    nameCustomer          varchar(45),
    birthdayCustomer      date,
    identity_cardCustomer varchar(45),
    numberPhoneCustomer   varchar(45),
    emailCustomer         varchar(45),
    addressCustomer       varchar(45),
    foreign key (idTypeCustomer) references typecustomer (idTypeCustomer)
);
insert into customer (idTypeCustomer, nameCustomer, birthdayCustomer, identity_cardCustomer, numberPhoneCustomer,
                      emailCustomer, addressCustomer)
values (1, 'Nguyễn Thị Chung', '1997-07-11', '212 486 009', '036 252 1226', 'chung@gmail.com', 'thanh khê ,đà nẵng');
create table typeRental
(
    idTypeRental   int primary key not null auto_increment,
    nameTypeRental varchar(45),
    price          int
);
insert into typeRental (nameTypeRental, price)
values ('theo giờ', 80000),
       ('theo ngày', 200000);
create table TypeService
(
    idTypeService   int primary key not null auto_increment,
    nameTypeService varchar(45)
);
insert into typeservice (nameTypeService)
values ('hồ bơi'),
       ('spa'),
       ('casino');
create table services
(
    idService     int primary key not null auto_increment,
    nameService   varchar(45),
    area          int,
    floors        int,
    maxPeople     varchar(45),
    rentalCosts   varchar(45),
    idTypeRental  int,
    idTypeService int,
    status        varchar(45),
    foreign key (idTypeRental) references typeRental (idTypeRental),
    foreign key (idTypeService) references TypeService (idTypeService)
);
insert into services(nameService, area, floors, maxPeople, rentalCosts, idTypeRental, idTypeService, status)
values ('villa', 100, 2, '10', '15000000', 1, 1, 'tốt');
create table ServiceExtra
(
    idServiceExtra     int primary key not null auto_increment,
    nameServiceExtra   varchar(45),
    price              int,
    unit               int,
    statusAvailability varchar(45)
);
insert into ServiceExtra (nameServiceExtra, price, unit, statusAvailability)
values ('massage', 200000, 2, 'tốt');
create table contract
(
    idContract int primary key auto_increment not null,
    idStaff    int,
    idCustomer int,
    idService  int,
    DateStart  date,
    DateEnd    date,
    deposits   int,
    total      int,
    foreign key (idStaff) references staff (idStaff),
    foreign key (idCustomer) references customer (idCustomer),
    foreign key (idService) references services (idService)
);
insert into contract(idStaff, idCustomer, idService, DateStart, DateEnd, deposits, total)
VALUES (1, 1, 1, '2021-05-13', '2021-05-16', 7000000, 20000000);
create table Contract_details
(
    idContract_detail int primary key not null auto_increment,
    idContract        int,
    idServiceExtra    int,
    amount            int,
    foreign key (idContract) references contract (idContract),
    foreign key (idServiceExtra) references ServiceExtra (idServiceExtra)
);
insert into Contract_details(idContract, idServiceExtra, amount)
VALUES (1, 1, 1);