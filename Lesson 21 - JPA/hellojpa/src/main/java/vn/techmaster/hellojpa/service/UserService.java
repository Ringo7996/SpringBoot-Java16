package vn.techmaster.hellojpa.service;

import org.springframework.data.domain.Pageable;
import vn.techmaster.hellojpa.dto.UserDTO;
import vn.techmaster.hellojpa.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    void testTransaction();
    List<User> getAllUsers();


    List<UserDTO> getUserByPageAndSort(Integer pageSize, Integer currentPage, String sortBy);

    List<UserDTO> getUserByPageAndSortPageable(Pageable pageable);


    List<UserDTO> filterByNameAndEmailContains(String nameOrEmail, Pageable pageable);
}
