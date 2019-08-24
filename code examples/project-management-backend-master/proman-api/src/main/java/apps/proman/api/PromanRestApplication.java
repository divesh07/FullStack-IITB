package apps.proman.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import apps.proman.api.config.ApiConfiguration;
import apps.proman.service.ServiceConfiguration;

@SpringBootApplication
@Import({ApiConfiguration.class, ServiceConfiguration.class})
public class PromanRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PromanRestApplication.class, args);
    }

}