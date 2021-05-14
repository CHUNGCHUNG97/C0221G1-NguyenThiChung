create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer
(
    idCustomer int primary key auto_increment not null,
    name       varchar(45),
    age        int
);
insert into customer(name, age)
VALUES ('Minh Quan', 10),
       ('Ngoc Oanh', 20),
       ('Hong Ha', 50);
create table oder
(
    idOder     int primary key not null auto_increment,
    idCustomer int,
    dateOder   date,
    totalPrice bigint,
    foreign key (idCustomer) references customer (idCustomer)
);
insert into oder(idCustomer, dateOder, totalPrice)
VALUES (1, '2006-3-21', null),
       (2, '2006-3-23', null),
       (1, '2006-3-16', null);
create table product
(
    idProduct   int primary key not null auto_increment,
    nameProduct varchar(45),
    price       float
);
insert into product(nameProduct, price)
VALUES ('May Giat', 3),
       ('Tu Lanh', 5),
       ('Dieu Hoa', 7),
       ('Quat', 1),
       ('Bep Dien', 2);
create table oderDetail
(
    idOder    int,
    idProduct int,
    oQTY      int,
    primary key (idOder, idProduct),
    foreign key (idOder) references oder (idOder),
    foreign key (idProduct) references product (idProduct)
);
insert into oderDetail(idOder, idProduct, oQTY)
VALUES (1, 1, 3),
       (1, 3, 7),
       (1, 4, 2),
       (2, 1, 1),
       (3, 1, 8),
       (2, 5, 4),
       (2, 3, 3);
select idOder, dateOder, totalPrice
from oder;
select name, nameProduct
from customer
         join oder on customer.idCustomer = oder.idCustomer
         join oderDetail oD on oder.idOder = oD.idOder
         join product p on oD.idProduct = p.idProduct
group by (nameProduct);
select name
from customer
         left join oder on customer.idCustomer = oder.idCustomer
where idOder is null;

select oder.idOder, oder.dateOder , sum(oD.oQTY*p.price) as total from oder inner join oderDetail oD on oder.idOder = oD.idOder
inner join product p on oD.idProduct = p.idProduct  group by idOder;
