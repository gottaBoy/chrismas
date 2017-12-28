package com.example.demo.bean;
/**
 * http://blog.csdn.net/xinghuo0007/article/details/51500923
 */
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HhgInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 编号
     */
    private Long id;

    /**
     * 始发
     */
    private String send;

    /**
     * 到达
     */
    private String arrive;
    
    
	/**
     * 发布时间
     */
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;

    /**
     * 单价
     */
    private BigDecimal price;
    
    /**
     * 货物名称
     */
    private String goodsName;
    
    /**
     * 信息部名称
     */
    private String departInfo;
    
    /**
     * 信息部联系人
     */
    private String departInfoName;
    
    /**
     * 信息部联系方式
     */
    private String departInfoTel;
    
    /**
     * 更多信息
     */
    private String departInfoMore;
    /**
     * 是否过期：0-港口收货   1-港口发货
     */
    private Boolean isInPort;
    
    /**
     * 是否过期：0-未过期   1-已过期 
     */
    private Boolean expire;
    
    /**
     * 创建者id
     */
    private String creatorId;
    /**
     * 创建者姓名
     */
    private String creatorName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者id
     */
    private Long modifierId;
    /**
     * 更新者姓名
     */
    private String modifierName;
    /**
     * 更新时间
     */
    private Date modifyTime;
    /**
     * 备注
     */
    private String remark;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	public String getArrive() {
		return arrive;
	}
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getDepartInfo() {
		return departInfo;
	}
	public void setDepartInfo(String departInfo) {
		this.departInfo = departInfo;
	}
	public String getDepartInfoName() {
		return departInfoName;
	}
	public void setDepartInfoName(String departInfoName) {
		this.departInfoName = departInfoName;
	}
	public String getDepartInfoTel() {
		return departInfoTel;
	}
	public void setDepartInfoTel(String departInfoTel) {
		this.departInfoTel = departInfoTel;
	}
	public String getDepartInfoMore() {
		return departInfoMore;
	}
	public void setDepartInfoMore(String departInfoMore) {
		this.departInfoMore = departInfoMore;
	}
	public Boolean getIsInPort() {
		return isInPort;
	}
	public void setIsInPort(Boolean isInPort) {
		this.isInPort = isInPort;
	}
	public Boolean getExpire() {
		return expire;
	}
	public void setExpire(Boolean expire) {
		this.expire = expire;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getModifierId() {
		return modifierId;
	}
	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}
	public String getModifierName() {
		return modifierName;
	}
	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "HhgInfo [id=" + id + ", send=" + send + ", arrive=" + arrive + ", publishTime=" + publishTime
				+ ", price=" + price + ", goodsName=" + goodsName + ", departInfo=" + departInfo + ", departInfoName="
				+ departInfoName + ", departInfoTel=" + departInfoTel + ", departInfoMore=" + departInfoMore
				+ ", isInPort=" + isInPort + ", expire=" + expire + ", creatorId=" + creatorId + ", creatorName="
				+ creatorName + ", createTime=" + createTime + ", modifierId=" + modifierId + ", modifierName="
				+ modifierName + ", modifyTime=" + modifyTime + ", remark=" + remark + "]";
	}
}
