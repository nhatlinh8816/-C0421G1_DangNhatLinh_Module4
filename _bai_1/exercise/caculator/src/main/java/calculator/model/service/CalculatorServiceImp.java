package calculator.model.service;

import calculator.model.repository.CalculatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImp implements CalculatorService {
    @Autowired
    CalculatorRepo calculatorRepo;
    @Override
    public double convert(double usd, double ty_gia) {
        return calculatorRepo.convert(usd,ty_gia);
    }
}
