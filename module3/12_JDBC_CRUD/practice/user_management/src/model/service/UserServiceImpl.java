package model.service;

import model.bean.User;
import model.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements IUserService {
    UserRepository userRepository = new UserRepository();

    @Override
    public void insertUser(User user) {
        userRepository.insertUser(user);
    }

    @Override
    public User selectUserById(int id) {
        return userRepository.selectUserById(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.selectAllUser();
    }

    @Override
    public boolean deleteUser(int id) {
        return userRepository.delete(id);
    }

    @Override
    public boolean updateUser(int id, User user) {
        return userRepository.update(id, user);
    }
}
