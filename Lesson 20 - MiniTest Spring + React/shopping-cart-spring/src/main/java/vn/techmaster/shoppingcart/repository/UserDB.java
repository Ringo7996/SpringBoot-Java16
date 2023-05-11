package vn.techmaster.shoppingcart.repository;

import vn.techmaster.shoppingcart.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> users = new ArrayList<>(List.of(
            User.builder().withId(1).withName("Nguyen Van A").withPhone("012345").withEmail("a@gmail.com").withAvatar("avatar1").build(),
            User.builder().withId(2).withName("Nguyen Van B").withPhone("012345").withEmail("b@gmail.com").withAvatar("avatar2").build(),
            User.builder().withId(3).withName("Nguyen Van C").withPhone("012345").withEmail("c@gmail.com").withAvatar("avatar3").build()

    ));

}
