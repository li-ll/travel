package com.ruo.travel_1.service;

import com.ruo.travel_1.domain.Favorite;
import com.ruo.travel_1.domain.Route;

import java.util.Date;
import java.util.List;

public interface FavoriteService {
    /**
     * 判断是否收藏
     * @param rid
     * @param uid
     * @return
     */
    public boolean isFavorite(Integer  rid, int uid);

    /**
     * 添加收藏
     */
    void add(int rid, Date date, int uid);

    /**
     * 删除收藏
     * @param rid
     * @param uid
     */
    void deleteByRidAndUid(int rid,int uid);

    /**
     * 个人收藏
     * @param uid
     * @return
     */
    List<Favorite> findByUid(Integer uid );

}
