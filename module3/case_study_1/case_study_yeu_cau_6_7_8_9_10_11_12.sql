use case_study;

# 6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại
# Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select s.id_service, s.name_service, s.area, s.rental_costs, ts.name_type_service
from services s
         inner join type_service ts on s.id_type_service = ts.id_type_service
         inner join contract c on s.id_service = c.id_service
where s.id_service not in (select s.id_service
                           from contract c
                                    inner join services s on c.id_service = s.id_service
                           where year(c.date_start) = 2019
                             and (month(c.date_start) = 1 or month(c.date_start) = 2 or month(c.date_start) = 3)
                           group by s.id_service)
group by s.id_service;

# 7.Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue,
# tenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách
# hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
select s.id_service, s.name_service, s.area, s.max_people, s.rental_costs, ts.name_type_service
from services s
         inner join type_service ts on s.id_type_service = ts.id_type_service
         inner join contract c on s.id_service = c.id_service
         inner join customer c2 on c.id_customer = c2.id_customer
where year(c.date_start) = 2018
  and ts.id_type_service not in (select ts.id_type_service
                                 from services s
                                          inner join type_service ts on s.id_type_service = ts.id_type_service
                                          inner join contract c on s.id_service = c.id_service
                                          inner join customer c3 on c.id_customer = c3.id_customer
                                 where year(c.date_start) = 2019);

# 8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
# Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
# cach 1:
select distinct c.name_customer
from customer c;
# cách 2:
select name_customer
from customer
group by name_customer;
# cách 3:
select c2.name_customer
from customer c2
union
select c.name_customer
from customer c;


# 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019
# thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(c.date_start) as 'tháng', count(distinct c.id_customer) as doanh_thu
from contract c
         inner join customer c2 on c.id_customer = c2.id_customer
where year(c.date_start)=2019
group by month(c.date_start);

# 10.Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
select c.id_contract, c.date_start, c.date_end, c.deposits, count(cd.id_contract_detail) as so_luong_DV_di_kem
from contract c
         inner join contract_details cd on c.id_contract = cd.id_contract
         inner join service_extra se on cd.id_service_extra = se.id_service_extra
group by c.id_contract;

# 11.Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có
# TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select s.id_service_extra, name_service_extra, price, unit, status_availability
from service_extra s
         inner join contract_details cd on s.id_service_extra = cd.id_service_extra
         inner join contract c on cd.id_contract = c.id_contract
         inner join customer c2 on c.id_customer = c2.id_customer
         inner join type_customer tc on c2.id_type_customer = tc.id_type_customer
where tc.name_type_customer = 'Diamond'
  and (c2.address_customer like '%Vinh%' or c2.address_customer like '%Quảng Ngãi%')
group by s.id_service_extra;

# 12.Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu,
# SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các
# dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng
# đặt vào 6 tháng đầu năm 2019.
select ch.id_contract,
       s.name_staff,
       c.name_customer,
       c.number_phone_customer,
       s2.name_service,
       count(cd.id_contract_detail) as so_luong_DV_di_kem,
       sum(ch.deposits) as tien_dat_coc
from contract ch
         inner join customer c on ch.id_customer = c.id_customer
         inner join staff s on ch.id_staff = s.id_staff
         inner join services s2 on ch.id_service = s2.id_service
         inner join contract_details cd on ch.id_contract = cd.id_contract
         inner join service_extra se on cd.id_service_extra = se.id_service_extra
where (month(ch.date_start) = 10 or month(ch.date_start) = 11 or month(ch.date_start) = 12)
  and month(ch.date_start) in
      (select month(c2.date_start) from contract c2 where year(c2.date_start) = 2019)
  and month(ch.date_start) not in (select month(c4.date_start)
                                   from contract c4
                                            inner join customer ct on c4.id_customer = ct.id_customer
                                            inner join services s3 on c4.id_service = s3.id_service
                                            inner join contract_details d on c4.id_contract = d.id_contract
                                            inner join service_extra e on d.id_service_extra = e.id_service_extra
                                   where month(c4.date_start) = 6
                                   group by s3.id_service)
group by s2.id_service, c.id_customer;
