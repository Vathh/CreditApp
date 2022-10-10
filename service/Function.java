package CreditApp.service;

import CreditApp.models.Rate;

import java.math.BigDecimal;

public interface Function {

    BigDecimal calculate(Rate rate);
}
