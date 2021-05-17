use student_management;

# Sử dụng hàm count để hiển thị số lượng sinh viên ở từng nơi
select address, count(id_student) as so_luong_sinh_vien
from student
group by address;

# Tính điểm trung bình các môn học của mỗi học viên
select c.id_student, c.name_student, avg(m.mark)
from student c
         inner join mark m on c.id_student = m.id_student
group by c.id_student;

# Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
select c.id_student, c.name_student, avg(m.mark)
from student c
         inner join mark m on c.id_student = m.id_student
group by c.id_student
having avg(m.mark) > 15;

# Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
select c.id_student, c.name_student, avg(m.mark) as diem_trung_binh
from student c
         inner join mark m on c.id_student = m.id_student
group by c.id_student
having diem_trung_binh >= all (select avg(m.mark) from mark group by c.id_student);
