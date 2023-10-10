package cn.lay.service.Impl;

import cn.lay.mapper.EntryMapper;
import cn.lay.pojo.Athlete;
import cn.lay.pojo.Entry;
import cn.lay.pojo.Match;
import cn.lay.service.EntryService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.security.DenyAll;
import java.util.ArrayList;
import java.util.List;
@Service
public class EntryServiceImpl implements EntryService {
    @Resource
    private EntryMapper entryMapper;

    @Override
    public JSONObject findAllEntry(int page, int limit, Entry entry) {
        JSONObject result=new JSONObject();
        //接收数据
        try {
            PageHelper.startPage(page,limit);
            List<Entry> list = entryMapper.findAllEntry(entry);
            PageInfo<Entry> pageInfo=new PageInfo<>(list);
            result.put("code","0"); //设置状态码
            result.put("msg","success"); //设置信息
            result.put("data",pageInfo.getList()); //获取数据集合
            result.put("count",pageInfo.getTotal()); //获取分页总数
        } catch (Exception e) {
            result.put("code","500");
            result.put("msg","查询异常！");
            System.out.print("查找全部数据");
        }
        return result;
    }

    @Override
    public JSONObject deleteBySno(String sno) {
        JSONObject result = new JSONObject();
        try {
            entryMapper.deleteBySno(sno);
            result.put("code", 0);
            result.put("msg", "删除成功,编号为" + sno);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "异常,删除失败！");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public JSONObject updateBySno(Entry entry) {
        JSONObject result = new JSONObject();
        try {
            entryMapper.updateBySno(entry);
            result.put("code", 0);
            result.put("msg", "修改,学号为" + entry.getSno());
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "异常,修改失败！");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public JSONObject addEntry(Entry entry) {
        JSONObject result = new JSONObject();
        try {
            entryMapper.addEntry(entry);
            result.put("code", 0);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "异常,添加失败！");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public JSONObject findTplPage(Entry entry) {
        JSONObject result = new JSONObject();
        //接收数据
        try {
            List<Entry> list = entryMapper.findAllEntry(entry);
            result.put("code", "0"); //设置状态码
            result.put("msg", "操作成功"); //设置信息
            result.put("data", JSON.toJSON(list)); //获取数据集合

        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "查询异常！");
        }
        return result;
    }

    @Override
    public JSONObject selectMatch(Match match) {
        JSONObject result = new JSONObject();
        //接收数据
        try {
            List<Match> list = entryMapper.selectMatch(match);
            PageInfo<Match> pageInfo = new PageInfo<>(list);
            result.put("code", "0"); //设置状态码
            result.put("msg", "success"); //设置信息
            result.put("data", pageInfo.getList()); //获取数据集合
        } catch (Exception e) {

            result.put("code", "500");
            result.put("msg", "查询异常！");
            System.out.print("查找全部数据");
        }
        return result;
    }

    @Override
    public JSONObject findMatch(Entry entry) {
        JSONObject result = new JSONObject();
        try {
            List<Entry> list = entryMapper.findAllEntry(entry);
            result.put("code", "0"); //设置状态码
            result.put("msg", "success"); //设置信息
            result.put("data",list);
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "查询异常！");
            System.out.print("查找全部数据");
        }
        return result;
    }
}
