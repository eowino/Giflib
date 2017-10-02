package com.eo.giflib.controller;

import com.eo.giflib.data.GifRepository;
import com.eo.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by evansowino on 29/09/2017.
 */
@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap) {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping("/favorites")
    public String getFavorites(ModelMap modelMap) {
        modelMap.put("gifs", gifRepository.getAllFavorites());
        return "favorites";
    }


    @RequestMapping("/gif/{name}")
    public String getDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/search")
    public String searchByName(@RequestParam String q, ModelMap modelMap) {
        String result = "error";
        Gif gif = gifRepository.findByName(q);

        if(gif != null) {
            modelMap.put("gif", gif);
            result = "gif-details";
        } else {
            modelMap.put("gifs", gifRepository.getAllGifs());
        }

        return result;
    }
}
