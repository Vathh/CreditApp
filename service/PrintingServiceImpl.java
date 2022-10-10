package CreditApp.service;

import CreditApp.models.InputData;
import CreditApp.models.Rate;
import CreditApp.models.Summary;

import java.util.List;

public class PrintingServiceImpl implements PrintingService{
    @SuppressWarnings("StringBufferReplaceableByString")
    @Override
    public void printInputDataInfo(InputData inputData) {
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(MORTGAGE_AMOUNT).append(inputData.getAmount()).append(CURRENCY);
        msg.append(NEW_LINE);
        msg.append(MORTGAGE_PERIOD).append(inputData.getMonthsDuration()).append(MONTHS);
        msg.append(NEW_LINE);
        msg.append(INTEREST).append(inputData.getInterestDisplay()).append(PERCENT);
        msg.append(NEW_LINE);

        printMessage(msg.toString());
    }

    @Override
    public void printRates(List<Rate> rates) {
        String format = "%4s %3s " +
                "%4s %3s " +
                "%4s %2s " +
                "%4s %2s " +
                "%4s %8s " +
                "%4s %8s " +
                "%4s %10s " +
                "%4s %10s " +
                "%4s %3s ";

        for (Rate rate : rates) {
            String message = String.format(format,
                    RATE_NUMBER, rate.getRateNumber(),
                    DATE, rate.getTimePoint().getDate(),
                    YEAR, rate.getTimePoint().getYear(),
                    MONTH, rate.getTimePoint().getMonth(),
                    RATE, rate.getRateAmounts().getRateAmount(),
                    INTEREST, rate.getRateAmounts().getInterestAmount(),
                    CAPITAL, rate.getRateAmounts().getCapitalAmount(),
                    LEFT_AMOUNT, rate.getMortgageResidual().getAmount(),
                    LEFT_MONTHS, rate.getMortgageResidual().getDuration()
                    );

            printMessage(message);
        }
    }

    @Override
    @SuppressWarnings("StringBufferReplaceableByString")
    public void printSummary(Summary summary) {
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(INTEREST_SUM).append(summary.getInterestSum()).append(CURRENCY);
        msg.append(NEW_LINE);

        printMessage(msg.toString());
    }

    private void printMessage(String sb){
        System.out.println(sb);
    }
}
