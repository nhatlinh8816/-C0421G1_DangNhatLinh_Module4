package dictionary.controller;

import dictionary.model.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;
    @RequestMapping(value ="/dictionary")
    private String getTranslatePage(HttpServletRequest request, Model model){
        String vietnamese = request.getParameter("vietnamese");
        String english= dictionaryService.translate(vietnamese);
        model.addAttribute("result",english);
        return "convert";
    }
}
