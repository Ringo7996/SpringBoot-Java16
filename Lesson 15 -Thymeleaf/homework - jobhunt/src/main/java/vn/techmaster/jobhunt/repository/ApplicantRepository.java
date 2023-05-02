package vn.techmaster.jobhunt.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import vn.techmaster.jobhunt.model.Applicant;
import vn.techmaster.jobhunt.model.Employer;

import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
@Repository
public class ApplicantRepository {
    private ConcurrentHashMap<Integer, Applicant> applicants;
    private int size = 100;

    public ApplicantRepository() {
        ConcurrentHashMap<Integer, Applicant> applicants = new ConcurrentHashMap<>();
        applicants.put(1, new Applicant(1, "Linh", "linh@gmail.com", "HN"));
        applicants.put(2, new Applicant(2, "Anh","anh@gmail.com", "HCM"));
        applicants.put(3, new Applicant(3, "Vũ","vu@gmail.com", "HN"));
        applicants.put(4, new Applicant(4, "Tuấn","tuan@gmail.com", "HCM"));
        this.applicants = applicants;
    }

}
