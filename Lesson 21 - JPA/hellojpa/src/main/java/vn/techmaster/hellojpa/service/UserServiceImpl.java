package vn.techmaster.hellojpa.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.techmaster.hellojpa.dto.UserDTO;
import vn.techmaster.hellojpa.entity.User;
import vn.techmaster.hellojpa.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackOn = {RuntimeException.class})
    public void testTransaction() {
        User user1 = new User();
        user1.setEmail("mongmo@gmail.com");
        user1.setName("Nguyễn Thị Mộng Mơ");
        user1.setPassword("123456789");


        // User không hợp lệ
        User user2 = new User();
        user2.setEmail("kurtis.torphy@yahoo.com");
        user2.setName("Phan Thị Lung Linh");
        user2.setPassword("abc123");

        userRepository.save(user1);
        userRepository.save(user2);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDTO> getUserByPageAndSort(Integer pageSize, Integer currentPage, String sortBy) {
        String[] sortCondition = sortBy.split(",");
        String sortByField = sortCondition[0];
        String sortByAscOrDesc = sortCondition[1];

        Sort sort;

        if (sortByAscOrDesc.equals("desc")) {
            sort = Sort.by(sortByField).descending();
        } else if (sortByAscOrDesc.equals("asc")) {
            sort = Sort.by(sortByField).ascending();
        } else {
            sort = Sort.by(sortByField).ascending();
        }

//        Page<User> page = userRepository.findAll(PageRequest.of(pageSize,currentPage,sort));
//        List<User> usersList = page.getContent();

        List<UserDTO> userDTOList = userRepository.getUserDTOWithPage(PageRequest.of(pageSize, currentPage, sort));

        return userDTOList;
    }

    @Override
    public List<UserDTO> getUserByPageAndSortPageable(Pageable pageable) {
        List<UserDTO> userDTOList = userRepository.getUserDTOWithPage(pageable);
        return userDTOList;
    }

    @Override
    public List<UserDTO> filterByNameAndEmailContains(String nameOrEmail, Pageable pageable) {

        List<UserDTO> userDTOList = userRepository.findByNameContainsAndEmailContains(nameOrEmail,pageable);
        return userDTOList;
    }


}
