# 21.Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ
# là “Hải Châu” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
create view v_nhan_vien as
select st.id_staff,
       name_staff,
       id_position,
       id_level,
       id_part,
       birthday,
       identity_card,
       salary,
       number_phone,
       email,
       address
from staff st
where st.address like '%Hải Châu%'
  and st.id_staff in (select c2.id_staff
                      from contract c2
                      where c2.date_start = '2019-12-12'
                      group by c2.id_staff);

# 22.Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các
# Nhân viên được nhìn thấy bởi khung nhìn này.
update v_nhan_vien v
set v.address='Liên Chiểu'
where v.id_staff;

# 23.Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng
# được truyền vào như là 1 tham số của Sp_1
delimiter //
create procedure Sp_1(c_id_customer int)
begin
    delete
    from customer
    where id_customer = c_id_customer;
end;
delimiter ;
set foreign_key_checks = 0;
call Sp_1(4);
set foreign_key_checks = 1;

# 24.Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện
# kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo
# toàn vẹn tham chiếu đến các bảng liên quan.
delimiter //
create procedure Sp_2(c_id_contract int,
                      c_id_staff int,
                      c_id_customer int,
                      c_id_service int,
                      c_date_start date,
                      c_date_end date,
                      c_deposits float,
                      c_total float)
begin
    if not exists(select c.id_contract from contract c where c.id_contract = c_id_contract)
        and exists(select s.id_staff from staff s where s.id_staff = c_id_staff)
        and exists(select ct.id_customer from customer ct where ct.id_customer = c_id_customer)
        and exists(select sv.id_service from services sv where sv.id_service = c_id_service)
    then
        insert into contract(id_staff, id_customer, id_service, date_start, date_end, deposits, total)
        VALUES (c_id_staff, c_id_customer, c_id_service, c_date_start, c_date_end, c_deposits, c_total);

    else
        SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT =
                'not success';
    end if;
end//
delimiter ;

call Sp_2(10, 4, 4, 1, '2017-5-15', '2017-5-20', 2000000, 14000000);
