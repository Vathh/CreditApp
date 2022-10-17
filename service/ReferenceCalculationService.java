package CreditApp.service;

import CreditApp.models.InputData;
import CreditApp.models.MortgageReference;
import CreditApp.models.Rate;
import CreditApp.models.RateAmounts;

public interface ReferenceCalculationService {

    MortgageReference calculate(InputData inputData);

    MortgageReference calculate(InputData inputData, RateAmounts rateAmounts, Rate previousRate);
}
