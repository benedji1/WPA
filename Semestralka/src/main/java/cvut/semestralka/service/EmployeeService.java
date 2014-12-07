package cvut.semestralka.service;

import cvut.semestralka.bo.Employee;
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
            dtos.add(new EmployeeDTO(employee.getFirstName(), employee.getLastName(), employee.getLogin(),
                    employee.getAddress(), employee.getPosition(),
                    Tools.getIdentifiers(employee.getOrders()), employee.getId()));
        }

        return dtos;
    }

    public boolean employeeExists(String login, String password) {
        boolean exists = false;
        List<Employee> employees = genericDao.getAll(Employee.class);
        for (Employee e : employees) {
            if (e.getLogin().equals(login) && e.getPassword().equals(password)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO, String password) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirst_name());
        employee.setLastName(employeeDTO.getLast_name());
        employee.setAddress(employeeDTO.getAddress());
        employee.setPosition(employeeDTO.getPosition());
        employee.setLogin(employeeDTO.getLogin());
        employee.setPassword(password);
        genericDao.saveOrUpdate(employee);

        return employeeDTO;
    }

    public Long deleteEmployee(EmployeeDTO employeeDTO) {
        return genericDao.remove(Employee.class, employeeDTO.getId());
    }

    public boolean isAdmin(String login) {
        List<Employee> employees = genericDao.getAll(Employee.class);
        for (Employee e : employees) {
            if (e.getLogin().equals(login) && e.getPosition().equals("administrator")) {
                return true;
            }
        }
        return false;
    }
}
