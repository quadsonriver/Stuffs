package DoublyLinkedList;

public class Node
{
	public Node next;
	public Node prev;
	private Object value;
	
	public Node(Object value, Node next, Node prev)
	{
		this.next = next;
		this.prev = prev;
		this.value = value;
	}
	
	public Object getValue()
	{
		return value;
	}
}
