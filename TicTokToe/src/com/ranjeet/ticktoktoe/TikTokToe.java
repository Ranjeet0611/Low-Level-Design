package com.ranjeet.ticktoktoe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TikTokToe {
   char board[][];
   int boardSize;
   boolean isGameOver;
   Queue<Player> playerTurns;
   public TikTokToe(int size,Queue<Player> players) {
	   
	   this.boardSize = size;
	   this.board = new char[size][size];
	   for (char[] row : board)
           Arrays.fill(row, '-');
	   playerTurns = players;
	   this.isGameOver = false;
	   
   }
   public void printBoard() {
	   for(int i=0;i<boardSize;i++) {
		   for(int j=0;j<boardSize;j++) {
			   System.out.print(board[i][j]);
		   }
		   System.out.print("\n");
	   }
   }
   public void play() {
	   int count = 0;
	   while(!isGameOver) {
		   if(count==boardSize*boardSize) {
			   System.out.println("Match Draw");
			   return;
		   }
		   printBoard();
		   Player player = playerTurns.poll();
		   int coordinates[] = getCoordinates(player);
		   player.getCoodinates().add(new Coordinates(coordinates[0], coordinates[1]));
		   if(checkStatus(coordinates,player)) {
			   isGameOver = true;
			   System.out.println(player.getName()+" has won the game");
			   printBoard();
		   }
		   playerTurns.add(player);
		   count++;
		   
	   }
   }
   public boolean checkColumnWise(int x,char playerSymbol) {
	   for(int i=0;i<boardSize;i++) {
		   if(board[i][x]!=playerSymbol) {
			   return false;
		   }
	   }
	   return true;
   }
   public boolean checkRowWise(int x,char playerSymbol) {
	   for(int i=0;i<boardSize;i++) {
		   if(board[x][i]!=playerSymbol) {
			   return false;
		   }
	   }
	   return true;
   }
   
   public boolean checkLeftDiagonal(int x,char playerSymbol) {
	   for(int i=0;i<boardSize;i++) {
		   if(board[i][i]!=playerSymbol) {
			   return false;
		   }
	   }
	   return true;
   }
   public boolean checkRightDiagonal(int x,char playerSymbol) {
	   
	   int j=0;
	   for(int i=boardSize-1;i>=0;i--) {
		   if(board[i][j++]!=playerSymbol) {
			   return false;
		   }
	   }
	   return true;
   }

   public boolean checkStatus(int coordinates[],Player player) {
	   int x = coordinates[0];
	   int y = coordinates[1];
	   char playerSymbol = player.getSymbol().name().charAt(0);
	   if(checkColumnWise(x,playerSymbol) || checkRowWise(x,playerSymbol) || checkRightDiagonal(x, playerSymbol) || checkLeftDiagonal(x, playerSymbol)) {
		   return true;
	   }
	   return false;
   }
   public int[] getCoordinates(Player player) {
	   Scanner br = new Scanner(System.in);
	   int coordinates [] = new int[2];
	   System.out.println(player.getName()+" Please enter your coordinates");
	   int x = br.nextInt();
	   int y = br.nextInt();
	   while(!isValid(x,y)) {
		   System.out.println("Please Enter a valid Coordinates");
		   x = br.nextInt();
		   y = br.nextInt();
	   }
	   coordinates[0] = x;
	   coordinates[1] = y;
	   board[x][y] = player.getSymbol().toString().charAt(0);
	return coordinates;
	   
   }
   public boolean isValid(int x,int y) {
	if(x>=boardSize || x<0 || y>=boardSize || y<0 || board[x][y]!='-') {
		return false;
	} 
	return true;
	   
   }

}
