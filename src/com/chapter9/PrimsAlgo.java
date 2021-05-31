package com.chapter9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PrimsAlgo extends GraphbyAdjHashMap{

	private class PrimsTable implements Comparable<PrimsTable>{
		int vertex;
		int weight;
		public PrimsTable(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(PrimsTable arg0) {
			return this.weight-arg0.weight;
		}
	}
	
	private class SpaningTree{
		int weight;
		int previousVertex;
		public SpaningTree(int weight, int previousVertex) {
			this.weight = weight;
			this.previousVertex = previousVertex;
		}
	}
	
	Map<Integer, SpaningTree> spanningTree = new HashMap<Integer, SpaningTree>();
	
	public void primesAlgo(int v) {
		PriorityQueue<PrimsTable> queue = new PriorityQueue<PrimsAlgo.PrimsTable>();
		queue.add(new PrimsTable(v, 0));
		spanningTree.put(v,new SpaningTree(0, -1));
		ArrayList<Integer> visited = new ArrayList<Integer>();
		visited.add(v);
		int count=0;
		while(!queue.isEmpty()) {
			count++;
			PrimsTable temp = queue.poll();
			
			for(Edge e: vertices.get(temp.vertex)) {
				
				if(!visited.contains(e.vertex)) {
					queue.add(new PrimsTable(e.vertex, e.weight));
				}
				visited.add(e.vertex);
				
				if(spanningTree.containsKey(e.vertex)) {
					if(spanningTree.get(e.vertex).weight > e.weight) {
						spanningTree.put(e.vertex, new SpaningTree(e.weight, temp.vertex));
					}
				}else {
					spanningTree.put(e.vertex, new SpaningTree(e.weight, temp.vertex));
				}
			}
		}
		for(Integer tempVertex:spanningTree.keySet()) {
			int weight = spanningTree.get(tempVertex).weight;
			int previous = spanningTree.get(tempVertex).previousVertex;
			System.out.println("Vertex = "+tempVertex+" weight = "+weight+" previous vertex = "+previous);
		}
		System.out.println(count);
	}
	public static void main(String[] args) {
		
		PrimsAlgo pa = new PrimsAlgo();
		
		pa.addEdge(0, 3, 40);
		pa.addEdge(0, 1,10);
		pa.addEdge(1, 2,10);
		pa.addEdge(2, 3,10);
		pa.addEdge(3, 4,2);
		pa.addEdge(4 ,5 ,3);
		pa.addEdge(4, 6,8);
		pa.addEdge(5, 6,3);
		pa.display();
		pa.primesAlgo(0);
	}
}
