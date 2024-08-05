package com.trainSchedule.model;

public class trainSchedule {
	private int trainID;
	private String trainName;
	private String frmStation;
	private String toStation;
	private String Price;
	private String departTime;
	private String arriveTime;

	public trainSchedule(int trainID, String trainName, String frmStation, String toStation, String price,
			String departTime, String arriveTime) {
		super();
		this.trainID = trainID;
		this.trainName = trainName;
		this.frmStation = frmStation;
		this.toStation = toStation;
		Price = price;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
	}

	public trainSchedule(String trainName, String frmStation, String toStation, String price, String departTime,
			String arriveTime) {
		super();
		this.trainName = trainName;
		this.frmStation = frmStation;
		this.toStation = toStation;
		Price = price;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
	}

	public int getTrainID() {
		return trainID;
	}

	public void setTrainID(int trainID) {
		this.trainID = trainID;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getFrmStation() {
		return frmStation;
	}

	public void setFrmStation(String frmStation) {
		this.frmStation = frmStation;
	}

	public String getToStation() {
		return toStation;
	}

	public void setToStation(String toStation) {
		this.toStation = toStation;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
}