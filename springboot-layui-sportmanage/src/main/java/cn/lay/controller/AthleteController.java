package cn.lay.controller;

import cn.lay.pojo.Athlete;
import cn.lay.service.AthleteService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/athletes")
public class AthleteController {

    @Autowired
    private AthleteService athleteService;

    /*查询所以*/
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public JSONObject findAll(Integer page, Integer limit,Athlete athlete){
        System.out.println(athlete);
        return athleteService.findAll(page,limit,athlete);
    }

    @RequestMapping(value = "/findTplPage",method = RequestMethod.GET)
    public JSONObject findTplPage(Athlete athlete){
        return athleteService.findTplPage(athlete);
    }

    @RequestMapping(value = "/deleteBySno",method = RequestMethod.GET)
    public JSONObject deleteBySno(@RequestParam("sno") String sno){
        return athleteService.deleteBySno(sno);
    }

    @RequestMapping(value = "/updateBySno",method = RequestMethod.POST)
    public JSONObject updateById(@RequestBody Athlete athlete){
        return athleteService.updateBySno(athlete);
    }

    @RequestMapping(value = "/addAthlete",method = RequestMethod.POST)
    public JSONObject add(@RequestBody Athlete athlete){
        return athleteService.add(athlete);
    }
}