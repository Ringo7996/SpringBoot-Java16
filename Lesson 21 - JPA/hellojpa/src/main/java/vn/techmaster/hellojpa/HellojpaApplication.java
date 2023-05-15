package vn.techmaster.hellojpa;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.techmaster.hellojpa.demoCar.Car;
import vn.techmaster.hellojpa.demoCar.CarRepository;

import java.util.ArrayList;
import java.util.Optional;

@AllArgsConstructor
@SpringBootApplication
public class HellojpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HellojpaApplication.class, args);
	}

	private CarRepository carRepository;

	// Method run sẽ được tự động thực thi sau khi load context
	@Override
	public void run(String... args) throws Exception {
		Car car = new Car();
		car.setName("Ford Tourneo Titanium");
		ArrayList<String> images = new ArrayList<String>();
		images.add("img1.jpg");
		images.add("img2.jpg");
		car.setImages(images);
		Car.Engine engine = new Car.Engine(220, "2.0 ecoboots");
		car.setEngine(engine);

		carRepository.save(car);

		Optional<Car> getCar = carRepository.findById(1);
		System.out.println(getCar.get().toString());
	}
}
