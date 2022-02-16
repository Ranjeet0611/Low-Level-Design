package com.ranjeet.snakeandladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.ranjeet.snakeandladder.entity.Ladder;
import com.ranjeet.snakeandladder.entity.Player;
import com.ranjeet.snakeandladder.entity.Snake;
import com.ranjeet.snakeandladder.service.SnakeAndLadderService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner br = new Scanner(System.in);
		int noOfSnakes = br.nextInt();
		List<Snake> snakes = new ArrayList<>();
		for(int i=0;i<noOfSnakes;i++) {
			snakes.add(new Snake(new Random().nextInt(24),new Random().nextInt(24)));
		}
		int noOfLadders = br.nextInt();
        List<Ladder> ladders = new ArrayList<Ladder>();
        for (int i = 0; i < noOfLadders; i++) {
            ladders.add(new Ladder(new Random().nextInt(14),new Random().nextInt(80)));
        }
        int noOfPlayers = br.nextInt();
        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < noOfPlayers; i++) {
        	String name = Integer.toString(i);
            players.add(new Player(name));
        }
        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
        snakeAndLadderService.setSnakes(snakes);
        snakeAndLadderService.setLadders(ladders);
        snakeAndLadderService.setPlayer(players);
        snakeAndLadderService.startGame();
	}

}
