package com.example.practice;

import com.example.practice.entity.Job;
import com.example.practice.entity.Location;
import com.example.practice.repository.JobRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JobControllerTest {

    @Autowired
    JobRepository jobRepository;

    @Test
    @Rollback(value = false)
    void addFakeData() {
        jobRepository.saveAll(Arrays.asList(
                Job.builder().withTitle("Giáo viên").withDescription("Giáo viên trường tiểu học").withEmailTo("email@gmail.com").withLocation(Location.HANOI.getValue()).withMinSalary(8000000).withMaxSalary(15000000).build(),
                Job.builder().withTitle("Kế toán").withDescription("Kế toán hành chính").withEmailTo("email1@gmail.com").withLocation(Location.HAIPHONG.getValue()).withMinSalary(12000000).withMaxSalary(18000000).build(),
                Job.builder().withTitle("Đầu bếp").withDescription("Đầu bếp nhà hàng").withEmailTo("email2@gmail.com").withLocation(Location.HOCHIMINH.getValue()).withMinSalary(13000000).withMaxSalary(17000000).build(),
                Job.builder().withTitle("Nhân viên").withDescription("Nhân viên thời vụ nhà hàng ").withEmailTo("email3@gmail.com").withLocation(Location.DANANG.getValue()).withMinSalary(4000000).withMaxSalary(8000000).build(),
                Job.builder().withTitle("Phiên dịch viên").withDescription("Phiên dịch tiếng Anh").withEmailTo("email4@gmail.com").withLocation(Location.HANOI.getValue()).withMinSalary(8000000).withMaxSalary(15000000).build(),
                Job.builder().withTitle("Bảo vệ").withDescription("Bảo vệ trường tiểu học").withEmailTo("email5@gmail.com").withLocation(Location.HAIPHONG.getValue()).withMinSalary(6000000).withMaxSalary(8000000).build(),
                Job.builder().withTitle("Kỹ sư").withDescription("Kỹ sư điện máy").withEmailTo("email6@gmail.com").withLocation(Location.HANOI.getValue()).withMinSalary(15000000).withMaxSalary(25000000).build(),
                Job.builder().withTitle("Lập trình viên").withDescription("Lập trình java").withEmailTo("email7@gmail.com").withLocation(Location.DANANG.getValue()).withMinSalary(8000000).withMaxSalary(25000000).build(),
                Job.builder().withTitle("Giáo viên").withDescription("Giáo viên trường cấp ba").withEmailTo("email8@gmail.com").withLocation(Location.HOCHIMINH.getValue()).withMinSalary(12000000).withMaxSalary(15000000).build(),
                Job.builder().withTitle("Giáo viên").withDescription("Giáo viên ielts").withEmailTo("email9@gmail.com").withLocation(Location.HOCHIMINH.getValue()).withMinSalary(12000000).withMaxSalary(18000000).build()
        ));
    }

    @Test
    public void testEnum(){
        System.out.println(Location.HANOI.getValue());
    }

    @Test
    public void test() {
        List<Job> a = jobRepository.findAllByOrderByLocation();
        List<Job> b = jobRepository.findBySalaryRange(14000000);
        List<Job> c = jobRepository.findByTitleContainsOrDescriptionContains("nhà hàng", "nhà hàng");
        List<Job> d = jobRepository.findByLocationAndKeyword("Tp. Hồ Chí Minh", "giáo viên");


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

}
