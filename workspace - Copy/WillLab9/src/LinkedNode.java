//import LinkedIntList.LinkedNode;

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