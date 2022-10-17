package CreditApp.service;

import CreditApp.models.*;

import java.math.BigDecimal;

public class ReferenceCalculationServiceImpl implements ReferenceCalculationService{

    @Override
    public MortgageReference calculate(InputData inputData) {
        return new MortgageReference(inputData.getAmount(), inputData.getMonthsDuration());
    }

    @Override
    public MortgageReference calculate(InputData inputData, RateAmounts rateAmounts, Rate previousRate) {
        if(BigDecimal.ZERO.equals(previousRate.getMortgageResidual().getAmount())){
            return new MortgageReference(BigDecimal.ZERO, BigDecimal.ZERO);
        }

        switch(inputData.getOverpaymentReduceWay()){
            case Overpayment.REDUCE_PERIOD:
                return new MortgageReference(inputData.getAmount(), inputData.getMonthsDuration());
            case Overpayment.REDUCE_RATE:
                return reduceRateMortgageReference(rateAmounts, previousRate);
            default:
                throw new MortgageException();
        }
    }

    private MortgageReference reduceRateMortgageReference(RateAmounts rateAmounts, Rate previousRate) {
        if(rateAmounts.getOverpayment().getAmount().compareTo(BigDecimal.ZERO) > 0){
            BigDecimal referenceAmount = calculateResidualAmount(rateAmounts, previousRate.getMortgageResidual().getAmount());
            BigDecimal referenceDuration = previousRate.getMortgageResidual().getDuration().subtract(BigDecimal.ONE);

            return new MortgageReference(referenceAmount, referenceDuration);
        }

        return new MortgageReference(
                previousRate.getMortgageReference().getReferenceAmount(),
                previousRate.getMortgageReference().getReferenceDuration());
    }

    private static BigDecimal calculateResidualAmount(RateAmounts rateAmounts, BigDecimal amount) {
        return amount
                .subtract(rateAmounts.getCapitalAmount())
                .subtract(rateAmounts.getOverpayment().getAmount())
                .max(BigDecimal.ZERO);
    }
}
