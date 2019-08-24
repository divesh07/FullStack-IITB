package apps.proman.service;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("apps.proman.service")
@EntityScan({"apps.proman.service.user.entity", "apps.proman.service.board.entity"})
public class ServiceConfiguration {
}
