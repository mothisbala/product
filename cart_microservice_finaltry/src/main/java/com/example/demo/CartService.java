package com.example.demo;

import java.util.List;

public interface CartService {
    CartEntity addItemToCart(Integer userId, List<String> itemIds);
    List<Item> getListOfItems(Integer userId);
    void removeItemFromCart(Integer userId, String itemId);
    void createCart(CartEntity cart);
    CartEntity updateCart(Integer userId, List<String> itemIds);
    void clearCart(Integer userId);
}
