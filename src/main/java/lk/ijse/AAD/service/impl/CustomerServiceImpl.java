package lk.ijse.AAD.service.impl;

import lk.ijse.AAD.dto.CustomerDTO;
import lk.ijse.AAD.entity.Customer;
import lk.ijse.AAD.repository.CustomerRepository;
import lk.ijse.AAD.repository.OrderRepository;
import lk.ijse.AAD.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;
    OrderRepository orderRepository;

    public CustomerServiceImpl (CustomerRepository customerRepository, OrderRepository orderRepository){
        this.customerRepository=customerRepository;
        this.orderRepository=orderRepository;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        try {
            log.info("Saving customer: {}", customerDTO);
            Customer customer = new Customer();
            customer.setName(customerDTO.getName());
            customer.setPhone(customerDTO.getPhone());
            customer.setAddress(customerDTO.getAddress());

            Customer savedCustomer = customerRepository.save(customer);

            CustomerDTO savedCustomerDTO = new CustomerDTO();
            savedCustomerDTO.setId(savedCustomer.getId());
            savedCustomerDTO.setName(savedCustomer.getName());
            savedCustomerDTO.setPhone(savedCustomer.getPhone());
            savedCustomerDTO.setAddress(savedCustomer.getAddress());
            return savedCustomerDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
