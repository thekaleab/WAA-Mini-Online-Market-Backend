package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Item;
import com.example.waaonlineminimarketbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping
    public void addItem(@RequestBody Item item){
        itemService.saveItem(item);

    }
    @GetMapping
    public List<Item> getAllItem() {

        return itemService.getAllItem();
    }
    @GetMapping("/{id}")
    public Item getItmeById(@PathVariable long id){
        return itemService.getItemById(id);
    }
    @PutMapping("/{id}")
    public void updateItemById(@PathVariable long id, @RequestBody Item item){
        itemService.UpdateItemById(id, item);

    }
    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable long id){
        itemService.deleteItemById(id);
    }
}
