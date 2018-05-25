import java.util.NoSuchElementException;



public class LLPractice<T> {
	private Node<T> front;
	private static class Node<T> {
		public final T data;
		public Node<T> next;
		
		public Node(T data){
			this.data = data;
			this.next = null;
		}
		public Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
		
	}
	
	//assume size method
	public void removeALL(T item) {
		if(this.front == null){
			throw new NoSuchElementException();
		}
		Node<T> current = front;
		for(int i = 0; i < size(); i++) {
			if(item.equals(current.data)) {
				remove(i);
			}
			current = current.next;
		}
	}
	
	public void removeFront(int n) {
		for(int i =0; i < n; i++) {
			front = front.next;
		}
	}


	
	public int size(){
		int size = 1;
		if(front == null){
			throw new NoSuchElementException();
		}
		Node<T> current = front;
		while(current.next != null){
			current = current.next;
			size++;
		}
		return size;
	}
	
	public void switchpairs() {

		Node<T> current = front;
		Node<T> temp = null;
		for(int i = 0; i < size(); i++) {
			if (i%2 == 0) {
				temp = current;
				current = current.next;
			}
		}
	}
	/*
	public void removeAll(T item) {
		// TODO Auto-generated method stub
		if(front == null){
			throw new NoSuchElementException();
		}
		LinkedNode current = front;
		for(int i = 0; i< this.size(); i++){
			if(item.indexOf(current.data) != -1){
				remove(i);
				i--;
			}
			current = current.next;
		}
		
	}
	*/
	
}
