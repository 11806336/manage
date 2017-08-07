package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.amsProductPu;

public interface AmsProductPuMapper {

    amsProductPu getProductIdByAccountId(Long acountId);

    int deleteByPrimaryKey(Long productTradeAccountId);

    /**
     * This method is used to bind Account and Product
     * @param record
     * @return
     */
    int insert(amsProductPu record);

    int insertSelective(amsProductPu record);

    amsProductPu selectByPrimaryKey(Long productTradeAccountId);

    int updateByPrimaryKeySelective(amsProductPu record);

    int updateByPrimaryKey(amsProductPu record);
}