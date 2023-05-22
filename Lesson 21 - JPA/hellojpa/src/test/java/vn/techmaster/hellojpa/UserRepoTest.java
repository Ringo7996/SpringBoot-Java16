package vn.techmaster.hellojpa;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import vn.techmaster.hellojpa.dto.UserDTO;
import vn.techmaster.hellojpa.entity.User;
import vn.techmaster.hellojpa.projection.UserProjection;
import vn.techmaster.hellojpa.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepoTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    void saveUser() {
        Faker faker = new Faker();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .password("11111")
                    .build();
            users.add(user);
        }
        userRepository.saveAll(users);
    }

    @Test
    void getAllUser() {
        List<User> users = userRepository.findAll();
        assertThat(users.size()).isEqualTo(30);
    }

    @Test
    void getUsersByName() {
        List<User> users = userRepository.findByName("Dr. Johnie Reichel");
        System.out.println(users);
        assertThat(users.size()).isEqualTo(1);
        assertThat(users.get(0).getId()).isEqualTo(2);
    }

    @Test
    void getUsersByNameStartingWith() {
        List<User> users = userRepository.findByNameStartsWith("M");
        System.out.println(users);
        System.out.println(users.size());
    }

    @Test
    void findByNameOrEmailContains() {
        List<User> users = userRepository.findByNameContainsOrEmailContains("Greg ","@yahoo.com");
        System.out.println(users);
        System.out.println(users.size());
    }

    @Test
    void countDistinctByEmailContains() {
        Integer count = userRepository.countDistinctByEmailContains("@yahoo.com");
        assertThat(count).isEqualTo(6);
    }

    @Test
    void getUserContainsNameOrEmail(){
        List<User> user = userRepository.getUserContainsNameOrEmail("johnie");
        System.out.println(user);
    }

    @Test
    void getUserByNameStartsWith(){
        List<User> user = userRepository.getUserByNameStartsWith("Emil");
        System.out.println(user);
        assertThat(user.get(0).getId()).isEqualTo(12);
    }

    @Test
    void getUserInfo(){
        User user = userRepository.getUserInfo(12);
        System.out.println(user);
        assertThat(user.getName()).isEqualTo("Emil Watsica");
    }

    @Test
    void getUserDTOUsingNativeQuery(){
        List<UserDTO> users = userRepository.getUserDTOUsingNativeQuery();
        System.out.println(users);
    }

    @Test
    void testFindUserProjectionByName(){
        List<UserProjection> users = userRepository.findUserProjectionByName("Emil Watsica");
        System.out.println(users.get(0));
      }

    @Test
    void getUserContainsNameOrEmailProjection(){
        List<UserDTO> user = userRepository.getUserDTOContainsNameOrEmail("johnie");
        System.out.println(user);
    }

    @Test
    void findAllwithPage(){
        Page<User> user = userRepository.findAll(PageRequest.of(0,7));
        Page<User> user1 = userRepository.findAll(PageRequest.of(1,7));

        List<User> user2 = userRepository.findAll();
        System.out.println(user.get().toList());
        System.out.println(user1.get().toList());
        System.out.println(user2);
    }

    @Test
    void findAllByOrderByEmail(){
        Page<User> user3 = userRepository.findAllByOrderByEmail(PageRequest.of(3,7));
        System.out.println(user3.get().toList());
    }

    @Test
    void findAllByPage(){
        // phan trang thuong
        Page<User> user = userRepository.findAll(PageRequest.of(3,7));

        // sap sep theo query method roi phan trang
        Page<User> user1 = userRepository.findAllByOrderByEmail(PageRequest.of(3,7));

        // phan trang bang page, sap xep bang Sort
        Page<User> user2 = userRepository.findAll(PageRequest.of(3,7,Sort.by("email")));
        System.out.println(user.get().toList());
        System.out.println(user1.get().toList());
        System.out.println(user2.get().toList());
    }



    @Test
    void page(){
        System.out.println(Arrays.toString(User.class.getDeclaredFields()));
    }


}