package CreditApp;

import CreditApp.models.InputData;
import CreditApp.service.*;

public class Main {

    public static void main(String[] args) {
        InputData inputData = new InputData();

        PrintingService printingService = new PrintingServiceImpl();
        RateCalculationService rateCalculationService = new RateCalculationServiceImpl();


        MortgageCalculationService mortgageCalculationService = new MortgageCalculationServiceImpl(
                printingService,
                rateCalculationService
        );

        mortgageCalculationService.calculate(inputData);
    }

}
