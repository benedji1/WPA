package cvut.semestralka.service;

import cvut.semestralka.bo.Customer;
import cvut.semestralka.dto.CustomerDTO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Koulas
 */
public class CustomerServiceTest extends AbstractServiceTest{

    @Test
    public void testGetAllCustomers() {
        System.out.println("getAllCustomers");
        CustomerService service = new CustomerService();
        int originalSize = service.getAllCustomers().size();
        CustomerDTO cust1 = new CustomerDTO("fn1", "ln1", "em1");
        CustomerDTO cust2 = new CustomerDTO("fn2", "ln2", "em2");
        CustomerDTO cust3 = new CustomerDTO("fn3", "ln3", "em3");
        CustomerDTO cust4 = new CustomerDTO("fn4", "ln4", "em4");
        CustomerDTO cust5 = new CustomerDTO("fn5", "ln5", "em5");
        
        cust1.setId(service.addCustomer(cust1, "p1"));
        cust2.setId(service.addCustomer(cust2, "p2"));
        cust3.setId(service.addCustomer(cust3, "p3"));
        cust4.setId(service.addCustomer(cust4, "p4"));
        cust5.setId(service.addCustomer(cust5, "p5"));
        
        List<CustomerDTO> customers = service.getAllCustomers();
        assertTrue(customers.size()==originalSize+5);
    }

    @Test
    public void testAddCustomer() {
       CustomerService service = new CustomerService();
       CustomerDTO customer = new CustomerDTO("fn", "ln", "email");
       Long expID = service.addCustomer(customer, "psswd");
       assertEquals(service.getDao().getById(expID, Customer.class).getId(), expID);     
    }

    @Test
    public void testDeleteCustomer() {
        CustomerDTO customerDTO = new CustomerDTO("fn", "ln", "email");
        CustomerService service = new CustomerService();
        customerDTO.setId(service.addCustomer(customerDTO, "passwd"));   
        Long id = service.deleteCustomer(customerDTO);
        assertEquals(id, customerDTO.getId());
    }
}
