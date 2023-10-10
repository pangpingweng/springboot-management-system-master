package cn.lay.service.Impl;

import cn.lay.mapper.AthleteMapper;
import cn.lay.mapper.AthleteMapper;
import cn.lay.pojo.Athlete;
import cn.lay.service.AthleteService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AthleteServiceImpl implements AthleteService {
    @Resource
    private AthleteMapper athleteMapper;

    @Override
    public JSONObject findAll(int page, int limit,Athlete athlete) {
        JSONObject result=new JSONObject();
        //接收数据
        try {
            PageHelper.startPage(page,limit);
            List<Athlete> list = athleteMapper.findAll(athlete);
            PageInfo<Athlete> pageInfo=new PageInfo<>(list);
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
        /*使用JSON*/
        JSONObject result=new JSONObject();
        try {
            athleteMapper.deleteBySno(sno);
            result.put("code",0);
            result.put("msg","删除成功,编号为"+sno);
        } catch (Exception e) {
            result.put("code",500);
            result.put("msg","异常,删除失败！");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public JSONObject updateBySno(Athlete athlete) {
        JSONObject result=new JSONObject();
        try {
            athleteMapper.updateBySno(athlete);
            result.put("code",0);
            result.put("msg","修改,学号为"+athlete.getSno());
        } catch (Exception e) {
            result.put("code",500);
            result.put("msg","异常,修改失败！");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public JSONObject add(Athlete athlete) {
        JSONObject result=new JSONObject();
        try {
            athleteMapper.add(athlete);
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
    public JSONObject findTplPage(Athlete athlete) {
        JSONObject result=new JSONObject();
        //接收数据
        try {
            List<Athlete> list=athleteMapper.findAll(athlete);
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
