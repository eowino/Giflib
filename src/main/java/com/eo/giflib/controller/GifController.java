package com.eo.giflib.controller;

import com.eo.giflib.model.Gif;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

/**
 * Created by evansowino on 29/09/2017.
 */
@Controller
public class GifController {

    @RequestMapping("/")
    public String listGifs() {
        return "home";
    }

    @RequestMapping("/favourites")
    public String getFavourites() {
        return "favourites";
    }

    @RequestMapping("/categories")
    public String getCategories() {
        return "categories";
    }

    @RequestMapping("/category")
    public String getCategory() {
        return "category";
    }

    @RequestMapping("/gif")
    public String getDetails(ModelMap modelMap) {
        Gif gif = new Gif("compiler-bot", LocalDate.of(2017, 9, 29), "mBot", true);
        modelMap.put("gif", gif);
        return "gif-details";
    }
}
