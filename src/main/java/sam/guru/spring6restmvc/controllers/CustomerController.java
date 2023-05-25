package sam.guru.spring6restmvc.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.guru.spring6restmvc.service.CustomerService;
import sam.guru.spring6restmvc.models.CustomerDto;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getCustomers() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/");
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto) {

        CustomerDto savedCustomerDto = CustomerDto
                .builder()
                .id(UUID.randomUUID())
                .version(customerDto.getVersion())
                .customerName(customerDto.getCustomerName())
                .createdDate(customerDto.getCreatedDate())
                .lastModifiedDate(customerDto.getLastModifiedDate())
                .build();
        customerService.saveCustomer(savedCustomerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedCustomerDto.getId().toString());
        return ResponseEntity.status(201).headers(headers).build();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable("customerId") UUID customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<?> updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerDto, customerId);
        return ResponseEntity.status(204).build();
    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.status(204).build();
    }
}
