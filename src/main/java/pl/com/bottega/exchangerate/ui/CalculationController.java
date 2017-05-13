package pl.com.bottega.exchangerate.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.exchangerate.domain.CalculationResult;
import pl.com.bottega.exchangerate.domain.Calculator;
import pl.com.bottega.exchangerate.domain.commands.CalculateExchangeCommand;

/**
 * Created by maciek on 13.05.2017.
 */
@RestController
public class CalculationController {

    private Calculator calculator;

    public CalculationController(Calculator calculator){
        this.calculator = calculator;
    }

    @GetMapping("/calculation")
    public CalculationResult calculate(@RequestParam(value = "date", required = true) String date,
                                       @RequestParam(value = "from", required = true) String from,
                                       @RequestParam(value = "to", required = true) String to,
                                       @RequestParam(value = "amount", required = true) String amount){
        CalculateExchangeCommand cmd = new CalculateExchangeCommand();


        return calculator.calculate(cmd);
    }
}
