package com.codegym.quan_ly_tinh.model.service;

import com.codegym.quan_ly_tinh.model.entity.Province;

import java.util.Optional;

public interface IProvinceService {
    Iterable<Province> findAll();

    Optional<Province> findById(Long id);

    void save(Province province);

    void remove(Long id);
}
