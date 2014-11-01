/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.service;

import cvut.semestralka.bo.Customer;
import cvut.semestralka.bo.Employee;
import cvut.semestralka.bo.Film;
import cvut.semestralka.bo.Order;
import cvut.semestralka.dto.OrderDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jirka
 */
public class OrderService extends AbstractService {

    private static OrderService orderService;

    public static OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderService();
        }
        return orderService;
    }

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = dao.getAll(Order.class);
        List<OrderDTO> ordersDto = new ArrayList<OrderDTO>();
        for (Order o : orders) {
            ordersDto.add(new OrderDTO(o.getId()));
        }
        return ordersDto;
    }

    public Long deleteOrder(OrderDTO orderDTO) {
        return dao.remove(Order.class, orderDTO.getId());
    }

    public OrderDTO createOrder(Long customerId, List<Film> films) {
        Order o = new Order();
        o.setCustomer(dao.getById(customerId, Customer.class));
        o.setFilms(films);
        OrderDTO saved = new OrderDTO(dao.saveOrUpdate(o).getId());
        return saved;
    }

    public OrderDTO manageOrder(OrderDTO order, Long employeeId) {
        Order o = new Order();
        o.setEmployee(dao.getById(employeeId, Employee.class));
        OrderDTO managed = new OrderDTO(dao.saveOrUpdate(o).getId());
        return managed;
    }

    public List<OrderDTO> getAllHandledOrders(Long employeeId) {
        List<Order> orders = dao.getByProperty("employee", dao.getById(employeeId, Employee.class), Order.class);
        List<OrderDTO> ordersDto = new ArrayList<OrderDTO>();
        for (Order o : orders) {
            ordersDto.add(new OrderDTO(o.getId()));
        }
        return ordersDto;
    }

    public List<OrderDTO> getAllCreatedOrders(Long customerID) {
        List<Order> orders = dao.getByProperty("customer", dao.getById(customerID, Customer.class), Order.class);
        List<OrderDTO> ordersDto = new ArrayList<OrderDTO>();
        for (Order o : orders) {
            ordersDto.add(new OrderDTO(o.getId()));
        }
        return ordersDto;
    }
    /*
     dalsi metody...
     */

}
