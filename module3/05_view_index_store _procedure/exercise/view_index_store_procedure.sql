create database demo;
use demo;
create table products
(
    id                  int not null primary key auto_increment,
    product_code        varchar(45),
    product_name        varchar(45),
    product_price       float,
    product_amount      int,
    product_description varchar(100),
    product_status      bit
);
#  chèn dữ liệu
insert into products(product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES ('A1', 'apple', 30000000, 1, 'apple', 1);
insert into products(product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES ('S1', 'samsung', 10000000, 3, 'samsung', 1);
insert into products(product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES ('N1', 'nokia', 5000000, 5, 'nokia', 1);

# tạo index
alter table products
    add unique index idx_product_code (product_code);
explain
select product_code
from products
where product_code = 'A1';

# composite index
create index idx_composite
    on products (product_name, product_price);
explain
select product_name, product_price
from products
where product_name = 'samsung';

# xóa chỉ mục
alter table products
    drop index idx_composite;

# tạo view
create view product_view as
select product_code, product_name, product_price, product_status
from products;

# sửa view
    alter view product_view as
    select product_code, product_name, product_status
    from products
    where products.id = 1;

# xóa view
drop view product_view;

# store procedure lấy thông tin của tất cả sp trong product
delimiter //
create procedure find_product()
begin

    select * from products;

END //
delimiter ;
call find_product();

# Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_product(p_code varchar(45),
                             p_name varchar(45),
                             p_price float,
                             p_amount int,
                             p_description varchar(100),
                             p_status bit)
begin
    insert into products(product_code, product_name, product_price, product_amount, product_description, product_status)
    VALUES (p_code, p_name, p_price, p_amount, p_description, p_status);
end;
delimiter ;

call add_product('A2', 'xiaomi', 8000000, 2, 'xiaomi', 0);

# Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure update_product_by_id(p_id int, p_code varchar(45),
                                      p_name varchar(45),
                                      p_price float,
                                      p_amount int,
                                      p_description varchar(100),
                                      p_status bit)
begin
    update products
    set product_code=p_code,
        product_name=p_name,
        product_price=p_price,
        product_amount=p_amount,
        product_description=p_description,
        product_status=p_status
    where id = p_id;
end;
delimiter ;

call update_product_by_id(2, 'L1', 'lenovo', 4000000, 3, 'lenovo', 1);

# Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_product_by_id(p_id int)
begin
    delete
    from products
    where id = p_id;
end //
delimiter ;

call delete_product_by_id(3);
