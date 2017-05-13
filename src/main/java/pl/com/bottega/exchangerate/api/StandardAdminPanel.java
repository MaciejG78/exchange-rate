package pl.com.bottega.exchangerate.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateCommand;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepository;
import pl.com.bottega.exchangerate.infrastructure.AdminPanel;

/**
 * Created by maciek on 13.05.2017.
 */
@Transactional
public class StandardAdminPanel implements AdminPanel {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public void saveExchangeRate(ExchangeRateCommand cmd) {
        ExchangeRate exchangeRate = new ExchangeRate(cmd.getDate(), cmd.getCurrency(), cmd.getRate());
        exchangeRateRepository.put(exchangeRate);
    }
}
