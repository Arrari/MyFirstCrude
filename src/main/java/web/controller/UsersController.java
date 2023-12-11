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
        userService.saveUser(new User("testfirstname","testlastname1","tes2t@mail.com","testUserName1"));
        userService.saveUser(new User("testfirstname1","testlastname2","test@mail.com","testUserName2"));
        userService.saveUser(new User("testfirstname2","testlastname3","test1@mail.com","testUserName3"));
        userService.saveUser(new User("testfirstname3","testlastname4","te3st@mail.com","testUserName4"));

    }

    @GetMapping()
    public String showAll(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "users/index";
    }

    @GetMapping("/?id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user",userService.getUserById(id));
        return "users/show";
    }


    @GetMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/newUser";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    /*

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
    */
}
