package com.pbs.ams.web.service;

import com.pbs.ams.web.model.amsProductPu;

/**
* AmsProducAccounttService
* Created by ams on 2017/6/28.
*/
public interface AmsProductAccountService {

    amsProductPu getProductIdByAccountId(Long acountId);

    int deleteByPrimaryKey(Long productTradeAccountId);

    int insert(amsProductPu record);

    int insertSelective(amsProductPu record);

    amsProductPu selectByPrimaryKey(Long productTradeAccountId);

    int updateByPrimaryKeySelective(amsProductPu record);

    int updateByPrimaryKey(amsProductPu record);
}