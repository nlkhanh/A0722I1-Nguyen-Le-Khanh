package codegym.m4_case_study.config;

import codegym.m4_case_study.formatter.StringToLocalDateFormatter;
import codegym.m4_case_study.formatter.StringToLocalDateTimeFormatter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements ApplicationContextAware, WebMvcConfigurer {
    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new StringToLocalDateFormatter());
        registry.addFormatter(new StringToLocalDateTimeFormatter());
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
