package com.ifty.security.model;

import java.util.List;

public class MainResponce {
	private List<City> cityList;
	private String totalElement;
	private String cuurentPage;
	private String totalRecord;
	private int nextPage;

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public String getTotalElement() {
		return totalElement;
	}

	public void setTotalElement(String totalElement) {
		this.totalElement = totalElement;
	}

	public String getCuurentPage() {
		return cuurentPage;
	}

	public void setCuurentPage(String cuurentPage) {
		this.cuurentPage = cuurentPage;
	}

	public String getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(String totalRecord) {
		this.totalRecord = totalRecord;
	}
}
