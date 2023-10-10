package cn.lay.service;

import cn.lay.pojo.Athlete;
import cn.lay.pojo.Entry;
import cn.lay.pojo.Match;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface EntryService {
    JSONObject findAllEntry(int page, int limit, Entry entry);
    //删除信息
    JSONObject deleteBySno(String sno);
    //修改
    JSONObject updateBySno(Entry entry);
    //添加
    JSONObject addEntry(Entry entry);
    //分页查询
    JSONObject findTplPage(Entry entry);
    JSONObject selectMatch(Match match);
    JSONObject findMatch(Entry entry);

}
