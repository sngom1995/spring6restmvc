package sam.guru.spring6restmvc.service;

import org.springframework.stereotype.Service;
import sam.guru.spring6restmvc.models.CustomerDto;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class CustomerServiceImpl implements CustomerService {

    Map<UUID, CustomerDto> customerMap;

    public CustomerServiceImpl() {
        customerMap = new HashMap<UUID, CustomerDto>();

        CustomerDto customerDto1 = CustomerDto
                .builder()
                .id(UUID.randomUUID())
                .customerName("Samba")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        CustomerDto customerDto2 = CustomerDto
                .builder()
                .id(UUID.randomUUID())
                .customerName("Bathie")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
        CustomerDto customerDto3 = CustomerDto
                .builder()
                .id(UUID.randomUUID())
                .customerName("Souna")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
        customerMap.put(customerDto1.getId(), customerDto1);
        customerMap.put(customerDto2.getId(), customerDto2);
        customerMap.put(customerDto3.getId(), customerDto3);
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return customerMap.get(customerId);
    }

    @Override
    public List<CustomerDto> getCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        customerMap.put(customerDto.getId(), customerDto);
    }

    @Override
    public void updateCustomer(CustomerDto customerDto, UUID customerId) {
        CustomerDto customerDto1 = customerMap.get(customerId);
        if (customerDto1 == null) {
            throw new RuntimeException("Customer not found");
        } else {
            customerDto1.setCustomerName(customerDto.getCustomerName());
            customerDto1.setLastModifiedDate(LocalDateTime.now());
            customerDto1.setVersion(customerDto1.getVersion() + 1);
        }
        customerMap.put(customerId, customerDto1);
    }
    @Override
    public void deleteCustomer(UUID customerId) {
        customerMap.remove(customerId);

    }
}
