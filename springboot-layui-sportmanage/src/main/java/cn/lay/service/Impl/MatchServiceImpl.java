package cn.lay.service.Impl;
import cn.lay.mapper.MatchMapper;
import cn.lay.pojo.Match;
import cn.lay.service.MatchService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    @Resource
    private MatchMapper matchMapper;

    @Override
    public JSONObject findAllMatch(int page, int limit, Match match) {
        JSONObject result=new JSONObject();
        //接收数据
        try {
            PageHelper.startPage(page,limit);
            List<Match> list = matchMapper.findAllMatch(match);

            PageInfo<Match> pageInfo=new PageInfo<>(list);
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
    public JSONObject deleteByMno(int mno) {
        JSONObject result=new JSONObject();
        try {
            matchMapper.deleteByMno(mno);
            result.put("code",0);
            result.put("msg","删除成功,编号为"+mno);
        } catch (Exception e) {
            result.put("code",500);
            result.put("msg","异常,删除失败！");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public JSONObject updateByMno(Match match) {
        JSONObject result=new JSONObject();
        try {
            matchMapper.updateByMno(match);
            result.put("code",0);
            result.put("msg","修改,编号为"+match.getMno());
        } catch (Exception e) {
            result.put("code",500);
            result.put("msg","异常,修改失败！");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public JSONObject addMatch(Match match) {
        JSONObject result=new JSONObject();
        try {
            matchMapper.addMatch(match);
            result.put("code",0);
            result.put("msg","添加成功");
        } catch (Exception e) {
            result.put("code",500);
            result.put("msg","异常,添加失败！");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public JSONObject findTplPage(Match match) {
        JSONObject result=new JSONObject();
        //接收数据
        try {
            List<Match> list=matchMapper.findAllMatch(match);
            result.put("code","0"); //设置状态码
            result.put("msg","操作成功"); //设置信息
            result.put("data", JSON.toJSON(list)); //获取数据集合

        } catch (Exception e) {
            result.put("code","500");
            result.put("msg","查询异常！");
        }
        return result;
    }
    }
