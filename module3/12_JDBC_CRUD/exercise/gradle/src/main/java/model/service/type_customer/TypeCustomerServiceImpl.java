package model.service.type_customer;

import model.bean.TypeCustomer;
import model.repository.service.type_service.TypeCustomerRepository;
import java.util.List;

public class TypeCustomerServiceImpl implements TypeCustomerService {
    TypeCustomerRepository typeCustomerRepository =new TypeCustomerRepository();
    @Override
    public List<TypeCustomer> getAll() {
        return typeCustomerRepository.getAllTypeCustomer() ;
    }
}
