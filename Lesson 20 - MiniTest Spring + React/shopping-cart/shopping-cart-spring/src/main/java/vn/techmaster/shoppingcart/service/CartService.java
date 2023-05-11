package vn.techmaster.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import vn.techmaster.shoppingcart.dto.CartItemDto;
import vn.techmaster.shoppingcart.entity.CartItem;
import vn.techmaster.shoppingcart.repository.CartItemDB;

import java.util.List;

public interface CartService {
    List<CartItemDto> getAllCartItem();

    void deleteCartItemById(Integer id);

    void incrementCartItem(Integer id);

    void decrementCartItem(Integer id);
}
