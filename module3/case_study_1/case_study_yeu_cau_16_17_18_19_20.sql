use case_study;

# 16.Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
SET SQL_SAFE_UPDATES = 0;
SET FOREIGN_KEY_CHECKS = 0;
delete
from staff s2
where s2.id_staff not in (select c.id
                          from (select c.id_staff as id
                                from contract c
                                where year(c.date_start) between 2017 and 2019
                                group by c.id_staff) as c);
set foreign_key_checks = 1;

# 17.Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những
# khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
update customer ct
set ct.id_type_customer=(select t.id_type_customer
                         from type_customer t
                         where name_type_customer = 'Diamond')
where ct.id_customer in (select ct2.id_customer
                         from (select c.id_customer as id_customer
                               from contract c
                                        inner join customer c2 on c.id_customer = c2.id_customer
                                        inner join type_customer tc on c2.id_type_customer = tc.id_type_customer
                                        inner join contract_details cd on c.id_contract = cd.id_contract
                                        inner join service_extra se on cd.id_service_extra = se.id_service_extra
                                        inner join services s on c.id_service = s.id_service
                               where year(c.date_start) = 2019
                                 and tc.name_type_customer = 'Platinium'
                               group by c2.id_customer
                               having sum(s.rental_costs + cd.amount * se.price)>10000000) as ct2);

# 18.Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).
SET FOREIGN_KEY_CHECKS = 0;
delete
from customer
where id_customer in (select c1.id_customer
                      from (select c2.id_customer as id_customer
                            from contract c
                                     inner join customer c2 on c.id_customer = c2.id_customer
                            where year(c.date_start) < 2019) as c1);

set foreign_key_checks = 1;

# 19.Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
update service_extra se
set se.price=2 * se.price
where se.id_service_extra in (select cd2.id_service_extra
                              from (select cd.id_service_extra as id_service_extra
                                    from contract_details cd
                                             inner join contract c on cd.id_contract = c.id_contract
                                    where year(c.date_start) = 2019
                                    group by cd.id_service_extra
                                    having count(cd.id_service_extra) > 10) as cd2);

# 20.Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị
# bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select id_staff as id, name_staff as name, birthday, number_phone, email, address
from staff s
union
select c.id_customer, name_customer, birthday_customer, number_phone_customer, email_customer, address_customer
from customer c;




