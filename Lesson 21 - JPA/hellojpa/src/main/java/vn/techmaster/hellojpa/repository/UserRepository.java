package vn.techmaster.hellojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.hellojpa.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);

    //Tìm các user theo tên
    List<User> findByName(String name);

    // Đếm số user theo tên
    Integer countByName(String name);

    // Kiểm tra xem email có tồn tại hay k
    Boolean existsByEmail(String email);

    //Tìm user theo tên và order theo email
    List<User> findByNameOrderByEmail(String name);

    //Tìm các user theo tên bắt đầu bằng chuôi
    List<User> findByNameStartsWith(String name);

    //Tìm các user theo tên mà chứa 1 chuỗi không phân biệt hoa thường
    List<User> findByNameContainingIgnoreCase(String string);

    //tìm user theo tên hoặc email chứa chuỗi được truyền vào
    List<User> findByNameOrEmailContaining(String string);

    //- Đếm số email không trùng mà chứa 1 chuỗi được truyền vào
    Integer countDistinctByEmailContaining(String string);

    //Tìm top 10 user theo tên
    List<User> findFirst10ByNameStartsWith(String string);



}



