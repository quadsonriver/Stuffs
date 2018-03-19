package TrinaryTree;

/* 
*  Node class for Trinary Tree
*/
public class Node {

	private Node left;
	private Node middle;
	private Node right;
	private int value;
	
	public Node()
	{
		left = null;
		middle = null;
		right = null;
	}
	public Node(int v)
	{
		left = null;
		middle = null;
		right = null;
		value = v;
	}
	public void setLeftNode(Node n)
	{
		left = n;
	}
	public void setRightNode(Node r)
	{
		right = r;
	}
	public void setMiddleNode(Node m)
	{
		middle = m;
	}	
	public void setValue(int v)
	{
		value = v;
	}
	public Node getLeftNode()
	{
		return left;
	}
	public Node getRightNode()
	{
		return right;
	}
	public Node getMiddleNode()
	{
		return middle;
	}
	public int getValue()
	{
		return value;
	}
}