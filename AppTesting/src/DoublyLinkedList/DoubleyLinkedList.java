package DoublyLinkedList;

import java.util.Iterator;


/*
 * NULL     HEAD --> [Link 1] --> [Link 2] --> NULL
 * NULL <-- HEAD <-- [Link 1] <-- [Link 2]     NULL
 */
public class DoubleyLinkedList implements Iterable<Object>
{
	private Node head;
	
	public DoubleyLinkedList()
	{
		head = null;
	}
	
	public void addFirst(Object value)
	{
		head = new Node(value, head, null);
		
		if(head.next != null)
			head.next.prev = head;
	}
	
	public void addLast(Object value)
	{
		if(head == null)
			addFirst(value);
		else
		{
			Node temp = head;
			while(temp.next != null)
				temp = temp.next;
			
			temp.next = new Node(value,null, temp);
		}
	}
	
	public void removeFirst()
	{
		if(head != null)
			head = head.next;
		
		if(head != null)
			head.prev = null;
	}
	
	public void removeLast()
	{
		if(head != null)
		{
			Node temp = head;
			if(temp.next == null)
				removeFirst();
			else
			{
				while(temp.next.next != null)
				{
					temp = temp.next;
				}
				temp.next = null;
			}
		}
	}
	
	public Object getFirst()
	{
		return head.getValue();
	}
	
	public Object getLast()
	{
		if(head == null)
			return null;
		
		Node temp = head;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		
		return temp.getValue();
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public void clear()
	{
		head = null;
	}
	
	@Override
	public Iterator<Object> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
