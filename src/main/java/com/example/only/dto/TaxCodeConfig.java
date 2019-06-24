package com.example.only.dto;

import java.io.Serializable;

/**
 * 项目名称: 票易通IMSC
 * 模块名称:
 * 说明:
 * JDK 版本: JDK1.8
 * 作者(@author)：wuhaojie
 * 创建日期：2017/10/18
 */
public class TaxCodeConfig implements Serializable {
    private static final long serialVersionUID = -1L;

    private Long id;
    /**
     * 税编转换代码
     */
    private String taxConvertCode;
    /**
     * 租户代码
     */
    private String tenantCode;
    /**
     * 租户名称
     */
    private String tenantName;
    /**
     * 税收分类编码
     */
    private String goodsTaxNo;
    /**
     * 税局货物名称
     */
    private String standardItemName;
    /**
     * 货物及服务代码
     */
    private String itemCode;
    /**
     * 商品和服务名称
     */
    private String itemName;
    /**
     * 是否享受税收优惠政策0-不1-享受
     */
    private String taxPre;
    /**
     * 享受税收优惠政策内容
     */
    private String taxPreCon;
    /**
     * 零税率标志空-非0税率；0-出口退税1-免税2-不征税3-普通0税率
     */
    private String zeroTax;
    /**
     * 大类名称
     */
    private String largeCategoryName;
    /**
     * 大类编码
     */
    private String largeCategoryCode;
    /**
     * 中类名称
     */
    private String medianCategoryName;
    /**
     * 中类编码
     */
    private String medianCategoryCode;
    /**
     * 小类名称
     */
    private String smallCategoryName;
    /**
     * 小类编码
     */
    private String smallCategoryCode;
    /**
     * 创建用户
     */
    private String createUserId;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新用户
     */
    private String updateUserId;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 0:待处理 1:待确认 2:已生效
     */
    private String status = "0";
    /**
     * 税率
     */
    private String taxRate = "0.00";
    /**
     * 扩展字段1
     */
    private String ext1;
    /**
     * 扩展字段2
     */
    private String ext2;
    /**
     * 扩展字段3
     */
    private String ext3;
    /**
     * 扩展字段4
     */
    private String ext4;
    /**
     * 扩展字段5
     */
    private String ext5;

    private String itemSpec = "";
    private String quantityUnit = "";

    public TaxCodeConfig() {
    }

    public TaxCodeConfig(String itemName, String taxRate) {
        this.itemName = itemName;
        this.taxRate = taxRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxConvertCode() {
        return taxConvertCode;
    }

    public void setTaxConvertCode(String taxConvertCode) {
        this.taxConvertCode = taxConvertCode;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getGoodsTaxNo() {
        return goodsTaxNo;
    }

    public void setGoodsTaxNo(String goodsTaxNo) {
        this.goodsTaxNo = goodsTaxNo;
    }

    public String getStandardItemName() {
        return standardItemName;
    }

    public void setStandardItemName(String standardItemName) {
        this.standardItemName = standardItemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getTaxPre() {
        return taxPre;
    }

    public void setTaxPre(String taxPre) {
        this.taxPre = taxPre;
    }

    public String getTaxPreCon() {
        return taxPreCon;
    }

    public void setTaxPreCon(String taxPreCon) {
        this.taxPreCon = taxPreCon;
    }

    public String getZeroTax() {
        return zeroTax;
    }

    public void setZeroTax(String zeroTax) {
        this.zeroTax = zeroTax;
    }

    public String getLargeCategoryName() {
        return largeCategoryName;
    }

    public void setLargeCategoryName(String largeCategoryName) {
        this.largeCategoryName = largeCategoryName;
    }

    public String getLargeCategoryCode() {
        return largeCategoryCode;
    }

    public void setLargeCategoryCode(String largeCategoryCode) {
        this.largeCategoryCode = largeCategoryCode;
    }

    public String getMedianCategoryName() {
        return medianCategoryName;
    }

    public void setMedianCategoryName(String medianCategoryName) {
        this.medianCategoryName = medianCategoryName;
    }

    public String getMedianCategoryCode() {
        return medianCategoryCode;
    }

    public void setMedianCategoryCode(String medianCategoryCode) {
        this.medianCategoryCode = medianCategoryCode;
    }

    public String getSmallCategoryName() {
        return smallCategoryName;
    }

    public void setSmallCategoryName(String smallCategoryName) {
        this.smallCategoryName = smallCategoryName;
    }

    public String getSmallCategoryCode() {
        return smallCategoryCode;
    }

    public void setSmallCategoryCode(String smallCategoryCode) {
        this.smallCategoryCode = smallCategoryCode;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    @Override
    public String toString() {
        return "TaxCodeConfig{" +
                "id='" + id + '\'' +
                ", taxConvertCode='" + taxConvertCode + '\'' +
                ", tenantCode='" + tenantCode + '\'' +
                ", tenantName='" + tenantName + '\'' +
                ", goodsTaxNo='" + goodsTaxNo + '\'' +
                ", standardItemName='" + standardItemName + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", taxPre='" + taxPre + '\'' +
                ", taxPreCon='" + taxPreCon + '\'' +
                ", zeroTax='" + zeroTax + '\'' +
                ", largeCategoryName='" + largeCategoryName + '\'' +
                ", largeCategoryCode='" + largeCategoryCode + '\'' +
                ", medianCategoryName='" + medianCategoryName + '\'' +
                ", medianCategoryCode='" + medianCategoryCode + '\'' +
                ", smallCategoryName='" + smallCategoryName + '\'' +
                ", smallCategoryCode='" + smallCategoryCode + '\'' +
                ", createUserId='" + createUserId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateUserId='" + updateUserId + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", status='" + status + '\'' +
                ", taxRate='" + taxRate + '\'' +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                ", ext4='" + ext4 + '\'' +
                ", ext5='" + ext5 + '\'' +
                ", itemSpec='" + itemSpec + '\'' +
                ", quantityUnit='" + quantityUnit + '\'' +
                '}';
    }
}