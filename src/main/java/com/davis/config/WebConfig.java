package com.davis.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
import java.util.Properties;

/**
 * @author Davis
 * @date 2021-11-09 - 10:06
 * @description
 */
@Configuration
@ComponentScan(value = "com.davis")
@EnableAspectJAutoProxy
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        TestInterceptor interceptor = new TestInterceptor();
//        registry.addInterceptor(interceptor).addPathPatterns("/**");
//    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".html");
        resolver.setOrder(0);
        return resolver;
    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        resolver.setExceptionAttribute("ex");
        Properties properties = new Properties();
        properties.setProperty("java.lang.ArithmeticException", "error");
        resolver.setExceptionMappings(properties);
        resolvers.add(resolver);
    }

    @Bean("multipartResolver")
    public CommonsMultipartResolver multipartFile(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        commonsMultipartResolver.setMaxInMemorySize(10240);
        commonsMultipartResolver.setMaxUploadSize(-1);
        return commonsMultipartResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowCredentials(true)
                .allowedHeaders("*")
                .maxAge(3600);

    }

    @Bean("kaptcha")
    public Producer getKaptcha(){
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        Config config = new Config(properties);
        //??????????????????
        properties.setProperty("kaptcha.border", "yes");
        //???????????????????????????RGB?????????????????????
        properties.setProperty("kaptcha.border.color", "75,139,244");
        //???????????????????????????RGB?????????????????????
        properties.setProperty("kaptcha.textproducer.font.color", "75,139,244");
        //???????????????
        properties.setProperty("kaptcha.image.width","100");
        //???????????????
        properties.setProperty("kaptcha.image.height","50");
        //??????????????????
        properties.setProperty("kaptcha.image.font.size","15");
        //?????????????????????
        properties.setProperty("kaptcha.textproducer.char.length","4");
        //??????????????????
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
