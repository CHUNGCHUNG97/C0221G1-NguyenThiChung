package model.service.contract;



import model.bean.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();

    Contract findById(int id);

    void add(Contract contract);

    void update(int id, Contract contract);

    Contract remove(int id);

    List<Contract> search(String name);
}
