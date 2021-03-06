package com.ruo.travel_1.controller;

import com.ruo.travel_1.domain.Category;
import com.ruo.travel_1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @ResponseBody
    @RequestMapping("/findAll")
    public List<Category>findAll(){
        List <Category>ls=categoryService.findAll();
        return ls;
    }
}
