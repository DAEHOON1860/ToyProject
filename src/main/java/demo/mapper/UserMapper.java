package demo.mapper;

import demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getUserList();

    void insert(User user);

    void delete();

    User login(User user);
}
