package App.Service;


import App.Model.Users;
import App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Users getUserById(int id) {
        return ur.findById(id).get();
    }
    public Users getUserByUsername(String username){
        return ur.findByName(); //placeholder
    }

    public Users addUser(Users p) {
        return ur.save(p);
    }

    public void deleteUserById(int id) {
        ur.deleteById(id);
    }
}
