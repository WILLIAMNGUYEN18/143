import java.util.*;


/*projectName: WillLab9
 * fileName: LinkedIntList
 * author name: William Nguyen
 * last modification date: 6/1/16
 * description: create Linked List that deals with integers and implements the
 * methods specified. Deals with exceptions to pre/post conditions.
 * */
public class LinkedIntList  implements IntList{
	
	/**
	 * Internal class LinkedNode with public fields within this class.
	 * Only we access it and we use it to store our lists.
	 * */
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
		public String toString(){
			return this.data +"";
		}
	}
	
	private LinkedNode front;
	
	/**
	 * Creates a new empty linkedList.
	 * */
	public LinkedIntList(){
		front = null;
	}
	
	
	/**
	 * Precondition: LinkedList exists.
	 * Postcondition: adds a value to the LinkedList, or creates a new value
	 * */
	public void add(int value){
		LinkedNode store = new LinkedNode(value);
		if(front == null){
			front = store;
		}
		else{
			LinkedNode current = front;
			while(current.next != null){
				current = current.next;
			}
			current.next = store;
		}
	}
	
	/**
	 * Precondition: if front isn't null
	 * Postcondition: returns the size of the LinkedList
	 * */
	public int size(){
		int size = 1;
		if(front == null){
			throw new NoSuchElementException();
		}
		LinkedNode current = front;
		while(current.next != null){
			current = current.next;
			size++;
		}
		return size;
	}
	
	/**
	 * 
	 * 
	 * */
	public int get(int index){
		LinkedNode current = front;
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
		if (index ==0){
			front = new LinkedNode(value, front);
		}
		else{
			LinkedNode current = front;
			for(int i = 0; i < index; i++){
				if(current.next ==null){
					throw new IndexOutOfBoundsException();
				}
				current = current.next;
			}
			current.next = new LinkedNode(value, current.next);
		}
	}
	
	/**
	 * Precondition: our front linkedlist node has to have a value.
	 * Postcondition: the first node of front will be removed.
	 * */
	public int remove(){
		if(front == null){
			throw new NoSuchElementException();
		}
		int temp = front.data;
		front = front.next;
		return temp;
	}
	
	/**
	 * Precondition: 0<= index <= size
	 * Postcondition: removes the value by placing the previous value's next to the value after this index.
	 * 
	 * */
	public void remove(int index){
		//int num = 0;
		if(index <0 || index > this.size()){
			throw new IndexOutOfBoundsException();
		}
		//int store = 0;
		LinkedNode current = front;
		if(index == 0){
			remove();
		}
		else{
			/*
			while(num+1 < index){
				current = current.next;
				num++;
			}
			*/
			for(int i = 0; i+1 < index; i++){
				if(current.next ==null){
					throw new IndexOutOfBoundsException();
				}
				current = current.next;
			}
			//store = current.next.data;
			current.next = current.next.next;
		}
		//return store;
	}
	
	
	
	/**
	 * Precondition: our Front linkedlist has some value
	 * Postcondition: returns a string of the values between brackets with spaces and commas.
	 * 
	 * */
	public String toString(){
		String store = "[";
		LinkedNode current = front;
		store+= current.data;
		while(current.next != null){
			current = current.next;
			store+= ", " + current.data;
		}
		store+= "]";
		return store;
	}
	/**
	 * Precondition: You have a list (front)
	 * Postcondition: removes all values by setting front to an empty node.
	 * */
	public void clear(){
		LinkedNode x = new LinkedNode(0);
		front = x;
	}
	
	
	/**
	 * Precondition: LinkedList exists
	 * Postcondition: finds out whether the LinkedList is empty and returns a boolean
	 * */
	public boolean isEmpty(){
		LinkedNode current = front;
		if(current == null || current.next ==null && current.data == 0){
			return true;
		}
		return false;
		
	}


	@Override
	
	/**
	 * Precondition: LinkedList must have a value
	 * Postcondition: return either the index of the value or -1 if it doesn't exist
	 * in the list 
	 * */
	public int indexOf(int value) {
		// TODO Auto-generated method stub
		int index = 0;
		if(front == null){
			throw new NoSuchElementException();
		}
		
		LinkedNode current = front;
		if(current.data == value){
			return index;
		}
		while(current.next != null){
			
			if(current.next.data == value){
				return index + 1;
			}
			current = current.next;
			index++;
			
		}
		return -1;
	}


	@Override
	/**
	 * Precondition: 0<= index <= size
	 * PostCondition: sets value at specific index to new value;
	 * */
	public void set(int index, int value) {
		if(index < 0 || index > this.size()){
			throw new IndexOutOfBoundsException();
		}
		LinkedNode current = front;
		for(int i = 0; i < index; i++){
			current = current.next;
			
		}
		current.data = value;
		// TODO Auto-generated method stub
		
	}


	@Override
/**
 * Precondition:front isn't null
 * Postcondition: removes all elements of this.list that match Otherlist
 * */
	public void removeAll(IntList Otherlist) {
		// TODO Auto-generated method stub
		if(front == null){
			throw new NoSuchElementException();
		}
		LinkedNode current = front;
		for(int i = 0; i< this.size(); i++){
			if(Otherlist.indexOf(current.data) != -1){
				remove(i);
				i--;
			}
			current = current.next;
		}
		
	}


	@Override
	/**
	 * Precondition: List has to exist.
	 * Postcondition: Keeps only the values that are in the otherlist.
	 * */
	public void retainAll(IntList Otherlist) {
		// TODO Auto-generated method stub
		
		if(front == null){
			throw new NoSuchElementException();
		}
		LinkedNode current = front;

		for(int i = 0; i< this.size(); i++){
			if(Otherlist.indexOf(current.data) == -1){
				remove(i);
				i--;
			}
			current = current.next;
		}
		
		
	}


	@Override
	/**
	 * Precondition: Linkedlist is sorted
	 * Postcondition: Adds a new value to the sorted list.
	 * */
	public void addSorted(int value) {
		if(front == null){
			throw new NoSuchElementException();
		}
		LinkedNode current = front;
		int size = this.size();
		for(int i = 0; i < size; i++){
			if(i == size-1){
				this.add(value);
			}
			if(value < front.data){
				this.add(0, value);
			}
			if(current.data < value && current.next.data > value){
				this.add(i, value);
			}
			
			current = current.next;
		}
		
	}
}


