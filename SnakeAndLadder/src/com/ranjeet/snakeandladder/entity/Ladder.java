package com.ranjeet.snakeandladder.entity;

public class Ladder {

	private int start;
	private int end;
	public Ladder(int start,int end) {
		this.setStart(start);
		this.setEnd(end);
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}
