package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Product;
import com.example.waaonlineminimarketbackend.repository.ProductRepository;
import com.example.waaonlineminimarketbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository itemRepository;

    @Override
    public void saveItem(Product item) {
        itemRepository.save(item);
    }

    @Override
    public List<Product> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public Product getItemById(long id) {
        return itemRepository.getById(id);
    }

    @Override
    public void deleteItemById(long id) {
//        var item = itemRepository.getById(id);
//        if (item.isAvailable()) {
//            itemRepository.deleteById(id);
//        }
    }


    @Override
    public void UpdateItemById(long id, Product i) {
//        System.out.println(i);
//        var item = itemRepository.getById(id);
//
//        item.setName(i.getName());
//        item.setPrice(i.getPrice());
//        item.setAvailable(i.isAvailable());
//
//        itemRepository.save(item);
    }

}
