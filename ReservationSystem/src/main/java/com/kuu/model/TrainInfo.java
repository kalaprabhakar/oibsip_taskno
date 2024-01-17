package com.kuu.model;

public class TrainInfo {
	
	private int trainNo;
	private String traiNname;
	private int pnr ;
	private String type ;
	private  String date;
	private  String from ;
	private String to ;
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public String getTraiNname() {
		return traiNname;
	}
	public void setTraiNname(String traiNname) {
		this.traiNname = traiNname;
	}
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	} 
	
	
	public TrainInfo() {
		
	}
	@Override
	public String toString() {
		return "TrainInfo [trainNo=" + trainNo + ", traiNname=" + traiNname + ", pnr=" + pnr + ", type=" + type
				+ ", date=" + date + ", from=" + from + ", to=" + to + "]";
	}
	
	

}
