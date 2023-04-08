package com.example.color;

import com.example.color.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ColorApplication {
	public static void main(String[] args) {
		SpringApplication.run(ColorApplication.class, args);
	}

}
