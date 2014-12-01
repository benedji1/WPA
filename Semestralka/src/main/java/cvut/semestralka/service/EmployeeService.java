package cvut.semestralka.service;

import cvut.semestralka.bo.Employee;
import cvut.semestralka.dao.GenericDao;
import cvut.semestralka.dto.EmployeeDTO;
import cvut.semestralka.tools.Tools;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService extends AbstractService {

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = genericDao.getAll(Employee.class);
        List<EmployeeDTO> dtos = new ArrayList<EmployeeDTO>();

        for (Employee employee : employees) {
            dtos.add(new EmployeeDTO(employee.getFirstName(), employee.getLastName(),
                    employee.getAddress(), employee.getPosition(),
                    Tools.getIdentifiers(employee.getOrders()), employee.getId()));
        }

        return dtos;
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirst_name());
        employee.setLastName(employeeDTO.getLast_name());
        employee.setAddress(employeeDTO.getAddress());
        employee.setPosition(employeeDTO.getPosition());

        genericDao.saveOrUpdate(employee);

        return employeeDTO;
    }

    public Long deleteEmployee(EmployeeDTO employeeDTO) {
        return genericDao.remove(Employee.class, employeeDTO.getId());
    }
    
    
    /*
     dalsi metody...
     */
}
