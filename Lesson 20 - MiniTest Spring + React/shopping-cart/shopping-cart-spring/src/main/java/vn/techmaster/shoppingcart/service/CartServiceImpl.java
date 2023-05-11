package vn.techmaster.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.shoppingcart.dto.CartItemDto;
import vn.techmaster.shoppingcart.entity.CartItem;
import vn.techmaster.shoppingcart.mapper.CartItemMapper;
import vn.techmaster.shoppingcart.repository.CartItemDB;
import vn.techmaster.shoppingcart.repository.CartRepository;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<CartItemDto> getAllCartItem() {
        return cartRepository.getAllCartItem();
    }

    @Override
    public void deleteCartItemById(Integer id) {
        cartRepository.deleteCartItemById(id);
    }

    @Override
    public void incrementCartItem(Integer id) {
        cartRepository.incrementCartItem(id);
    }

    @Override
    public void decrementCartItem(Integer id) {
        cartRepository.decrementCartItem(id);
    }
}

