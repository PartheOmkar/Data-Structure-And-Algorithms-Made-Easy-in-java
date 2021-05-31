package com.chapter9;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort extends GraphbyAdjHashMap{

	ArrayList<Integer> visited = new ArrayList<Integer>();
	Stack<Integer> topologicalsort = new Stack<Integer>();
	
	public void topologicalSort() {
		for(Integer v:vertices.keySet()) {
			if(!visited.contains(v)) {
				topologicalSort(v);
			}
		}
		int size = topologicalsort.size();
		for(int i=0;i<size;i++) {
			System.out.println(topologicalsort.pop());
		}
	}
	public void topologicalSort(int v) {
		if(visited.contains(v)) {
			return;
		}
		visited.add(v);
		for(Edge e:vertices.get(v)) {
			topologicalSort(e.vertex);
		}
		topologicalsort.add(v);
	}
	
	public static void main(String[] args) {
		
		TopologicalSort ts = new TopologicalSort();
		ts.addEdge(7, 11, 0);
		ts.addEdge(7, 8, 0);
		ts.addEdge(5, 11, 0);
		ts.addEdge(11, 2, 0);
		ts.addEdge(11, 9, 0);
		ts.addEdge(11, 10, 0);
		ts.addEdge(3, 8, 0);
		ts.addEdge(3, 10,0 );
		ts.addEdge(8, 9, 0);
		
		ts.topologicalSort();
	}
}
