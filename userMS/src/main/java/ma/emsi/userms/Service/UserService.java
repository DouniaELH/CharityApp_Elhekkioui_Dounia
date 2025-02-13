package ma.emsi.userms.Service;


import ma.emsi.userms.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllUsers();
    public User createUser(User user);
    public User updateUser(User user);
    public void deleteUser(Long id);
    public  User findUserById(Long id);
}
