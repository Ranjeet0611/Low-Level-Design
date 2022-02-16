package com.hashmap.linkedlist;

public class LinkedList<K,V> {

	public K key;
	public V Value;
	public LinkedList<K, V> next;
	public LinkedList(K key,V value) {
		this.key =key;
		this.Value=value;
		this.next=null;
	}
}
