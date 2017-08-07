package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsStockOrderExecution;

import java.util.List;
import java.util.Map;

/**
* AmsStockOrderExecutionService接口
* Created by ams on 2017/8/3.
*/
public interface AmsStockOrderExecutionService{

    /**
     * This method is used to get PageList data.查询委托列表
     * @param map
     * @return
     */
    List<Map> selectStockOrderExecutionWithDetail(Map map);

    /**
     * This method is used to get PageListTotalSize
     * @param map
     * @return
     */
    int selectStockOrderExecutionWithDetailCount(Map map);

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsStockOrderExecution record);

    int insertSelective(AmsStockOrderExecution record);

    AmsStockOrderExecution selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsStockOrderExecution record);

    int updateByPrimaryKeySelective(AmsStockOrderExecution record);

    int insertToAmsStockOrderExecutionSnaps();
}