package App.Controller;


import App.Model.Users;
import App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@CrossOrigin
=======
>>>>>>> origin/transactions-backend-2
public class UserController {

    UserService us;
    @Autowired
    public UserController(UserService ps){
        this.us = ps;
    }

<<<<<<< HEAD
=======
  /*  @GetMapping("/")
    public String sayHello(){
        return "User page currently in progress";
    } */
>>>>>>> origin/transactions-backend-2


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
<<<<<<< HEAD

    @DeleteMapping("/users/delete/{id}")
    public void deleteUserById(@PathVariable("id") int id){
        us.deleteUserById(id);

    }
=======
>>>>>>> origin/transactions-backend-2
}
