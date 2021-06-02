package model.repository;

import model.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceRepository {
    private static Map<Integer, Service> services;

    static {
        services = new HashMap<>();
        services.put(1, new Service(1, "Samsung"));
        services.put(2, new Service(2, "Nokia"));
    }


    public List<Service> findAll() {
        return new ArrayList<>(services.values());
    }


    public Service findById(int id) {
        return services.get(id);
    }


    public void add(Service service) {
        services.put(service.getId(), service);
    }


    public void update(int id, Service service) {
        services.put(id, service);
    }

    public Service remove(int id) {
        services.remove(id);
        return null;
    }


    public List<Service> search(String name) {
        return findAll().stream().filter(ob -> ob.getName().contains(name)).collect(Collectors.toList());
    }
}
