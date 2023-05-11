package vn.techmaster.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.techmaster.shoppingcart.repository.CourseDB;

@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShoppingCartApplication.class, args);
	}

}
