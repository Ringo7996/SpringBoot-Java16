package vn.techmaster.shoppingcart.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import vn.techmaster.shoppingcart.dto.CartItemDto;
import vn.techmaster.shoppingcart.entity.CartItem;
import vn.techmaster.shoppingcart.entity.Course;
import vn.techmaster.shoppingcart.repository.CartItemDB;
import vn.techmaster.shoppingcart.repository.CourseDB;

import java.util.Objects;

public class CartItemMapper {
    public static CartItemDto toCartItemDto(CartItem cartItem, Course course) {

        return CartItemDto.builder().withId(cartItem.getId()).withCount(cartItem.getCount()).withCourse(course).build();
    }
}
