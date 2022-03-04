package com.xttc.demo.service;

import com.xttc.demo.pojo.UserInfo;
import com.xttc.demo.utils.ServerResponse;

public interface IUserService {
//  登录
    public ServerResponse loginLogic(String username,String password);
//    注册
    public ServerResponse registerLogin(UserInfo userInfo);

}
