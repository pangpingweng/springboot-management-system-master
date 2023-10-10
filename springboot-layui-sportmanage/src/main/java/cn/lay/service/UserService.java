package cn.lay.service;

import cn.lay.pojo.User;
import cn.lay.req.PictureReq;
import com.alibaba.fastjson.JSONObject;

public interface UserService {
    JSONObject setPicture(PictureReq pictureReq);

    JSONObject showPicture(PictureReq pictureReq);

    User login(User user);

    JSONObject register(User user);

    void updatePassword(User user);

    User findUserById(int uid);
//    JSONObject showPicture(PictureReq pictureReq);
}
