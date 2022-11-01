package App.Controller;


import App.Model.Users;
import App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    UserService us;
    @Autowired
    public UserController(UserService ps){
        this.us = ps;
    }

    /**
     * Used to get all users from the database
     * @return a list of all users currently in the database
     */
    @GetMapping("users")
    public List<Users> getAllUsers(){
        return us.getAllUsers();
    }


    /**
     * Used to get a user based on their id
     * @param id an integer that represents a user's id
     * @return the user that has said id
     */
    @GetMapping("/users/id/{id}")
    public Users getUserById(@PathVariable("id") int id) {
        Users user = us.getUserById(id);
        return user;
    }

    /**
     * Used to add a new user to the database
     * @param p represents the user that is to be added
     */
    @PostMapping("users")
    public void addUser(@RequestBody Users p) {
        us.addUser(p);
    }

    /**
     * Used to delete a user based on their id
     * @param id an integer that represents a user's id
     */
    @DeleteMapping("/users/delete/{id}")
    public void deleteUserById(@PathVariable("id") int id){
        us.deleteUserById(id);

    }

}
