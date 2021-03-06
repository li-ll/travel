package com.ruo.travel_1.service.impl;

import com.ruo.travel_1.domain.Category;
import com.ruo.travel_1.mapper.CategoryMapper;
import com.ruo.travel_1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> findAll() {
        return categoryMapper.findAll();
    }
}
