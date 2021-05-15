use case_study;

-- Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là 
select *
from case_study.customer
where (name_customer like 'H%' or name_customer like 'K%' or name_customer like 'T%')
  and LENGTH(name_customer) <= 15;

-- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from customer
where (year(curdate()) - year(birthday_customer) >= 18
    and year(curdate()) - year(birthday_customer) <= 50)
    and address_customer like '%Đà Nẵng%'
   or address_customer like '%Quảng Trị%';

-- Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần
select name_customer, name_type_customer, count(id_contract)
from customer a
         inner join type_customer t2 on a.id_type_customer = t2.id_type_customer
         inner join contract c on c.id_customer = c.id_customer
where t2.name_type_customer = 'Diamond'
group by a.id_customer
order by count(id_contract) asc;

-- Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
select a.id_customer,
       a.name_customer,
       t.name_type_customer,
       c.id_contract,
       s.name_service,
       c.date_start,
       c.date_end,
       sum(s.rental_costs + s2.unit * s2.price) as total
from customer a
         left join contract c on a.id_customer = c.id_customer
         left join contract_details cd on c.id_contract = cd.id_contract
         left join type_customer t on a.id_type_customer = t.id_type_customer
         left join services s on c.id_service = s.id_service
         left join service_extra s2 on cd.id_service_extra = s2.id_service_extra
group by (a.id_customer);


