package vn.techmaster.jobhunt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@AllArgsConstructor
public class Applicant {
    private int id;
    private String name;
    private String email;
    private String address;
}
