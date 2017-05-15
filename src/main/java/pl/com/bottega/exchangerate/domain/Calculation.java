package pl.com.bottega.exchangerate.domain;

import pl.com.bottega.exchangerate.domain.commands.CalculateExchangeCommand;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by maciek on 13.05.2017.
 */
public class Calculation {

    public static String MAIN_CURRENCY = "PLN";

    private ExchangeRateRepository exchangeRateRepository;

    public Calculation(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public CalculationResult calculate(CalculateExchangeCommand cmd) {
        if (cmd.getFrom().equals(MAIN_CURRENCY))
            return calculationFromMainCurrency(cmd);
        else if (cmd.getTo().equals(MAIN_CURRENCY))
            return calculationToMainCurrency(cmd);
        else
            return calculationDifferentCurrency(cmd);
    }

    private CalculationResult calculationFromMainCurrency(CalculateExchangeCommand cmd) {
        ExchangeRate exchangeRateTo = checkIfExist(exchangeRateRepository.get(cmd.getDate(), cmd.getTo()));
        BigDecimal rateTo = exchangeRateTo.getRate();
        BigDecimal calculatedAmount = cmd.getAmount().divide(rateTo, 2, RoundingMode.HALF_EVEN);
        CalculationResult calculationResult = new CalculationResult(cmd.getFrom(), cmd.getTo(), cmd.getAmount(), calculatedAmount, cmd.getDate());
        return calculationResult;
    }

    private CalculationResult calculationToMainCurrency(CalculateExchangeCommand cmd) {
        ExchangeRate exchangeRateFrom = checkIfExist(exchangeRateRepository.get(cmd.getDate(), cmd.getFrom()));
        BigDecimal rateFrom = exchangeRateFrom.getRate();
        BigDecimal calculatedAmount = cmd.getAmount().multiply(rateFrom);
        CalculationResult calculationResult = new CalculationResult(cmd.getFrom(), cmd.getTo(), cmd.getAmount(), calculatedAmount, cmd.getDate());
        return calculationResult;
    }

    private CalculationResult calculationDifferentCurrency(CalculateExchangeCommand cmd) {
        ExchangeRate exchangeRateTo = checkIfExist(exchangeRateRepository.get(cmd.getDate(), cmd.getTo()));
        ExchangeRate exchangeRateFrom = checkIfExist(exchangeRateRepository.get(cmd.getDate(), cmd.getFrom()));
        BigDecimal rateFrom = exchangeRateFrom.getRate();
        BigDecimal rateTo = exchangeRateTo.getRate();
        BigDecimal calculatedAmount = (cmd.getAmount().multiply(rateFrom)).divide(rateTo, 2, RoundingMode.HALF_EVEN);
        CalculationResult calculationResult = new CalculationResult(cmd.getFrom(), cmd.getTo(), cmd.getAmount(), calculatedAmount, cmd.getDate());
        return calculationResult;
    }

    private ExchangeRate checkIfExist(ExchangeRate exchangeRate) {
        if (exchangeRate == null)
            throw new NoRateException();
        return exchangeRate;
    }
}
