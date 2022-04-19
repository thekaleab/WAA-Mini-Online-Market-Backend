package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderInputDto;
import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderUpdateInputDto;
import com.example.waaonlineminimarketbackend.repository.OrderRepository;
import com.example.waaonlineminimarketbackend.repository.OrderStatusRepository;
import com.example.waaonlineminimarketbackend.repository.ProductRepository;
import com.example.waaonlineminimarketbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Override
    public void saveOrder(OrderInputDto orderD) {
        orderD.getOrder().stream().forEach(orderItem -> {
            var product = productRepository.getById(orderItem.getProductId());
            var orderStatus = orderStatusRepository.getById(1L); // id=1 should be RECEIVED
            Order newOrder = new Order();
            // TODO: set Buyer somehow
            newOrder.setStatus(orderStatus);
            newOrder.setQuantity(orderItem.getQuantity());
            newOrder.setProduct(product);

            orderRepository.save(newOrder);

            product.setQuantity(product.getQuantity() - orderItem.getQuantity() );
            productRepository.save(product);
        });

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
    public void UpdateOrderById(long id, OrderStatus orderStatus) {
        var order = orderRepository.getById(id);
        order.setStatus(orderStatus);
        orderRepository.save(order);
    }
}
