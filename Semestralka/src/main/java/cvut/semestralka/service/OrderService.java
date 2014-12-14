/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.semestralka.service;

import cvut.semestralka.bo.Customer;
import cvut.semestralka.bo.Employee;
import cvut.semestralka.bo.Film;
import cvut.semestralka.bo.Orders;
import cvut.semestralka.dto.OrderDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;


/**
 *
 * @author Jirka
 */
@Component
public class OrderService extends AbstractService {

    private static OrderService orderService;

    public static OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderService();
        }
        return orderService;
    }

    public List<OrderDTO> getAllOrders() {
        List<Orders> orders = genericDao.getAll(Orders.class);
        List<OrderDTO> ordersDto = new ArrayList<OrderDTO>();
        for (Orders o : orders) {
            ordersDto.add(new OrderDTO(o.getId()));
        }
        return ordersDto;
    }

    public Long deleteOrder(OrderDTO orderDTO) {
        return genericDao.remove(Orders.class, orderDTO.getId());
    }

    public OrderDTO createOrder(Long customerId, List<Film> films) {
        Orders o = new Orders();
        o.setCustomer(genericDao.getById(customerId, Customer.class));
        o.setFilms(films);
        OrderDTO saved = new OrderDTO(genericDao.saveOrUpdate(o).getId());
        return saved;
    }

    public OrderDTO manageOrder(OrderDTO order, Long employeeId) {
        Orders o = new Orders();
        o.setEmployee(genericDao.getById(employeeId, Employee.class));
        OrderDTO managed = new OrderDTO(genericDao.saveOrUpdate(o).getId());
        return managed;
    }

    public List<OrderDTO> getAllHandledOrders(Long employeeId) {
        List<Orders> orders = genericDao.getByProperty("employee", genericDao.getById(employeeId, Employee.class), Orders.class);
        List<OrderDTO> ordersDto = new ArrayList<OrderDTO>();
        for (Orders o : orders) {
            ordersDto.add(new OrderDTO(o.getId()));
        }
        return ordersDto;
    }

    public List<OrderDTO> getAllCreatedOrders(Long customerID) {
        List<Orders> orders = genericDao.getByProperty("customer", genericDao.getById(customerID, Customer.class), Orders.class);
        List<OrderDTO> ordersDto = new ArrayList<OrderDTO>();
        for (Orders o : orders) {
            ordersDto.add(new OrderDTO(o.getId()));
        }
        return ordersDto;
    }
    
    public List<OrderDTO> getFilmOrders(Long idFilm){
        List<Orders> orders = manyToManyDao.getFilmOrders(idFilm);        
        List<OrderDTO> odtos = new ArrayList<OrderDTO>();    
        for (Orders o : orders) {
            odtos.add(new OrderDTO(o.getId()));       
        }    
        return odtos;
    }
    
    /*
     dalsi metody...
     */

}
