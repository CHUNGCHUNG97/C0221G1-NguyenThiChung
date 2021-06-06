package model.service.contract;

import model.bean.Contract;
import model.repository.contract.ContractRepository;

import java.util.List;

public class ContractServiceImpl implements ContractService {
    ContractRepository contractRepository = new ContractRepository();

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }


//    @Override
//    public Contract findById(int id) {
//        return contractRepository.findById(id);
//    }
//
//    @Override
//    public void add(Contract contract) {
//        contractRepository.add(contract);
//    }
//
//    @Override
//    public void update(int id, Contract contract) {
//        contractRepository.update(id, contract);
//    }
//
//    @Override
//    public Contract remove(int id) {
//        contractRepository.remove(id);
//        return null;
//    }
//
//    @Override
//    public List<Contract> search(String name) {
//        return contractRepository.search(name);
//    }
}
