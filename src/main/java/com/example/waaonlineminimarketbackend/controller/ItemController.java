package com.example.waaonlineminimarketbackend.controller;

import com.example.waaonlineminimarketbackend.entity.Address;
import com.example.waaonlineminimarketbackend.entity.Item;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @PostMapping
    public void addItem(Item item){

    }
    @GetMapping
    public List<Item> getAllItem(){
        return null;
    }
    @GetMapping
    public Item getItmeById(long id){
        return null;
    }
    @PutMapping
    public void updateItemById(long id, Item item){

    }
    @DeleteMapping
    public void deleteItemById(long id){

    }
}
