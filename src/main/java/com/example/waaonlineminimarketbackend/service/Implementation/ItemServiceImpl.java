package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.Item;
import com.example.waaonlineminimarketbackend.repository.ItemRepository;
import com.example.waaonlineminimarketbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemService;

    @Override
    public void saveItem(Item item) {
    itemService.save(item);
    }

    @Override
    public List<Item> getAllItem() {
        return itemService.findAll();
    }

    @Override
    public Item getItemById(long id) {
        return itemService.getById(id);
    }

    @Override
    public void deleteItemById(long id) {
        itemService.deleteById(id);
    }

    @Override
    public void UpdateItemById(long id, Item i) {
        var item = itemService.getById(id);
        item.setItemId(i.getItemId());
        item.setName(i.getName());
        item.setPrice(i.getPrice());
        item.setQuantity(i.getQuantity());
        item.setReviewList(i.getReviewList());
    }

}
