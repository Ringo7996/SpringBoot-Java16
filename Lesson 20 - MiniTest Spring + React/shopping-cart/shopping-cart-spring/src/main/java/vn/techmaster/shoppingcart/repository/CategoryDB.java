package vn.techmaster.shoppingcart.repository;

import vn.techmaster.shoppingcart.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDB {
    public static List<Category> categories = new ArrayList<>(List.of(
            Category.builder().withId(1).withName("Backend").build(),
            Category.builder().withId(2).withName("Frontend").build(),
            Category.builder().withId(3).withName("Fullstack").build(),
            Category.builder().withId(4).withName("Mobile").build()
    ));
 }

