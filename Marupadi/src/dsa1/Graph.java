package dsa1;

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
	q.add(startVertex);
	while(q.size()!=0)
	{
		int vertex=q.remove();
		System.out.print(vertex + " ");
		for(int i=0;i<adjList.get(vertex).size();i++)
		{
			int av=adjList.get(vertex).get(i);
			if(!visited[av])
			{
				q.add(av);
				visited[av]=true;
			}
		}
	}
   

	
}
public void dfs(int startVertex)
{
	int noOfVertex=adjList.size();
	boolean[] visited=new boolean[noOfVertex];
	dfs2(startVertex,visited);
}
public void dfs2(int startVertex,boolean[] visited)
{
	visited[startVertex]=true;
	System.out.print(startVertex + " ");
	for(int i=0;i<adjList.get(startVertex).size();i++)
	{
		int av=adjList.get(startVertex).get(i);
		if(!visited[av])
			dfs2(av,visited);
	}
	
}

}
