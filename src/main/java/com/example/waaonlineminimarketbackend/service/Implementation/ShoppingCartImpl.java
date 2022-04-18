package com.example.waaonlineminimarketbackend.service.Implementation;

import com.example.waaonlineminimarketbackend.entity.*;
import com.example.waaonlineminimarketbackend.repository.*;
import com.example.waaonlineminimarketbackend.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ShoppingCartImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public void addToCart(long id, CartItem cartItem) {
//        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartItemDto.getBuyer().getId());
//        if (shoppingCart != null){
//            System.out.println("not empty");
//            List<CartItem> cartItems = shoppingCart.getItems();
//            for (CartItem cartItem: cartItems){
//                if (cartItem.getProduct().getId().equals(cartItemDto.getProduct().getId())) {
//                    cartItem.setQuantity(cartItem.getQuantity() + cartItemDto.getQuantity());
//                    shoppingCart.setItems(cartItems);
//                    return shoppingCartRepository.save(shoppingCart);
//                }
//            }
//        }else {
//            shoppingCart = new ShoppingCart();
//            cartItemDto.setProduct(modelMapper.map(productService.findProductById(cartItemDto.getProduct().getId()), Product.class));
//            cartItemDto.setDate(new Date());
//            shoppingCart.setCreatedDate(new Date());
//            shoppingCart.setBuyer(cartItemDto.getBuyer());
//            shoppingCart.getItems().add(modelMapper.map(cartItemDto, CartItem.class));
//        }
//        //shoppingCart.setTotalPrice(shoppingCart.getTotalPrice(shoppingCart.getItems()));
//        return shoppingCartRepository.save(shoppingCart);


    }

    @Override
    public List<CartItem> getAllItemfromCart() {
        return cartItemRepository.findAll();
    }

    @Override
    public void updateCart() {

    }

    @Override
    public void deleteCart(Long buyerId, Long cartItemId) {
//        ShoppingCart shoppingCart = shoppingCartRepository.findByBuyer_Id(buyerId);
//        System.out.println(buyerId+" "+cartItemId);
//        List<CartItem> cartItems = shoppingCart.getItems();
//        cartItems.stream().filter(cartItem1 -> Objects.equals(cartItem1.getId(), cartItemId)).findFirst().ifPresent(cartItems::remove);
//        shoppingCart.setItems(cartItems);
//        shoppingCartRepository.save(shoppingCart);

    }
}
