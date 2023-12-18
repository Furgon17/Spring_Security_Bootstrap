package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import java.util.List;

//@RestController
@Controller
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUserList(Model model) {
        List<User> users = userService.getListUsers();
        model.addAttribute("users", users);
        return "admin";
    }
//    @GetMapping("/")
//    public List<User> getUserList(){
//        List<User> users = userService.getListUsers();
//        return users; //теперь вместо представления возвращаем список пользователей
//    }

    @GetMapping("/admin")
    public String createUserFrom(User user, Model model) {
        model.addAttribute("user", user);
        List<User> users = userService.getListUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @PostMapping("/admin")
    public String createUser(User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PostMapping ("/admin/{id}/delete")
    public String removeUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/edit")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("users", user);
        return "redirect:/admin";
    }

    @PostMapping("/admin/{id}/edit")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }
}