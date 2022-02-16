package com.ranjeet.snakeandladder.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.ranjeet.snakeandladder.entity.Ladder;
import com.ranjeet.snakeandladder.entity.Player;
import com.ranjeet.snakeandladder.entity.Snake;
import com.ranjeet.snakeandladder.entity.SnakeAndLadderBoard;

public class SnakeAndLadderService {

	private SnakeAndLadderBoard  snakeAndLadderBoard;
	private int initialPlayer;
	private Queue<Player> players;
	private boolean isGameCompleted;
	private int noOfDices;
	
	private static final int DEFAULT_BOARD_SIZE = 100; 
    private static final int DEFAULT_NO_OF_DICES = 1;
	public SnakeAndLadderService(int size) {
		snakeAndLadderBoard = new SnakeAndLadderBoard(size);
		this.players = new LinkedList<>();
		this.setNoOfDices(SnakeAndLadderService.DEFAULT_NO_OF_DICES);
		
	}
	public SnakeAndLadderService() {
		this(DEFAULT_BOARD_SIZE);
	}
	public void setSnakes(List<Snake> snakes) {
        snakeAndLadderBoard.setSnakes(snakes); // Add snakes to board
    }

    public void setLadders(List<Ladder> ladders) {
        snakeAndLadderBoard.setLadders(ladders); // Add ladders to board
    }
	public void setPlayer(List<Player> players) {
		this.initialPlayer = players.size();
		Map<String,Integer> playerPieces = new HashMap<>();
		for(Player player:players) {
			this.players.add(player);
			playerPieces.put(player.getId(), 0);
		}
		snakeAndLadderBoard.setPlayerPieces(playerPieces);
	}
	public int getDiceValue() {
		return DiceService.diceRoll();
	}
	public void movePlayer(Player player,int diceValue) {
		int oldPosition = snakeAndLadderBoard.getPlayerPieces().get(player.getId());
		int newPosition = oldPosition + diceValue;
		int boardSize = snakeAndLadderBoard.getSize();
		if(newPosition>boardSize) {
			newPosition = oldPosition;
		}
		else {
			newPosition = getNewPositionAfterGoingThroughSnakeAndLadder(newPosition);
		}
		snakeAndLadderBoard.getPlayerPieces().put(player.getId(), newPosition);
		System.out.println(player.getName() + " rolled a " + diceValue + " and moved from " + oldPosition +" to " + newPosition);
	}
	private int getNewPositionAfterGoingThroughSnakeAndLadder(int newPosition) {
		int previousPosition;
		do {
			previousPosition = newPosition;
			for(Snake snake : snakeAndLadderBoard.getSnakes()) {
				if(snake.getStart() ==  newPosition) {
					newPosition = snake.getEnd();
				}
			}
			for(Ladder ladder:snakeAndLadderBoard.getLadders()) {
				if(ladder.getStart()==newPosition) {
					newPosition = ladder.getEnd();
				}
			}
		}while(previousPosition!=newPosition);
		return newPosition;
	}
	
	public void startGame() {
		while(!isGameCompleted()) {
			int diceValue = getDiceValue();
			Player player = players.poll();
			movePlayer(player,diceValue);
			if(hasPlayerWon(player)) {
				System.out.println(player.getName() + " wins the game");
                snakeAndLadderBoard.getPlayerPieces().remove(player.getId());
			}
			else {
				players.add(player);
			}
		}
	}
	private boolean isGameCompleted() {
		// TODO Auto-generated method stub
		int currPlayers = players.size();
		return currPlayers==0;
	}
	private boolean hasPlayerWon(Player player) {
		// TODO Auto-generated method stub
		int playerPosition = snakeAndLadderBoard.getPlayerPieces().get(player.getId());
		int winningPlayer = snakeAndLadderBoard.getSize();
		return playerPosition==winningPlayer;

	}
	public int getNoOfDices() {
		return noOfDices;
	}
	public void setNoOfDices(int noOfDices) {
		this.noOfDices = noOfDices;
	}
	
}
