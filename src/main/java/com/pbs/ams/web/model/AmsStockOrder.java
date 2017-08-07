package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmsStockOrder implements Serializable {
    /**
     * 委托ID
     *
     * @mbg.generated
     */
    private Long stockOrderId;

    /**
     * 合约编号
     *
     * @mbg.generated
     */
    private String contractId;

    /**
     * 委托状态
     *
     * @mbg.generated
     */
    private Byte stockOrderStatus;

    /**
     * 委托时间
     *
     * @mbg.generated
     */
    private Long stockOrderDate;

    /**
     * 成交均价
     *
     * @mbg.generated
     */
    private BigDecimal knockAvgPrice;

    /**
     * 已撤数量
     *
     * @mbg.generated
     */
    private Integer cancelQty;

    /**
     * 委托类别(买1/卖2)
     *
     * @mbg.generated
     */
    private Byte stockOrderType;

    /**
     * ip来源
     *
     * @mbg.generated
     */
    private String ipSource;

    /**
     * MAC地址
     *
     * @mbg.generated
     */
    private String macAddress;

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

    private static final long serialVersionUID = 1L;

    public Long getStockOrderId() {
        return stockOrderId;
    }

    public void setStockOrderId(Long stockOrderId) {
        this.stockOrderId = stockOrderId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Byte getStockOrderStatus() {
        return stockOrderStatus;
    }

    public void setStockOrderStatus(Byte stockOrderStatus) {
        this.stockOrderStatus = stockOrderStatus;
    }

    public Long getStockOrderDate() {
        return stockOrderDate;
    }

    public void setStockOrderDate(Long stockOrderDate) {
        this.stockOrderDate = stockOrderDate;
    }

    public BigDecimal getKnockAvgPrice() {
        return knockAvgPrice;
    }

    public void setKnockAvgPrice(BigDecimal knockAvgPrice) {
        this.knockAvgPrice = knockAvgPrice;
    }

    public Integer getCancelQty() {
        return cancelQty;
    }

    public void setCancelQty(Integer cancelQty) {
        this.cancelQty = cancelQty;
    }

    public Byte getStockOrderType() {
        return stockOrderType;
    }

    public void setStockOrderType(Byte stockOrderType) {
        this.stockOrderType = stockOrderType;
    }

    public String getIpSource() {
        return ipSource;
    }

    public void setIpSource(String ipSource) {
        this.ipSource = ipSource;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
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
}