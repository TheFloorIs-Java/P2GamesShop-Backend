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

    /**
     * Used to get all users from the database
     * @return a list of all users from the database
     */
    public List<Users> getAllUsers() {

        return ur.findAll();
    }

    /**
     * Used to get a specific user based on their id
     * @param id an integer that represents a user's id
     * @return the user that has the requested id
     */
    public Users getUserById(int id){
        return ur.findById(id).get();
    }

    /**
     * Used to add a new user to the database
     * @param p represents the new user that is to be added
     * @return the save function that will save the new user to the database
     */
    public Users addUser(Users p){
        return ur.save(p);
    }

    /**
     * Used to delete a specific user based on their id
     * @param id an integer that represents a user's id
     */
    public void deleteUserById(int id) {
        ur.deleteById(id);
    }

}
