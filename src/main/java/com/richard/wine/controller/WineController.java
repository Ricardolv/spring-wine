package com.richard.wine.controller;

import com.richard.wine.model.TypeWine;
import com.richard.wine.model.Wine;
import com.richard.wine.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class WineController {

    @Autowired
    private WineService wineService;

    @GetMapping("/wine/new")
    public ModelAndView wineNew(Wine wine) {
        ModelAndView mv = new ModelAndView("wine/Register-wine");
        mv.addObject("types", TypeWine.values());
        return mv;
    }

    @PostMapping("/wine/new")
    public  ModelAndView save(@Valid Wine wine, BindingResult result) {

        if (result.hasErrors())
            return wineNew(wine);

        wineService.save(wine);
        return  new ModelAndView("redirect:/wine/new");
    }

}
