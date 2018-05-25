import java.util.*;

public class LinkedIntList {
	
	public class LinkedNode {
		int data;
		LinkedNode next;
		
		public LinkedNode(int data){
			this.data = data;
			this.next = null;
		}
		public LinkedNode(int data, LinkedNode next){
			this.data = data;
			this.next = next;
		}
	}
	
	/*
	 * add, add, get, indexOf, remove, size, toString
 The list is internally implemented as a chain of linked nodes 
 The LinkedIntListkeeps a reference to its front as a field 
 null is the end of the list;  
a null front signifies an empty list
	 * */
	
	private ListNode front;
	public LinkedIntList(){
		front = null;
	}
	public void add(int value){
		ListNode store = new ListNode(value);
		if(front == null){
			front = store;
		}
		else{
			ListNode current = front;
			while(current.next != null){
				current = current.next;
			}
			current.next = store;
		}
	}
	public int size(){
		int size = 1;
		ListNode current = front;
		while(current.next != null){
			current = current.next;
			size++;
		}
		return size;
	}
	public int get(int index){
		ListNode current = front;
		for(int i = 0; i < index; i++){
			if(current.next ==null){
				throw new IndexOutOfBoundsException();
			}
			current = current.next;
		}
		return current.data;
	}
	/**
	 * inserts new node at specified index of list.
	 * Precondition: 0 <= index <= size()
	 * */
	public void add(int index, int value){
		//if(index > )
		if (index ==0){
			front = new ListNode(value, front);
		}
		else{
			ListNode current = front;
			for(int i = 0; i < index; i++){
				if(current.next ==null){
					throw new IndexOutOfBoundsException();
				}
				current = current.next;
			}
			current.next = new ListNode(value, current.next);
		}
	}
	public int remove(){
		if(front == null){
			throw new NoSuchElementException();
		}
		int temp = front.data;
		front = front.next;
		return temp;
	}
	/*
	public int remove(int index){
		int store = 0;
		if(index == 0){
			remove();
		}
		else{
			
		}
	}
	*/
}
