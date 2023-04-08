package vn.techmaster.demo.other_package2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vn.techmaster.demo.Outfit;

@Component
public class Dress implements Outfit {
    @Override
    public void wear() {
        System.out.println("Đang mặc váy");
    }
}

