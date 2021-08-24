package medical_declaration.controller;

import medical_declaration.model.bean.MedicalDeclaration;
import medical_declaration.model.service.MedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/declaration")
public class MedicalDeclarationController {
    @Autowired
    MedicalDeclarationService medicalDeclarationService;

    @RequestMapping(value = "/create")
    private String showCreatePage(Model model){
        MedicalDeclaration medicalDeclaration = medicalDeclarationService.display();
        model.addAttribute("medicalDeclaration",medicalDeclaration);
        List<String> sympathyList = new ArrayList<>();
        sympathyList.add("Sốt");
        sympathyList.add("Ho");
        sympathyList.add("Khó thở");
        sympathyList.add("Đau họng");
        sympathyList.add("Nôn");
        sympathyList.add("Tiêu chảy");
        sympathyList.add("Xuất huyết");
        sympathyList.add("Nổi ban");
        model.addAttribute("sympathyList",sympathyList);
        List<String> exposureList = new ArrayList<>();
        exposureList.add("Đến trang trại chăn nuôi...");
        exposureList.add("Tiếp xúc gần...");
        model.addAttribute("exposureList",exposureList);
        return "create";
    }
    @RequestMapping(value = "/details")
    private ModelAndView detailDeclaration(){
        MedicalDeclaration medicalDeclaration = medicalDeclarationService.display();
        return new ModelAndView("detail","declaration",medicalDeclaration);
    }

    @PostMapping(value = "/create")
    private String updateDeclaration(@ModelAttribute MedicalDeclaration medicalDeclaration){
        medicalDeclarationService.edit(medicalDeclaration);
        return "redirect:/declaration/details";
    }
}
