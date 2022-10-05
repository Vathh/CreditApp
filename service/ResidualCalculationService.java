package CreditApp.service;

import CreditApp.models.InputData;
import CreditApp.models.MortgageResidual;
import CreditApp.models.Rate;
import CreditApp.models.RateAmounts;

public interface ResidualCalculationService {
    MortgageResidual calculate(RateAmounts rateAmounts, InputData inputData);

    MortgageResidual calculate(RateAmounts rateAmounts, Rate previousRate);
}
