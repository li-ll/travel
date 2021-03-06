package com.ruo.travel_1.service;

import com.ruo.travel_1.domain.Route;

import java.util.List;

public interface RouService {
    /**
     * 分页查询
     * @param cid
     * @return
     */
    public List<Route> findAll(int cid);

    /**
     * 根据id查询
     *
     * @param rid
     * @return
     */
    public Route findOne(int rid);


    /**
     * 查询收藏大于50的
     * @return
     */
    List<Route> findByCount();
    /**
     * 模糊查询
     * @param str
     * @return
     */
    List<Route>findByFuzzyQuery( String str);

}
