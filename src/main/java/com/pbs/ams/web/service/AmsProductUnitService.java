package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsProductUnit;
import com.pbs.ams.web.model.AmsProductUnitSnaps;

import java.util.List;
import java.util.Map;

/**
* AmsTradeAccountService接口
* Created by ams on 2017/6/29.
*/
public interface AmsProductUnitService {

    int deleteByPrimaryKey(Long id);

    /**
     * 根据id删除账号
     * @param ids 券商id
     * @return
     */
    int deleteByPrimaryKeys(List<Long> ids);

    int insert(AmsProductUnit record);

    /**
     * 新增账号
     * @param record 账号实体
     * @return
     */
    int insertSelective(AmsProductUnit record);

    /**
     * 根据id查询单条记录
     * @param id 券商id
     * @return
     */
    AmsProductUnit selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsProductUnit record);

    /**
     *编辑券商
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AmsProductUnit record);

    /**
     * 修改账号状态
     * @param id 账号id
     * @param status 账号状态
     * @return
     */
    int updateAccountStatusById(Long id, Integer status);
    /**
     * 向快照表中插入数据
     * @return
     */

    int insertIntoAmsProductUnitSnaps(AmsProductUnitSnaps amsProductUnitSnaps);

    /**
     * This method is used to get PageList data.
     * @param map
     * @return
     */
    List<Map> selectProductUnitWithDetail(Map map);

    /**
     * This method is used to get PageListTotalSize
     * @param map
     * @return
     */
    int selectProductUnitWithDetailCount(Map map);

    AmsProductUnit selectProductUnitByUnit(Long Unit);
}