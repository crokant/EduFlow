package eduflow.services;

import eduflow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eduflow.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository UserRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.UserRepository = userRepository;
    }

    public User saveUser(User user) {
        return UserRepository.save(user);
    }

    public User getUser(long id) {
        return UserRepository.findById(id).orElseThrow();
    }

    public List<User> getUsers() {
        return UserRepository.findAll();
    }
}

