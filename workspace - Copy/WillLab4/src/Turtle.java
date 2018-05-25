
public class Turtle extends Critter{
	/*project name: WillLab4
	filename: Turtle
	authors' last name: William Nguyen
	last modification date: 4/25/2016
	program description:
	subclass of Critter that changes toString and getMove
	*/
	
	private int move = 5;
	/*
	 * constructor that takes in 2 values
	 * to then send them to the superclass's
	 * constructor, giving an x,y location for that
	 * instance of the Turtle object
	 * */
	public Turtle(int x, int y){
		super(x,y);
		super.setInc(1);
		super.wrap();
	}
	/*
	 * overriding the getMove method to randomly
	 * move x or y by moving 5 down (-y), 5 left (-x)
	 * then reverting that by going north 5 (+y)
	 * and then right 5 (+x), ending back up in the original
	 * position. forces class invariant at end.
	 * */
	public void getMove(){
		if(super.getInc() == 1){
		super.setY(super.getY() - 1);
		move--;
			if(move == 1){
				super.setInc(super.getInc() + 1);
				move = 5;
			}
		
		}
		
		
		else if(super.getInc() == 2){
		super.setX(super.getX() - 1);
		move--;
			if(move == 1){
				super.setInc(super.getInc() + 1);
				move = 5;
			}
		
		}
		
		
		else if(super.getInc() == 3){
		super.setY(super.getY() + 1);
		move--;
			if(move == 1){
				super.setInc(super.getInc() + 1);
				move = 5;
			}
		}
		
		
		else if(super.getInc() == 4){
		super.setX(super.getX() + 1);
		move--;
			if(move == 1){
				super.setInc(1);
				move = 5;
			}
		}
		super.wrap();
	}
	
	/*overriding the toString method to now
	 * return "T"
	 * */
	public String toString(){
		return "T";
	}
	

}
