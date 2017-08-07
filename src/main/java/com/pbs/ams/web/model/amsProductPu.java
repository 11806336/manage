package com.pbs.ams.web.model;

import java.io.Serializable;

public class amsProductPu implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Long productPuId;

    /**
     * 产品ID
     *
     * @mbg.generated
     */
    private Long productId;

    /**
     * 账号ID
     *
     * @mbg.generated
     */
    private Long productUnitId;

    private static final long serialVersionUID = 1L;

    public Long getProductPuId() {
        return productPuId;
    }

    public void setProductPuId(Long productPuId) {
        this.productPuId = productPuId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(Long productUnitId) {
        this.productUnitId = productUnitId;
    }
}