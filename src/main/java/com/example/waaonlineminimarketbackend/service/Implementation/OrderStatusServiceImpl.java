package com.example.waaonlineminimarketbackend.service.Implementation;


import com.example.waaonlineminimarketbackend.entity.OrderStatus;
import com.example.waaonlineminimarketbackend.repository.OrderStatusRepository;
import com.example.waaonlineminimarketbackend.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Override
    public void saveOrderStatus(OrderStatus os) {
      orderStatusRepository.save(os);
    }

    @Override
    public List<OrderStatus> getAllOrderStatus() {
        return orderStatusRepository.findAll();
    }

    @Override
    public OrderStatus getOrderStatusById(long id) {
        return  orderStatusRepository.getById(id);
    }

    @Override
    public void deleteOrderStatusById(long id) {
        orderStatusRepository.deleteById(id);

    }

    @Override
    public void UpdateOrderStatusById(long id, OrderStatus os) {
         var orderStatus = orderStatusRepository.getById(id);
         orderStatus.setId(os.getId());
         orderStatus.setName(os.getName());
    }
}
