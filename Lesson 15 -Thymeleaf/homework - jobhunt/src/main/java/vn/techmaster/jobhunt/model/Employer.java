package vn.techmaster.jobhunt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class Employer {
    private int id;
    private String name;
    private String email;
    private String address;

}
