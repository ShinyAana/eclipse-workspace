package dsa;

public class GraphDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Graph g=new Graph(5);
g.addEdge(0,1);
g.addEdge(2, 3);
g.addEdge(1, 2);
g.addEdge(3, 4);
g.addEdge(0, 4);
g.printAdjList();
	}

}
