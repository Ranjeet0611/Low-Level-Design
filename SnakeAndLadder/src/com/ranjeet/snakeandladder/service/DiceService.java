package com.ranjeet.snakeandladder.service;

import java.util.Random;

public class DiceService {

	public static int diceRoll() {
		return new Random().nextInt(6)+1;
	}
}
