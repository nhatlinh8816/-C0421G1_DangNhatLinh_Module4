package spring_session_cookie.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring_session_cookie.dto.CartDto;
import spring_session_cookie.dto.ProductDto;
import spring_session_cookie.model.entity.Product;
import spring_session_cookie.model.service.ProductService;

import java.util.Optional;
//khai bao 1 session cart
@SessionAttributes("cart")
@Controller
@RequestMapping(value = "/shop")
public class ProductController {
    @Autowired
    private ProductService productService;

    // khai bao gia tri mac dinh cho cart
    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }
    @RequestMapping()
    public ModelAndView showList(){
        return new ModelAndView("/product/list","productList",productService.findAll());
    }

    @RequestMapping(value = "/add/{id}")
    public ModelAndView addToCart(@PathVariable int id, @SessionAttribute CartDto cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productService.findById(id).get(),productDto);
            cart.addProduct(productDto);
            return new ModelAndView("redirect:/shop");
        }else {
            return new ModelAndView("/product/error");
        }

    }
    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteToCart(@PathVariable int id, @SessionAttribute CartDto cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productService.findById(id).get(),productDto);
            cart.deleteProductOnCart(productDto);
            return new ModelAndView("redirect:/cart/list");
        }else {
            return new ModelAndView("/product/error");
        }
    }

    @RequestMapping(value ="/detail/{id}")
    public ModelAndView detailProduct(@PathVariable int id){
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            return new ModelAndView("/product/detail","product", productOptional.get());
        }else {
            return new ModelAndView("/product/error");
        }
    }

    @RequestMapping(value = "/remove/{id}")
    public ModelAndView removeToCart(@PathVariable int id, @SessionAttribute CartDto cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productService.findById(id).get(),productDto);
            cart.removeProduct(productDto);
            return new ModelAndView("redirect:/cart/list");
        }else {
            return new ModelAndView("/product/error");
        }
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editOnCart(@PathVariable int id, @SessionAttribute CartDto cart,@RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()&&action.equals("add")){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productService.findById(id).get(),productDto);
            cart.addProduct(productDto);
            return new ModelAndView("redirect:/cart/list");
        }else if (productOptional.isPresent()&&action.equals("remove")){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productService.findById(id).get(),productDto);
            cart.removeProduct(productDto);
            return new ModelAndView("redirect:/cart/list");
        }
        return new ModelAndView("redirect:/shop");
    }
    @RequestMapping(value = "/payment")
    public ModelAndView payment(@SessionAttribute CartDto cart){
        cart.removeAllProductOnCart();
        return new ModelAndView("redirect:/cart/list");
    }
}
