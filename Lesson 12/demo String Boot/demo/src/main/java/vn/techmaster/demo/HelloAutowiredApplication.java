package vn.techmaster.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import vn.techmaster.demo.other_package.Bikini;
import vn.techmaster.demo.other_package2.Dress;
@SpringBootApplication
public class HelloAutowiredApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloAutowiredApplication.class, args);

	}
}
