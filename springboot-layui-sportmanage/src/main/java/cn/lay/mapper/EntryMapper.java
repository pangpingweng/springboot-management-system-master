package cn.lay.mapper;

import cn.lay.pojo.Athlete;
import cn.lay.pojo.Entry;
import cn.lay.pojo.Match;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EntryMapper {
    //查询全部信息
    List<Entry> findAllEntry(Entry entry);
    //删除一条信息
    void deleteBySno(String sno);
    //修改
    void updateBySno(Entry entry);
    //添加
    void addEntry(Entry entry);
    List<Match> selectMatch(Match match);
}
