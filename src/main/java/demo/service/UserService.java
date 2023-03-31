package demo.service;

import demo.domain.User;
import demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Repository
public class UserService {
    private final UserMapper userMapper;

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    public void delete() {
        userMapper.delete();
    }

    public User login(User user) {
        return userMapper.login(user);
    }
}
