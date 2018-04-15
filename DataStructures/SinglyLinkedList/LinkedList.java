package SinglyLinkedList;

import java.util.Iterator;

public class LinkedList implements Iterable<Object>
{
	private Node head;
	
	public LinkedList()
	{
		head = null;
	}
	
	public void addFirst(Object value)
	{
		head = new Node(value, head);
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
			
			temp.next = new Node(value,null);
		}
	}
	
	public void removeFirst()
	{
		if(head != null)
			head = head.next;
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
