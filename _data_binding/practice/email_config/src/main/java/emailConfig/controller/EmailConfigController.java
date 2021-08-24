package emailConfig.controller;

import emailConfig.model.bean.EmailConfig;
import emailConfig.model.service.EmailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/email")
public class EmailConfigController {
    @Autowired
    EmailConfigService emailConfigService;
    @RequestMapping(value = "/details")
    private ModelAndView detailConfig(){
        EmailConfig emailConfig = emailConfigService.displayConfig();
        return new ModelAndView("detail","config",emailConfig);
    }

    //kẹp đối tượng rỗng cho người dùng nhập
    @RequestMapping(value = "/edit")
    private String showCreatePage(Model model){
        EmailConfig emailConfig = emailConfigService.displayConfig();
        model.addAttribute("emailConfig",emailConfig);
        return "edit";
    }
    @PostMapping(value = "/edit")
    private String updateConfig(@ModelAttribute EmailConfig emailConfig){
        emailConfigService.update(emailConfig);
        return "redirect:/email/details";
    }
}
