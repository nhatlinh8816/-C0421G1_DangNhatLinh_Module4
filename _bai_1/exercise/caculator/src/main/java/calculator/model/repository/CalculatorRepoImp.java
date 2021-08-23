package calculator.model.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepoImp implements CalculatorRepo {
    @Override
    public double convert(double usd, double ty_gia) {
        double vnd = usd*ty_gia;
        return vnd;
    }
}
