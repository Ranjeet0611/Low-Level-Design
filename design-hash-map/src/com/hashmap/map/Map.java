package com.hashmap.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.hashmap.linkedlist.LinkedList;

public class Map<K,V> {

	private List<LinkedList<K,V>> bucketArray;
	private int size;
	private int bucketSize;
	public Map() {
		bucketArray = new ArrayList<>();
		bucketSize = 10;
		size= 0;
		for(int i=0;i<bucketSize;i++) {
			bucketArray.add(null);
		}
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	private int hashCode(K key) {
		return Objects.hashCode(key);
	}
	private int bucketIndex(K key) {
		int hashcode = hashCode(key);
		int index = hashcode%bucketSize;
		index = index<0?index*-1:index;
		return index;
	}
	public void add(K key,V value) {
		int bucketIndex = bucketIndex(key);
		LinkedList<K, V> head = bucketArray.get(bucketIndex);
		while(head!=null) {
			if(head.key.equals(key)) {
				head.Value=value;
				return;
			}
			head=head.next;
		}
		size++;
		head = bucketArray.get(bucketIndex);
		LinkedList<K, V> node = new LinkedList<>(key, value);
		node.next = head;
		bucketArray.set(bucketIndex, node);
	}
	public V remove(K key) {
		int bucketIndex = bucketIndex(key);
		LinkedList<K, V> head = bucketArray.get(bucketIndex);
		if(head==null) {
			return null;
		}
		LinkedList<K, V> prev = null;
		while(head!=null) {
			if(head.key.equals(key)) {
				break;
			}
			prev = head;
			head=head.next;
		}
		size--;
		if(prev!=null) {
			prev.next = head.next;
		}
		else {
			bucketArray.set(bucketIndex, head.next);
		}
		return head.Value;
	}
	public V get(K key) {
		int bucketIndex = bucketIndex(key);
		LinkedList<K, V> head = bucketArray.get(bucketIndex);
		while(head!=null) {
			if(head.key.equals(key)) {
				return head.Value;
			}
			head=head.next;
		}
		return null;
		
	}
	
}
