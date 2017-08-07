package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.RskBlackwhiteList;

import java.util.List;
import java.util.Map;

public interface RskBlackwhiteListMapper {

    List<Map<String, Object>> selectBlackWhite(Map<String, Object> params);

    int selectBlackWhiteCount(Map<String, Object> params);

    int deleteByPrimaryKey(Long blackwhiteId);

    int insert(RskBlackwhiteList record);

    int insertSelective(RskBlackwhiteList record);

    RskBlackwhiteList selectByPrimaryKey(Long blackwhiteId);

    int updateByPrimaryKeySelective(RskBlackwhiteList record);

    int updateByPrimaryKey(RskBlackwhiteList record);

    /**
     * 判断黑/白名单   删除
     * @param isBlack
     * @return
     */
    int deleteByIsBlack(Integer isBlack);
}