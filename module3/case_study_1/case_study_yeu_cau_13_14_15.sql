# 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.

select se.id_service_extra, name_service_extra, price, unit, status_availability, count(se.id_service_extra)
from service_extra se
         inner join contract_details cd on se.id_service_extra = cd.id_service_extra
         inner join contract c on cd.id_contract = c.id_contract
         inner join customer c2 on c.id_customer = c2.id_customer
group by se.id_service_extra
having count(se.id_service_extra) = (select count(se.id_service_extra)
                                     from service_extra se
                                              inner join contract_details cd on se.id_service_extra = cd.id_service_extra
                                              inner join contract c on cd.id_contract = c.id_contract
                                              inner join customer c2 on c.id_customer = c2.id_customer

                                     group by se.id_service_extra
                                     order by count(se.id_service_extra) desc
                                     limit 1
);

select se.id_service_extra, name_service_extra, price, unit, status_availability, count(se.id_service_extra)
from service_extra se
         inner join contract_details cd on se.id_service_extra = cd.id_service_extra
         inner join contract c on cd.id_contract = c.id_contract
         inner join customer c2 on c.id_customer = c2.id_customer
group by se.id_service_extra
having count(se.id_service_extra) = (select max(c.count)
                                     from (select count(se.id_service_extra) as count
                                           from service_extra se
                                                    inner join contract_details cd on se.id_service_extra = cd.id_service_extra
                                                    inner join contract c on cd.id_contract = c.id_contract
                                                    inner join customer c2 on c.id_customer = c2.id_customer

                                           group by se.id_service_extra) as c
);

# 14.Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
# Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
select c.id_contract, tc.name_type_customer, se.name_service_extra, count(se.id_service_extra) as so_lan_su_dung
from service_extra se
         inner join contract_details cd on se.id_service_extra = cd.id_service_extra
         inner join contract c on cd.id_contract = c.id_contract
         inner join customer c2 on c.id_customer = c2.id_customer
         inner join type_customer tc on c2.id_type_customer = tc.id_type_customer
group by c.id_contract
having count(se.id_service_extra) = (select c.count
                                     from (select count(se.id_service_extra) as count
                                           from service_extra se
                                                    inner join contract_details cd on se.id_service_extra = cd.id_service_extra
                                                    inner join contract c on cd.id_contract = c.id_contract
                                                    inner join customer c2 on c.id_customer = c2.id_customer
                                           group by se.id_service_extra
                                           having count(se.id_service_extra) = 1
                                           limit 1) as c);

# 15.Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai,
# DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.


select s.id_staff,
       s.name_staff,
       l.level,
       p.name_position,
       s.number_phone,
       s.address,
       count(c.id_contract) as so_luong_hop_dong
from contract c
         inner join staff s on c.id_staff = s.id_staff
         inner join level l on s.id_level = l.id_level
         inner join position p on s.id_position = p.id_position
where c.id_staff in (select c.id_staff
                     from contract c
                              inner join staff s on c.id_staff = s.id_staff
                     where year(c.date_start) >= 2018
                       and year(c.date_start) <= 2019
                     group by c.id_staff
                     having count(c.id_contract) <= 3)
group by c.id_staff;
