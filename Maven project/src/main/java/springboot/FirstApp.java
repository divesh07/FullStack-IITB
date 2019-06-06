package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan // Scans the servlets
@ComponentScan // Scans for Spring MVC components and registers them with IOC container
public class FirstApp {
    public static void main(String[] args) {
        SpringApplication.run(FirstApp.class, args);
    }
}

