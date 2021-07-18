package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the Number Game");

        // tworzymy kontekst (Container)
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // wyciągamy z tego kontekstu beana (szukamy odpowiedniego po ID)
        // kontener da nam nową instancję klasy NumberGeneratorImpl (info z beana),
        // a sporo NumberGeneratorImpl implementuje interfejs NumberGenerator, to
        // kodujemy to do interface'u (dobra praktyka)
        NumberGenerator numberGenerator =
                context.getBean("numberGenerator", NumberGenerator.class);

        // wywołujemy metodę:
        int number = numberGenerator.next();

        // log:
        log.info("number = {}", number);
            // slf4j automatycznie zamieni {} na parametr podany po przecinku

        // zamykamy kontener:
        context.close();
    }
}
