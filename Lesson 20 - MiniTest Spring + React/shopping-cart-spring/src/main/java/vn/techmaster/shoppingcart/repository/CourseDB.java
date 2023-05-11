package vn.techmaster.shoppingcart.repository;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import vn.techmaster.shoppingcart.entity.CartItem;
import vn.techmaster.shoppingcart.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDB {


    public static List<Course> courses = new ArrayList<>(List.of(
            Course.builder().withId(1).withName("Java").withDescription("Java description").withType("offline").withCategories(List.of(CategoryDB.categories.get(1), CategoryDB.categories.get(3))).withThumbnail("java.jpg").withPrice(150000).withRating(4.5).withUserId(1).build(),
            Course.builder().withId(2).withName("PHP").withDescription("PHP description").withType("offline").withCategories(List.of(CategoryDB.categories.get(1), CategoryDB.categories.get(3))).withThumbnail("php.jpg").withPrice(200000).withRating(4.0).withUserId(3).build(),
            Course.builder().withId(3).withName("Flutter").withDescription("Flutter description").withType("online").withCategories(List.of(CategoryDB.categories.get(1))).withThumbnail("flutter.jpg").withPrice(300000).withRating(4.0).withUserId(3).build(),
            Course.builder().withId(4).withName("React").withDescription("React description").withType("online").withCategories(List.of(CategoryDB.categories.get(2))).withThumbnail("react.jpg").withPrice(150000).withRating(4.5).withUserId(2).build()
    ));
}
