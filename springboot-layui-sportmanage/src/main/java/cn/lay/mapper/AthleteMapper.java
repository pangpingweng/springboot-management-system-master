package cn.lay.mapper;

import cn.lay.pojo.Athlete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AthleteMapper {
    //查询全部信息
    List<Athlete> findAll(Athlete athlete);
    //删除一条信息
    void deleteBySno(String sno);
    //修改
    void updateBySno(Athlete athlete);
    //添加
    void add(Athlete athlete);
}
