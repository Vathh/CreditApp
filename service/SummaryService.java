package CreditApp.service;

import CreditApp.models.Rate;
import CreditApp.models.Summary;

import java.util.List;

public interface SummaryService {

    Summary calculate(List<Rate> rates);
}
