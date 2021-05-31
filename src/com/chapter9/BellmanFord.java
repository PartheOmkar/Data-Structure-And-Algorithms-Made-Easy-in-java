package com.chapter9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BellmanFord extends GraphbyAdjHashMap{

	int MAX_DISTANCE = 10000;
	private class EdgeTable{
		int source;
		int destination;
		int weight;
		public EdgeTable(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}
	
	private class ShortDistancePathTable{
		int distance;
		int previousVertex;
		public ShortDistancePathTable(int distance, int previousVertex) {
			this.distance = distance;
			this.previousVertex = previousVertex;
		}
	}
	
	Map<Integer, ShortDistancePathTable> shortDistanceTable = new HashMap<Integer, BellmanFord.ShortDistancePathTable>();
	ArrayList<EdgeTable> edgeTable = new ArrayList<BellmanFord.EdgeTable>();
	
	public void assignEdges(int x) {
		for(Integer v:vertices.keySet()) {
			for(Edge e:vertices.get(v)) {
				edgeTable.add(new EdgeTable(v, e.vertex, e.weight));
			}
		}
	}
	public void assignVertex(int x) {
		for(Integer v:vertices.keySet()) {
			if(v==x) {
				shortDistanceTable.put(v, new ShortDistancePathTable(0, -1));
				continue;
			}
			shortDistanceTable.put(v, new ShortDistancePathTable(MAX_DISTANCE, -1));
		}
	}
	public void bellmanFord(int v) {
		assignEdges(v);
		assignVertex(v);
		
		for(int i=0;i<vertices.size()-1;i++) {
			for(EdgeTable e:edgeTable) {
				if(shortDistanceTable.containsKey(e.destination) && shortDistanceTable.containsKey(e.source)) {
					int newDistance = shortDistanceTable.get(e.source).distance + e.weight;
					if( newDistance < shortDistanceTable.get(e.destination).distance) {
						shortDistanceTable.put(e.destination,new ShortDistancePathTable(newDistance, e.source));
					}
				}
			}
		}
		for(Integer tempv : shortDistanceTable.keySet()) {
			int vertic = tempv;
			int weight = shortDistanceTable.get(tempv).distance;
			int previous = shortDistanceTable.get(tempv).previousVertex;
			System.out.println("vertice = "+vertic+" weight = "+weight+" previous = "+previous);
		}
		
		if(!checkNegativeCycle()) {
			System.out.println("the given output is correct \nThe Graph has not contain any negative cycle");
		}else {
			System.out.println("the given output is **Not correct** \nThe Graph has contain **negative cycle**");
		}
		
		for(Integer tempv : shortDistanceTable.keySet()) {
			int vertic = tempv;
			int weight = shortDistanceTable.get(tempv).distance;
			int previous = shortDistanceTable.get(tempv).previousVertex;
			System.out.println("vertice = "+vertic+" weight = "+weight+" previous = "+previous);
		}
	}
	
	public boolean checkNegativeCycle() {
		for(EdgeTable e:edgeTable) {
			if(shortDistanceTable.containsKey(e.destination) && shortDistanceTable.containsKey(e.source)) {
				int newDistance = shortDistanceTable.get(e.source).distance + e.weight;
				if( newDistance < shortDistanceTable.get(e.destination).distance) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		BellmanFord bf = new BellmanFord();
		
		bf.addVertex(0);
		bf.addVertex(1);
		bf.addVertex(2);
		bf.addVertex(3);
		bf.addVertex(4);
		// contain negative cycle
//		bf.addEdge(0, 1, 1);
//		bf.addEdge(1,2 ,-1 );
//		bf.addEdge(2, 3, -1);
//		bf.addEdge(3, 0, -1);
		
//		not contain any negative cycle
		bf.addEdge(0, 1, -1);
		bf.addEdge(0, 2, 4);
		bf.addEdge(1, 2, 3);
		bf.addEdge(1, 3, 2);
		bf.addEdge(1, 4, 2);
		bf.addEdge(3, 1, 1);
		bf.addEdge(3, 2, 5);
		bf.addEdge(4, 3, -3);
		
		bf.display();
		bf.bellmanFord(0);
	}
}
