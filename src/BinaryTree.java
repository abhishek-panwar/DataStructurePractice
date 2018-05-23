import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*** 
 * this is very basic implementation of binary tree
 * there is a lot of scope of further modification
 * @author Abhishek Panwar
 *
 */
public class BinaryTree {
	public static void main(String[] args) {
		BTree b = new BTree();
		
		
		for (int i = 0; i < 15; i++) {
			b.add(i);
		}
		//b.print();
		//System.out.println();
		//b.printNodesAtLevel(4);
		
		//System.out.println(b.getNode(12).data);
		//b.printPath(b.getNode(0), b.getNode(10));
		
		
		
		//System.out.println(b.search(5));
		//System.out.println(b.countNode());
		//System.out.println(b.ifEmpty());
		
		//System.out.println(b.findMaxDepth());
		//System.out.println("LCAs");
		//System.out.println(b.findLCA(4,5).data);
		
		
/*		int[] arr = {1,2,3,4,5,6};
		BTreeNode  root = b.createBST(arr);
		b.inorder(root);
*/		
//		System.out.println();
//		b.preorder(root);
		

	}
}

/***
 * Binary tree implementation
 * @author Abhishek Panwar
 *
 */
class BTree
{
	BTreeNode root; //root of the tree
	public BTree()
	{
		root = null;
	}
	
	public void add(int data)
	{
		root = add(root, data);
	}
	
	private BTreeNode add(BTreeNode root, int data)
	{// finds a null node/pointer to add the new node there, recursively
		 
		/*if(root==null)
			 root = new BTreeNode(data);
		 else
		 {
			 if(root.getRight()==null)
				 root.right = add(root.getRight(), data);
			 else
				 root.left = add(root.getLeft(), data);
		 }
		 return root;
		*/ 
		
		
		//proper addition in order from left to right
		if(root == null)
			root = new BTreeNode(data);
		else
		{
		 
			 Queue<BTreeNode> q = new LinkedList<BTreeNode>();
			 q.add(root);
			 
			 while(!q.isEmpty())
			 {
				 BTreeNode temp = q.peek();
				 q.remove();
				 
				 if(temp.left==null)
				 {
					 temp.left = new BTreeNode(data);
					 break;
				 }
				 else
					 q.add(temp.left);
				 if(temp.right==null)
				 {
					 temp.right = new BTreeNode(data);
					 break;
				 }
				 else
					 q.add(temp.right);
				 
			 }
		}
		 return root;
		 
	}
	
	
	//for BST
	public BTreeNode findLCA(int n1, int n2)
	{
		return this.findingLCA(this.root, n1, n2);
		
	}
	//for BST
	public BTreeNode findingLCA(BTreeNode root, int n1, int n2)
	{
		if(root==null)
			return null;
		if(root.data>n1 && root.data>n2)
			return findingLCA(root.left, n1, n2);
		if(root.data<n1 && root.data<n2)
			return findingLCA(root.right, n1, n2);
		
		//if data is in between the nodes, thats the LCA
		return root;
	}
	
	public int findMaxDepth()
	{
		return this.findingMaxDepth(root);
	}
	
	private int findingMaxDepth(BTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			int leftDepth = this.findingMaxDepth(root.left);
			int rightDepth = this.findingMaxDepth(root.right);
			
			if(leftDepth>rightDepth)
				return leftDepth +1;
			else
				return rightDepth +1;
		}
		
	}
	
/*	public BTreeNode getNode(int data)
	{
		return getNode(root,data);
	}
	private BTreeNode getNode(BTreeNode root, int data)
	{//recursive search for node
		if(root==null)
			return null;
		if(root.data==data)
			return root;
		else
		{
			getNode(root.left,data);
			getNode(root.right,data);
	
			return root;
		}
	}
*/
	
	public boolean search(int data)
	{
		return search(root,data);
	}
	private boolean search(BTreeNode root, int data)
	{//recursive search for node
		if(root!=null)
		{
			if(root.data==data)
				return true;
			else
			{
				return search(root.left,data) || search(root.right,data);
/*				if(root.left!=null)
					return search(root.left,data);
					//if(search(root.left,data))
						//return true;
				if(root.right!=null)
					return search(root.right,data);
					//if(search(root.right,data))
						//return true;
*/			}
		}
		
		return false;
	}
	
	public BTreeNode createBST(int[] arr)
	{
		Arrays.sort(arr);
		//System.out.println(arr.length);
		return creatingBST(arr, 0, arr.length-1);
	}
	
	public BTreeNode creatingBST(int[] arr, int start, int end)
	{
	
		if(start>end)
			return null;
	
		int mid = (start + end)/2;
		//System.out.println(arr[mid]);
		BTreeNode root = new BTreeNode(arr[mid]);
		
		
		root.left = creatingBST(arr, start, mid-1);
		root.right = creatingBST(arr, mid+1, end);
		
		return root;
		
		
	}
	
	public void printNodesAtLevel(int level)
	{
		printingNodesAtLevel(root,level);
	}
	
	public void printingNodesAtLevel(BTreeNode root, int level)
	{
		
		if(root==null)
			return;
		if(level==1)
			System.out.print(root.data+" ");
		
		else
		{
			printingNodesAtLevel(root.left,level-1);
			printingNodesAtLevel(root.right,level-1);
		}
		
	}
	
	
	public boolean printPath(BTreeNode node1, BTreeNode node2)
	{
		if(node1==null)
			return false;
		if(node1.data == node2.data || printPath(node1.left, node2) || printPath(node1.right, node2))
		{
			System.out.print(node1.data+"  ");
			return true;
		}
		return false;
	}
	
	
	public int countNode()
	{
		return countNode(root);
	}
	private int countNode(BTreeNode root)
	{
		if(root==null) //tree is empty
			return 0;
		else
		{
			int count= 1; //counting root
			count += countNode(root.left);
			count += countNode(root.right);
			return count;
		}
	}
	
	public boolean ifEmpty()
	{
		return root==null;
	}
	
	public void print()
	{
		inorder(root);
	}
	public void inorder(BTreeNode root)
	{//inorder traversal
		if(root!=null)
		{
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}

	public void preorder(BTreeNode root)
	{//inorder traversal
		if(root!=null) //tree not empty, for empty tree there is nothing to print
		{
			System.out.print(root.data+" ");
			preorder(root.left);
			
			preorder(root.right);
		}
	}

	
}

/***
 * node consisting of two pointers- left and right
 * and data/label
 * @author Abhishek Panwar
 *
 */
class BTreeNode
{
	int data;
	BTreeNode left;
	BTreeNode right;
	public BTreeNode(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
	public void setData(int data) {
		this.data = data;
	}
	public void setLeft(BTreeNode left) {
		this.left = left;
	}
	public void setRight(BTreeNode right) {
		this.right = right;
	}
}
