package com.example.controller;

import com.example.model.Song;
import com.example.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;
    @GetMapping
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Song> songs = songService.findAll();
        modelAndView.addObject("songs",songs);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id){
        Song song = songService.findById(id);
        if (song != null){
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("song", song);
        return modelAndView;
    } else {
        ModelAndView modelAndView = new ModelAndView("error.404");
        return modelAndView;
        }
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("song") Song song, Model model){
        songService.save(song);
        model.addAttribute("song",song);
        return "update";
    }
}
