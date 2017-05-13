package pl.com.bottega.exchangerate.infrastructure;

import org.springframework.context.annotation.Bean;
import pl.com.bottega.exchangerate.api.StandardAdminPanel;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepository;

/**
 * Created by maciek on 13.05.2017.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public AdminPanel adminPanel() {
        return new StandardAdminPanel();
    }

    @Bean
    public ExchangeRateRepository exchangeRateRepository(){
    return new JPAExchangeRateRepository();
    }
}
