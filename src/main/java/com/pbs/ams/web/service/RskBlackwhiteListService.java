package com.pbs.ams.web.service;

import com.pbs.ams.web.model.RskBlackwhiteList;

import java.util.List;
import java.util.Map;

/**
* RskBlackwhiteListService接口
* Created by ams on 2017/7/28.
*/
public interface RskBlackwhiteListService{

    List<Map<String, Object>> selectBlackWhite(Map<String, Object> params);

    int selectBlackWhiteCount(Map<String, Object> params);

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(RskBlackwhiteList record);

    int insertSelective(RskBlackwhiteList record);

    RskBlackwhiteList selectByPrimaryKey(Long id);

    int updateByPrimaryKey(RskBlackwhiteList record);

    int updateByPrimaryKeySelective(RskBlackwhiteList record);

    int insertToRskBlackwhiteListSnaps();

    int deleteByIsBlack(Integer isBlack);
}