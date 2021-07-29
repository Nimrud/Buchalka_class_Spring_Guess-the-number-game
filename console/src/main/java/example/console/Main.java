package example.console;

import example.AppConfig;
import example.Game;
import example.MessageGenerator;
import example.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the Number Game");

        // tworzymy kontekst (Container)
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // wyciągamy z tego kontekstu beana (szukamy odpowiedniego po ID)
        // kontener da nam nową instancję klasy NumberGeneratorImpl (info z beana),
        // a sporo NumberGeneratorImpl implementuje interfejs NumberGenerator, to
        // kodujemy to do interface'u (dobra praktyka)
        NumberGenerator numberGenerator =
                context.getBean(NumberGenerator.class);

        // wywołujemy metodę:
        int number = numberGenerator.next();

        // log:
        log.info("number = {}", number);
            // slf4j automatycznie zamieni {} na parametr podany po przecinku

        // pobieramy beana gry z kontekstu (kontenera)
        Game game = context.getBean(Game.class);

        // CHALLENGE 1:
        MessageGenerator messageGenerator =
                context.getBean(MessageGenerator.class);
        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

        // zamykamy kontener:
        context.close();
    }
}
