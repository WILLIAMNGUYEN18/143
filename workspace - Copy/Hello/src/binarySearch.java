
public class binarySearch {
	/*
	private int min;
	private int max;
	private int[] arr;
	*/
	public static int binarySearch1(int [] a, int target){
		/*
		this.arr = a;
		this.min = 0;
		this.max = a.length -1;
		*/
		return binarySearch1(a, 0, a.length -1, target);
	}
	public static void main(String[] args){
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
		int num = binarySearch1(arr, 10);
		System.out.println(num);
		num = binarySearch1(arr, 2);
		System.out.println(num);
		num = binarySearch1(arr, 20);
		System.out.println(num);
		num = binarySearch1(arr, 5);
		System.out.println(num);
		
	}
	private static int binarySearch1(int[] arr2, int min2, int max2, int target) {
		// TODO Auto-generated method stub
		if(min2 <= max2){
		int mid = (min2 + max2)/2;
		if(arr2[mid] == target){
			return mid;
			
		}
		else if(arr2[mid] > target){
			//max2 = mid;
			return binarySearch1(arr2, min2, mid-1, target);
			
		}
		else if(arr2[mid] < target){
			return binarySearch1(arr2, mid+1, max2, target);
		}
		}
		return -1;
	}
		
}
	/*
	private binarySearch(int [] a, int min, int max){
		
	}

}
*/
