package cn.lay.controller;

import cn.lay.pojo.Athlete;
import cn.lay.pojo.Entry;
import cn.lay.pojo.Match;
import cn.lay.service.AthleteService;
import cn.lay.service.EntryService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entry")
public class EntryController {
    @Autowired
    private EntryService entryService;

    @RequestMapping(value = "/findAllEntry", method = RequestMethod.GET)
    public JSONObject findAllEntry(Integer page, Integer limit, Entry entry) {
        System.out.println(entry);
        return entryService.findAllEntry(page, limit, entry);
    }

    @RequestMapping(value = "/findTplPage", method = RequestMethod.GET)
    public JSONObject findTplPage(Entry entry) {
        return entryService.findTplPage(entry);
    }

    @RequestMapping(value = "/deleteBySno", method = RequestMethod.GET)
    public JSONObject deleteBySno(@RequestParam("sno") String sno) {
        return entryService.deleteBySno(sno);
    }

    @RequestMapping(value = "/updateBySno", method = RequestMethod.POST)
    public JSONObject updateById(@RequestBody Entry entry) {
        return entryService.updateBySno(entry);
    }

    @RequestMapping(value = "/addEntry", method = RequestMethod.POST)
    public JSONObject addEntry(@RequestBody Entry entry) {
        return entryService.addEntry(entry);
    }


    @RequestMapping(value = "/selectMatch", method = RequestMethod.GET)
    public JSONObject selectMatch(Match match) {
        System.out.println(match);
        return entryService.selectMatch(match);
    }
    @RequestMapping(value = "/findMatch", method = RequestMethod.POST)
    public JSONObject findMatch(Entry entry) {
        System.out.println(entry);
        return entryService.findMatch(entry);
    }
}
