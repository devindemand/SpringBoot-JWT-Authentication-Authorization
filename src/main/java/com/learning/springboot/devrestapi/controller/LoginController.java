package com.learning.springboot.devrestapi.controller;

import com.learning.springboot.devrestapi.model.User;
import com.learning.springboot.devrestapi.service.SecurityService;
import com.learning.springboot.devrestapi.service.UserService;
import com.learning.springboot.devrestapi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @ResponseBody
    @RequestMapping(value="/user/customer", method = RequestMethod.POST)
    public Map<String, Object> registerCustomer(@RequestParam(value = "uname") String uname, @RequestParam(value = "password") String password) {
        userService.createUser(uname, password, 1);
        return Util.getSuccessResult();
    }

    @ResponseBody
    @RequestMapping(value = "/login/customer", method = RequestMethod.POST)
    public Map<String, Object> loginCustomer(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

        //this could be a traditional validation , user name password and load the complete user object based on the user name and password
        User user = userService.getUser(username, password, 1);
        if (user == null) {
            return Util.getUserNotAvailableError();
        }
        String subject = user.getUserid() + "=" + user.getUsertype();
        String token = securityService.createToken(subject, (15 * 1000 * 60)); // 15 minutes expiry time
        return Util.getSuccessResult(token);
    }
}
