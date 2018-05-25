import java.util.Scanner;

//784 - 791
public class Queens1 {
	//private int size;
/*project name: WillLab7
filename: recursiveKochSnowflake
authors names: William Nguyen
last modification date: 5/18/2016
program description:
takes input of number and creates a snowflake image out of triangles, triangles being made out of lines, 
 recursively. 
 * */	  
	
	/*
	 * Takes in a number, calls the helper method and when the recursion ends the repeated iterations,
	 * says "Success" for when it ends on a successful note.
	 * */
	public static void main(String args[]){
		System.out.println("Provide the size of the board");
		Scanner input = new Scanner(System.in);
		
		int level = input.nextInt();
		solve(level);
		System.out.println("Result");
	}
	/*
	 * public helper method that takes in the size and creates an array to traverse
	 * that is the size inputed.
	 * calls private recursive method.
	 * */
	public static void solve(int size){
		int[] queenBoard = new int[size];
		solve(queenBoard, 0);
	}
	/*
	 * checks if the level has reached the size (end) of the square board, and if it has, print it.
	 * otherwise, it loops the size # of times, sets the board level to the current number keeping
	 * a position in the current layer of the queenBoard and checks if it's possible
	 * to do this specific iteration with this position, then solves for the next layer if this current position is possible
    */
	private static void solve(int[] queenBoard, int lev){
		int size = queenBoard.length;
		if(lev == size){
			System.out.println("Running Possibility");
			printQueens(queenBoard);
		}
		else{
			for(int i = 0; i < size; i++){
				queenBoard[lev] = i;
				if(possibility(queenBoard, lev)){
					solve(queenBoard, lev +1);
				}
			}
		}
	}
	/*
	 * Possibility iterates over the entire column and sees if there are any
	 * positions that actually do work, as in they don't line up with any
	 * other queens either diagonally or vertically.
	 * 
	 * */
	private static boolean possibility(int[] queenBoard, int lev) {
		// TODO Auto-generated method stub
		for(int i = 0; i < lev; i++){
			//if there is another queen in the same column, return false with a dead-end
			if(queenBoard[i] == queenBoard[lev]){
				return false;
			}
			//if there is another queen diagonal of this one  that is above, return false with a dead end
			if((queenBoard[i] - queenBoard[lev]) == (lev-i)){
				return false;
			}
			//if there is another queen for the other diagonal, return false again.
			if((queenBoard[lev] - queenBoard[i]) == queenBoard[lev - i]){
				return false;
			}
		}
		//return true since this can be placed without being taken
		return true;
	}
	
	/*
	 *  Iterates over the entire board, which it takes 2 for loops of the size to full iterate,
	 *  and if the numerical value matches the inner loop, then it puts a queen in place, or else
	 *  it just puts an asterisk for an empty spot
	 * */
	private static void printQueens(int[] queenBoard) {
		// TODO Auto-generated method stub
		int size = queenBoard.length;
		for(int i = 0; i < size; i++){
			for (int j= 0 ; j < size; j++){
				if(queenBoard[i] == j){
					System.out.print("Q ");
				}
				else{
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		System.out.println();
		
	}
}

 