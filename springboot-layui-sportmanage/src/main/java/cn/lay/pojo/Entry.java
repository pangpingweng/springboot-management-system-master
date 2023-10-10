package cn.lay.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Entry{
    //学号
    private String sno;
    //姓名
    private String sname;
    //参赛项目
    private int mno;
    //参赛者成绩
    private String pgrade;
    //状态
    private int status;

    private Match match;
}
