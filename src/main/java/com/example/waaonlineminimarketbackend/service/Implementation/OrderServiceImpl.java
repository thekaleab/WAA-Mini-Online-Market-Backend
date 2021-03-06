package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.OrderItem;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderInputDto;
import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderItemInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderStatusInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.OrderOutputDto;
import com.example.waaonlineminimarketbackend.exceptions.BadRequestException;
import com.example.waaonlineminimarketbackend.repository.OrderRepository;
import com.example.waaonlineminimarketbackend.repository.OrderStatusRepository;
import com.example.waaonlineminimarketbackend.repository.ProductRepository;
import com.example.waaonlineminimarketbackend.service.OrderService;
import com.example.waaonlineminimarketbackend.util.AuthenticatedUser;
import com.example.waaonlineminimarketbackend.util.ListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Autowired
    ListMapper<Order, OrderOutputDto> listModelMapper;

    @Override
    public void saveOrder(OrderInputDto orderD) throws BadRequestException {
        var buyer = authenticatedUser.getCurrentUser();

        if(buyer == null) {
            throw new BadRequestException("Cannot create a product without seller");
        }
        boolean errorOccured = false;
        double total = 0;
        List<OrderItem> orderItems = new ArrayList<>();
        for(OrderItemInputDto orderItem: orderD.getOrder()) {
            var product = productRepository.getById(orderItem.getProductId());
            if (product.getQuantity() < orderItem.getQuantity()) {
                errorOccured = true;
                break;
            } else {
                OrderItem newOrderItem = new OrderItem();
                newOrderItem.setQuantity(orderItem.getQuantity());
                newOrderItem.setProduct(product);
                orderItems.add(newOrderItem);
                total += (product.getPrice() * orderItem.getQuantity());
            }
        }
        if(errorOccured) {
            throw new BadRequestException("Product no longer available");
        }
        Order newOrder = new Order();
        LocalDateTime now = LocalDateTime.now();
        var orderStatus = orderStatusRepository.getById(2L); // id=2 should be RECEIVED
        newOrder.setStatus(orderStatus);
        newOrder.setOrderItems(orderItems);
        newOrder.setOrderTime(now);
        newOrder.setUpdatedTime(now);
        newOrder.setAmount(total);
        newOrder.setBuyer(buyer);
        orderRepository.save(newOrder);

        for(OrderItem oItem: orderItems) {
            var product = productRepository.getById(oItem.getProduct().getId());
            product.setQuantity(product.getQuantity() - oItem.getQuantity());
            productRepository.save(product);
        }

    }

    @Override
    public List<OrderOutputDto> getAllOrder() {
        var orders = orderRepository.findAll();
        return (List<OrderOutputDto>) listModelMapper.mapList(orders, new OrderOutputDto());
    }

    @Override
    public List<OrderOutputDto> getByBuyer(long id) {
        var orders = orderRepository.getByBuyerId(id);
        return (List<OrderOutputDto>) listModelMapper.mapList(orders, new OrderOutputDto());
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
