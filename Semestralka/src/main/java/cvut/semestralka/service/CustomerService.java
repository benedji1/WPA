/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.service;

import cvut.semestralka.bo.Customer;
import cvut.semestralka.dto.CustomerDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jirka
 */
@Component
public class CustomerService extends AbstractService {

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = genericDao.getAll(Customer.class);
        List<CustomerDTO> customersDto = new ArrayList<CustomerDTO>();
        for (Customer c : customers) {
            customersDto.add(new CustomerDTO(c.getFirstName(), c.getLastName(), c.getEmail(),c.getId()));
        }
        return customersDto;
    }
    public Long addCustomer(CustomerDTO customerDTO, String password){
        Customer customer = new Customer();
        customer.setEmail(customerDTO.getEmail());
        customer.setFirstName(customerDTO.getFirst_name());
        customer.setLastName(customerDTO.getLast_name());
        customer.setPassword(password);
        Customer saved = genericDao.saveOrUpdate(customer);
        return saved.getId();
    }
    
    public Long deleteCustomer(CustomerDTO customerDTO){
        return genericDao.remove(Customer.class, customerDTO.getId());
    }
    /*
    dalsi metody...
    */
}
