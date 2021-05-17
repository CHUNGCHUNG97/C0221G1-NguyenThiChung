use student_management;

# Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *
from subject s
where s.credit = (select max(sb.credit) from subject sb);

# Hiển thị các thông tin môn học có điểm thi lớn nhất.
select *
from subject s
         join mark m on s.id_subject = m.id_subject

where m.mark = all (select max(m2.mark) from mark m2);

# Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select *, avg(m.mark) as diem_trung_binh
from student a
         left join class c on a.id_class = c.id_class
         left join mark m on a.id_student = m.id_student
         left join subject s on m.id_subject = s.id_subject
group by a.id_student
order by avg(m.mark) desc;