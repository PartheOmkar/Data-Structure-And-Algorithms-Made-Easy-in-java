package com.chapter9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class GraphbyAdjHashMap {
//	blue print of edge
	public class Edge{
		int vertex;
		int weight;
		public Edge(int vertex,int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
//	for store vertices
	public Map<Integer, List<Edge>> vertices = new HashMap<>();
//	add vertices
	public void addVertex(int vertex){
		vertices.put(vertex,new LinkedList<Edge>());
	}
//	add edges
	public void addEdge(int vertex1, int vertex2, int weight) {
		Edge edge1 = new Edge(vertex2, weight);
//		Edge edge2 = new Edge(vertex1, weight);
		if(!vertices.containsKey(vertex1)) {
			addVertex(vertex1);
		}
		if(!vertices.containsKey(vertex2)) {
			addVertex(vertex2);
		}
		vertices.get(vertex1).add(edge1);
//		vertices.get(vertex2).add(edge2);
	}
//	Display graph
	public void display() {
		for(Integer v:vertices.keySet()) {
			System.out.print(v);
			for(Edge e: vertices.get(v)) {
				System.out.print("-->"+e.vertex+"("+e.weight+")");
			}
			System.out.println();
		}
	}
//	display in DFS Format
	private void dfs(int v) {
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> vertexlist = new ArrayList<Integer>();
		vertexlist.addAll(vertices.keySet());
			
		stack.add(v);
		System.out.print("DFS Way From :- "+v+" ");
//		visited.add(v);
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			visited.add(temp);
			System.out.print("-->"+temp);
			for(Edge e:vertices.get(temp)) {
				if(!visited.contains(e.vertex)) {
					stack.add(e.vertex);
				}
			}
		}
		System.out.println();
	}
	private void bfs(int v) {
		
		Queue<Integer> node = new LinkedList<Integer>();
		ArrayList<Integer> visited = new ArrayList<>();
		
		node.add(v);
//		visited.add(v);
		System.out.print("BFS Way From :- "+v+" ");
		while(!node.isEmpty()) {
			int temp = node.remove();
			visited.add(temp);
			System.out.print("-->"+temp);
			for(Edge e:vertices.get(temp)) {
				if(!visited.contains(e.vertex)) {
					node.add(e.vertex);
				}
			}
		}
		System.out.println();
		visited.clear();
	}
	public static void main(String[] args) {
		GraphbyAdjHashMap gh = new GraphbyAdjHashMap();
		
		gh.addVertex(1);
		gh.addVertex(2);
		gh.addVertex(3);
		gh.addVertex(4);
		gh.addVertex(5);
		gh.addVertex(6);
		gh.addVertex(7);
		gh.addVertex(8);
		
		gh.addEdge(1, 2, 0);
		gh.addEdge(2, 3, 0);
		gh.addEdge(3, 4, 0);
		gh.addEdge(3, 5, 0);
		gh.addEdge(5, 6, 0);
		gh.addEdge(5, 7, 0);
		gh.addEdge(2, 8, 0);
		
		gh.display();
		
		gh.dfs(2);
		gh.bfs(2);
	}
}
