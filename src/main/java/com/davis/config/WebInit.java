package com.davis.config;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;


/**
 * @author Davis
 * @date 2021-11-09 - 10:04
 * @description
 */
@Configuration
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //指明数据层的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
    //指明控制层的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }
    //指明前端控制器的映射路径为当前工程
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    //添加过滤器
    @Override
    protected Filter[] getServletFilters() {
        //使用REST必须的，开启隐藏的HttpMethod
        HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();
        //指明响应和请求的编码集
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceResponseEncoding(true);
        return new Filter[]{httpMethodFilter,encodingFilter};
    }
}
