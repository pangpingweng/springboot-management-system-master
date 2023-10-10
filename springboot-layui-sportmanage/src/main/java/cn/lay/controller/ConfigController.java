package cn.lay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ConfigController {
    @GetMapping("/login")
        public String Login(){
        return "../static/login.html";
    }
    @GetMapping("/index")
    public String Index(){
        return "redirect:index.html";
    }
    @GetMapping(value ="/loginout")
    public String logout(HttpServletRequest request) {
        System.out.print("进入loginout");
        Object userInfor = request.getSession().getAttribute("userInfor");
        if(null != userInfor) {
            System.out.print("session已删除");
            request.getSession().removeAttribute("userInfor");
        }
        return "../static/login.html";
    }
}
