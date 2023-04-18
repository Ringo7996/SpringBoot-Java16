package vn.techmaster.jobhunt.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import vn.techmaster.jobhunt.model.Employer;

import java.util.concurrent.ConcurrentHashMap;


@Getter
@Setter
@Repository
public class EmployerRepository {
    private ConcurrentHashMap<Integer, Employer> employers;
    private int size = 100;

    public EmployerRepository() {
        ConcurrentHashMap<Integer, Employer> employers = new ConcurrentHashMap<>();
        employers.put(1, new Employer(1, "Samsung", "samsung@gmail.com", "HN"));
        employers.put(2, new Employer(2, "Viettel","viettel@gmail.com", "HCM"));
        employers.put(3, new Employer(3, "Vin Group","vin@gmail.com", "HN"));
        employers.put(4, new Employer(4, "Golden Gate","golden@gmail.com", "HCM"));
        this.employers = employers;
    }

}
