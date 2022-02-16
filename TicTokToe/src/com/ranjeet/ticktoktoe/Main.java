package com.ranjeet.ticktoktoe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner br = new Scanner(System.in);
		
		System.out.println("Give Players name");
		String name1 = br.nextLine();
		String name2 = br.nextLine();
		Player player1 = new Player(name1,Symbol.X);
		Player player2 = new Player(name2,Symbol.O);
		Queue<Player> players = new LinkedList<>();
		players.add(player1);
		players.add(player2);
		TikTokToe tikTokToe = new TikTokToe(3,players);
		tikTokToe.play();
//		System.out.println(player1.getName()+" All coordinates");
//		player1.getCoodinates().forEach(x->System.out.println(x.getX()+" "+x.getY()));
	}
}
