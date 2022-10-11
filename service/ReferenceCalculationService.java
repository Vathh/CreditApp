package CreditApp.service;

import CreditApp.models.MortgageReference;
import CreditApp.models.Rate;

public interface ReferenceCalculationService {

    MortgageReference calculate();

    MortgageReference calculate(Rate previousRate);
}
