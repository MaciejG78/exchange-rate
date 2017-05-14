package pl.com.bottega.exchangerate.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.exchangerate.domain.CalculationResult;
import pl.com.bottega.exchangerate.domain.Calculation;
import pl.com.bottega.exchangerate.domain.commands.CalculateExchangeCommand;
import pl.com.bottega.exchangerate.infrastructure.ExchangeCalculation;

import java.math.BigDecimal;

/**
 * Created by maciek on 13.05.2017.
 */
@RestController
public class CalculationController {

    private ExchangeCalculation exchangeCalculation;

    public CalculationController(ExchangeCalculation exchangeCalculation){
        this.exchangeCalculation = exchangeCalculation;
    }

    @GetMapping("/calculation")
    public CalculationResult calculate(CalculateExchangeCommand cmd){
        return exchangeCalculation.calculate(cmd);
    }
}
