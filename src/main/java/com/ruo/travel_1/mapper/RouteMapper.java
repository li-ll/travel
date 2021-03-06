package com.ruo.travel_1.mapper;

import com.ruo.travel_1.domain.Route;
import com.ruo.travel_1.domain.RouteImg;
import com.ruo.travel_1.domain.Seller;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RouteMapper {
    /**
     * 分页查询
     * @param rid
     * @return
     */
    public List<Route> findAll(int rid);

    /**
     * 根据id查询
     *
     * @param rid
     * @return
     */
    public Route findOne(int rid);

    /**
     * 查找图片
     * @param rid
     * @return
     */
    public List<RouteImg> findByRid(int rid);

    /**
     * 根据id查询商户
     * @param id
     * @return
     */
    public Seller findById(int id);

    /**
     * 查询收藏大于50的
     * @return
     */
    List<Route> findByCount();

    /**
     * 模糊查询
     * @param s
     * @return
     */
    List<Route>findByFuzzyQuery(@Param("rname") String s);

}
