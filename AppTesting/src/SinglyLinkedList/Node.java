package SinglyLinkedList;

public class Node
{
	public Node next;
	private Object value;
	
	public Node(Object value, Node next)
	{
		this.next = next;
		this.value = value;
	}
	
	public Object getValue()
	{
		return value;
	}
}
