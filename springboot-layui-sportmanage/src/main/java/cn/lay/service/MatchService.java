package cn.lay.service;
import cn.lay.pojo.Match;
import com.alibaba.fastjson.JSONObject;

public interface MatchService {
    JSONObject findAllMatch(int page, int limit, Match match);
    //删除信息
    JSONObject deleteByMno(int mno);
    //修改
    JSONObject updateByMno(Match match);
    //添加
    JSONObject addMatch(Match match);
    //分页查询
    JSONObject findTplPage(Match match);
}
