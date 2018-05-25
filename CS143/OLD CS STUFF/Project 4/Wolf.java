import java.util.*;
public class Wolf extends Critter{
	/*project name: WillLab4
	filename: Wolf
	authors' last name: William Nguyen
	last modification date: 4/25/2016
	program description:
	subclass of Critter that changes toString and getMove
	*/
	
	private int move = 1;
	/*
	 * constructor that takes in 2 values
	 * to then send them to the superclass's
	 * constructor, giving an x,y location for that
	 * instance of the Wolf object
	 * */
	public Wolf(int x, int y){
		super(x,y);
		super.setInc(1);
		super.wrap();
	}
	/*overriding the toString method to now
	 * return "W"
	 * */
	public String toString(){
		return "W";
	}
	
	/*Takes in User input to choose a direction
	 * by letting them choose input an integer
	 * and if the integer is one of the four directional
	 * numbers, it then goes 1 unit in that direction
	 * Forces class invariant at end.
	 * */
	public void getMove(){
		int direct = 1;
		Scanner direction = new Scanner(System.in);
		System.out.println("To go West - Enter 1");
		System.out.println("To get East - Enter 2");
		System.out.println("To go North - Enter 3");
		System.out.println("To go South - Enter 4");
		try{
		direct = direction.nextInt();
		}
		catch(InputMismatchException i){
			System.out.println("Wrong input, need integer");
			System.out.println("Defaulting to West");
			direct = 1;
		}
		while(!(direct == 1 || direct == 2 || direct == 3 || direct == 4)){
			System.out.println("Please try to choose an integer");
			direct = direction.nextInt();
			
		}
		if(super.getInc() == 10){
			super.setInc(1);
		}
		if(direct == 1){
			if(super.getInc() != 10){
			super.setX(super.getX() - move);
			super.setInc(super.getInc() + move);
			}
		}
		else if(direct == 2){
			if(super.getInc() != 10){
			super.setX(super.getX() + move);
			super.setInc(super.getInc() + move);
			}
		}
		else if(direct == 3){
			if(super.getInc() != 10){
		
			super.setY(super.getY() + move);
			super.setInc(super.getInc() + move);
			}
		}
		else if(direct ==4){
			if(super.getInc() != 10){
		
			super.setY(super.getY() - move);
			super.setInc(super.getInc() + move);
			}
		}
		
		super.wrap();
	}

}
