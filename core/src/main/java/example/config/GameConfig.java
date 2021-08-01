package example.config;

import example.GuessCount;
import example.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    // == fields ==
    private int maxNumber = 80;
    private int guessCount = 8;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber() {      // nazwa metody musi być taka sama jak nazwa pola z @Autowired
        return maxNumber;         // chyba że skorzystamy z qualifier annotation
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
