package pl.com.bottega.exchangerate.infrastructure;

import org.springframework.context.annotation.Bean;
import pl.com.bottega.exchangerate.api.StandardAdminPanel;
import pl.com.bottega.exchangerate.api.StandardExchangeCalculation;
import pl.com.bottega.exchangerate.domain.Calculation;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepository;

/**
 * Created by maciek on 13.05.2017.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public ExchangeRateRepository exchangeRateRepository(){
        return new JPAExchangeRateRepository();
    }

    @Bean
    public AdminPanel adminPanel(ExchangeRateRepository exchangeRateRepository) {
        return new StandardAdminPanel(exchangeRateRepository);
    }

    @Bean
    public ExchangeCalculation exchangeCalculation(Calculation calculation){
        return new StandardExchangeCalculation(calculation);
    }
    @Bean
    public Calculation calculation(){
        return new Calculation();
    }
}
