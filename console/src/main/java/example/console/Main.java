package example.console;

import example.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the Number Game");

        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        context.close();
    }
}
