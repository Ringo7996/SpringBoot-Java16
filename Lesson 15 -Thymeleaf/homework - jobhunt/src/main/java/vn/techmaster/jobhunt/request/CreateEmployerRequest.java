package vn.techmaster.jobhunt.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployerRequest {
    private int id;
    private String name;
    private String email;
    private String address;

}

