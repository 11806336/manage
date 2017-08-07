package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmsStockOrderExecution implements Serializable {
    /**
     * 成交ID
     *
     * @mbg.generated
     */
    private Long stockOrderExecutionId;

    /**
     * 合同编号
     *
     * @mbg.generated
     */
    private String contractId;

    /**
     * 成交价格
     *
     * @mbg.generated
     */
    private BigDecimal knockPrice;

    /**
     * 成交数量
     *
     * @mbg.generated
     */
    private Integer knockQty;

    /**
     * 成交时间
     *
     * @mbg.generated
     */
    private Long knockDate;

    /**
     * 成交金额
     *
     * @mbg.generated
     */
    private BigDecimal knockAmount;

    /**
     * 委托类别(1:买 2卖)
     *
     * @mbg.generated
     */
    private Boolean stockOrderType;

    /**
     * 手续费
     *
     * @mbg.generated
     */
    private BigDecimal fee;

    /**
     * 操作人ID
     *
     * @mbg.generated
     */
    private Long operatorId;

    private static final long serialVersionUID = 1L;

    public Long getStockOrderExecutionId() {
        return stockOrderExecutionId;
    }

    public void setStockOrderExecutionId(Long stockOrderExecutionId) {
        this.stockOrderExecutionId = stockOrderExecutionId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getKnockPrice() {
        return knockPrice;
    }

    public void setKnockPrice(BigDecimal knockPrice) {
        this.knockPrice = knockPrice;
    }

    public Integer getKnockQty() {
        return knockQty;
    }

    public void setKnockQty(Integer knockQty) {
        this.knockQty = knockQty;
    }

    public Long getKnockDate() {
        return knockDate;
    }

    public void setKnockDate(Long knockDate) {
        this.knockDate = knockDate;
    }

    public BigDecimal getKnockAmount() {
        return knockAmount;
    }

    public void setKnockAmount(BigDecimal knockAmount) {
        this.knockAmount = knockAmount;
    }

    public Boolean getStockOrderType() {
        return stockOrderType;
    }

    public void setStockOrderType(Boolean stockOrderType) {
        this.stockOrderType = stockOrderType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
}