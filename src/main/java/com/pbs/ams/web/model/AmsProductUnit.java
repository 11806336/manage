package com.pbs.ams.web.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AmsProductUnit implements Serializable {
    /**
     * 账号ID
     *
     * @mbg.generated
     */
    private Long productUnitId;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Long companyId;

    /**
     * 交易账号
     *
     * @mbg.generated
     */
    private Long tradeAccount;

    /**
     * 账号名称
     *
     * @mbg.generated
     */
    private String productUnitName;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String tradeAccountPassword;

    /**
     * 证券公司ID
     *
     * @mbg.generated
     */
    private Long brokerId;

    /**
     * 账号状态
     *
     * @mbg.generated
     */
    private String tradeAccountStatus;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Long createTime;

    /**
     * 修改时间
     *
     * @mbg.generated
     */
    private Long updateTime;

    /**
     * 操作人ID
     *
     * @mbg.generated
     */
    private Long operatorId;

    private String tableName;

    private static final long serialVersionUID = 1L;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(Long productUnitId) {
        this.productUnitId = productUnitId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getTradeAccount() {
        return tradeAccount;
    }

    public void setTradeAccount(Long tradeAccount) {
        this.tradeAccount = tradeAccount;
    }

    public String getProductUnitName() {
        return productUnitName;
    }

    public void setProductUnitName(String productUnitName) {
        this.productUnitName = productUnitName;
    }

    public String getTradeAccountPassword() {
        return tradeAccountPassword;
    }

    public void setTradeAccountPassword(String tradeAccountPassword) {
        this.tradeAccountPassword = tradeAccountPassword;
    }

    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

    public String getTradeAccountStatus() {
        return tradeAccountStatus;
    }

    public void setTradeAccountStatus(String tradeAccountStatus) {
        this.tradeAccountStatus = tradeAccountStatus;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        if (null != this.getTableName() && !"".equals(this.getTableName())) {
            map.put("goodsTitles", this.getTableName());
        }
        return map;
    }
}