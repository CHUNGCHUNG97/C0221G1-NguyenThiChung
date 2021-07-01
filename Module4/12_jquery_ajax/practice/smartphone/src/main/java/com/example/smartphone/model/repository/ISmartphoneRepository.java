package com.example.smartphone.model.repository;

import com.example.smartphone.model.entity.Smartphone;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends PagingAndSortingRepository<Smartphone, Long> {
}
