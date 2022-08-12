package com.interview247.l3;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
 
class Edge
{
    int src, dest;
    int weight;
 
    Edge(int src, int dest, int weight)
    {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
 
// A class to store adjacency list nodes
class Node
{
    int value;
    int weight;
 
    Node(int value, int weight)
    {
        this.value = value;
        this.weight = weight;
    }
 
    @Override
    public String toString() {
        return this.value + " (" + this.weight + ")";
    }
}
 
class Graph
{
    List<List<Node>> adjList = new ArrayList<>();
 
    public Graph(List<Edge> edges)
    {
        int n = 0;
		
		 for (Edge e: edges)
		 {
			 n = Integer.max(n, Integer.max(e.src, e.dest));
			 }
		
        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }
 
        for (Edge e: edges)
        {
            adjList.get(e.src).add(new Node(e.dest, e.weight));
 
           adjList.get(e.dest).add(new Node(e.src, e.weight));
        }
    }

 
    public static void printGraph(Graph graph)
    {
        int src = 0;
        int n = graph.adjList.size();
 
        while (src < n)
        {
            // print current vertex and all its neighboring vertices
            for (Node edge: graph.adjList.get(src)) {
                System.out.printf("%d ——> %s\t", src, edge);
            }
 
            System.out.println();
            src++;
        }
    }

	public static void listCities(Graph graph)
	{
		int src = 0;
        int n = graph.adjList.size();
 
		for(int i=0;i<n;i++)
		{
			System.out.println(i + " ");
		}
	}

	public static void adjacentCities(Graph graph)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the city number to find ");
		int search=input.nextInt();
		//int src=0;
		//int n = graph.adjList.size();
		 System.out.print("( ");
		         for (Node edge: graph.adjList.get(search)) 
	             {
	            	
	               // System.out.printf("%d ——> %s\t", search, edge);
		        	 System.out.print( edge.value + " ");
	            }
		         System.out.print(")");
	 
	           
	}

	public static void printRoutes(Graph graph)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter city 1");
		int c1=input.nextInt();
		System.out.println("Enter city 2");
		int c2=input.nextInt();
		ArrayList<Integer> al=new ArrayList<>();
		ArrayList<Integer> alweight=new ArrayList<>();
		
		ArrayList<Integer> al2=new ArrayList<>();
		
		for (Node edge: graph.adjList.get(c1)) 
        {
       	
          // System.out.printf("%d ——> %s\t", search, edge);
       	// System.out.print( edge.value + " ");
			al.add(edge.value);
			alweight.add(edge.weight);
			for(int i=0;i<al.size();i++)
			{
				for (Node edge1: graph.adjList.get(al.get(i))) 
		        {
					if(edge1.value==c2)
					{
					int value1=al.get(i);
					int value2=edge1.value;
					int weight=alweight.get(i);
					int weight2=edge1.weight;
					System.out.print(c1 + " " +value1 + " " +value2 + " " + (weight+weight2));
					System.out.println();
					//break;
					}
					
		        }
		       	
			}
       }
		
		
       
	}


	public static void findBusyCity(Graph graph)
	{
		int src=0;
		int n = graph.adjList.size();
		// System.out.println(n);
		 int max=0;
		 int count=0;
		 while (src < n)
	        {
	            for (Node edge: graph.adjList.get(src)) {
	                count++;
	            }
	            if(max<count)
	            {
	            	max=count;
	            	count=0;
	            }
	 
	            src++;
	        }
		 System.out.println("Busiest city " + max);
	 
		 
	}


	public static void addRoute(Graph graph) 
	{
		Scanner input=new Scanner(System.in);
		int n=graph.adjList.size();
		//List<Edge> edges1=Arrays.asList(new Edge(0,6,20));
		System.out.println("Enter src dest weight");
		int src=input.nextInt();
		int dest=input.nextInt();
		int weight=input.nextInt();
		graph.adjList.get(src).add(new Node(dest,weight));
		Graph.printGraph(graph);
		
		//List<Node> edges=graph.adjList.add(edges);
			    
	}


	public static void deleteRoute(Graph graph)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter src");
		int src=input.nextInt();
		System.out.println("Enter dest");
		int dest=input.nextInt();
	graph.adjList.get(src);
		//graph.adjList.remove(src);
		//graph.adjList.remove(dest);
		Graph.printGraph(graph);
	}
}

public class MainGraphDS
{
    public static void main (String[] args)
    {
    	Scanner input=new Scanner(System.in);
		/*
		 * System.out.println("Enter number of cities"); int n=input.nextInt();
		 * List<Edge> edges=null; for(int i=0;i<10;i++) {
		 * System.out.println("Enter source destination and weight"); int
		 * scr=input.nextInt(); int dest=input.nextInt(); int weight=input.nextInt();
		 * edges=Arrays.asList(new Edge(scr,dest,weight));
		 * 
		 * }
		 */
    	List<Edge> edges = Arrays.asList(
                new Edge(0,1,20), new Edge(0,2,45), new Edge(0,3,25),
                 new Edge(1,6,35), new Edge(1,5,90),
                new Edge(2,4,10),
                new Edge(3,6,30),new Edge(4,7,35),
                new Edge(5,6,30),new Edge(6,7,40));
 
    	
    	Graph graph = new Graph(edges);
    	boolean isTrue=true;
    	 while(isTrue)
    	 {

 System.out.println("Enter the choice \n1.Print Graph \n2.List cities \n3.Find Adjacent Cities \n4.Print Routes \n5.Busy City \n6.Add route \n7.Delete Route \n8.Exit");
 int ch=input.nextInt();
 	 switch(ch)
	 {
	 case 1:Graph.printGraph(graph);
             break;
	 case 2:
		 Graph.listCities(graph);
		 break;
	 case 3:
		 Graph.adjacentCities(graph);
		 break;
	 case 4:
		 Graph.printRoutes(graph);
		 break;
	 case 5:
		 Graph.findBusyCity(graph);
		 break;
	 case 6:
		 Graph.addRoute(graph);
		 break;
		 
	 case 7:
		 Graph.deleteRoute(graph);
		 break;
	 case 8:
		 isTrue=false;
		 break;
     default:
    	 System.out.println("Enter a valid choice");
		 
	 }
 }
       
    }
}

