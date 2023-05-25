package sam.guru.spring6restmvc.mappers;


import org.mapstruct.Mapper;
import sam.guru.spring6restmvc.entities.Customer;
import sam.guru.spring6restmvc.models.CustomerDto;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto customer);
    CustomerDto customerToCustomerDto(Customer customer);
}
