CREATE DATABASE case_study
create table typecustomer (
idTypeCustomer int not null auto_increment primary key,
nameTypeCustomer varchar(45)
);
create table staff(
idStaff int primary key,
nameStaff varchar(45),
idLocation int,
idLevel int,
idPart int,
birthday date,
identity_card varchar(45),
salary varchar(45),
numberPhone varchar(45),
email varchar(45),
address varchar(45)
);
create table part(
idPart int primary key,
namePart varchar(45)
);
create table level(
idLevel int primary key,
level varchar(45)
);
create table location(
idLocation int primary key,
nameLocation varchar(45)
);
create table customer(
idCustomer int primary key,
idTypeCustomer int,
nameCustomer varchar(45),
birthdayCustomer date,
identity_cardCustomer varchar(45),
numberPhoneCustomer varchar(45),
emailCustomer varchar(45),
addressCustomer varchar(45) 
);
create table services(
idService int primary key,
nameService varchar(45),
area int,
floors int,
maxPeople varchar(45),
rentalCosts varchar(45),
idTypeRental varchar(45),
idTypeService int,
status varchar(45)
);
create table ServiceExtra(
idServiceExtra int primary key,
nameServiceExtra varchar(45),
price int,
unit int,
statusAvailability varchar(45)
);
create table contract(
idContract int primary key,
idStaff int,
idCustomer int,
idService int,
DateStart date,
DateEnd date,
deposits int,
total int
);
create table Contract_details(
idContract_detail int primary key,
idContract int,
idServiceExtra int,
amount int
);
