package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProductUnit;
import com.pbs.ams.web.model.AmsProductUnitSnaps;

import java.util.List;
import java.util.Map;

public interface AmsProductUnitMapper {
    int deleteByPrimaryKey(Long productUnitId);

    int insert(AmsProductUnit record);

    int insertSelective(AmsProductUnit record);

    AmsProductUnit selectByPrimaryKey(Long productUnitId);

    int updateByPrimaryKeySelective(AmsProductUnit record);

    int updateByPrimaryKey(AmsProductUnit record);

    List<Map> selectProductUnitWithDetail(Map map);

    int selectProductUnitWithDetailCount(Map map);

    int insertIntoAmsProductUnitSnaps(AmsProductUnitSnaps snaps);

    AmsProductUnit selectProductUnitByUnit(Long Unit);
}