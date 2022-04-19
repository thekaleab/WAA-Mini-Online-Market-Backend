package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.repository.OrderRepository;
import com.example.waaonlineminimarketbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
     orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public  Order getOrderById(long id) {
        return orderRepository.getById(id);
    }

    @Override
    public void deleteOrderById(long id) {
        orderRepository.deleteById(id);

    }

    @Override
    public void UpdateOrderById(long id, Order o) {
        var order = orderRepository.getById(id);
//        order.setOrderId(o.getOrderId());
//        order.setOrderDate(o.getOrderDate());
//        order.setOrderStatus(o.getOrderStatus());
//        order.setOrderTime(o.getOrderTime());
//        order.setItemList(o.getItemList());
    }
}
