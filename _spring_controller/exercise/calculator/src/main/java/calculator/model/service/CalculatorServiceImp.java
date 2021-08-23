package calculator.model.service;

import calculator.model.repository.CalculatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CalculatorServiceImp implements CalculatorService {
    @Autowired
    CalculatorRepo calculatorRepo;
    @Override
    public double add(double firstNum, double secondNum) {
        return calculatorRepo.add(firstNum,secondNum);
    }

    @Override
    public double sub(double firstNum, double secondNum) {
        return calculatorRepo.sub(firstNum,secondNum);
    }

    @Override
    public double div(double firstNum, double secondNum) {
        return calculatorRepo.div(firstNum,secondNum);
    }

    @Override
    public double multi(double firstNum, double secondNum) {
        return calculatorRepo.multi(firstNum,secondNum);
    }
}
