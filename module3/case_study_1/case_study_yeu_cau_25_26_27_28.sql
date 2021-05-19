# 25.Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi
# còn lại có trong bảng HopDong ra giao diện console của database
delimiter //
create trigger Tr_1
    after delete
    on contract
    for each row
begin
    select count(*) from contract as log into outfile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/log.txt';
end;
delimiter ;
delete
from contract
where id_contract = 3;
select *
from contract;


# 26.Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không
delimiter //
create trigger Tr_2
    before update
    on contract
    for each row

begin

    if (datediff(NEW.date_end, OLD.date_start) < 2)
    then
        SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT =
                'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
    else

        select concat('update success: ', id_contract)
        from contract as log
        into outfile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/log2.txt';
    end if;
end
//
delimiter ;

update contract c
set c.date_end='2019-12-18'
where c.id_contract=2;


# 27.a.Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
delimiter //
create function func_1(total float)
    returns int
    deterministic
begin
    declare count_service int;
    set count_service =
            (select count(id)
             from (select s.id_service as id
                   from services s
                            inner join contract c on s.id_service = c.id_service
                   group by s.id_service
                   having sum(s.rental_costs) > total) as a);
    return count_service;
end;
delimiter ;

select func_1(2000000);

# 27 b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng
# đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ

delimiter //
create function Func_2(c_id_customer int)
    returns int
    deterministic
begin
    declare time_max int;
    set time_max = (select t.time
                    from (select max(datediff(c.date_end, c.date_start)) as time
                          from contract c
                          where c.id_customer = c_id_customer) as t);
    return time_max;
end;
delimiter ;
drop function Func_2;

select Func_2(1);

# 28.Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ
# là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó

delimiter //
create procedure sp_3()
begin
    alter table contract
        drop foreign key contract_ibfk_3;
    alter table contract
        add constraint contract_ibfk_3 foreign key (id_service) references services (id_service) on delete cascade;
    delete
    from services
    where id_service = (select s.id
                        from (select s.id_service as id
                              from contract c
                                       inner join services s on c.id_service = s.id_service
                              where (year(c.date_start) between 2015 and 2019)
                                and s.name_service = 'room'
                              group by s.id_service) as s);

end;
delimiter ;

call sp_3();