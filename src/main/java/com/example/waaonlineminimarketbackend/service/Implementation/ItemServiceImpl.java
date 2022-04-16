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
    ItemRepository itemRepository;

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(long id) {
        return itemRepository.getById(id);
    }

    @Override
    public void deleteItemById(long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void UpdateItemById(long id, Item i) {
        var item = itemRepository.getById(id);
        item.setItemId(i.getItemId());
        item.setName(i.getName());
        item.setPrice(i.getPrice());
        item.setQuantity(i.getQuantity());
        item.setReviewList(i.getReviewList());
    }

}
