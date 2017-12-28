package com.example.demo.wechat.config;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wechat.url")
public class WechatUrlProperties {

	/**
     * 通过code获取结果的url
     */
    private String codeUrl;
    /**
     * 腾讯地图逆地址解析Key
     */
    private String lbsKey;
    /**
     * 腾讯地图逆地址解析url
     */
    private String lbsUrl;
    /**
     * 存储微信位置信息的url
     */
    private String locUrl;
    
    public String getCodeUrl() {
        return this.codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }
    
    public String getLbsKey() {
		return lbsKey;
	}

	public void setLbsKey(String lbsKey) {
		this.lbsKey = lbsKey;
	}

	public String getLbsUrl() {
		return lbsUrl;
	}

	public void setLbsUrl(String lbsUrl) {
		this.lbsUrl = lbsUrl;
	}

	public String getLocUrl() {
		return locUrl;
	}

	public void setLocUrl(String locUrl) {
		this.locUrl = locUrl;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }
}
