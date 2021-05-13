create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer
(
    idCustomer int primary key auto_increment not null,
    name       varchar(45),
    age        int
);
create table oder
(
    idOder     int primary key not null auto_increment,
    idCustomer int,
    dateOder   date,
    totalPrice bigint,
    foreign key (idCustomer) references customer (idCustomer)
);
create table product
(
    idProduct   int primary key not null auto_increment,
    nameProduct varchar(45),
    price       float
);
create table oderDetail
(
    idOder    int,
    idProduct int,
    oQTY      int,
    primary key (idOder, idProduct),
    foreign key (idOder) references oder (idOder),
    foreign key (idProduct) references product (idProduct)
);