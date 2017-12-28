package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.City;
import com.example.demo.service.CityService;

@RestController
public class CityController {
	@Autowired
    private CityService cityService;
	
	@RequestMapping(value = "/initpage", method = RequestMethod.GET)
    public ModelAndView doView() {
		List<City> cityList = cityService.findAllCity();
        ModelAndView mv = new ModelAndView("cityList");
        mv.addObject("cityList", cityList);
        return mv;
    }

    @RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
    public String findOneCity(Model model, @PathVariable("id") Long id) {
        model.addAttribute("city", cityService.findCityById(id));
        return "city";
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public String findAllCity(Model model) {
        List<City> cityList = cityService.findAllCity();
        model.addAttribute("cityList",cityList);
        return "cityList";
    }
}
