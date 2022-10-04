package App.Service;


import App.Model.Users;
import App.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {
    UserRepository ur;
    @Autowired
    public UserService(UserRepository ur) {
        this.ur = ur;

    }

    public List<Users> getAllUsers() {

        return ur.findAll();
    }
    public Users getUserById(int id){
        return ur.findById(id).get();
    }

    public Users addUser(Users p){
        return ur.save(p);
    }
}
