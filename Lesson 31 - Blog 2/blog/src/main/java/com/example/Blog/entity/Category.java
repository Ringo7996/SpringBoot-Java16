package com.example.Blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;



//@SqlResultSetMappings(value={
//        @SqlResultSetMapping(
//                name = "categoryDTO",
//                classes = @ConstructorResult(
//                        targetClass = CategoryDto.class,
//                        columns = {
//                                @ColumnResult(name = "id",type = Integer.class),
//                                @ColumnResult(name = "name",type = String.class),
//                                @ColumnResult(name = "used",type = Long.class)
//                        }
//                )
//        )
//})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "categories")
    private List<Blog> blogs = new ArrayList<>();

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
