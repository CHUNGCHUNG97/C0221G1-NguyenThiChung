create database furama_resort;
use furama_resort;
create table divison
(
    divison_id   int primary key auto_increment not null,
    divison_name varchar(45)
);
create table education_degree
(
    education_degree_id   int primary key auto_increment not null,
    education_degree_name varchar(45)
);
create table position
(
    position_id   int primary key auto_increment not null,
    position_name varchar(45)
);
create table role
(
    role_id   int not null primary key auto_increment,
    role_name varchar(45)
);
create table user
(
    user_name varchar(45) primary key not null,
    password  varchar(45)
);
create table user_role
(
    role_id   int,
    user_name varchar(45),
    foreign key (role_id) references role (role_id) on delete cascade,
    foreign key (user_name) references user (user_name) on delete cascade
);
create table employee
(
    employee_id         int not null primary key auto_increment,
    employee_name       varchar(45),
    position_id         int,
    education_degree_id int,
    division_id         int,
    employee_birthday   date,
    employee_id_card    varchar(45),
    employee_salary     double,
    employee_phone      varchar(45),
    employee_email      varchar(45),
    employee_address    varchar(45),
    user_name           varchar(255),
    foreign key (division_id) references divison (divison_id) on delete cascade,
    foreign key (education_degree_id) references education_degree (education_degree_id) on delete cascade,
    foreign key (position_id) references position (position_id) on delete cascade,
    foreign key (user_name) references user (user_name) on delete cascade
);
create table customer_type
(
    customer_type_id   int primary key auto_increment not null,
    customer_type_name varchar(45)
);
create table customer
(
    customer_id       int primary key auto_increment not null,
    customer_type_id  int,
    customer_name     varchar(45),
    customer_birthday date,
    customer_id_card  varchar(45),
    customer_gender   bit(1),
    customer_phone    varchar(45),
    customer_email    varchar(45),
    customer_address  varchar(45),
    foreign key (customer_type_id) references customer_type (customer_type_id) on delete cascade
);
create table rent_type
(
    rent_type_id   int primary key not null auto_increment,
    rent_type_name varchar(45),
    rent_type_cost double
);
create table service_type
(
    service_type_id   int primary key not null auto_increment,
    service_type_name varchar(45)
);
create table service
(
    service_id                    int primary key not null auto_increment,
    service_name                  varchar(45),
    service_area                  int,
    service_cost                  double,
    service_max_people            varchar(45),
    rent_type_id                  int,
    service_type_id               int,
    standard_room                 varchar(45),
    description_other_convenience varchar(45),
    pool_area                     double,
    number_of_floors              int(45),
    foreign key (rent_type_id) references rent_type (rent_type_id) on delete cascade,
    foreign key (service_type_id) references service_type (service_type_id) on delete cascade
);
create table attach_service
(
    attach_service_id     int primary key not null auto_increment,
    attach_service_name   varchar(45),
    attach_service_cost   double,
    attach_service_unit   int,
    attach_service_status varchar(45)
);
create table contract
(
    contract_id          int primary key auto_increment not null,
    employee_id          int,
    customer_id          int,
    service_id           int,
    contract_start_date  date,
    contract_end_date    date,
    contract_deposit     double,
    contract_total_money double,
    foreign key (employee_id) references employee (employee_id) on delete cascade,
    foreign key (customer_id) references customer (customer_id) on delete cascade,
    foreign key (service_id) references service (service_id) on delete cascade
);
create table contract_detail
(
    contract_detail_id int primary key not null auto_increment,
    contract_id        int,
    attach_service_id  int,
    quantity           int,
    foreign key (contract_id) references contract (contract_id) on delete cascade,
    foreign key (attach_service_id) references attach_service (attach_service_id) on delete cascade
);
