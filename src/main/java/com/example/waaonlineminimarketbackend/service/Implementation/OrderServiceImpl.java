package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderInputDto;
import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderStatusInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderUpdateInputDto;
import com.example.waaonlineminimarketbackend.repository.OrderRepository;
import com.example.waaonlineminimarketbackend.repository.OrderStatusRepository;
import com.example.waaonlineminimarketbackend.repository.ProductRepository;
import com.example.waaonlineminimarketbackend.service.OrderService;
import com.example.waaonlineminimarketbackend.util.AuthenticatedUser;
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

    @Autowired
    AuthenticatedUser authenticatedUser;

    @Override
    public void saveOrder(OrderInputDto orderD) throws Exception {
        var buyer = authenticatedUser.getCurrentUser();
        if(buyer == null) {
            throw new Exception("Cannot create a product without seller");
        }
        orderD.getOrder().stream().forEach(orderItem -> {
            var product = productRepository.getById(orderItem.getProductId());
            var orderStatus = orderStatusRepository.getById(1L); // id=1 should be RECEIVED
            Order newOrder = new Order();
            newOrder.setStatus(orderStatus);
            newOrder.setQuantity(orderItem.getQuantity());
            newOrder.setProduct(product);
            newOrder.setBuyer(buyer);
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
    public List<Order> getByBuyer(long id) {
        return orderRepository.getByBuyerId(id);
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

    @Override
    public void updateStatus(long id, OrderStatusInputDto orderStatusDto) {
        var order = orderRepository.getById(id);
        long currentStatusId = order.getStatus().getId();
        if(orderStatusDto.getStatus().getId() == 5 && currentStatusId > 2) {
            return;  // Shipped item can't be cancelled.
        }
        order.setStatus(orderStatusDto.getStatus());
        orderRepository.save(order);
    }
}
