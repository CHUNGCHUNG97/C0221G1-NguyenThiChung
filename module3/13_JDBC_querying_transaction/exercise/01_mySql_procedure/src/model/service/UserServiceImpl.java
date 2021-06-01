package model.service;

import model.bean.User;
import model.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements IUserService {
    UserRepository userRepository = new UserRepository();

    @Override
    public List<User> callAllUsers() {
        return userRepository.callAllUser();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public boolean updateUser(int id, User user) {
        return userRepository.update(id, user);
    }

    @Override
    public void insertUserStore(User user) {
        userRepository.insertUserStore(user);
    }

    @Override
    public User selectUserById(int id) {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return userRepository.deleteUserById(id);
    }

}
