package vn.techmaster.shoppingcart.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Setter
@Getter
@Builder(toBuilder = true,setterPrefix = "with")
public class User {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
}
