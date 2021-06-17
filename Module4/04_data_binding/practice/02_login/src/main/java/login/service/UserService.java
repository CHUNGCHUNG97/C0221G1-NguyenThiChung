package login.service;

import login.model.Login;
import login.model.User;



public interface UserService {
    User checkLogin(Login login);
}
