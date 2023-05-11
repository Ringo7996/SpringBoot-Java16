package vn.techmaster.shoppingcart.repository;

import vn.techmaster.shoppingcart.entity.CartItem;
import vn.techmaster.shoppingcart.entity.Category;
import vn.techmaster.shoppingcart.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CartItemDB {
    public List<Category> getCategories() {
        return CategoryDB.categories;
    }

    public static List<CartItem> cartItems = new ArrayList<>(List.of(
            CartItem.builder().withId(1).withCount(1).withCourseId(1).build(),
            CartItem.builder().withId(2).withCount(1).withCourseId(2).build(),
            CartItem.builder().withId(3).withCount(1).withCourseId(3).build(),
            CartItem.builder().withId(4).withCount(1).withCourseId(4).build()
    ));
}



