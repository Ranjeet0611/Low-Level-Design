package com.ranjeet.ticktoktoe;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private Symbol symbol;
	private List<Coordinates> coodinates;
	public Player(String name,Symbol symbol) {
		this.setName(name);
		this.setSymbol(symbol);
		this.setCoodinates(new ArrayList<>());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	public List<Coordinates> getCoodinates() {
		return coodinates;
	}

	public void setCoodinates(List<Coordinates> coodinates) {
		this.coodinates = coodinates;
	}
	
}
