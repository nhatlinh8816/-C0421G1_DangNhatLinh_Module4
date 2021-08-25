package calculator.controller;

import calculator.model.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    @RequestMapping(value = "/")
    private ModelAndView getHomepage(){
        return new ModelAndView("homepage");
    }
    @RequestMapping(value = "/calculator")
    private ModelAndView getResult(@RequestParam double firstNum,double secondNum,String operator){
        ModelAndView modelAndView = new ModelAndView("resultpage");
        switch (operator){
            case "add":
                double result1 = calculatorService.add(firstNum,secondNum);
                modelAndView.addObject("result",result1);
                modelAndView.addObject("operator",operator);
                break;
            case "sub":
                double result2 = calculatorService.sub(firstNum,secondNum);
                modelAndView.addObject("result",result2);
                modelAndView.addObject("operator",operator);
                break;
            case "multi":
                double result3 = calculatorService.multi(firstNum,secondNum);
                modelAndView.addObject("result",result3);
                modelAndView.addObject("operator",operator);
                break;
            case "div":
                double result4 = calculatorService.div(firstNum,secondNum);
                modelAndView.addObject("result",result4);
                modelAndView.addObject("operator",operator);
                break;
        }
    return modelAndView;
    }
}
