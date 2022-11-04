import java.util.*;

class InsertinLLtoPosition
{
	static class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	static void printLL(Node head)
	{
		Node a = new Node(0);
		a = head;
		while(a != null)
		{
			System.out.print(Integer.toString(a.data) + " ");
			a = a.next;
		}
	}
	
	static Node insertLL( int[] arr)
	{
		int len = arr.length;
		Node head = new Node(arr[0]) ;
		Node a = head;
		for(int i = 1; i < len; i++)
		{
			Node b = new Node(arr[i]);
			a.next = b;
			a = b;
		}
		return head;
	}
	
	static void insertPosition(Node head,int data, int position)
	{
		int pos = 0;
		Node add = new Node(data);
		Node itr = head;
		while(pos != position-1)
		{
			itr = itr.next;
			pos++;
			//System.out.println(pos);
		}
		//System.out.println(pos);
		add.next = itr.next;
		itr.next = add;
	}
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int nos = s.nextInt();
		int[] arr = new int[nos];
		for(int i = 0 ; i < nos; i++)
		{
			int a = s.nextInt();
			arr[i] = a;
		}
		Node head = insertLL(arr);
		int data = s.nextInt();
		int position = s.nextInt();
		insertPosition(head,data,position);
		printLL(head);
	}
}