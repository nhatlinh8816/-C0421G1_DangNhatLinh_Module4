package calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping(value = "/calculator")
     public ModelAndView getUSDToVND(@RequestParam("valueUSD") double valueUSD){
         return new ModelAndView("convert","valueToVND",valueUSD);
         //vd: http://localhost:8080/calculator?valueUSD=1
    }
}
