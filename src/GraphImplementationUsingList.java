import java.util.ArrayList;
import java.util.LinkedList;

public class GraphImplementationUsingList {

	public static void main(String[] args) {
		GraphUsingList g = new GraphUsingList(13);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(2, 6);
		
		g.addEdge(3, 7);
		g.addEdge(3, 8);
		g.addEdge(4, 9);
		g.addEdge(5, 10);
		g.addEdge(6, 10);
		//g.addEdge(6, 12);
		
		//try and make above tree/graph for more clarity
		
		/*int[] n = g.getNeighbours(2);
		
		for(int i: n)
			System.out.print(i+ " ");*/
		
		//g.BFS(0);
		System.out.println(g.findRouteBetweenNodes(10, 2));

	}

}

class GraphUsingList
{
	ArrayList<Integer>[] vertices;
	int numberOfVertices;
	
	public GraphUsingList(int numberOfVertices)
	{
		this.vertices = new ArrayList[numberOfVertices];
		this.numberOfVertices = numberOfVertices;
		for(int i=0;i<numberOfVertices;i++)
		{
			this.vertices[i] = new ArrayList<>();
			
		}
	}
	
	public void addEdge(int vertex1, int vertex2)
	{
		if(this.vertices[vertex1] !=null)
		{
			if(!this.vertices[vertex1].contains(vertex2))
				this.vertices[vertex1].add(vertex2);
		}
	}
	
	public int[] getNeighbours(int vertex)
	{
		if(this.vertices[vertex] !=null)
		{
			Object[] objNeighbours = this.vertices[vertex].toArray();
			int[] neighbours = new int[objNeighbours.length];
			
			for(int i=0;i<objNeighbours.length;i++)
			{
				neighbours[i] = (int)objNeighbours[i];
			}
			return neighbours;		 
		}
		return new int[0];
		
	}
	
	//queue
	public void BFS(int vertex)
	{//add first remove last 
		LinkedList<Integer> list = new LinkedList<Integer>();
		boolean[] visited = new boolean[this.numberOfVertices];
		list.addFirst(vertex);
		visited[vertex] = true;
		
		while(list.size()>0)
		{
			
			vertex = list.removeLast();
			System.out.print(vertex+" ");
			
			int[] neighbours = this.getNeighbours(vertex);
			for(int i : neighbours)
			{
				if(!visited[i])
				{
					list.addFirst(i);
					visited[i] = true;
				}
			}
		}
	}
	
	//Stack implementation
	public void DFS(int vertex)
	{//add first remove first 
		LinkedList<Integer> list = new LinkedList<Integer>();
		boolean[] visited = new boolean[this.numberOfVertices];
		list.addFirst(vertex);
		visited[vertex] = true;
		
		while(list.size()>0)
		{
			
			vertex = list.removeFirst();
			System.out.print(vertex+" ");
			
			int[] neighbours = this.getNeighbours(vertex);
			for(int i : neighbours)
			{
				if(!visited[i])
				{
					list.addFirst(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public boolean findRouteBetweenNodes(int vertex1, int vertex2)
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		boolean[] visited = new boolean[this.numberOfVertices];
		//LinkedList<Integer> path = new LinkedList<Integer>();
		list.addFirst(vertex1);
		visited[vertex1] = true;
		
		while(list.size()>0)
		{
			int vertex = list.removeLast();
			//path.add(vertex);
			//System.out.print(vertex+" ");
			if(vertex == vertex2)
				return true;
			
			int[] neighbours = this.getNeighbours(vertex);
			for(int i : neighbours)
			{
				if(!visited[i])
				{
					list.addFirst(i);
					visited[i] = true;
				}
			}
			
		}
		
/*		list = new LinkedList<Integer>();
		visited = new boolean[this.numberOfVertices];
		//LinkedList<Integer> path = new LinkedList<Integer>();
		list.addFirst(vertex2);
		visited[vertex2] = true;
		
		while(list.size()>0)
		{
			int vertex = list.removeLast();
			//path.add(vertex);
			//System.out.print(vertex+" ");
			if(vertex == vertex1)
				return true;
			
			int[] neighbours = this.getNeighbours(vertex);
			for(int i : neighbours)
			{
				if(!visited[i])
				{
					list.addFirst(i);
					visited[i] = true;
				}
			}
			
		}
*/	
		return false;
		
		
	}
	
}

