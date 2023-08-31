package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}")
    public ResponseEntity<CartEntity> addItemToCart(@PathVariable Integer userId, @RequestBody List<String> itemIds) {
        CartEntity cart = cartService.addItemToCart(userId, itemIds);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Item>> getListOfItemsInCart(@PathVariable Integer userId) {
        List<Item> items = cartService.getListOfItems(userId);
        if (items != null) {
            return ResponseEntity.ok(items);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userId}/{itemId}")
    public ResponseEntity<Void> removeItemFromCart(@PathVariable Integer userId, @PathVariable String itemId) {
        cartService.removeItemFromCart(userId, itemId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createCart(@RequestBody CartEntity cart) {
        cartService.createCart(cart);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{userId}")
    public ResponseEntity<CartEntity> updateCart(@PathVariable Integer userId, @RequestBody List<String> itemIds) {
        CartEntity cart = cartService.updateCart(userId, itemIds);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> clearCart(@PathVariable Integer userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok().build();
    }
}

