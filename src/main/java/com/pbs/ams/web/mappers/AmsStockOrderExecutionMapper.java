package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStockOrderExecution;

import java.util.List;
import java.util.Map;

public interface AmsStockOrderExecutionMapper {
    int deleteByPrimaryKey(Long stockOrderExecutionId);

    int insert(AmsStockOrderExecution record);

    int insertSelective(AmsStockOrderExecution record);

    AmsStockOrderExecution selectByPrimaryKey(Long stockOrderExecutionId);

    int updateByPrimaryKeySelective(AmsStockOrderExecution record);

    int updateByPrimaryKey(AmsStockOrderExecution record);

    /**
     * This method is used to get PageList data.查询成交记录
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
}