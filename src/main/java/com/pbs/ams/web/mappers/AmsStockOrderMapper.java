package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStockOrder;

import java.util.List;
import java.util.Map;

public interface AmsStockOrderMapper {
    int deleteByPrimaryKey(Long stockOrderId);

    int insert(AmsStockOrder record);

    int insertSelective(AmsStockOrder record);

    AmsStockOrder selectByPrimaryKey(Long stockOrderId);

    int updateByPrimaryKeySelective(AmsStockOrder record);

    int updateByPrimaryKey(AmsStockOrder record);

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
}