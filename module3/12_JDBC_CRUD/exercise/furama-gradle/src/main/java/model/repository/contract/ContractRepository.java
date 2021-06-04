package model.repository.contract;



import model.bean.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ContractRepository {
    private static Map<Integer, Contract> contracts;

    static {
        contracts = new HashMap<>();
        contracts.put(1, new Contract(1, "Samsung"));
        contracts.put(2, new Contract(2, "Nokia"));
    }


    public List<Contract> findAll() {
        return new ArrayList<>(contracts.values());
    }


    public Contract findById(int id) {
        return contracts.get(id);
    }


    public void add(Contract contract) {
        contracts.put(contract.getId(), contract);
    }


    public void update(int id, Contract contract) {
        contracts.put(id, contract);
    }

    public Contract remove(int id) {
        contracts.remove(id);
        return null;
    }


    public List<Contract> search(String name) {
        return findAll().stream().filter(ob -> ob.getName().contains(name)).collect(Collectors.toList());
    }
}
