package com.example.demo.controller;

import com.example.demo.dto.SongDto;
import com.example.demo.model.entity.Song;
import com.example.demo.model.service.SongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value = "/song")
public class SongController {
    @Autowired
    private SongService songService;
    @RequestMapping(value = "/list")
    public ModelAndView viewAll(@PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("/song/list","songList",songService.findAll(pageable));
    }

    @RequestMapping(value = "/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("/song/create","newSongDto",new SongDto());
    }

    @PostMapping(value = "/create")
    public ModelAndView create (@Validated @ModelAttribute ("newSongDto") SongDto newSongDto , BindingResult bindingResult){
        new SongDto().validate(newSongDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/song/create");
        }else {
            Song newSong = new Song();
            BeanUtils.copyProperties(newSongDto,newSong);
            songService.save(newSong);
            return new ModelAndView("redirect:/song/list");
        }
    }
}
