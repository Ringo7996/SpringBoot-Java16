package vn.techmaster.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.shoppingcart.dto.CartItemDto;
import vn.techmaster.shoppingcart.entity.CartItem;
import vn.techmaster.shoppingcart.entity.Course;
import vn.techmaster.shoppingcart.repository.CourseDB;
import vn.techmaster.shoppingcart.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cartItems")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("")
    public List<CartItemDto> getAllCartItems(){
        return cartService.getAllCartItem();
    }

    @DeleteMapping("/{id}")
    public void deleteCartItemById(@PathVariable Integer id){
         cartService.deleteCartItemById(id);
    }

    @PutMapping("/{id}/increment")
    public void IncrementCartItem(@PathVariable Integer id){
        cartService.incrementCartItem(id);
    }

    @PutMapping("/{id}/decrement")
    public void DecrementCartItem(@PathVariable Integer id){
        cartService.decrementCartItem(id);
    }


}
