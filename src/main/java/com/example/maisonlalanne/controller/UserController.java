package com.example.maisonlalanne.controller;

import com.example.maisonlalanne.model.beans.UserBean;
import com.example.maisonlalanne.model.repository.UserRepository;
import com.example.maisonlalanne.services.BedroomService;
import com.example.maisonlalanne.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userrepository;

    @Autowired
    private HttpSession httpSession;


    //http://localhost:8080/user/alluser
    //Avoir tout les utilisateurs
    @GetMapping("/alluser")
    public List<UserBean> allUser() {
        System.out.println("/alluser");

        return userService.getAllUser();
    }


    //http://localhost:8080/user/user/1
    //trouver un utilisateur par son id
    @GetMapping("/{id}") //
    public UserBean getUserId(@PathVariable Long id) {
        System.out.println("/getUserId id=" + id);

        return userService.getById(id);
    }


    //http://localhost:8080/user/adduser
    //Ajouter un utilisateur
    @PostMapping("/adduser")
    public void addUser(@RequestBody UserBean userBean) throws Exception {
        System.out.println("/adduser");
//        UserBean userBean = new UserBean("de Zaltza", "Gavin","gavindezaltza@gmail.com", "azerty3");
        userrepository.save(userBean);
    }

    //http://localhost:8080/user/adduptadeuser
    //Ajouter un utilisateur
    @PostMapping("/adduptadeuser")
    public void addOrUpdateuser(@RequestBody UserBean userBean) throws Exception {
        System.out.println("/adduptadeuser");
//        UserBean userBean = new UserBean("de Zaltza", "Gavin","gavindezaltza@gmail.com", "azerty3");
        userService.addOrUpdateUser(userBean);
    }


    //http://localhost:8080/user/userconnect
    @PostMapping("/userconnect")
    public Object connect(@RequestBody UserBean userBean, HttpServletResponse response) {
        System.out.println("/userconnect");
        System.out.println("SessionID: " + httpSession.getId());
        try {
            UserBean user = userService.checkUserSession(userBean, httpSession);
            System.out.println("userIdsession: "+ user.getIdsession()+" infoUser: "+ user);
            System.out.println("userId: " + user.getId()+" userEmail: "+ user.getEmail()+" userPass: "+ user.getPassword());
            return user;

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(514);
            System.out.println("mauvais user");
        }
        return null;
    }


    //http://localhost:8080/user/login
    @GetMapping("/login")
    public String login(UserBean userBean) {
        System.out.println("/login");

        UserBean userRegister = userService.getUserByIdSession(httpSession.getId());
        System.out.println("httpsession.getid:  " + httpSession.getId());

        if (userRegister != null) {
            return httpSession.getId();
        }
        return null;
    }

    //http://localhost:8080/user/loginuser
    @PostMapping("/loginuser")
    public String loginuser(UserBean userBean, RedirectAttributes redirect) {
        System.out.println("/loginuser : email=" + userBean.getEmail() + " password=" + userBean.getPassword());

        try {
            //insert ou verif
          UserBean user =  userService.checkUserSession(userBean, httpSession);

            //Lance studentFormResult.html
         //  return user;
        } catch (Exception e) {
            e.printStackTrace();
            redirect.addFlashAttribute("errorMessage", e.getMessage());

            //redirectuion sur une url
//            return "redirect:/login";
        }
        return null;
    }

    //http://localhost:8080/user/userregister
    @GetMapping("/userregister")
    public String userregister(Model model) {
        System.out.println("/userregister");

        UserBean userConnected = userService.getUserByIdSession(httpSession.getId());
        if (userConnected == null) {
            return "redirect:/user/login";
        }
        model.addAttribute("userConnected", userConnected);
        model.addAttribute("userList", userService.getAllUser());

        //Lance studentForm.html
        return "/userregister";
    }
}
