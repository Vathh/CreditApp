package CreditApp.service;

import CreditApp.models.InputData;
import CreditApp.models.TimePoint;

import java.math.BigDecimal;

public interface TimePointService {
    TimePoint calculate(BigDecimal rateNumber, InputData inputData);
}
