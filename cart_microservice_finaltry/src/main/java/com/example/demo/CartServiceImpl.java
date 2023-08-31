package com.example.demo;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public CartEntity addItemToCart(Integer userId, List<String> itemIds) {
        CartEntity cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            cart = new CartEntity();
            cart.setUserId(userId);
        }

        List<Item> items = itemIds.stream()
                .map(itemId -> itemRepository.findById(itemId).orElse(null))
                .collect(Collectors.toList());

        if (items.isEmpty()) {
            // Handle item not found scenario
            return null;
        }

        cart.setItems(items);
        return cartRepository.save(cart);
    }

    @Override
    public List<Item> getListOfItems(Integer userId) {
        CartEntity cart = cartRepository.findByUserId(userId);
        if (cart != null) {
            return cart.getItems();
        }
        return null;
    }

    @Override
    public void removeItemFromCart(Integer userId, String itemId) {
        CartEntity cart = cartRepository.findByUserId(userId);
        if (cart != null) {
            List<Item> updatedItems = cart.getItems().stream()
                    .filter(item -> !item.getId().equals(itemId))
                    .collect(Collectors.toList());
            cart.setItems(updatedItems);
            cartRepository.save(cart);
        }
    }

    @Override
    public void createCart(CartEntity cart) {
        cartRepository.save(cart);
    }

    @Override
    public CartEntity updateCart(Integer userId, List<String> itemIds) {
        CartEntity cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            // Handle cart not found scenario
            return null;
        }

        List<Item> items = itemIds.stream()
                .map(itemId -> itemRepository.findById(itemId).orElse(null))
                .collect(Collectors.toList());

        if (items.isEmpty()) {
            // Handle item not found scenario
            return null;
        }

        cart.setItems(items);
        return cartRepository.save(cart);
    }

    @Override
    public void clearCart(Integer userId) {
        CartEntity cart = cartRepository.findByUserId(userId);
        if (cart != null) {
            cart.setItems(null);
            cartRepository.save(cart);
        }
    }
}
