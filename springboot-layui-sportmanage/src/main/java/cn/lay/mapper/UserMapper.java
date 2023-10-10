package cn.lay.mapper;

import cn.lay.pojo.User;
import cn.lay.req.PictureReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    void setPicture(PictureReq picture);
    List<PictureReq> showPicture(PictureReq pictureReq);
    public User login(User user);
    void register(User user);
    void updatePassword(User user);
    User findUserById(@Param("uid") int uid);
}
