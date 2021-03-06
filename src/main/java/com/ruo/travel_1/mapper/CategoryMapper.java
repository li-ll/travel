package com.ruo.travel_1.mapper;

import com.ruo.travel_1.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryMapper {
    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();
}
