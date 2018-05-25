
public class Frog  extends Critter{
	/*project name: WillLab4
	filename: Frog
	authors' last name: William Nguyen
	last modification date: 4/25/2016
	program description:
	subclass of Critter that changes toString and getMove
	*/
	
	
	/*
	 * constructor that takes in 2 values
	 * to then send them to the superclass's
	 * constructor, giving an x,y location for that
	 * instance of the frog object
	 * */
	public Frog(int x, int y){
		super(x,y);
		super.wrap();
	}
	/*overriding the toString method to now
	 * return "F"*/
	public String toString(){
		return "F";
	}
	/*
	 * overriding the getMove method to randomly
	 * move x or y by 3 in any direction
	 * left and right are changes in x
	 * and up and down is changes in y
	 * proceeds to wrap the numerical values if 
	 * they extend off the0-99 grid*/
	public void getMove(){
		
		int move = 3;
		super.setInc((int) (Math.random() * 4));
		if(super.getInc() == 0){
			//left == -x
			if(move != 0){
			super.setX((super.getX()-1));
			move--;
			}
			
		}
		else if(super.getInc() == 1){
			//right == x
			if(move != 0){
			super.setX((super.getX()+1));
			move--;
			}
			
		}
		else if(super.getInc() == 2){
			//up
			if(move != 0){
			super.setY((super.getY()+1));
			move--;
			}
			
		}
		else if(super.getInc() == 3){
			if(move != 0){
			super.setY((super.getY()-1));
			move--;
			}
		}
		if(move == 0){
			move = 3;
		}
		super.wrap();
	}
}


