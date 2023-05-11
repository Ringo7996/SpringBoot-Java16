package vn.techmaster.shoppingcart.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import vn.techmaster.shoppingcart.entity.Course;
@Data
@Getter
@Setter
@Builder(toBuilder = true,setterPrefix = "with")
public class CartItemDto {
    private Integer id;
    private Course course;
    private Integer count;
}
