CREATE DATABASE case_study;
use case_study;
create table part
(
    idPart   int primary key auto_increment not null,
    namePart varchar(45)
);
create table level
(
    idLevel int primary key auto_increment not null,
    level   varchar(45)
);
create table position
(
    idPosition   int primary key auto_increment not null,
    nameLocation varchar(45)
);
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
create table typecustomer
(
    idTypeCustomer   int primary key auto_increment not null,
    nameTypeCustomer varchar(45)
);
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
create table typeRental
(
    idTypeRental   int primary key not null auto_increment,
    nameTypeRental varchar(45),
    price          int
);
create table TypeService
(
    idTypeService   int primary key not null primary key,
    nameTypeService varchar(45)
);
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
create table ServiceExtra
(
    idServiceExtra     int primary key not null auto_increment,
    nameServiceExtra   varchar(45),
    price              int,
    unit               int,
    statusAvailability varchar(45)
);
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
create table Contract_details
(
    idContract_detail int primary key not null auto_increment,
    idContract        int,
    idServiceExtra    int,
    amount            int,
    foreign key (idContract) references contract (idContract),
    foreign key (idServiceExtra) references ServiceExtra (idServiceExtra)
);