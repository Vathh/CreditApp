package CreditApp.service;

import CreditApp.models.InputData;
import CreditApp.models.Overpayment;
import CreditApp.models.Rate;
import CreditApp.models.RateAmounts;

public interface DecreasingAmountsCalculationService {

    RateAmounts calculate(InputData inputData, Overpayment overpayment);

    RateAmounts calculate(InputData inputData, Overpayment overpayment, Rate previousRate);
}
