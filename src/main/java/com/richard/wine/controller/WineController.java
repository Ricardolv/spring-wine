package com.richard.wine.controller;

import com.richard.wine.model.TypeWine;
import com.richard.wine.model.Wine;
import com.richard.wine.service.WineService;
import com.richard.wine.service.filter.WineFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/wines")
public class WineController {

    @Autowired
    private WineService wineService;

    @GetMapping("/new")
    public ModelAndView wineNew(Wine wine) {
        ModelAndView mv = new ModelAndView("wine/register-wine");
        mv.addObject(wine);
        mv.addObject("types", TypeWine.values());
        return mv;
    }

    @PostMapping("/new")
    public  ModelAndView save(@Valid Wine wine, BindingResult result,
                              RedirectAttributes attributes) {

        if (result.hasErrors())
            return wineNew(wine);

        wineService.save(wine);
        attributes.addFlashAttribute("message", "Vinho salvo com sucesso");
        return  new ModelAndView("redirect:/wines/new");
    }

    @GetMapping
    public ModelAndView search(WineFilter wineFilter) {
        ModelAndView mv = new ModelAndView("wine/search-wine");
        mv.addObject("wines", wineService.findByNameContainingIgnoreCase(
                                            Optional.ofNullable(wineFilter.getNameFilter()).orElse("%")));
        return mv;
    }

    @GetMapping("/{code}")
    public ModelAndView edit(@PathVariable Long code) {
        Wine wine = wineService.findOne(code);
        return wineNew(wine);
    }

    @DeleteMapping("/{code}")
    public String delete(@PathVariable Long code ,
                         RedirectAttributes attributes) {
        wineService.delete(code);
        attributes.addFlashAttribute("message", "Vinho removido com sucesso");
        return "redirect:/wines";
    }

}
