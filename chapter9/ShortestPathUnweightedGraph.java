package com.chapter9;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ShortestPathUnweightedGraph extends GraphbyAdjHashMap{

	private class ShortestPath{
		int distance = 0;
		int previousVertex = -1;
		public ShortestPath(int distance,int previousVertex){
			this.distance = distance;
			this.previousVertex = previousVertex;
		}
	}
	
	Map<Integer, ShortestPath> shortDistanceTable = new HashMap<Integer, ShortestPath>();
	
	public void findShortestPathUnweightedGraph(int v) {
		PriorityQueue<Integer> vertice = new PriorityQueue<Integer>();
		vertice.add(v);
		ShortestPath d = new ShortestPath(0, -1);
		shortDistanceTable.put(v, d);
		while(!vertice.isEmpty()) {
			int temp = vertice.poll();
			for(Edge edge : vertices.get(temp)) {
				vertice.add(edge.vertex);
//				check vertex distance is not -1 then compare with old distance vs new distance and update distance
				if(shortDistanceTable.containsKey(edge.vertex)) {
					if(shortDistanceTable.get(edge.vertex).distance > shortDistanceTable.get(temp).distance+1) {
						ShortestPath path = new ShortestPath(shortDistanceTable.get(temp).distance+1, temp);
						shortDistanceTable.put(edge.vertex, path);
					}
				}else {
//					if distance is infinite or -1 then execute following code
					ShortestPath path = new ShortestPath(shortDistanceTable.get(temp).distance+1, temp);
					shortDistanceTable.put(edge.vertex, path);
				}
			}
		}
//		display Table
		for(Integer tempv : shortDistanceTable.keySet()) {
			int distance = shortDistanceTable.get(tempv).distance;
			int previous = shortDistanceTable.get(tempv).previousVertex;
			System.out.println("Vertex = "+tempv+" Distance = "+distance+" previous vertex = "+previous);
		}
	}
	public static void main(String[] args) {
		
		ShortestPathUnweightedGraph sgw = new ShortestPathUnweightedGraph();
		
		sgw.addVertex(1);
		sgw.addVertex(2);
		sgw.addVertex(3);
		sgw.addVertex(4);
		sgw.addVertex(5);
		sgw.addVertex(6);
		sgw.addVertex(7);
		
		sgw.addEdge(1, 2, 0);
		sgw.addEdge(1, 7, 0);
		sgw.addEdge(2, 3, 0);
		sgw.addEdge(2, 4, 0);
		sgw.addEdge(3, 4, 0);
		sgw.addEdge(3, 5, 0);
		sgw.addEdge(4, 7, 0);
		sgw.addEdge(4, 6, 0);
		sgw.addEdge(5, 6, 0);
		sgw.addEdge(6, 7, 0);
		sgw.findShortestPathUnweightedGraph(1);
	}
}
