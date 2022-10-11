package CreditApp.service;

import CreditApp.models.InputData;
import CreditApp.models.Overpayment;

import java.math.BigDecimal;

public interface OverpaymentCalculationService {
    Overpayment calculate(BigDecimal rateNumber, InputData inputData);
}
