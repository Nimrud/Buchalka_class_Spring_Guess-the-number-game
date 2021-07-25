package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;

    private int guessCount = 10;

    @PostConstruct
    public void initialize() {
        log.info("MessageGeneratorImpl has been called");
        log.debug("game: {}", game.getBiggest());
    }

    @Override
    public String getMainMessage() {
        return "calling method getMainMessage()";
    }

    @Override
    public String getResultMessage() {
        return "calling method getResultMessage()";
    }
}
