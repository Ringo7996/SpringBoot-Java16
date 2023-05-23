package vn.techmaster.hellojpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.techmaster.hellojpa.dto.UserDTO;
import vn.techmaster.hellojpa.entity.User;
import vn.techmaster.hellojpa.projection.UserProjection;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
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

    //    tìm user theo tên hoặc email chứa chuỗi được truyền vào
    List<User> findByNameContainsOrEmailContains(String name, String email);

    //- Đếm số email không trùng mà chứa 1 chuỗi được truyền vào
    Integer countDistinctByEmailContains(String string);

    //Tìm top 10 user theo tên
    List<User> findFirst10ByNameStartsWith(String string);


    //tìm user theo tên hoặc email chứa chuỗi được truyền vào dạng native query
    @Query(value = "select * from users u where u.name like %:nameOrEmail% OR u.email like %:nameOrEmail%", nativeQuery = true)
    List<User> getUserContainsNameOrEmail(@Param("nameOrEmail") String nameOrEmail);

    //Tìm các user theo tên bắt đầu bằng chuôi dạng query JPQL
    @Query("select u from User u where u.name like %?1%")
    List<User> getUserByNameStartsWith(String name);

    @Query(nativeQuery = true, name = "getUserInfo")
    User getUserInfo(int id);

    // cách 1 projection
    // step 3: gọi câu query đã được khai báo tên trong entity
    @Query(nativeQuery = true, name = "getUserDTOUsingNativeQuery")
    List<UserDTO> getUserDTOUsingNativeQuery();


    List<UserProjection> findUserProjectionByName(String name);

    // cách 2 projection
    @Query(value = "select new vn.techmaster.hellojpa.dto.UserDTO(u.id, u.name, u.email) from User u where u.name like %:nameOrEmail% OR u.email like %:nameOrEmail%")
    List<UserDTO> getUserDTOContainsNameOrEmail(@Param("nameOrEmail") String nameOrEmail);


    List<User> findAllByNameLike(String name, Pageable pageable);

    // Kết quả trả về thông tin trang
    Page<User> findAllByOrderByEmail(Pageable pageable);

    Page<User> findAll(Pageable pageable);



    @Query(value = "select new vn.techmaster.hellojpa.dto.UserDTO(u.id, u.name, u.email) from User u")
    List<UserDTO> getUserDTOWithPage(Pageable pageable);


    @Query(value = "select new vn.techmaster.hellojpa.dto.UserDTO(u.id, u.name, u.email) from User u where u.name like %?1% or u.email like %?1%")
    List<UserDTO> findByNameContainsAndEmailContains(String nameOrEmail, Pageable pageable);
}



