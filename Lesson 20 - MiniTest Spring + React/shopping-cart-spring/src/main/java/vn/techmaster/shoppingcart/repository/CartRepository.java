package vn.techmaster.shoppingcart.repository;

import org.springframework.stereotype.Repository;
import vn.techmaster.shoppingcart.dto.CartItemDto;
import vn.techmaster.shoppingcart.entity.CartItem;
import vn.techmaster.shoppingcart.entity.Course;
import vn.techmaster.shoppingcart.entity.User;
import vn.techmaster.shoppingcart.exception.NotFoundException;
import vn.techmaster.shoppingcart.mapper.CartItemMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CartRepository {
    public static List<Course> getAllCourses() {
        return CourseDB.courses;
    }

    public List<CartItemDto> getAllCartItem() {
        List<CartItemDto> cartItemDtos = new ArrayList<>();
        for (CartItem cartItem : CartItemDB.cartItems) {
            Course courseOfItem = null;
            for (Course course : CourseDB.courses) {
                if (Objects.equals(cartItem.getCourseId(), course.getId())) {
                    courseOfItem = course;
                }
            }

            if (courseOfItem == null){
                throw new NotFoundException("Course id "+ cartItem.getCourseId() + "is not found");
            }

            CartItemDto mappedItemDto = CartItemMapper.toCartItemDto(cartItem, courseOfItem);
            cartItemDtos.add(mappedItemDto);
        }
        return cartItemDtos;
    }


    public void deleteCartItemById(Integer id) {
        CartItem item2find = findItemById(id);
        CartItemDB.cartItems.remove(item2find);
    }


    public void incrementCartItem(Integer id) {
        CartItem item2find = findItemById(id);
        Integer newCount = item2find.getCount() + 1;
        item2find.setCount(newCount);
    }

    public void decrementCartItem(Integer id) {
        CartItem item2find = findItemById(id);
        Integer newCount = item2find.getCount() - 1;
        item2find.setCount(newCount);
    }

    public CartItem findItemById(Integer id) {
        CartItem item2find = null;
        for (CartItem cartItem : CartItemDB.cartItems) {
            if (Objects.equals(cartItem.getId(), id)) {
                item2find = cartItem;
            }
        }
        if (item2find == null) {
            throw new NotFoundException("User " + id + "not found");
        }
        return item2find;
    }


}
