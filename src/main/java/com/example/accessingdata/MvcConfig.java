package com.example.accessingdata;
//wendel
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    
    public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/home").setViewName("home");
    registry.addViewController("/").setViewName("home");
    registry.addViewController("/hello").setViewName("hello"); 
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/gerenciar-painel").setViewName("gerenciar-painel");
    registry.addViewController("/painel").setViewName("painel");
    registry.addViewController("/css/hrt.css").setViewName("css/hrt.css");
	registry.addViewController("/img/Bandeira_do_Distrito_Federal_Brasil.jpg").setViewName
    ("img/Bandeira_do_Distrito_Federal_Brasil");
   

}
}
 