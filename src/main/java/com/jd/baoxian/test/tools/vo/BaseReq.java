
package com.jd.baoxian.test.tools.vo;

public abstract class BaseReq {
	
	private String pin;

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public void checkPin() {
//		if(StringUtil.isBlank(getPin())) {
//			throw new NessaryParametersNullException("pin为空");
//		}
	}
	
	/**
	 * 对输入参数进行必要的校验
	 */
	
	public abstract void checkParameter();
}
