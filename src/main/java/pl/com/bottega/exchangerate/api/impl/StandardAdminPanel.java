package pl.com.bottega.exchangerate.api.impl;

import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateCommand;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepository;
import pl.com.bottega.exchangerate.api.AdminPanel;

/**
 * Created by maciek on 13.05.2017.
 */
@Transactional
public class StandardAdminPanel implements AdminPanel {

    private ExchangeRateRepository exchangeRateRepository;

    public StandardAdminPanel(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public void saveExchangeRate(ExchangeRateCommand cmd) {
        ExchangeRate exchangeRate = exchangeRateRepository.get(cmd.getDate(), cmd.getCurrency());
        if (exchangeRate != null) {
        exchangeRate.setRate(cmd.getRate());
        } else {
            exchangeRate = new ExchangeRate(cmd.getDate(), cmd.getCurrency(), cmd.getRate());
            exchangeRateRepository.put(exchangeRate);
        }
    }
}
