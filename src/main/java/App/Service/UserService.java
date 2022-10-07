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
    //Repository call to get all users.
    public Users getUserById(int id){
        return ur.findById(id).get();
    }
    //Repository call to get a user based on the user ID passed in by the frontend.

    public Users addUser(Users p){
        return ur.save(p);
    }
    //Repository call to add a user based on the information passed in by the frontend.

    public void deleteUserById(int id) {
        ur.deleteById(id);
    }
    //Repository call to delete a user based on the user ID passed in by the frontend.
}
