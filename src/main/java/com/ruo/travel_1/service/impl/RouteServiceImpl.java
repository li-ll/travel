package com.ruo.travel_1.service.impl;

import com.ruo.travel_1.domain.Category;
import com.ruo.travel_1.domain.Route;
import com.ruo.travel_1.domain.RouteImg;
import com.ruo.travel_1.domain.Seller;
import com.ruo.travel_1.mapper.CategoryMapper;
import com.ruo.travel_1.mapper.FavoriteMapper;
import com.ruo.travel_1.mapper.RouteMapper;
import com.ruo.travel_1.service.RouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RouteServiceImpl implements RouService {
    @Autowired
    private RouteMapper routeMapper;
    @Autowired
    private FavoriteMapper favoriteMapper;
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Route> findAll(int cid) {
        return routeMapper.findAll(cid);
    }

    @Override
    public Route findOne(int rid) {

        //1.根据id去route表中查询route对象
        Route route=routeMapper.findOne(rid);

        //2.根据route的id 查询图片集合信息
        List<RouteImg> routeImgList=routeMapper.findByRid(route.getRid());

        //2.2将集合设置到route对象
        route.setRouteImgList(routeImgList);

        //3.根据route的sid（商家id）查询商家对象
        Seller seller=routeMapper.findById(route.getSid());
        route.setSeller(seller);
        //4. 查询收藏次数
        int count=favoriteMapper.findCountByRid(route.getRid());
        route.setCount(count);
/*
        Category category=categoryMapper.*/


        return route;
    }

    @Override
    public List<Route> findByCount() {
        return routeMapper.findByCount();
    }

    @Override
    public List<Route> findByFuzzyQuery(String str) {
        String key="%"+str+"%";
        return routeMapper.findByFuzzyQuery(key);
    }
}
