create database internship;
create table faculty
(
    id_faculty   char(10) primary key,
    name_faculty char(30),
    phone        char(10)
);

create table instructor
(
    id_instructor   int primary key,
    name_instructor char(30),
    salary          decimal(5, 2),
    id_faculty      char(10),
    foreign key (id_faculty) references faculty (id_faculty)
);

create table student
(
    id_student     int primary key,
    name_student   char(40),
    id_faculty     char(10),
    date_of_birth  date,
    place_of_birth char(30),
    foreign key (id_faculty) references faculty (id_faculty)
);

create table project
(
    id_project      char(10) primary key,
    name_project    char(30),
    expense         int,
    place_of_intern char(30)
);

create table instructor_student
(
    id_student    int,
    id_project    char(10),
    id_instructor int,
    grade         decimal(5, 2),
    primary key (id_student, id_project, id_instructor),
    foreign key (id_student) references student (id_student),
    foreign key (id_project) references project (id_project),
    foreign key (id_instructor) references instructor (id_instructor)
);
insert into faculty
    value (1, 'geography', '0356126444'),
    (2, 'Biotechnology', '0913455134'),
    (3, 'Mathematics', '0949378900'),
    (4, ' resource_management', '0964662111');

insert into instructor
    value (1, 'Ngọc Thạch', 250, 2),
    (2, 'Thị Chung', 400, 1),
    (3, 'Sỹ Phú', 300, null);

insert into student
    value (1, 'Hoàng', 3, '1996/04/03', 'Quảng Nam'),
    (2, 'Thùy', 2, '1998/06/12', 'Da Nang'),
    (3, 'Linh', 2, '1999/01/06', 'Hue'),
    (4, 'Duc', 1, '1997/12/03', 'Da Nang');

insert into project
    value (1, 'Project 1', 350, 'Da Nang'),
    (2, 'Project 2', 550, 'Da Nang'),
    (3, 'Project 3', 400, 'HCM');

insert into instructor_student
    value (1, 1, 2, 3.2),
    (2, 1, 1, 2.5),
    (2, 2, 2, 3.6);
