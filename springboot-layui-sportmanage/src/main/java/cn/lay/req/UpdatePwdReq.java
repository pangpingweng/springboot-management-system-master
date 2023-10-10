package cn.lay.req;

import lombok.Data;

@Data
public class UpdatePwdReq {
    private int uid;
    private String oldPassword;
    private String newPassword;


    }
