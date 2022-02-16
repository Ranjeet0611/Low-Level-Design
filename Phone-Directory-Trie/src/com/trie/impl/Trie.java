package com.trie.impl;

import java.util.HashMap;
import java.util.Map;

public class Trie<K,V> {

	public  Map<K,V> hmap;
	public  boolean isWordEnd;
	
	public Trie() {
		hmap = new HashMap<>();
		for(int i=0;i<=345;i++) {
			Character ch = (char)i;
			hmap.put((K) ch, null);
		}
		isWordEnd = false;
	}
	public static void insert(Trie root,String word) {
		Trie newNode = root;
		for(int i=0;i<word.length();i++) {
			if(newNode.hmap.get(word.charAt(i))==null) {
				Trie nextNode  = new Trie();
				newNode.hmap.put(word.charAt(i),nextNode);
			}
			newNode = (Trie) newNode.hmap.get(word.charAt(i));
		}
		newNode.isWordEnd = true;
	}
	public static void suggestsUtil(Trie root,String str) {
		if(root.isWordEnd) {
			System.out.println(str);
		}

		for(int i=0;i<=345;i++) {
			Character ch = (char)i;
			Trie nextNode = (Trie) root.hmap.get(ch);
			if(nextNode!=null) {
				suggestsUtil(nextNode, str+ch);
			}
		}
	}
	public static void suggests(Trie root,String str) {
		Trie newNode = root;
		String prefix="";
		int len = str.length();
		for(int i=0;i<len;i++) {
			prefix+=str.charAt(i);
			char lastPrefix = prefix.charAt(i);
			Trie currNode = (Trie) newNode.hmap.get(lastPrefix);
			if(currNode==null) {
				System.out.println("No Suggestions found");
				i++;
				break;
			}
			System.out.println("Suggestions based on "+ prefix + " are");
			suggestsUtil(currNode,prefix);
			newNode = currNode;
		}
	}
}

