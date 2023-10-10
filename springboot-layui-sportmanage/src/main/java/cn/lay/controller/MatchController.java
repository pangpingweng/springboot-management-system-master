package cn.lay.controller;

import cn.lay.pojo.Athlete;
import cn.lay.pojo.Match;
import cn.lay.service.AthleteService;
import cn.lay.service.MatchService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    /*查询所以*/
    @RequestMapping(value = "/findAllMatch",method = RequestMethod.GET)
    public JSONObject findAllMatch(Integer page, Integer limit, Match match){
        System.out.println(match);
        return matchService.findAllMatch(page,limit,match);
    }

    @RequestMapping(value = "/findTplPage",method = RequestMethod.GET)
    public JSONObject findTplPage(Match match){
        return matchService.findTplPage(match);
    }

    @RequestMapping(value = "/deleteByMno",method = RequestMethod.GET)
    public JSONObject deleteByMno(@RequestParam("mno") int mno){
        return matchService.deleteByMno(mno);
    }

    @RequestMapping(value = "/updateByMno",method = RequestMethod.POST)
    public JSONObject updateByMno(@RequestBody Match match){
        return matchService.updateByMno(match);
    }

    @RequestMapping(value = "/addMatch",method = RequestMethod.POST)
    public JSONObject addMatch(@RequestBody Match match){
        return matchService.addMatch(match);
    }
}
