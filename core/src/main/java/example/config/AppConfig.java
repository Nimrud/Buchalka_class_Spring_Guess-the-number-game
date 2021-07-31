package example.config;

import example.MessageGenerator;
import example.MessageGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "example")
public class AppConfig {

    // == bean methods ==
    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }
}
