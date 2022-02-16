package com.hashmap.main;

import com.hashmap.map.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> hmap = new Map<>();
		hmap.add(1, "Ranjeet");
		hmap.add(2, "Steve");
		hmap.add(3, "balmer");
		hmap.add(4, "mark");
		hmap.add(5, "bhuchan");
		hmap.add(6, "gdfs");
		
		System.out.println(hmap.get(2)+" "+hmap.size());
	}

}
