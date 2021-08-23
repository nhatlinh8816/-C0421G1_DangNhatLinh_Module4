package calculator.controller;

import calculator.model.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;
    @RequestMapping(value = "/calculator")
    private String getConvertPage(HttpServletRequest request, Model model){
        double tyGia =Double.parseDouble(request.getParameter("ty-gia"));
        double usd = Double.parseDouble(request.getParameter("USD"));
        double result = calculatorService.convert(usd,tyGia);
        model.addAttribute("result",result);
        return "convert";
    }
}
