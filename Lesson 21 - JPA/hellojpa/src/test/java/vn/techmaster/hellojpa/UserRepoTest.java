package vn.techmaster.hellojpa;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import vn.techmaster.hellojpa.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
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
        List<User> users = userRepository.findByName("Ma Dibbert MD");
    }

    @Test
    void getUsersByNameStartingWith() {
        List<User> users = userRepository.findByNameStartsWith("M");
        System.out.println(users);
        System.out.println(users.size());
    }
}