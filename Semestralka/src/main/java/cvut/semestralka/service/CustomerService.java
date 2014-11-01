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

/**
 *
 * @author Jirka
 */
public class CustomerService extends AbstractService {

    private static CustomerService customerService;

    public static CustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = dao.getAll(Customer.class);
        List<CustomerDTO> customersDto = new ArrayList<CustomerDTO>();
        for (Customer c : customers) {
            customersDto.add(new CustomerDTO(c.getFirstName(), c.getLastName(), c.getEmail(),c.getId()));
        }
        return customersDto;
    }
    public CustomerDTO addCustomer(CustomerDTO customerDTO, String password){
        Customer customer = new Customer();
        customer.setEmail(customerDTO.getEmail());
        customer.setFirstName(customerDTO.getFirst_name());
        customer.setLastName(customerDTO.getLast_name());
        customer.setPassword(password);
        Customer saved = dao.saveOrUpdate(customer);
        return new CustomerDTO(saved.getFirstName(), saved.getLastName(), saved.getEmail(), saved.getId());
    }
    
    public Long deleteCustomer(CustomerDTO customerDTO){
        return dao.remove(Customer.class, customerDTO.getId());
    }
    /*
    dalsi metody...
    */
}