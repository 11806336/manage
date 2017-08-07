package com.pbs.ams.web.model;

import java.io.Serializable;

public class RskBlackwhiteListSnaps implements Serializable {
    /**
     * 快照时间
     *
     * @mbg.generated
     */
    private Long snapsTime;

    /**
     * 黑白名单ID
     *
     * @mbg.generated
     */
    private Long blackwhiteId;

    /**
     * 黑白名单名称
     *
     * @mbg.generated
     */
    private String blackwhiteName;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Long companyId;

    /**
     * 金融工具ID
     *
     * @mbg.generated
     */
    private Long finInstrId;

    /**
     * 金融工具类型
     *
     * @mbg.generated
     */
    private Integer finInstrType;

    /**
     * 黑白名单范围(字典表查询)
     *
     * @mbg.generated
     */
    private Integer blackwhiteListType;

    /**
     * 1:黑名单 0:白名单
     *
     * @mbg.generated
     */
    private Boolean isBlack;

    /**
     * 是否生效 1:是 0:否
     *
     * @mbg.generated
     */
    private Integer isEffective;

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

    public Long getSnapsTime() {
        return snapsTime;
    }

    public void setSnapsTime(Long snapsTime) {
        this.snapsTime = snapsTime;
    }

    public Long getBlackwhiteId() {
        return blackwhiteId;
    }

    public void setBlackwhiteId(Long blackwhiteId) {
        this.blackwhiteId = blackwhiteId;
    }

    public String getBlackwhiteName() {
        return blackwhiteName;
    }

    public void setBlackwhiteName(String blackwhiteName) {
        this.blackwhiteName = blackwhiteName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getFinInstrId() {
        return finInstrId;
    }

    public void setFinInstrId(Long finInstrId) {
        this.finInstrId = finInstrId;
    }

    public Integer getFinInstrType() {
        return finInstrType;
    }

    public void setFinInstrType(Integer finInstrType) {
        this.finInstrType = finInstrType;
    }

    public Integer getBlackwhiteListType() {
        return blackwhiteListType;
    }

    public void setBlackwhiteListType(Integer blackwhiteListType) {
        this.blackwhiteListType = blackwhiteListType;
    }

    public Boolean getIsBlack() {
        return isBlack;
    }

    public void setIsBlack(Boolean isBlack) {
        this.isBlack = isBlack;
    }

    public Integer getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Integer isEffective) {
        this.isEffective = isEffective;
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