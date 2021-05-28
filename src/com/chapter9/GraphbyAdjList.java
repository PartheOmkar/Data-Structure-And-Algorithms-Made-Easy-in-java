package com.chapter9;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphbyAdjList {
	
	ArrayList<Vertices> list;
	private class Edge{
		int vertexInedge;
		int weight;
		public Edge(int vertexInedge, int weight) {
			this.vertexInedge = vertexInedge;
			this.weight = weight;
		}
	}
	private class Vertices{
		int vertex;
		LinkedList<Edge> edges;
		public Vertices(int vertex) {
			this.vertex = vertex;
			edges = new LinkedList<GraphbyAdjList.Edge>();
		}
	}
	public GraphbyAdjList() {
		list = new ArrayList<GraphbyAdjList.Vertices>();
	}
	
//	add vertex time complexity is O(1)
	public void addVertex(int vertex) {
		Vertices v = new Vertices(vertex);
		if(!list.contains(v)) {
			list.add(v);
		}else {
			System.out.println("ERROR : Vertex is already Present");
		}
	}
//	add edge between two vertex time complexity is O(n) n-> vertices
//	perform operation of undirected graph
	public void addEdge(int vertex1,int vertex2,int weight) {
		Edge ed1 = new Edge(vertex2, weight);
		Edge ed2 = new Edge(vertex1,weight);
		for(Vertices v:list) {
			if(v.vertex==vertex1) {
				v.edges.addLast(ed1);
			}
			if(v.vertex==vertex2) {
				v.edges.addLast(ed2);
			}
		}
	}
//	display graph time complexity is (O^2) in worst case V*E 
//	no of vertices = No. vertices-1 edges which is across to the  N*N=>(O^2)
	public void display() {
		for(Vertices v:list) {
			System.out.print("["+v.vertex+"] -> ");
			for(Edge e:v.edges) {
				System.out.print("["+e.vertexInedge+" ("+e.weight+")],");
			}
			System.out.println();
		}
	}
//	remove edge between two vertices
	public void removeEdge(int vertex1, int vertex2) {
		for(Vertices v:list) {
			if(v.vertex==vertex1) {
				for (Edge e : v.edges) {
					if(e.vertexInedge==vertex2) {
						v.edges.remove(e);
					}
				}
			}
			if(v.vertex==vertex2) {
				for (Edge e : v.edges) {
					if(e.vertexInedge==vertex1) {
						v.edges.remove(e);
					}
				}
			}
		}
	}
//	check edge is present or not
	public boolean checkEdge(int vertex1, int vertex2) {
		for(Vertices v:list) {
			if(v.vertex==vertex1) {
				for(Edge e:v.edges) {
					if(e.vertexInedge==vertex2) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
		GraphbyAdjList g1 = new GraphbyAdjList();
		g1.addVertex(1);
		g1.addVertex(2);
		g1.addVertex(3);
		
		g1.addEdge(1, 2, 0);
		g1.addEdge(3, 2, 5);
		g1.display();
//		g1.removeEdge(3,2);
		
		System.out.println(g1.checkEdge(3, 2));
		System.out.println(g1.checkEdge(2, 1));
	}
}