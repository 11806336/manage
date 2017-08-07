package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsProductUnitExt;

import java.util.List;
import java.util.Map;


/**
* AmsTradeAccountExtService接口
* Created by ams on 2017/7/13.
*/
public interface AmsProductUnitExtService {

    List<Map> selectAmsProductUnitExtWithDetail(Map map);

    long selectAmsProductUnitExtWithDetailCount(Map map);

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsProductUnitExt record);

    int insertSelective(AmsProductUnitExt record);

    AmsProductUnitExt selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsProductUnitExt record);

    int updateByPrimaryKeySelective(AmsProductUnitExt record);

    int insertToAmsProductUnitExtSnaps();
}