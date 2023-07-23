package com.ifty.security.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;



public class Pagi {
	private int offset;
	private int limit;
	private String cc;
	private String population;
	@JsonInclude
	private boolean tusted ;
	private List<String> cityL;

	public List<String> getCityL() {
		return cityL;
	}

	public void setCityL(List<String> cityL) {
		this.cityL = cityL;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public boolean isTusted() {
		return tusted;
	}

	public void setTusted(boolean tusted) {
		this.tusted = tusted;
	}

	
}
