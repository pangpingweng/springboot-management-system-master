package cn.lay.webConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    @Qualifier(value ="loginInterceptor")
    private HandlerInterceptor handlerInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(handlerInterceptor);
        interceptorRegistration.addPathPatterns("/**");
        interceptorRegistration.excludePathPatterns(
                "/login",
                "/user/login",
                "/user/loginout",
                "/layui/**",
                "/css/**",
                "/img/**",
                "/js/**",
                "/user/register");
    }

}
