package com.codegym.quan_ly_tinh.model.repository;

import com.codegym.quan_ly_tinh.model.entity.Customer;
import com.codegym.quan_ly_tinh.model.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProvinceRepository extends JpaRepository<Province, Long> {


}
