package com.hurst.program;

public class Horse {
	
	private String name = "";
	private Integer totalYards = 0;
	private Integer laneNumber = 0;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getTotalYards() {
		return totalYards;
	}
	
	public void setTotalYards(Integer totalYards) {
		this.totalYards = totalYards;
	}
	
	public Integer getLaneNumber() {
		return laneNumber;
	}
	
	public void setLaneNumber(Integer laneNumber) {
		this.laneNumber = laneNumber;
	}
	
	public void addRaceYards(Integer yards) {
		this.totalYards = this.totalYards + yards;
	}
	

}
