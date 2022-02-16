package com.trie.main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.trie.impl.Trie;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Trie<Character,Trie> root = new Trie<>();
		JSONParser parser = new JSONParser();
		URL url = new URL("https://api.jikan.moe/v3/search/anime?q=naruto");
		URLConnection connection = url.openConnection();
		Scanner br = new Scanner(url.openStream());
		String inline="";
		while(br.hasNext()) {
			inline+=br.nextLine();
		}
		JSONObject parse = (JSONObject) parser.parse(inline);
		JSONArray object = (JSONArray) parse.get("results");
		for(int i=0;i<object.size();i++) {
			JSONObject jsonObject = (JSONObject) object.get(i);
			Trie.insert(root,jsonObject.get("title").toString());
		}
		
		Trie.suggests(root,"E");
	}

}
