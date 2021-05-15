create database sale_management;
use sale_management;
create table customer
(
    id_customer int primary key auto_increment not null,
    name        varchar(45),
    age         int
);
insert into customer(name, age)
VALUES ('Minh Quan', 10),
       ('Ngoc Oanh', 20),
       ('Hong Ha', 50);
create table oder
(
    id_oder     int primary key not null auto_increment,
    id_customer int,
    date_oder   date,
    total_price bigint,
    foreign key (id_customer) references customer (id_customer)
);
insert into oder(id_customer, date_oder, total_price)
VALUES (1, '2006-3-21', null),
       (2, '2006-3-23', null),
       (1, '2006-3-16', null);
create table product
(
    id_product   int primary key not null auto_increment,
    name_product varchar(45),
    price        float
);
insert into product(name_product, price)
VALUES ('May Giat', 3),
       ('Tu Lanh', 5),
       ('Dieu Hoa', 7),
       ('Quat', 1),
       ('Bep Dien', 2);
create table oder_detail
(
    id_oder    int,
    id_product int,
    oQTY       int,
    primary key (id_oder, id_product),
    foreign key (id_oder) references oder (id_oder),
    foreign key (id_product) references product (id_product)
);
insert into oder_detail(id_oder, id_product, oQTY)
VALUES (1, 1, 3),
       (1, 3, 7),
       (1, 4, 2),
       (2, 1, 1),
       (3, 1, 8),
       (2, 5, 4),
       (2, 3, 3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select id_oder, date_oder, total_price
from oder;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select name, name_product
from customer
         join oder on customer.id_customer = oder.id_customer
         join oder_detail oD on oder.id_oder = oD.id_oder
         join product p on oD.id_product = p.id_product
group by (name_product);
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select name
from customer
         left join oder on customer.id_customer = oder.id_customer
where id_oder is null;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn
select oder.id_oder, oder.date_oder, sum(oD.oQTY * p.price) as total
from oder
         inner join oder_detail oD on oder.id_oder = oD.id_oder
         inner join product p on oD.id_product = p.id_product
group by id_oder;
