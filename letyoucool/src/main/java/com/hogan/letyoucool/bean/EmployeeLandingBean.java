package com.hogan.letyoucool.bean;

import android.graphics.Bitmap;
import android.text.TextUtils;

import java.util.ArrayList;

/**
 * @作者 CH
 * @描述 这个类是用于保存员工登陆相关信息
 * @时间 2015-11-19 上午9:36:04
 * */
public class EmployeeLandingBean {

	private static EmployeeLandingBean employeeLandingBean;

	private boolean isautocheck;// 是否具有自动签到功能

	private String port;// Socket端口号

	private String serverip;// 服务器IP

	private String token;// 很重要的token

	private String userName;// 员工姓名

	private String jobNumber;// 员工工号

	private String companyName;// 公司名称

	private String serverTimeString;// 服务器时间

	private Bitmap bmp; // 个人头像

	private String balance;// 账户余额(现金余额)
	
	private String tickBalance;// 票券余额

	private String parkId;// 公园Id

	private String creditLine;// 票券信用额度

	public String getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(String creditLine) {
		this.creditLine = creditLine;
	}

	public String getTickBalance() {
		return tickBalance;
	}

	public void setTickBalance(String tickBalance) {
		this.tickBalance = tickBalance;
	}

	private String longitude;// 经度

	private String Latitude;// 纬度

	private String ulimoney;// 最大免费金额

	private boolean isPayPwd; // 是否有支付密码

	private int uliid;// 唯一码

	private String depId;// 部门ID

	private String compId;// 公司ID
	private String ediname;// 部门名称

	private String uliEasepwd;// 环信的工号
    /**
	 * 用于动态APP的类
	 * */
	public ArrayList<DynamicAppBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(ArrayList<DynamicAppBean> beanList) {
		this.beanList = beanList;
	}

	private String uliEaseid;// 环信的密码

	private String personPhotoUrl; // 个人头像url
	private ArrayList<DynamicAppBean> beanList;

	public String getPersonPhotoUrl() {
		return personPhotoUrl;
	}

	public void setPersonPhotoUrl(String personPhotoUrl) {
		this.personPhotoUrl = personPhotoUrl;
	}

	public  boolean isExsitEase() {
		if (getUliEaseid() != null && !TextUtils.isEmpty(getUliEaseid())) {
			return true;
		}
		return false;
	}

	public String getUliEasepwd() {
		return uliEasepwd;
	}

	public void setUliEasepwd(String uliEasepwd) {
		this.uliEasepwd = uliEasepwd;
	}

	public String getUliEaseid() {
		return uliEaseid;
	}

	public void setUliEaseid(String uliEaseid) {
		this.uliEaseid = uliEaseid;
	}

	public String getEdiname() {
		return ediname;
	}

	public void setEdiname(String ediname) {
		this.ediname = ediname;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public int getUliid() {
		return uliid;
	}

	public void setUliid(int uliid) {
		this.uliid = uliid;
	}

	public boolean isPayPwd() {
		return isPayPwd;
	}

	public void setPayPwd(boolean isPayPwd) {
		this.isPayPwd = isPayPwd;
	}

	public String getUlimoney() {
		return ulimoney;
	}

	public void setUlimoney(String ulimoney) {
		this.ulimoney = ulimoney;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getParkId() {
		return parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public boolean getIsAutoCheck() {
		return isautocheck;
	}

	public Bitmap getBmp() {
		return bmp;
	}

	public void setBmp(Bitmap bmp) {
		this.bmp = bmp;
	}

	public void setIsAutoCheck(boolean isautocheck) {
		this.isautocheck = isautocheck;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getServerip() {
		return serverip;
	}

	public void setServerip(String serverip) {
		this.serverip = serverip;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getServerTimeString() {
		return serverTimeString;
	}

	public void setServerTimeString(String serverTimeString) {
		this.serverTimeString = serverTimeString;
	}

	public synchronized static EmployeeLandingBean getInstance() {
		if (employeeLandingBean == null) {
			employeeLandingBean = new EmployeeLandingBean();
//			Log.e("EmployeeLandingBean", "EmployeeLandingBean==null"+employeeLandingBean.toString());
		}else{
//			Log.e("EmployeeLandingBean", "EmployeeLandingBean!=null"+employeeLandingBean.toString());
		}
		return employeeLandingBean;
	}
	
	

	@Override
	public String toString() {
		return "EmployeeLandingBean [token=" + token + ", userName=" + userName
				+ ", jobNumber=" + jobNumber + ", uliEasepwd=" + uliEasepwd
				+ ", uliEaseid=" + uliEaseid + "]";
	}

	/**
	 * @描述 统一时间转化方法 2015-11-18T12:22:30.79+08:00转化成 2015-11-18 12:22:30
	 * @时间 2015-11-25 下午12:09:14
	 * */
	public String timeFromeString(String sysTime) {
		if (sysTime != null && sysTime.length() > 18) {
			String year = sysTime.substring(0, 4);
			String month = sysTime.substring(5, 7);
			String day = sysTime.substring(8, 10);
			String hour = sysTime.substring(11, 13);
			String min = sysTime.substring(14, 16);
			String sencond = sysTime.substring(17, 19);
			String data = year + "-" + month + "-" + day + " " + hour + ":"
					+ min + ":" + sencond;

			return data;
		} else {
			return null;
		}
	}
	
	
	
}
