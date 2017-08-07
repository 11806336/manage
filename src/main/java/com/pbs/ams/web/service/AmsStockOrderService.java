package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsStockOrder;

import java.util.List;
import java.util.Map;

/**
* AmsStockOrderService接口
* Created by ams on 2017/8/3.
*/
public interface AmsStockOrderService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsStockOrder record);

    int insertSelective(AmsStockOrder record);

    AmsStockOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsStockOrder record);

    int updateByPrimaryKeySelective(AmsStockOrder record);

    /**
     * This method is used to get PageList data.查询委托列表
     * @param map
     * @return
     */
    List<Map> selectAmsStockOrderWithDetail(Map map);

    /**
     * This method is used to get PageListTotalSize
     * @param map
     * @return
     */
    int selectAmsStockOrderWithDetailCount(Map map);

    int insertToAmsStockOrderSnaps();
}