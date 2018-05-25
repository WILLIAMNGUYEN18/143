
public class Snake extends Critter{
	/*project name: WillLab4
	filename: Snake
	authors' last name: William Nguyen
	last modification date: 4/25/2016
	program description:
	subclass of Critter that changes toString and getMove
	*/
	private int movesLeft = 0;
/*
 * constructor that takes in 2 values
 * to then send them to the superclass's
 * constructor, giving an x,y location for that
 * instance of the Snake object
 * */
	public Snake(int x, int y){
		super(x,y);
		super.setInc(1);
		super.wrap();
	}
	/*
	 * overriding the getMove method to randomly
	 * move x or y by increasingly moving left and right
	 * while constantly moving down (-y). It checks if increment
	 * is even, and goes west or east depending, wraps. 
	 * Increases increment and then repeats.
	 * */
	public void getMove(){
		
		if(super.getInc() % 2 == 0 && this.movesLeft != 0){
			
			super.setX(super.getX() - 1);
			this.movesLeft--;
		}
		else if(super.getInc() % 2 == 1 && this.movesLeft != 0){
			super.setX(super.getX() + 1);
			this.movesLeft--;
		}
		else if(this.movesLeft == 0){
			super.setY(super.getY() - 1);
			super.setInc(super.getInc() + 1);
			this.movesLeft = super.getInc();
			
		}
		super.wrap();
		

	}
	/*overriding the toString method to now
	 * return "S"*/
	public String toString(){
		return "S";
	}
}
