package cvut.semestralka.service;

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
        CustomerDTO cust1 = new CustomerDTO("fn1", "ln1", "em1", 1L);
        CustomerDTO cust2 = new CustomerDTO("fn2", "ln2", "em2", 2L);
        CustomerDTO cust3 = new CustomerDTO("fn3", "ln3", "em3", 3L);
        CustomerDTO cust4 = new CustomerDTO("fn4", "ln4", "em4", 4L);
        CustomerDTO cust5 = new CustomerDTO("fn5", "ln5", "em5", 5L);
        
        service.addCustomer(cust1, "p1");
        service.addCustomer(cust2, "p2");
        service.addCustomer(cust3, "p3");
        service.addCustomer(cust4, "p4");
        service.addCustomer(cust5, "p5");
        
        List<CustomerDTO> customers = service.getAllCustomers();
        assertTrue(customers.size()==5);
    }

    @Test
    public void testAddCustomer() {
       CustomerService service = new CustomerService();
       CustomerDTO customer = new CustomerDTO("fn", "ln", "email", 70L);
       CustomerDTO expCustomer = service.addCustomer(customer, "psswd");
       assertEquals(customer, expCustomer);     
    }

    @Test
    public void testDeleteCustomer() {
        CustomerDTO customerDTO = new CustomerDTO("fn", "ln", "email", 80L);
        CustomerService service = new CustomerService();
        service.addCustomer(customerDTO, "passwd");   
        Long id = service.deleteCustomer(customerDTO);
        assertEquals(id, customerDTO.getId());
    }
}
