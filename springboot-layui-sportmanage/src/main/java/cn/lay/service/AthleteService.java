package cn.lay.service;

import cn.lay.pojo.Athlete;
import com.alibaba.fastjson.JSONObject;

public interface AthleteService {
    //查询全部信息 格式为JSON
    //使用mybatis插件进行分页
    JSONObject findAll(int page, int limit,Athlete athlete);
    //删除信息
    JSONObject deleteBySno(String sno);
    //修改
    JSONObject updateBySno(Athlete athlete);
    //添加
    JSONObject add(Athlete athlete);
    //分页查询
    JSONObject findTplPage(Athlete athlete);
}
