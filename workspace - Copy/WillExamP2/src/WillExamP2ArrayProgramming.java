import java.util.*;

/*Author: William Nguyen
 * Project Name: WillExamP2
 * File Name: WillExamP2ArrayProgramming
 * Date:4/21/16
 * Desc: return length of longest sequence of consecutive integers in an array based list.
 * 
 * 
 * */
public class WillExamP2ArrayProgramming {
	
	private static int[] elementData;
	private int size = 11;
	public static void main(String[] args){
		//elementData = new int[]{1, 18, 2, 7, 8, 9, 10, 39, 18, 19, 40};
		//elementData = new int[]{1, 18, 2, 7, 8, 9, 10, 11, 12, 19, 40};
		//elementData = new int[]{1, 18, 2, 7, 8, 123, 45, 56, 12, 19, 40};
		//elementData = new int[]{1, 18, 2, 7, 8, 12, 13, 14, 12, 19, 40};

		System.out.println(maxConsecutive(elementData));
	}
	
	
	/*
	 * finds all the consecutive values in an integer array.
	 * stores them in an ArrayList
	 * Proceeds to compare consecutive indexes of the array from the Arraylist to see if they are consecutive and 
	 * if the number values are consecutive. If so, add one to counter, if not, reset the counter
	 * during addition to counter, check if max values is higher than counter;
	 * 
	 * */
	public static int maxConsecutive(int[] array){
		ArrayList<Integer> store = new ArrayList<Integer>();
		int count = 1;
		int max = 1;
		//if a number and its consecutive number are consecutive numbers, add the first
		//number to an arraylist, separating consecutive numbers and other numbers
		for(int i = 0; i < array.length-1; i++){
			if(array[i] == (array[i+1] - 1)){
				store.add(i);
			}
			//getting the values that are at the end of a consecutive sequence.
			else if(i >=1){
			if(array[i] == (array[i-1] +1)){
				store.add(i);
			}
			}
			
		}
		for(int j = 0; j< store.size()-1; j++){
			//if the index of two values and two values are both incrementing (consecutive), then add one to the counter.
			//then check if the max count is lower than the new count and set max to count if so.
			//if not, the counter is reset
			if((store.get(j) == (store.get(j+1) - 1)) && (array[store.get(j)] == array[store.get(j+1)] -1)){
				count++;
				
				if(max < count){
					max = count;
					
				}
			}
			else{
				count = 1;
			}
			
		}
			//return the highest count value, as count can be reset and the highest is stored in max
		return max;
	}
}
