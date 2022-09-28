package CreditApp.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InputData {

    private LocalDate repaymentStartDate = LocalDate.of(2022,1,6);

    private BigDecimal wiborPercent = new BigDecimal("1.73");

    private BigDecimal amount = new BigDecimal("300000");

    private BigDecimal monthsDuration = BigDecimal.valueOf(180);

    private RateType rateType = RateType.CONSTANT;

    private BigDecimal bankMargin = new BigDecimal("1.9");
}
