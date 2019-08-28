package com.project.service;


import com.project.dao.UserDao;
import com.project.entity.User;

/**
 * @author zhuof
 * @company
 * @date 2019/8/23 14:37
 * @description
 */
public class LoginService {

    UserDao dao=new UserDao();
    public  int login(String username,String password){
        int flag=3;
        User user=dao.findUser(username,password);
        if (user!=null){
            String status=user.getStatus();
            if (status.equals("0")){
                flag=0;
            }else  if (status.equals("1")){
                flag=1;
            }
            else if (status.equals("2")){
                flag=2;
            }
        }
        return flag;
    }
}
