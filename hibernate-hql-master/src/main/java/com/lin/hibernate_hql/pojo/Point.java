package com.lin.hibernate_hql.pojo;

import java.util.Set;



public class Point {
	
	public Point(String pointNo, String pointName, String longitude,
			String latitude, String address) {
		super();
		this.pointNo = pointNo;
		this.pointName = pointName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.address = address;
	}
	

	@Override
	public String toString() {
		return "Point [pointNo=" + pointNo + ", pointName=" + pointName
				+ ", longitude=" + longitude + ", latitude=" + latitude
				+ ", address=" + address + "]";
	}

	private String pointId;

	/**
	 * 巡检点编号
	 */
	private String pointNo;

	/**
	 * 巡检点名称
	 */
	private String pointName;

	/**
	 * 经度
	 */
	private String longitude;

	/**
	 * 纬度
	 */
	private String latitude;

	private Integer isDeleted;
	public Integer getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 备注
	 */
	private String remark;
	
	private Set<Device> devices;

	public Set<Device> getDevices() {
		return devices;
	}

	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}

	public String getPointId() {
		return pointId;
	}

	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	public String getPointNo() {
		return pointNo;
	}

	public void setPointNo(String pointNo) {
		this.pointNo = pointNo;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Point() {
		super();
	}
	

}
