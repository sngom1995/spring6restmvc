package sam.guru.spring6restmvc.service;
import sam.guru.spring6restmvc.models.CustomerDto;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);
    List<CustomerDto> getCustomers();

    void saveCustomer(CustomerDto customerDto);

    void updateCustomer(CustomerDto customerDto, UUID customerId);
     void deleteCustomer(UUID customerId);

}
