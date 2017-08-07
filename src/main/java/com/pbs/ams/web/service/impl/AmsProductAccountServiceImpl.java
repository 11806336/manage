package com.pbs.ams.web.service.impl;

import com.pbs.ams.web.mappers.AmsProductPuMapper;
import com.pbs.ams.web.model.amsProductPu;
import com.pbs.ams.web.service.AmsProductAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* AmsProductAccountService实现
* Created by ams on 2017/6/29.
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsProductAccountServiceImpl implements AmsProductAccountService {

    @Autowired
    private AmsProductPuMapper amsProductPuMapper;


    @Override
    public amsProductPu getProductIdByAccountId(Long acountId) {
        return amsProductPuMapper.getProductIdByAccountId(acountId);
    }

    @Override
    public int deleteByPrimaryKey(Long productTradeAccountId) {
        return 0;
    }

    @Override
    public int insert(amsProductPu record) {
        return 0;
    }

    @Override
    public int insertSelective(amsProductPu record) {
        return amsProductPuMapper.insertSelective(record);
    }

    @Override
    public amsProductPu selectByPrimaryKey(Long productTradeAccountId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(amsProductPu record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(amsProductPu record) {
        return 0;
    }
}