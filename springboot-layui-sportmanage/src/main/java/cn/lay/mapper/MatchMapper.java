package cn.lay.mapper;

import cn.lay.pojo.Athlete;
import cn.lay.pojo.Match;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MatchMapper {
    //查询全部信息
    List<Match> findAllMatch(Match match);
    //删除一条信息
    void deleteByMno(int mno);
    //修改
    void updateByMno(Match match);
    //添加
    void addMatch(Match match);
}
