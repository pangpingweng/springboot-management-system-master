package cn.lay.pojo;

import lombok.Data;

@Data
public class Match {
    //项目号
    private int mno;
    //项目名
    private String mname;
    //项目历史记录
    private String mgrade;
    //比赛时间
    private String time;
    //比赛地点
    private String mfiled;
    //比赛类型：田赛or竞赛
    private String mkind;
    //状态
    private int status;
}
