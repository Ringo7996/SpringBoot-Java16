package vn.techmaster.shoppingcart.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@Builder(toBuilder = true,setterPrefix = "with")
public class Category {
    private Integer id;
    private String name;
}
