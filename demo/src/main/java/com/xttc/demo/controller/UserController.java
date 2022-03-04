package com.xttc.demo.controller;

import com.xttc.demo.common.Const;
import com.xttc.demo.pojo.UserInfo;
import com.xttc.demo.service.IUserService;
import com.xttc.demo.service.impl.UserService;
import com.xttc.demo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/protal/")
public class UserController {
    @Autowired
   IUserService userService;


    @RequestMapping(value = "user/login.do")
    public ServerResponse login(String username, String password, HttpSession session){
        ServerResponse serverResponse= userService.loginLogic(username,password);
        if(serverResponse.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,serverResponse.getData());
        }
        return serverResponse;
   }
@RequestMapping("user/register.do")
   public ServerResponse register(UserInfo userInfo){
       return userService.registerLogin(userInfo);

   }

}
