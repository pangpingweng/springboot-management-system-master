package cn.lay.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session，判断session是否存在
        Object userInfor = request.getSession().getAttribute("userInfor");
        if (userInfor==null){
            log.debug("未登录请求:"+request.getRequestURI());
            response.sendRedirect(request.getContextPath()+"login");
            return false;
        }
        log.debug("已登录:"+request.getRequestURI());
        return true;
    }
}
