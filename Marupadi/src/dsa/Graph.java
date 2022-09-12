package dsa;

import java.util.*;


public class Graph {
ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
public Graph(int noOFVertices)
{
	for(int i=0;i<noOFVertices;i++)
	{
		adjList.add(new ArrayList<Integer>());
	}
}
public void addEdge(int u, int v) {
	adjList.get(u).add(v);
	adjList.get(v).add(u);
}
public void printAdjList()
{
	for(int i=0;i<adjList.size();i++)
	{
		System.out.println("Adjacency list of vertex " + i);
		for(int j=0;j<adjList.get(i).size();j++)
		{
			System.out.print(adjList.get(i).get(j) + "  ");
		}
		System.out.println();
	}
}
public void bfs(int startVertex)
{
	int noOfVertex=adjList.size();
	boolean[] visited=new boolean[noOfVertex];
	visited[startVertex]=true;
	Queue<Integer> q=new LinkedList<>();
   

	
}
}
