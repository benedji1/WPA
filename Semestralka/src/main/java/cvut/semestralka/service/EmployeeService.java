package cvut.semestralka.service;

import cvut.semestralka.bo.Employee;
import cvut.semestralka.dao.GenericDao;
import cvut.semestralka.dao.GenericDaoI;
import cvut.semestralka.dto.EmployeeDTO;
import cvut.semestralka.tools.Tools;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public List<EmployeeDTO> getAllEmployees() {
        GenericDaoI dao = GenericDao.getDao();
        List<Employee> employees = dao.getAll(Employee.class);
        List<EmployeeDTO> dtos = new ArrayList<EmployeeDTO>();

        for (Employee employee : employees) {
            dtos.add(new EmployeeDTO(employee.getFirstName(), employee.getLastName(),
                    employee.getAddress(), employee.getPosition(),
                    Tools.getIdentifiers(employee.getOrders())));
        }

        return dtos;
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        GenericDaoI dao = GenericDao.getDao();

        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirst_name());
        employee.setLastName(employeeDTO.getLast_name());
        employee.setAddress(employeeDTO.getAddress());
        employee.setPosition(employeeDTO.getPosition());
        
        dao.saveOrUpdate(employee);

        return employeeDTO;
    }
}
