package vn.techmaster.usermanagement.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.usermanagement.dto.CreateUserRequest;
import vn.techmaster.usermanagement.dto.UpdateUserPasswordRequest;
import vn.techmaster.usermanagement.dto.UpdateUserRequest;
import vn.techmaster.usermanagement.dto.UserDTO;
import vn.techmaster.usermanagement.entity.User;
import vn.techmaster.usermanagement.exception.NotFoundException;
import vn.techmaster.usermanagement.exception.UserHandleException;
import vn.techmaster.usermanagement.mapper.UserMapper;
import vn.techmaster.usermanagement.model.FileResponse;
import vn.techmaster.usermanagement.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    public List<UserDTO> getAllUsers() {
        return userRepo.findAll().stream().map(UserMapper::toUserDTO).toList();
    }

    @Override
    public List<UserDTO> getUserByNameContain(String name) {
        return userRepo.findByNameContains(name).stream().map(UserMapper::toUserDTO).toList();
    }


    public UserDTO getUserById(int id) {
        Optional<User> user2Find = userRepo.findById(id);
        if (user2Find.isEmpty()) {
            throw new NotFoundException("User " + id + "is not found");
        }
        return UserMapper.toUserDTO(user2Find.get());

    }

    public UserDTO createUser(CreateUserRequest userRequest) {
        for (User user : userRepo.findAll()) {
            if (user.getEmail().equals(userRequest.email())) {
                throw new UserHandleException("Email da ton tai!");
            }
        }
        User user2Save = User.builder().withName(userRequest.name())
                .withEmail(userRequest.email())
                .withPhone(userRequest.phone())
                .withAvatar(userRequest.avatar())
                .withAddress(userRequest.address())
                .withPassword(BCrypt.hashpw(userRequest.password(), BCrypt.gensalt(12))).build();
        userRepo.save(user2Save);
        return UserMapper.toUserDTO(user2Save);
    }

    @Override
    public UserDTO updateUser(int id, UpdateUserRequest userRequest) {
        Optional<User> userById = userRepo.findById(id);
        if (userById.isEmpty()) {
            throw new NotFoundException("User " + id + "is not found");
        }

        User user2Find = userById.get();
        user2Find.setName(userRequest.name());
        user2Find.setEmail(userRequest.email());
        user2Find.setPhone(userRequest.phone());
        user2Find.setAddress(userRequest.address());

        return UserMapper.toUserDTO(user2Find);
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDTO updateUserPassWord(int id, UpdateUserPasswordRequest req) {
        Optional<User> userById = userRepo.findById(id);
        if (userById.isEmpty()) {
            throw new NotFoundException("User " + id + "is not found");
        }
        User user2Find = userById.get();

        
        // Encrypted password string is random for each time generating
        /*if (!req.oldPassword().equals(BCrypt.hashpw(user2Find.getPassword(), BCrypt.gensalt(12)))) {
            throw new UserHandleException("Password not match");
        }*/
        // Check if old password is right
        if (!BCrypt.checkpw(req.oldPassword(), user2Find.getPassword())) {
            throw new UserHandleException("Password not match");
        }
        user2Find.setPassword(BCrypt.hashpw(req.newPassword(), BCrypt.gensalt(12)));
        return UserMapper.toUserDTO(user2Find);
    }

    @Override
    public FileResponse updateUserAvatar(int id, MultipartFile file) {
        return null;
    }
}
