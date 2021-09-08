package spring_session_cookie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import spring_session_cookie.dto.CartDto;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
    @RequestMapping(value = "/list")
    //lay session o productController ra
    public ModelAndView showCart(@SessionAttribute CartDto cart){
        return new ModelAndView("cart/list","cart",cart);
    }
}
