
public class Mouse  extends Critter{
	/*project name: WillLab4
	filename: Mouse
	authors' last name: William Nguyen
	last modification date: 4/25/2016
	program description:
	subclass of Critter that changes toString and getMove
	*/
	
	/*
	 * constructor that takes in 2 values
	 * to then send them to the superclass's
	 * constructor, giving an x,y location for that
	 * instance of the Mouse object
	 * */
	public Mouse(int x, int y){
		super(x,y);
		super.setInc(1);
		super.wrap();
		
	}
	/*overriding the toString method to now
	 * return "M"*/
	public String toString(){
		return "M";
	}
	/*
	 * overriding the getMove method to randomly
	 * move x or y by moving to the west/left (-x)
	 * and up/north(+y) by 1 unit each
	 * and then wraps the method with class invariants.
	 * */
	public void getMove(){
		
		int move = 1;
		//left 1, up 1
		if(super.getInc() == 1){
		super.setX(super.getX() - move);
		
		}
		else if(super.getInc() == 2){
		super.setY(super.getY() + move);
		super.setInc(1);
		}
		super.wrap();
	}
}
