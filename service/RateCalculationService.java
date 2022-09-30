package CreditApp.service;

import CreditApp.models.InputData;
import CreditApp.models.Rate;

import java.util.List;

public interface RateCalculationService {

    List<Rate> calculate(final InputData inputData);

}
