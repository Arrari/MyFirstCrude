package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
        userService.persistUser(new User("testfirstname", "testlastname1", "tes2t@mail.com", "testUserName1"));
        userService.persistUser(new User("testfirstname1", "testlastname2", "test@mail.com", "testUserName2"));
        userService.persistUser(new User("testfirstname2", "testlastname3", "test1@mail.com", "testUserName3"));
        userService.persistUser(new User("testfirstname3", "testlastname4", "te3st@mail.com", "testUserName4"));
    }

    @GetMapping(value = {"", "/index", "/home", "/"})
    public String showAll(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "users/index";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/show";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }


    @GetMapping(value = {"/new", "/newUser"})
    public String createNewBlankUser(Model model) {
        model.addAttribute("user", new User());
        return "users/newUser";
    }

    @PostMapping()
    public String persistCreatedUser(@ModelAttribute("user") User user) {
        userService.persistUser(user);
        return "redirect:/users";
    }
}