package com.chapter9;

public class GraphbyAdjMatrix {
	
	private boolean adjMatrix[][];
	private int vertexCount;
	
	public GraphbyAdjMatrix(int vertexCount) {
		this.vertexCount = vertexCount;
		adjMatrix = new boolean[vertexCount][vertexCount];
	}
//	for undirected graph
	public void addEdge(int i,int j) {
		if(i>=0 && i <=vertexCount && j>=0 && j<=vertexCount) {
			adjMatrix[i][j] = true;
			adjMatrix[j][i] = true;
		}else {
			System.out.println("The Enter Vertex"+i+" "+j+" is not Present");
		}
	}
//	remove edge from vertices
	public void removeEdge(int i,int j) {
		if(i>0 && i<vertexCount && j>0 && j<vertexCount) {
			adjMatrix[i][j] = false;
			adjMatrix[j][i] = false;
		}else {
			System.out.println("The Enter Vertex"+i+" "+j+" is not Present");
		}
	}
//	check is Edge is present or not
	public boolean isEdge(int i, int j) {
		if(i>0 && i<vertexCount && j>0 && j<vertexCount) {
			return adjMatrix[i][j];
		}else {
			System.out.println("The Enter Vertex"+i+" "+j+" is not Present");
		}
		return false;
	}
//	display graph
	public void display() {
		for(int i=0;i<4;i++) {
			System.out.print("| ");
			for(int j=0;j<4;j++) {
				System.out.print(adjMatrix[i][j]+"\t| ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		GraphbyAdjMatrix m1 = new GraphbyAdjMatrix(4);
		
		m1.addEdge(0, 1);
		m1.addEdge(0, 3);
		m1.addEdge(1, 2);
		m1.addEdge(2, 1);
		m1.addEdge(2, 3);
		m1.display();
	}
}
