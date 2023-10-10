package cn.lay.service.Impl;

import cn.lay.mapper.UserMapper;
import cn.lay.pojo.User;
import cn.lay.req.PictureReq;
import cn.lay.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public JSONObject setPicture(PictureReq pictureReq) {
        JSONObject result=new JSONObject();
        try {
            userMapper.setPicture(pictureReq);
            result.put("code",0);
            result.put("msg","上传成功");
        } catch (Exception e) {
            result.put("code",500);
            result.put("msg","异常,上传失败！");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public JSONObject showPicture(PictureReq pictureReq) {
        JSONObject result=new JSONObject();
        try {
            List<PictureReq> list = userMapper.showPicture(pictureReq);
            System.out.print(list);
            result.put("image",list);
        } catch (Exception e) {
            result.put("code",500);
            result.put("msg","异常,上传失败！");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User login(User user) {
//        JSONObject result=new JSONObject();
//        try {
//            User userdata=
//            if (userdata !=null){
//                System.out.print(userdata.getUid());
//                result.put("msg","登录成功");
//                result.put("data",userdata);
//            }
//            else {
//                result.put("msg","密码或用户名错误");
//            }
//        } catch (Exception e) {
//            result.put("code",500);
//            result.put("msg","连接错误");
//            e.printStackTrace();
//        }
        return userMapper.login(user);
    }

    @Override
    public JSONObject register(User user) {
        JSONObject result=new JSONObject();
        try {
            userMapper.register(user);
            result.put("code",0);
            result.put("msg","注册成功请在登录页面登录");
        } catch (Exception e) {
            result.put("code",500);
            result.put("msg","用户名已存在");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void updatePassword(User user) {

        userMapper.updatePassword(user);
    }

    @Override
    public User findUserById(int uid) {
        return userMapper.findUserById(uid);
    }
}
