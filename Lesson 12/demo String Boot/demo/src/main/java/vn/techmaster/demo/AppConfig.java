package vn.techmaster.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.demo.other_package2.Dress;

@Configuration
public class AppConfig {
    /* Nếu method được đánh dấu bởi @Bean có tham số truyền vào,
    thì Spring Boot sẽ tự inject các Bean đã có trong Context vào làm tham số.
     */
//    @Bean("girlFriend")
//    GirlFriend girlFriendConfig(Dress dress){
//        return new GirlFriend(dress);
//    }
////
//    @Bean("dress")
//    Dress dressConfig(){
//        return new Dress(20);
//    }
}
