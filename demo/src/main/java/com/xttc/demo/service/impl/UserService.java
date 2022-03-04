package com.xttc.demo.service.impl;

import com.xttc.demo.common.Const;
import com.xttc.demo.common.ResponCode;
import com.xttc.demo.dao.UserInfoMapper;
import com.xttc.demo.pojo.UserInfo;
import com.xttc.demo.service.IUserService;
import com.xttc.demo.utils.MD5Utils;
import com.xttc.demo.utils.ServerResponse;

import com.xttc.demo.vo.UserInfoVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    /*
    *  登录================
    *
    * */
      @Autowired
    UserInfoMapper userInfoMapper;


    @Override
    public ServerResponse loginLogic(String username, String password) {
//        step:1 用户名和密码的非空判断
          if(StringUtils.isBlank(username)){
              return ServerResponse.createServerResponseByFail(ResponCode.USERNAME_NOT_EMPTY.getCode(),ResponCode.USERNAME_NOT_EMPTY.getMsg());
          }
        if(StringUtils.isBlank(password)){
            return ServerResponse.createServerResponseByFail(ResponCode.PASSWORD_NOT_EMPTY.getCode(),ResponCode.PASSWORD_NOT_EMPTY.getMsg());
        }


//        step：2 查看用户名是否存在
       int count=userInfoMapper.findByUsername(username);
          if(count==0){
//              用户名不存在
              return ServerResponse.createServerResponseByFail(ResponCode.USERNAME_NOT_EXISTS.getCode(),ResponCode.USERNAME_NOT_EXISTS.getMsg());
          }


//        step：3根据用户名和密码查询


        UserInfo userInfo=userInfoMapper.findByUsernameAndPassword(username,MD5Utils.getMD5Code(password));
//        System.out.println(username+MD5Utils.getMD5Code(password));
          if(userInfo==null){
          return ServerResponse.createServerResponseByFail(ResponCode.PASSWORD_ERROR.getCode(),ResponCode.PASSWORD_ERROR.getMsg());
      }

          //        step:4 返回结果

        return ServerResponse.createServerResponseBySuccess(conver(userInfo));
    }

private UserInfoVo conver(UserInfo userInfo){
        UserInfoVo userInfoVo=new UserInfoVo();
        userInfoVo.setId(userInfo.getId());
        userInfoVo.setUsername(userInfo.getUsername());
        userInfoVo.setEmail(userInfo.getEmail());
        return userInfoVo;
}




/*
*  注册==============================
* */
    @Override
    public ServerResponse registerLogin(UserInfo userInfo) {


        if(userInfo==null){
            return ServerResponse.createServerResponseByFail(ResponCode.PARAM_NOT_EMPTY.getCode(),ResponCode.PARAM_NOT_EMPTY.getMsg());
        }

        String username=userInfo.getUsername();
        String password=userInfo.getPassword();
        String email=userInfo.getEmail();
        userInfo.setRoles(Const.CUSTOM_USER); //设置用户角色
//        参数非空判断
        if(StringUtils.isBlank(username)){
            return ServerResponse.createServerResponseByFail(ResponCode.USERNAME_NOT_EMPTY.getCode(),ResponCode.USERNAME_NOT_EMPTY.getMsg());
        }
        if(StringUtils.isBlank(password)){
            return ServerResponse.createServerResponseByFail(ResponCode.PASSWORD_NOT_EMPTY.getCode(),ResponCode.PASSWORD_NOT_EMPTY.getMsg());
        }
        if(StringUtils.isBlank(email)){
            return ServerResponse.createServerResponseByFail(ResponCode.EMAIL_NOT_EMPTY.getCode(),ResponCode.EMAIL_NOT_EMPTY.getMsg());
        }

//  判断用户名是否存在
        int username_count=userInfoMapper.findByUsername(username);
        System.out.println(username);
        if(username_count>0)// 用户名存在
        {
            return ServerResponse.createServerResponseByFail(ResponCode.USERNAME_IS_EXISTS.getCode(),ResponCode.USERNAME_IS_EXISTS.getMsg());

        }
//  判断邮箱是否存在

        int email_count=userInfoMapper.findByEmail(email);
        if(email_count>0){
            return ServerResponse.createServerResponseByFail(ResponCode.EMAIL_IS_EXISTS.getCode(),ResponCode.EMAIL_IS_EXISTS.getMsg());
        }
// 注册 密码加密
        userInfo.setPassword(MD5Utils.getMD5Code(userInfo.getPassword()));
        int result= userInfoMapper.insert(userInfo);
      if(result==0){
//          注册失败
          return ServerResponse.createServerResponseByFail(ResponCode.REGISTER_FAIL.getCode(),ResponCode.REGISTER_FAIL.getMsg());

      }
        return ServerResponse.createServerResponseBySuccess();
    }
}
