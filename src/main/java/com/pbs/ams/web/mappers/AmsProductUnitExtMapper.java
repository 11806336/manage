package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProductUnitExt;

import java.util.List;
import java.util.Map;

public interface AmsProductUnitExtMapper {

    List<Map> selectAmsProductUnitExtWithDetail(Map map);

    long selectAmsProductUnitExtWithDetailCount(Map map);

    int deleteByPrimaryKey(Long productUnitId);

    int insert(AmsProductUnitExt record);

    int insertSelective(AmsProductUnitExt record);

    AmsProductUnitExt selectByPrimaryKey(Long productUnitId);

    int updateByPrimaryKeySelective(AmsProductUnitExt record);

    int updateByPrimaryKey(AmsProductUnitExt record);
}