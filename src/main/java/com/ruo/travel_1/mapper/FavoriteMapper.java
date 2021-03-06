package com.ruo.travel_1.mapper;

import com.ruo.travel_1.domain.Favorite;
import com.ruo.travel_1.domain.Route;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FavoriteMapper {

    /**
     * 根据rid和uid查询收藏信息
     * @param rid
     * @param uid
     * @return
     */
    public Favorite findByRidAndUid(Integer rid, int uid);

    /**
     * 根据rid 查询收藏次数
     * @param rid
     * @return
     */
    public int findCountByRid(int rid);

    /**
     * 添加收藏
     */
    void add(int rid, Date date, int uid);

    void deleteByRidAndUid(int rid,int uid);

    /**
     * 查询收藏排行
     * @return
     */
    List<Route> findByCount();

    List<Favorite> findByUid(Integer uid );
}
