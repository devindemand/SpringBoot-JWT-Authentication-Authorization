package com.learning.springboot.devrestapi.controller;

import com.learning.springboot.devrestapi.aop.UserTokenRequired;
import com.learning.springboot.devrestapi.model.User;
import com.learning.springboot.devrestapi.service.UserService;
import com.learning.springboot.devrestapi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    @Autowired
    UserService userService;

    @SuppressWarnings("unchecked")
    @ResponseBody
    @UserTokenRequired // this is an annotation to valid the user token
    @RequestMapping(value = "", method = RequestMethod.POST)
    public <T> T addTicket(@RequestParam(value = "content") String content, HttpServletRequest request) {
        User user = userService.getUserByToken(request.getHeader("token"));
        System.out.println("User came back in 15 mins and so I've authorized him with the old token that he had , his subject has been verified");
        //ticketSevice.addTicket(user.getUserid(), content, 2, 1);
        return Util.getSuccessResult();
    }
}
