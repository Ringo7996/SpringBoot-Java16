package vn.techmaster.demo.other_package;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import vn.techmaster.demo.Outfit;

@Primary
@Component("Bikini1")
public class Bikini implements Outfit {
    @Override
    public void wear() {
        System.out.println("Đang mặc bikini");
    }
}
