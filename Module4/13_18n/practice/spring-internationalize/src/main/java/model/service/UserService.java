package model.service;

import model.entity.Login;
import model.entity.User;


public interface UserService {
    User checkLogin(Login login);
}
