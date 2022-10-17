package CreditApp;

import CreditApp.models.InputData;
import CreditApp.models.Overpayment;
import CreditApp.models.RateType;
import CreditApp.models.TimePoint;
import CreditApp.service.*;

import java.math.BigDecimal;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        InputData inputData = new InputData()
                .withAmount(new BigDecimal("298000"))
                .withOverpaymentSchema(Map.of(
                        4, BigDecimal.valueOf(10000),
                        8, BigDecimal.valueOf(10000),
                        15, BigDecimal.valueOf(10000),
                        28, BigDecimal.valueOf(10000)
                ))
                .withMonthsDuration(BigDecimal.valueOf(360))
                .withRateType(RateType.DECREASING)
                .withOverpaymentReduceWay(Overpayment.REDUCE_RATE);

        PrintingService printingService = new PrintingServiceImpl();
        RateCalculationService rateCalculationService = new RateCalculationServiceImpl(
                new TimePointServiceImpl(),
                new AmountsCalculationServiceImpl(
                        new ConstantAmountsCalculationServiceImpl(),
                        new DecreasingAmountsCalculationServiceImpl()
                ),
                new OverpaymentCalculationServiceImpl(),
                new ResidualCalculationServiceImpl(),
                new ReferenceCalculationServiceImpl()
        );


        MortgageCalculationService mortgageCalculationService = new MortgageCalculationServiceImpl(
                printingService,
                rateCalculationService,
                SummaryServiceFactory.create()
        );

        mortgageCalculationService.calculate(inputData);
    }

}
