
public class Rabbit extends Critter{
	/*project name: WillLab4
	filename: Rabbit
	authors' last name: William Nguyen
	last modification date: 4/25/2016
	program description:
	subclass of Critter that changes toString and getMove
	*/
private int move = 2;
	
	/*
	 * constructor that takes in 2 values
	 * to then send them to the superclass's
	 * constructor, giving an x,y location for that
	 * instance of the Rabbit object
	 * */
	public Rabbit(int x, int y){
		super(x,y);
		super.setInc(1);
		super.wrap();
	}
	
	/*
	 * overriding the getMove method to randomly
	 * move x or y by hopping up (+y), to the east/right (+x)
	 * and to the southdown(-y), effectively just moving right
	 * by 1 unit, then wrapping with class invariants after.
	 * */
	public void getMove(){
		if(super.getInc() == 1){
			if(move != 0){
				super.setY(super.getY() + 1);
				move--;
			}
			else if(move == 0){
				super.setInc(2);
			}
		}
	
		else if(super.getInc() == 2){
			if(move != 0){
				super.setX(super.getX() + 1);
				move--;
			}
			else if(move == 0){
				super.setInc(2);
			}
		}
		
		
		else if(super.getInc() == 3){
			if(move != 0){
				super.setY(super.getY() - 1);
				move--;
			}
			else if(move == 0){
			super.setInc(2);
			}
		}
		if(move == 0){
			move = 2;
		}
		super.wrap();
	}
	/*overriding the toString method to now
	 * return "V"*/
	public String toString(){
		return "V";
	}

}
