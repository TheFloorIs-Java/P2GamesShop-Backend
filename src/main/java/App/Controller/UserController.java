package App.Controller;


import App.Model.Users;
import App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    UserService us;
    @Autowired
    public UserController(UserService ps){
        this.us = ps;
    }

  /*  @GetMapping("/")
    public String sayHello(){
        return "User page currently in progress";
    } */


    @GetMapping("users")
    public List<Users> getAllUsers(){
        return us.getAllUsers();
    }


    @GetMapping("/users/id/{id}")
    public Users getUserById(@PathVariable("id") int id) {
        Users user = us.getUserById(id);
        return user;
    }
    @PostMapping("users")
    public void addUser(@RequestBody Users p) {
        us.addUser(p);
    }
}
