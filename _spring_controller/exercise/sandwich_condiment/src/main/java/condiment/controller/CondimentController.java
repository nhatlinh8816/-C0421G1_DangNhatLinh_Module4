package condiment.controller;

import condiment.model.service.CondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CondimentController {
    @Autowired
    private CondimentService condimentService;
    @RequestMapping(value = "/")
    private String getHomepage(){
        return "homepage";
    }

    @RequestMapping(value = "/condiment")
    private ModelAndView save (@RequestParam(value = "lettuce",required = false) String lettuce, String tomato, String mustard, String sprouts ){
        ArrayList<String> stringList = condimentService.showList();
        if (lettuce!=null){
            stringList.add(lettuce);
        }
        if (tomato!=null){
            stringList.add(tomato);
        }
        if (mustard!=null){
            stringList.add(mustard);
        }
        if (sprouts!=null){
            stringList.add(sprouts);
        }
        return new ModelAndView("result","lists",stringList);
    }
}
