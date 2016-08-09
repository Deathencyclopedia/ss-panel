package com.dep.sspanel.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import com.dep.sspanel.util.type.UserType;

/**
 * 用户
 * @author Maclaine
 *
 */
@Entity
@DynamicUpdate
public class User implements Serializable{
	private static final long serialVersionUID = 1228256212143751728L;
	
	private int id;
	private String email;//用户邮箱
	private String pass;//用户密码
	private String passwd;//ss密码
	private int time;//最后使用的时间
	private long upload;//已上传流量
	private long download;//已下载流量
	private long transferEnable;//可用流量（总量）
	private int port=50000;//ss端口
	private byte switchs;//保留字段
	private byte enable=0;//启用或禁用ss帐号（1启用，0禁用）
	private byte type;//保留字段
	private int lastGetGiftTime;//保留字段
	private int lastRestPassTime;//保留字段
	private Date updateDate=Calendar.getInstance().getTime();//修改日期
	private int cycleType=2;//周期类型:6=日,2=月,1=年
	private int expires=0;//有效时间
	private int status=UserType.unactive.getId();//用户状态
	
	@Id
	@Column(nullable=false)
	public int getId() {
		return id;
	}
	/**
	 * 用户邮箱
	 * @return
	 */
	@Column(name="email",length=32,nullable=false)
	public String getEmail() {
		return email;
	}
	/**
	 * 用户密码
	 * @return
	 */
	@Column(name="pass",length=16,nullable=false)
	public String getPass() {
		return pass;
	}
	/**
	 * ss密码
	 * @return
	 */
	@Column(name="passwd",length=16,nullable=false)
	public String getPasswd() {
		return passwd;
	}
	@Column(name="t",nullable=false)
	public int getTime() {
		return time;
	}
	@Column(name="u",nullable=false)
	public long getUpload() {
		return upload;
	}
	@Column(name="d",nullable=false)
	public long getDownload() {
		return download;
	}
	@Column(name="transfer_enable",nullable=false)
	public long getTransferEnable() {
		return transferEnable;
	}
	@Column(name="port",nullable=false,unique=true)
	public int getPort() {
		return port;
	}
	@Column(name="switch",nullable=false)
	public byte getSwitchs() {
		return switchs;
	}
	@Column(name="enable",nullable=false)
	public byte getEnable() {
		return enable;
	}
	@Column(name="type",nullable=false)
	public byte getType() {
		return type;
	}
	@Column(name="last_get_gift_time",nullable=false)
	public int getLastGetGiftTime() {
		return lastGetGiftTime;
	}
	@Column(name="last_rest_pass_time",nullable=false)
	public int getLastRestPassTime() {
		return lastRestPassTime;
	}
	@Column
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 周期类型:6=日,2=月,1=年
	 * @return
	 */
	@Column
	public int getCycleType() {
		return cycleType;
	}
	/**
	 * 有效期
	 * @return
	 */
	@Column
	public int getExpires() {
		return expires;
	}
	/**
	 * 用户状态
	 * @return
	 */
	@Column
	public int getStatus() {
		return status;
	}
	
	/**
	 * 是否过期
	 * @return
	 */
	@Transient
	public boolean isTimeout(){
		Calendar cal=Calendar.getInstance();
		cal.setTime(updateDate);
		cal.add(cycleType, expires);
		if(cal.getTimeInMillis()<Calendar.getInstance().getTimeInMillis()){
			return true;
		}
		return false;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public void setUpload(long upload) {
		this.upload = upload;
	}
	public void setDownload(long download) {
		this.download = download;
	}
	public void setTransferEnable(long transferEnable) {
		this.transferEnable = transferEnable;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public void setSwitchs(byte switchs) {
		this.switchs = switchs;
	}
	public void setEnable(byte enable) {
		this.enable = enable;
	}
	public void setType(byte type) {
		this.type = type;
	}
	public void setLastGetGiftTime(int lastGetGiftTime) {
		this.lastGetGiftTime = lastGetGiftTime;
	}
	public void setLastRestPassTime(int lastRestPassTime) {
		this.lastRestPassTime = lastRestPassTime;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public void setCycleType(int cycleType) {
		this.cycleType = cycleType;
	}
	public void setExpires(int expires) {
		this.expires = expires;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
