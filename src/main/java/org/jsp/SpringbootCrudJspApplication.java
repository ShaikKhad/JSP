package org.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.org")
public class SpringbootCrudJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudJspApplication.class, args);
	}

}
