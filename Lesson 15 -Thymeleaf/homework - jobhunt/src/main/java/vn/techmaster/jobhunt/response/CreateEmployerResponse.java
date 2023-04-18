package vn.techmaster.jobhunt.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployerResponse {
    private int id;
    private String name;
    private String email;
    private String address;

}
