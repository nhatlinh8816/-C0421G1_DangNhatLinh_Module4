package case_study_module4.furama_resort_manager.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value = {"","/home"})
    public ModelAndView getHomePage(){
        return new ModelAndView("common/home");
    }
    @RequestMapping(value = "/login")
    public ModelAndView getLoginPage(){
        return new ModelAndView("common/login");
    }
    @PostMapping(value = "/login")
    public ModelAndView getHomePageLogin(){
        return new ModelAndView("common/login");
    }
    @RequestMapping(value = "/logout")
    public ModelAndView getLogoutPage(){
        return new ModelAndView("common/login");
    }
}
