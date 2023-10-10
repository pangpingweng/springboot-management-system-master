package cn.lay.controller;
import cn.lay.pojo.User;
import cn.lay.req.PictureReq;
import cn.lay.req.UpdatePwdReq;
import cn.lay.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/setPicture",method = RequestMethod.POST)
    public JSONObject setPicture(@RequestBody PictureReq pictureReq){
        System.out.print(pictureReq);
        return userService.setPicture(pictureReq);
    }
    @RequestMapping(value = "/showPicture",method = RequestMethod.POST)
    public JSONObject showPicture(@RequestBody PictureReq pictureReq){
        System.out.print(pictureReq);
        return userService.showPicture(pictureReq);
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public User Login(@RequestBody User user,HttpSession session){
//        System.out.print(user);
        JSONObject result=new JSONObject();
        User userInfor =userService.login(user);
        if (userInfor != null) {
            result.put("data",userInfor);
            session.setAttribute("userInfor", userInfor);

            System.out.print("存取session");
        }
        else{
            result.put("msg","用户名不存在");
        }
        return userInfor;
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JSONObject register(@RequestBody User user){
        return userService.register(user);
    }
    @RequestMapping(value = "/updatePwd",method = RequestMethod.POST)
    public JSONObject selectOldPwd(@RequestBody UpdatePwdReq updatePwdReq){
        JSONObject result=new JSONObject();
        int id = updatePwdReq.getUid();
        User user = userService.findUserById(id);
        String oPassword = user.getPassword();
        String oldPassword = updatePwdReq.getOldPassword();
        String newPassword = updatePwdReq.getNewPassword();
        User user1 = new User();
        user1.setUid(id);
        user1.setPassword(newPassword);
        System.out.print(updatePwdReq);
        System.out.print("数据库里的旧密码："+oPassword);
        System.out.print("输入的旧密码："+oldPassword);
        if(!oldPassword.equals(oPassword)){
            result.put("msg","旧密码错误");
        }else {
            result.put("msg","修改成功");
            userService.updatePassword(user1);
        }
        return result;
    }

}
