package product_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import product_management.model.beans.Product;
import product_management.model.service.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping(value = "/list")
    public ModelAndView showProductList (){
        return new ModelAndView("list","productList",productService.viewAll());
    }
    @RequestMapping(value = "/create")
    public ModelAndView showCreateForm(Model model){
        //gửi 1 đối tượng rỗng cho người dùng thêm
        model.addAttribute("newProduct",new Product());
        return new ModelAndView("create","newProduct",new Product());

    }
    @PostMapping(value = "/create")
    public ModelAndView createProduct(@ModelAttribute Product newProduct){
        productService.save(newProduct);
        return new ModelAndView("redirect:/product/list");
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        return new ModelAndView("edit","editProduct",productService.viewById(id));
    }
    @PostMapping(value = "/edit")
    public ModelAndView saveEditProduct(@ModelAttribute Product editProduct){
        productService.update(editProduct);
        return new ModelAndView("redirect:/product/list");
    }

    @RequestMapping(value = "/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id){
        return new ModelAndView("detail","detailProduct",productService.viewById(id));
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
        return new ModelAndView("delete","deleteProduct",productService.viewById(id));
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteProduct(@ModelAttribute Product deleteProduct){
        productService.delete(deleteProduct);
        return new ModelAndView("redirect:/product/list");
    }

    @PostMapping(value = "/searchByName")
    public ModelAndView showDetailByName(@RequestParam("productName") String name){
        return new ModelAndView("detail","detailProduct",productService.viewByName(name));
    }
}
