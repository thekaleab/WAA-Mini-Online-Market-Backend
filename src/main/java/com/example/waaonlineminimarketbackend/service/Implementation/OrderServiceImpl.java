package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Item;
import com.example.waaonlineminimarketbackend.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void saveOrder() {

    }

    @Override
    public List<Item> getAllOrder() {
        return null;
    }

    @Override
    public Item getOrderById(long id) {
        return null;
    }

    @Override
    public void deleteOrderById(long id) {

    }

    @Override
    public void UpdateOrderById(long id) {

    }
}
