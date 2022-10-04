package CreditApp.service;

import CreditApp.models.InputData;
import CreditApp.models.Rate;
import CreditApp.models.RateAmounts;

public interface AmountsCalculationService {
    public RateAmounts calculate(InputData inputData);

    public RateAmounts calculate(InputData inputData, Rate previousRate);
}
