package com.example.waaonlineminimarketbackend.service;

import com.example.waaonlineminimarketbackend.entity.CartItem;
import com.example.waaonlineminimarketbackend.entity.Item;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface ShoppingCartService {

    public void addToCart(long buyerId, CartItem cartItem);

    public List<CartItem> getAllItemfromCart();

    public void updateCart();

    public void deleteCart(Long buyerId, Long cartItemId);
}
