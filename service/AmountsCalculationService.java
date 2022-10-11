package CreditApp.service;

import CreditApp.models.InputData;
import CreditApp.models.Overpayment;
import CreditApp.models.Rate;
import CreditApp.models.RateAmounts;

public interface AmountsCalculationService {
    public RateAmounts calculate(InputData inputData, Overpayment overpayment);

    public RateAmounts calculate(InputData inputData, Overpayment overpayment, Rate previousRate);
}
