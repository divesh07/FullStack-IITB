package techBlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration // Scans the configuration classed
public class TechnicalBlogApplication {
    // Create a persistence.xml config file inside resources/META-INF folder
    // for the JPA Entity manager to read the configuration from
    // Create persistence - unit tag for each database
    // Create provider tag to mention provider which implements the JPA specifications
    public static void main(String[] args) {
        SpringApplication.run(TechnicalBlogApplication.class, args);
    }
}
