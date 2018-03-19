package TrinaryTree;

import java.util.NoSuchElementException;

public class TrinaryTree {

	private Node head;
	public TrinaryTree()
	{
		head = null;
	}
	
	public void insert(int v)
	{
		/*
		 * If head node is empty, new node will be created.
		 * 
		 * Otherwise-
		 * 
		 * Method will traverse tree until null value is found. New node will be inserted under the following guidelines:
		 * 		Smaller values will be placed as a left leaf node.
		 * 		Larger values will be placed as a right leaf node.
		 * 		Same values will be placed as a middle leaf node.
		 */
		
		if(head == null)
			head = new Node(v);
		else
		{
			Node cur = head;
			Node prev = null;
			while(cur!=null)
			{
				prev = cur;
				if(cur.getValue() > v)
					cur = cur.getLeftNode();
				else if(cur.getValue() < v)
					cur = cur.getRightNode();
				else
					cur = cur.getMiddleNode();
			}
			if(prev.getValue() > v)
				prev.setLeftNode(new Node(v));
			else if(prev.getValue() < v)
				prev.setRightNode(new Node(v));
			else
				prev.setMiddleNode(new Node(v));
		}		
	}

	public void delete(int v)
	{
		/*
		 * Method will search for given value within nodes. If tree is empty or null node is reached, NoSuchElementException will be thrown.
		 * 
		 * When node is found with matching value, there are two possible paths
		 * 1) Matching node has middle children (duplicates). Method will trim the deepest middle child. No other trim or movement needed.
		 * 2) Matching node has no middle children. removeNode(Node) method will be called to handle trim/movements. The removed node's left and right children will
		 * 		be applied to the returned node (if exists). If the head value is being trimmed, then head will be set to the returned node.
		 * 
		 */
		if(head == null) //no value to remove
			throw new NoSuchElementException("Value does not exist in this tree. Tree is empty.");
		
		Node cur = head;
		Node prev = head;
		while(cur != null)
		{
			if(cur.getValue() > v) //move left
			{
				prev = cur;
				cur = cur.getLeftNode();
			}
			else if(cur.getValue() < v) //move right
			{
				prev = cur;
				cur = cur.getRightNode();
			}
			else //found matching value
				break;
		}
		
		if(cur== null)
			throw new NoSuchElementException("Value does not exist in this tree");
		
		if(cur.getMiddleNode() != null) //duplicate value, remove deepest duplicate - no node swap needed
		{
			Node temp = cur;
			while(temp.getMiddleNode().getMiddleNode() != null)
				temp = temp.getMiddleNode();
			temp.setMiddleNode(null);
		}
		else
		{
			if(cur == head)
				head = removeNode(cur);
			else if(cur.getValue() > prev.getValue())
				prev.setRightNode(removeNode(cur));
			else
				prev.setLeftNode(removeNode(cur));
		}
				
	}
	
	private Node removeNode(Node cur)
	{
		/*
		 * Method has 3 paths
		 * 
		 * 1) Node has 2 children - recursively remove, manipulate and replace appropriate nodes
		 * 2) Node has 1 child - 	return left or right child as no trimming or tree manipulations are required
		 * 3) Node has 0 children - return null as no manipulations are required
		 * 
		 * Note: There is no need to monitor for middle child as that is covered in remove(int) method, or
		 * 			subsequent middle children will follow any parent movement with no effect
		 * 
		 * Replacement node for removed node will be returned.
		 */
		
		Node leftChild = cur.getLeftNode();
		Node rightChild = cur.getRightNode();
		
		if(leftChild!= null && rightChild!= null) //two child nodes, need to find inner most node for replacement
		{
			Node temp = leftChild;
			Node tempPrev = null;
			while(temp.getRightNode() != null)
			{
				tempPrev = temp;
				temp = temp.getRightNode();
			}
			if(tempPrev!= null)
			{
				tempPrev.setRightNode(removeNode(temp));
				temp.setLeftNode(leftChild);
			}
			temp.setRightNode(rightChild);
			return temp;
		}
		else if(leftChild!=null) //only left child
			return leftChild;
		else if(rightChild!=null) //only right child
			return rightChild;
		
		return null; //no children
			
		
	}
	
	//for testing
	public void inOrderPrintTree()
	{
		if(head==null)
		{
			System.out.println("Empty tree");
			return;
		}
		preOrderPrintTree(head);
	}
	private void preOrderPrintTree(Node n)
	{		
		if(n!=null)
		{
			System.out.print(n.getValue() + " ");
			preOrderPrintTree(n.getLeftNode());
			preOrderPrintTree(n.getMiddleNode());
			preOrderPrintTree(n.getRightNode());
		}
	}
}