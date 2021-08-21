package dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
public class DictionaryController {
    static Map<String,String> dictionaryMap = new HashMap<>();
    static {
        dictionaryMap.put("Nhà","House");
        dictionaryMap.put("Dog","Chó");
        dictionaryMap.put("Cat","Mèo");
        dictionaryMap.put("Computer","Máy tính");
        dictionaryMap.put("Father","Bố");
    }
    @RequestMapping(value ="/dictionary")
    public String getTranslatePage(HttpServletRequest request, Model model){
        String englishWord = request.getParameter("english");
        String vietnamWord= dictionaryMap.get(englishWord);
        model.addAttribute("result",vietnamWord);
        return "convert";
    }
}
