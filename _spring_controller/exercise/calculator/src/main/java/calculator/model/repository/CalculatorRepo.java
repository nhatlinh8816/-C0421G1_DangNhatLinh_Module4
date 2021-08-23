package calculator.model.repository;

public interface CalculatorRepo {
    double add(double firstNum, double secondNum);
    double sub(double firstNum, double secondNum);
    double div(double firstNum, double secondNum);
    double multi(double firstNum, double secondNum);
}
