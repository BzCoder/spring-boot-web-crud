package com.example.springbootwebcrud.config;


import com.example.springbootwebcrud.component.LoginHandlerInterceptor;
import com.example.springbootwebcrud.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.template.TemplateAvailabilityProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author BaoZhou
 * @date 2018/5/14
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 视图映射器
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/login").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/main").setViewName("dashboard");
    }

    /**
     * 拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/", "/index", "/user/login");
    }


    @Bean
    public LocaleResolver localeResolver() {

        return new MyLocaleResolver();
    }


}
