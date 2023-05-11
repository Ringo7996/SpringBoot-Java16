package vn.techmaster.shoppingcart.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
@Getter
@Setter
@Builder(toBuilder = true,setterPrefix = "with")
public class Course {

    private Integer id;
    private String name;
    private String description;
    private String type;
    private List<Category> categories;
    private String thumbnail;
    private Integer price;
    private Double rating;
    private Integer userId;
}
