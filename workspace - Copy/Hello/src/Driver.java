import java.util.Arrays;

public class Driver {
	public static void main(String[] args){
		ArrayIntList x = new ArrayIntList(10);
		x.add(10);
		x.add(20);
		//x.remove(0);
		for(int i = 1; i< 10; i++){
			x.add(i);
		}
		x.add(20);
		x.add(20);
		x.add(20);
		x.set(1, 300);
		//x.get(800);
		System.out.println(x.toString());
		
		int[] a1 = {5, 2, 7, 8, 4}; 
		int[] a2 = {2, 7, 42, 8}; 
		int[] a3 = {7, 42, 42};
		helper(a1, a2); 
		helper(a2, a3); 
		helper(new int[] {1, 2, 3, 4, 5}, new int[] {2, 3, 42, 4});
	}
	public static void helper(int[] elements, int[] expected){
		ArrayIntList list  = new ArrayIntList(elements.length);
		for(int i = 0; i < elements.length; i++){
			list.add(elements[i]);
		}
		list.remove(0);
		list.remove(list.size() - 1);
		list.add(2,42);
		for(int i = 0; i < expected.length; i++){
			if(list.get(i) != expected[i]){
				System.out.println("fail; expect " + Arrays.toString(expected) + ", actual " + list);
			}
		}
	}

}
