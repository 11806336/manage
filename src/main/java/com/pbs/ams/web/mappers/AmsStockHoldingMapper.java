package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStockHolding;

import java.util.List;
import java.util.Map;

public interface AmsStockHoldingMapper {
    int deleteByPrimaryKey(Long stockHoldingId);

    int insert(AmsStockHolding record);

    int insertSelective(AmsStockHolding record);

    AmsStockHolding selectByPrimaryKey(Long stockHoldingId);

    int updateByPrimaryKeySelective(AmsStockHolding record);

    int updateByPrimaryKey(AmsStockHolding record);

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
}