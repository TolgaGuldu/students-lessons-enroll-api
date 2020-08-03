package com.students.enroll;

import java.util.Collections;

import com.students.enroll.dao.repository.LessonRepository;
import com.students.enroll.model.Lesson;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(LessonRepository lessonRepository){
		return args -> {
			lessonRepository.save (new Lesson("TUR-Türkçe"));
			lessonRepository.save (new Lesson("MAT-Matematik"));
			lessonRepository.save (new Lesson("GEO-Geometri"));
			lessonRepository.save (new Lesson("TAR-Tarih"));
		};
	}

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				 .select()
				 .apis(RequestHandlerSelectors.basePackage("com.students.enroll"))
				 .paths(PathSelectors.any())
				 .build()
				 .apiInfo(getApiInfo());
	}
	private ApiInfo getApiInfo() {
		return new ApiInfo("Student & Lesson Enroll System",
				"This API helps to add, remove and enroll student and lesson", "VERSION", "TERMS OF SERVICE URL",
				new Contact("Tolga", "https://github.com/tolgaguldu", "tolga.guldutuna@gmail.com"), "LICENSE", "LICENSE URL",
				Collections.emptyList());
	}
}
