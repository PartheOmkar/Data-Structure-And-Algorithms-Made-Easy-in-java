package com.chapter9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkastraAlgo extends GraphbyAdjHashMap{

	private class ShortestPath{
		int distance = 0;
		int previousVertex = -1;
		public ShortestPath(int distance,int previousVertex){
			this.distance = distance;
			this.previousVertex = previousVertex;
		}
	}
	
	private class QueueNode implements Comparable<QueueNode>{
		int currentVertex;
		int distance;
		public QueueNode(int currentVertex, int distance) {
			this.currentVertex = currentVertex;
			this.distance = distance;
		}
		@Override
		public int compareTo(QueueNode arg0) {
			return this.distance- arg0.distance;
		}
		
	}
	Map<Integer,ShortestPath> shortDistanceTable = new HashMap<Integer, ShortestPath>();
	
	public void findMinimumDistance(int v) {
		
		PriorityQueue<QueueNode> queue = new PriorityQueue<DijkastraAlgo.QueueNode>();
		queue.add(new QueueNode(v, 0));
		shortDistanceTable.put(v, new ShortestPath(0, -1));
		
		ArrayList<Integer> visited = new ArrayList<Integer>();
		
		while(!queue.isEmpty()) {
			
			QueueNode temp = queue.poll();
			visited.add(temp.currentVertex);
			
			for(Edge e:vertices.get(temp.currentVertex)) {
				
				if(!visited.contains(e.vertex)) {
					queue.add(new QueueNode(e.vertex, e.weight));
				}
				
				if(shortDistanceTable.containsKey(e.vertex)) {
					int newDistance = shortDistanceTable.get(temp.currentVertex).distance + e.weight;
					if(shortDistanceTable.get(e.vertex).distance > newDistance) {
						shortDistanceTable.put(e.vertex, new ShortestPath(newDistance, temp.currentVertex));
					}
				}
				else {
					int newDistance = shortDistanceTable.get(temp.currentVertex).distance + e.weight;
					shortDistanceTable.put(e.vertex, new ShortestPath(newDistance, temp.currentVertex));
					queue.add(new QueueNode(e.vertex, e.weight));
				}
			}
		}
		
		for(Integer tempNode : shortDistanceTable.keySet()) {
			int vertex = tempNode;
			int distance = shortDistanceTable.get(tempNode).distance;
			int previous = shortDistanceTable.get(tempNode).previousVertex;
			System.out.println("Vertex = "+vertex+" Distance = "+distance +" previous = "+previous);
		}
	}
	public static void main(String[] args) {
		
		DijkastraAlgo dj = new DijkastraAlgo();
		
		dj.addEdge(1, 2, 4);
		dj.addEdge(1, 3, 1);
		dj.addEdge(3, 2, 2);
		dj.addEdge(3, 4, 4);
		dj.addEdge(2, 5, 4);
		dj.addEdge(4, 5, 4);
		
		dj.display();
		
		System.out.println("hello");
		dj.findMinimumDistance(1);
	}
}
