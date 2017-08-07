package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsStockHolding;

import java.util.List;
import java.util.Map;

/**
* AmsStockHoldingService接口
* Created by ams on 2017/7/31.
*/
public interface AmsStockHoldingService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsStockHolding record);

    int insertSelective(AmsStockHolding record);

    AmsStockHolding selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsStockHolding record);

    int updateByPrimaryKeySelective(AmsStockHolding record);

    /**
     * This method is used to get PageList data.
     * @param map
     * @return
     */
    List<Map> selectStockHoldingWithDetail(Map map);

    /**
     * This method is used to get PageListTotalSize
     * @param map
     * @return
     */
    int selectStockHoldingWithDetailCount(Map map);

    int insertToAmsStockHoldingSnaps();
}