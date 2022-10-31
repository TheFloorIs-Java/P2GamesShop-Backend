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



    @GetMapping("users")
    public List<Users> getAllUsers(){
        return us.getAllUsers();
    }
    //Service call to get all users.


    @GetMapping("/users/id/{id}")
    public Users getUserById(@PathVariable("id") int id) {
        Users user = us.getUserById(id);
        return user;
    }
    //Service call to get a user based on the user ID passed in by the frontend.
    @PostMapping("users")
    public void addUser(@RequestBody Users p) {
        us.addUser(p);
    }
    //Service call to add a new user to the database with the information passed in by the frontend.

    @DeleteMapping("/users/delete/{id}")
    public void deleteUserById(@PathVariable("id") int id){
        us.deleteUserById(id);

    }
    //Service call to delete the user with the user ID passed in by the frontend.
}
