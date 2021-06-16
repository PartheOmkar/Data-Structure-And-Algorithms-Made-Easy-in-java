package com.chapter14;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapDS<K,V> {
	private class HashNode{
		K key;
		V val;
		public HashNode(K key,V val) {
			this.key = key;
			this.val = val;
		}
	}
	private int size;
	private double factor;
	private LinkedList<HashNode>[] buckets;
	
	public HashMapDS() {
		initBucket(10);
		size = 0;
	}
	private void initBucket(int n) {
		buckets = new LinkedList[n];
		for(int bi=0;bi<buckets.length;bi++) {
			buckets[bi] = new LinkedList<HashNode>();
		}
	}
	private int getHash(K key) {
		int hashKey = key.hashCode();
		return Math.abs(hashKey)%buckets.length;
	}
	private int getIndexwithinBuckets(K key,int hashkey) {
		int di = 0;  
		for(HashNode node:buckets[hashkey]) {
			if(key==node.key) {
				return di;
			}
			di++;
		}
		return -1;
	}
	public void put(K key,V value) {
		int hashKey = getHash(key);
		int di = getIndexwithinBuckets(key,hashKey);
		if(di==-1) {
			HashNode node = new HashNode(key, value);
			buckets[hashKey].add(node);
			size++;
		}else {
			buckets[hashKey].get(di).val = value;
		}
		
		factor = buckets.length/size;
		if(factor < 1.0) {
			rehash();
		}
	}
	
	private void rehash() {
		LinkedList<HashNode>[] oldBucket = buckets;
		initBucket(oldBucket.length*2);
		factor = 
		size = 0;
		for(int i=0;i<oldBucket.length;i++) {
			for(HashNode n : oldBucket[i]) {
				put(n.key,n.val);
			}
		}
	}
	public V getValue(K key) {
		int hashkey = getHash(key);
		int di = getIndexwithinBuckets(key, hashkey);
		if(di==-1) {
			return null;
		}else {
			return buckets[hashkey].get(di).val;
		}
	}
	public boolean containKey(K key) {
		
		int hashkey = getHash(key);
		int di = getIndexwithinBuckets(key, hashkey);
		return di==-1?false:true;
	}
	public V remove(K key) {
		int hashkey = getHash(key);
		int di = getIndexwithinBuckets(key, hashkey);
		if(di==-1) {
			return null;
		}else {
			HashNode temp = buckets[hashkey].remove(di);
			size--;
			return temp.val;
		}
	}
	public ArrayList<K> keyset(){
		ArrayList<K> list = new ArrayList<K>();
		for(int i=0;i<buckets.length;i++) {
			for(HashNode n : buckets[i]) {
				list.add(n.key);
			}
		}
		return list;
	}
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		HashMapDS<Integer, Integer> hm = new HashMapDS<Integer, Integer>();
		
		hm.put(1, 10);
		hm.put(2, 20);
		hm.put(3, 30);
		hm.put(4, 40);
		hm.put(5, 50);
		hm.put(6, 70);
		
		System.out.println(hm.getValue(3));
		
		hm.put(10, 10);
		hm.put(20, 20);
		hm.put(30, 30);
		hm.put(40, 40);
		hm.put(50, 50);
		hm.put(60, 70);
		hm.put(12, 12);
		hm.put(13, 13);
		System.out.println(hm.remove(5));
		System.out.println(hm.size());
		
	}
}
