package com;

import com.formatter.StringToLocalDateFormatter;
import com.formatter.StringToLocalDateTimeFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

	@Configuration
	public static class AppConfig implements WebMvcConfigurer {
		@Override
		public void addFormatters(FormatterRegistry registry) {
			registry.addFormatter(new StringToLocalDateFormatter());
			registry.addFormatter(new StringToLocalDateTimeFormatter());
		}
	}
}
