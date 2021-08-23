package calculator.model.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepoImp implements CalculatorRepo {
    @Override
    public double add(double firstNum, double secondNum) {
        return firstNum+secondNum;
    }

    @Override
    public double sub(double firstNum, double secondNum) {
        return firstNum-secondNum;
    }

    @Override
    public double div(double firstNum, double secondNum) {
        if (secondNum==0){
            try {
                return firstNum/secondNum;
            }catch (NumberFormatException e){
                System.out.println(e);
            }
        }
        return firstNum/secondNum;
    }

    @Override
    public double multi(double firstNum, double secondNum) {
        return firstNum*secondNum;
    }
}
