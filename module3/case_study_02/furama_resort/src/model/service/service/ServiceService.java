package model.service.service;

import model.Service;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();

    Service findById(int id);

    void add(Service service);

    void update(int id, Service service);

    Service remove(int id);

    List<Service> search(String name);
}
