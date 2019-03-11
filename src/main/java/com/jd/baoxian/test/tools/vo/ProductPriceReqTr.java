package com.jd.baoxian.test.tools.vo;

public class ProductPriceReqTr extends BaseReq {
	/**
	 * 产品编号
	 */
	private String productCode;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 性别 1男 2女
	 */
	private Integer gender;
	/**
	 * 交费期限
	 */
	private String payPeriod;
	/**
	 * 交费期限类型
	 */
	private String payPeriodType;
	/**
	 * 社保 false为无社保项 true为有社保项
	 */
	private String socialSecurity;
	/**
	 * 保额
	 */
	private String amount;
	/**
	 * 保障期限
	 */
	private String productPeriod;
	/**
	 * 保障期限类型
	 */
	private String productPeriodType;
	/**
	 * 套餐
	 */
	private String planCode;
   
    
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getPayPeriod() {
		return payPeriod;
	}
	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}
	public String getPayPeriodType() {
		return payPeriodType;
	}
	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}
	public String getSocialSecurity() {
		return socialSecurity;
	}
	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getProductPeriod() {
		return productPeriod;
	}
	public void setProductPeriod(String productPeriod) {
		this.productPeriod = productPeriod;
	}
	public String getProductPeriodType() {
		return productPeriodType;
	}
	public void setProductPeriodType(String productPeriodType) {
		this.productPeriodType = productPeriodType;
	}
	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	@Override
	public String toString() {
		return "ProductPriceReqTr [productCode=" + productCode + ", age=" + age
				+ ", gender=" + gender + ", payPeriod=" + payPeriod
				+ ", payPeriodType=" + payPeriodType + ", socialSecurity="
				+ socialSecurity + ", amount=" + amount + ", productPeriod="
				+ productPeriod + ", productPeriodType=" + productPeriodType
				+ ", planCode=" + planCode + ", pin=" + getPin()+ "]";
	}
	@Override
	public void checkParameter() {
		checkPin();
//		if(StringUtil.isBlank(getProductCode())) {
//			throw new NessaryParametersNullException("产品编码为空");
//		}
	}
}
