package CreditApp;

import CreditApp.models.InputData;
import CreditApp.service.PrintingService;
import CreditApp.service.PrintingServiceImpl;

public class Main {

    public static void main(String[] args) {
        InputData inputData = new InputData();

        PrintingService printingService = new PrintingServiceImpl();
        printingService.printInputDataInfo(inputData);
    }

}
