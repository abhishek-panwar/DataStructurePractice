import java.util.ArrayList;


/***
 * this is basic idea of how we can implement a graph using matrix
 * but since we have to keep matrix equal to V^2 size.
 * there is no pint using this approach, due to space constraints
 * @author Abhishek Panwar
 *
 */
public class GraphImplementationUsingMatrix {

	public static void main(String[] args) {

		int[] vertices = {5,3,8,2};
		//System.out.println(vertices.length);
	
		GraphUsingMatrix g = new GraphUsingMatrix(vertices);
		g.printMatrix();
		//System.out.println();
		g.addEdge(5, 2);
		g.addEdge(5, 3);
		g.addEdge(5, 8);
		g.addEdge(8, 2);
		g.addEdge(8, 3);
		g.addEdge(8, 5);
		g.addVertex(10);
		g.addVertex(12);
		g.addEdge(3, 2);
		g.addEdge(3, 8);
		g.addEdge(2, 8);
		g.addEdge(10, 5);
		
		g.printMatrix();
		int[] n = g.findNeighbours(12);
		//int[] n = g.findNeighbours(5);
		//int[] n = g.findNeighbours(3);
		//int[] n = g.findNeighbours(8);

		for(int i : n)
			System.out.print(i+" ");
		
	}

}



class GraphUsingMatrix
{
	int[][] matrix;
	ArrayList<Integer> vertices;
	
	public GraphUsingMatrix()
	{
		matrix = new int[5][5];
	}
	public GraphUsingMatrix(ArrayList<Integer> vertices)
	{
		this.vertices = vertices;
		matrix = new int[this.vertices.size()][this.vertices.size()];
		init();
	}
	public GraphUsingMatrix(int[] vertices)
	{
		this.vertices = new ArrayList<>();
		for(int i : vertices)
		{
			this.vertices.add(i);
		}
		
		matrix = new int[this.vertices.size()][this.vertices.size()];
		init();
	}
	
	public void init()
	{
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix.length;j++)
			{
				matrix[i][j]=0;
			}
		}
	}
	
	// for adding edge we simply mark the matrix block with 1
	public void addEdge(int from, int to)
	{
		if(vertices.contains(from) && vertices.contains(to) && from!=to)
		{
			matrix[vertices.indexOf(from)][vertices.indexOf(to)] = 1;
		}
		else
			System.out.println("incorrect vertex");
	}
	
	// for adding a vertex we need to recreate matrix once it is full
	// add vertex in vertices also
	public void addVertex(int vertex)
	{
		if(vertices.contains(vertex))
			System.out.println("vertex already exists");
		else
		{
			if(vertices.size()==matrix.length)
			{
				int[][] newMatrix = new int[matrix.length+5][matrix.length+5];
				for(int i=0;i<matrix.length;i++)
				{
					for(int j=0;j<matrix.length;j++)
					{
						newMatrix[i][j]=matrix[i][j];
					}
				}
				
				for(int i=matrix.length;i<newMatrix.length;i++)
				{
					for(int j=matrix.length;j<newMatrix.length;j++)
					{
						newMatrix[i][j]=0;
					}
				}
				
				matrix = newMatrix;
				vertices.add(vertex);
				
			}
			else
			{
				vertices.add(vertex);
			}
		}
		
	}
	
	// neighbours are, vertices we can go to, from vertex
	public int[] findNeighbours(int vertex)
	{
		if(!this.vertices.contains(vertex))
		{
			System.out.println("incorrect vertex");
			return new int[0];
			
		}
		else
		{
			int[] arr = new int[matrix.length]; 
			int index = this.vertices.indexOf(vertex);
			int j=0,count=0;
			for(int i=0;i<matrix.length;i++)
			{
				if(matrix[index][i]==1)
				{
					arr[j++] = this.vertices.get(i);
					count++;
				}
			}
			
			int[] neighbours = new int[count];
			for(int i=0;i<count;i++)
				neighbours[i] = arr[i];
			
			return neighbours;
		}
		
	}
	
	
	public void printMatrix()
	{
		//matrix of size vertices is actual matrix, rest we are not using right now.
		for(int i=0;i<vertices.size();i++)
		{
			for(int j=0;j<vertices.size();j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	
	
}