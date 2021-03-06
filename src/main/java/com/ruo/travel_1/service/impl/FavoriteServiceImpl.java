package com.ruo.travel_1.service.impl;

import com.ruo.travel_1.domain.Favorite;
import com.ruo.travel_1.mapper.FavoriteMapper;
import com.ruo.travel_1.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;


    @Override
    public boolean isFavorite(Integer  rid, int uid) {
        Favorite favorite=favoriteMapper.findByRidAndUid(rid,uid);
        return favorite!=null;//如果对象有值，则为true，反之，则为false
    }

    @Override
    public void add(int rid,Date date, int uid) {
      favoriteMapper.add(rid, date ,uid);
    }

    @Override
    public void deleteByRidAndUid(int rid, int uid) {
        favoriteMapper.deleteByRidAndUid(rid,uid);

    }


    @Override
    public List<Favorite> findByUid(Integer uid) {
        return favoriteMapper.findByUid(uid);
    }
}
