//import LinkedIntList.LinkedNode;
public class LinkedDrive {
	public static void main(String[] args){
		
		LinkedNode nn = new LinkedNode(30);
		LinkedNode n = new LinkedNode(20);
		LinkedNode list = new LinkedNode(10);
		LinkedNode current = list;
		list.next = n;
		list.next.next = nn;
		while(current != null){
			System.out.println(current.data);
		current = current.next;
		}
		
		/*
		list.next.next = new LinkedNode(30);
		list.next = n;
		list = nn;
		*/
		System.out.println();
		System.out.println();
		list = new LinkedNode(10, new LinkedNode(20));
		LinkedNode temp = new LinkedNode(30);
		temp.next = list;
		//list.next = n;
		//list.next.next = temp;
		
		current = temp;
		while(current != null){
			System.out.println(current.data);
		current = current.next;
		}
		
		//list.next.next = null;
		
		/*
		current = list;
		while(current != null){
			System.out.println(current.data);
		current = current.next;
		}
		//current.next = new LinkedNode(1000);
		*/
		System.out.println();
		System.out.println();
		LinkedNode list1 = new LinkedNode(10, new LinkedNode(20));
		LinkedNode list2 = new LinkedNode(30,new LinkedNode(40));
		temp = list2;
		list2 = list2.next;
		//list1.next = list2;
		temp.next = list1.next;
		list1.next = temp;
		
		
		current = list1;
		while(current != null){
			System.out.println(current.data);
		current = current.next;
		}
		
		System.out.println();
		System.out.println();
		current = list2;
		while(current != null){
			System.out.println(current.data);
		current = current.next;
		}
		
		System.out.println();
		System.out.println();
		list = new LinkedNode(10, new LinkedNode(20,new LinkedNode(30, new LinkedNode(990))));
		current = list;
		while(current != null){
			System.out.println(current.data);
		current = current.next;
		}
		current = new LinkedNode(1000);
		System.out.println(current.data);
		
		LinkedIntList y = new LinkedIntList();
		y.add(50);
		y.add(70);
		y.add(60);
		LinkedIntList x = new LinkedIntList();
		for(int i = 0; i < 11; i++){
		x.add(10*i);
		}
		//x.add(20);
		//x.add(30);
		
		
		
		System.out.println();
		System.out.println("testing toString");
		System.out.println(x.toString());
		
		System.out.println();
		System.out.println("testing Size: " + x.size());
		
		
		System.out.println();
		System.out.println("testing removeAll");
		x.removeAll(y);
		System.out.println(x.toString());
		
		System.out.println();
		System.out.println("testing Size: " + x.size());
		
		
		System.out.println();
		System.out.println("testing clear");
		x.clear();
		System.out.println("Is it empty?: " + x.isEmpty());
		
		System.out.println();
		System.out.println("testing add and remove and set after giving values");
		for(int i = 1; i < 11; i++){
			x.add(10*i);
		}
		x.add(6, 3000);
		x.remove(1);
		x.set(10, 9000);
		System.out.println(x.toString());
		
		
		System.out.println();
		System.out.println("Y: " + y.toString());
		System.out.println(x.toString());
		System.out.println("testing retainAll");
		x.retainAll(y);
		System.out.println(x.toString());
		
		
		System.out.println();
		System.out.println("testing Size: " + x.size());
		
		
		
		System.out.println();
		System.out.println("testing sorted");
		x.addSorted(65);
		x.addSorted(100);
		x.addSorted(5);
		System.out.println(x.toString());
	}

}
