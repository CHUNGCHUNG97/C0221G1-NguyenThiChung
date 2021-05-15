CREATE DATABASE student_management;
USE student_management;
CREATE TABLE class
(
    id_class  INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name_class VARCHAR(60) NOT NULL,
    date_start DATETIME    NOT NULL,
    status    BIT
);
INSERT INTO class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO class
VALUES (3, 'B3', current_date, 0);
CREATE TABLE student
(
    id_student   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name_student VARCHAR(30) NOT NULL,
    address     VARCHAR(50),
    phone       VARCHAR(20),
    status      BIT,
    id_class     INT         NOT NULL,
    FOREIGN KEY (id_class) REFERENCES class (id_class)
);
INSERT INTO student (name_student, address, phone, status, id_class)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (name_student, address, status, id_class)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO student (name_student, address, phone, status, id_class)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);
CREATE TABLE subject
(
    id_subject   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name_subject VARCHAR(30) NOT NULL,
    credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( credit >= 1 ),
    status  BIT                  DEFAULT 1
);
INSERT INTO subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
CREATE TABLE mark
(
    id_mark    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_subject     INT NOT NULL,
    id_student INT NOT NULL,
    mark      FLOAT   DEFAULT 0 CHECK ( mark BETWEEN 0 AND 100),
    exam_time TINYINT DEFAULT 1,
    UNIQUE (id_subject, id_student),
    FOREIGN KEY (id_subject) REFERENCES subject (id_subject),
    FOREIGN KEY (id_student) REFERENCES student (id_student)
);
INSERT INTO mark (id_subject, id_student, mark, exam_time)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select name_student
from student
where name_student like 'h%';
-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select *
from class
where month(date_start) = 12;
-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select name_subject, credit
from subject
where credit between 3 and 5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
update student
set id_class=2
where name_student = 'Hung';
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select name_student, name_subject, mark
from student
         join mark on student.id_student = mark.id_student
         join subject S on mark.id_subject = S.id_subject
order by mark desc, name_student asc;

