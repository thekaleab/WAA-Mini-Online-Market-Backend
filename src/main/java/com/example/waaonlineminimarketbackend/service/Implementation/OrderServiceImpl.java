package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Order;
import com.example.waaonlineminimarketbackend.entity.OrderItem;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderInputDto;
import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderItemInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderItemStatusInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.input.OrderStatusInputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.OrderItemOutputDto;
import com.example.waaonlineminimarketbackend.entity.dto.output.OrderOutputDto;
import com.example.waaonlineminimarketbackend.exceptions.BadRequestException;
import com.example.waaonlineminimarketbackend.repository.OrderItemRepository;
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

    @Autowired
    ListMapper<OrderItem, OrderItemOutputDto> listModelMapper2;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public void saveOrder(OrderInputDto orderD) throws BadRequestException {
        var buyer = authenticatedUser.getCurrentUser();

        if(buyer == null) {
            throw new BadRequestException("Cannot create a product without seller");
        }
        boolean errorOccured = false;
        double total = 0;
        var orderStatus = orderStatusRepository.getById(2L); // id=2 should be RECEIVED
        List<OrderItem> orderItems = new ArrayList<>();
        for(OrderItemInputDto orderItem: orderD.getOrder()) {
            var product = productRepository.getById(orderItem.getProductId());
            if (product.getQuantity() < 0 || product.getQuantity() < orderItem.getQuantity()) {
                errorOccured = true;
                break;
            } else {
                OrderItem newOrderItem = new OrderItem();
                newOrderItem.setQuantity(orderItem.getQuantity());
                newOrderItem.setProduct(product);
                orderItems.add(newOrderItem);
                newOrderItem.setStatus(orderStatus);
                total += (product.getPrice() * orderItem.getQuantity());
            }
        }
        if(errorOccured) {
            throw new BadRequestException("Product no longer available");
        }
        Order newOrder = new Order();
        LocalDateTime now = LocalDateTime.now();
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
    public void updateStatus(long id, OrderStatusInputDto orderStatusDto) throws BadRequestException{
        var order = orderRepository.getById(id);
        if(order.getStatus().getId() == 5 && orderStatusDto.getId() > 2) {
            throw new BadRequestException("Order is cancelled and can not longer be updated");
        }
        var orderStatus = orderStatusRepository.getById(orderStatusDto.getId());
        order.setStatus(orderStatus);
        orderRepository.save(order);
    }

    @Override
    public void updateOrderItemStatus(long orderItemId, OrderItemStatusInputDto orderStatusDto) throws BadRequestException {
        var order = orderRepository.getById(orderStatusDto.getOrderId());
        var orderItems = order.getOrderItems();
        var storeOrderItem = orderItems.stream().filter(oT -> oT.getId() == orderItemId)
                .findFirst().orElseThrow(BadRequestException::new);
        if(storeOrderItem.getStatus().getId() == 5 && orderStatusDto.getStatusId() > 2) {
            throw new BadRequestException("Order is cancelled and can not longer be updated");
        }
        var desiredOrderStatus = orderStatusRepository.getById(orderStatusDto.getStatusId());
        storeOrderItem.setStatus(desiredOrderStatus);
        orderRepository.save(order);
    }

    @Override
    public List<OrderStatus> getAllOrderStatus() {
        return orderStatusRepository.findAll();
    }

    @Override
    public List<OrderOutputDto> getAllOrdersBySeller(long id) {
        var orders = orderRepository.findBySellerId(id);
        return (List<OrderOutputDto>) listModelMapper.mapList(orders, new OrderOutputDto());
    }

    // OrderItem related, added here because orderItem and Order are closely coupled
    @Override
    public List<OrderItemOutputDto> getAllOrderItemsBySeller(long id) {
        var orderItems = orderItemRepository.findBySellerId(id);
        return (List<OrderItemOutputDto>) listModelMapper2.mapList(orderItems, new OrderItemOutputDto());
    }

}
