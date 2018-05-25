import java.util.*;
public class Bird extends Critter {
	/*project name: WillLab4
	filename: Bird
	authors' last name: William Nguyen
	last modification date: 4/25/2016
	program description:
	subclass of Critter that changes toString and getMove
	 * constructor that takes in 2 values
	 * to then send them to the superclass's
	 * constructor, giving an x,y location for that
	 * instance of the bird object
	 * */
	public Bird(int x, int y){
		super(x,y);
		super.wrap();
	}
	/*overriding the toString method to now
	 * return "B"*/
	public String toString(){
		return "B";
	}
	/*
	 * overriding the getMove method to randomly
	 * move x or y by one in any direction
	 * left and right are changes in x
	 * and up and down is changes in y
	 * proceeds to wrap the numerical values if they extend off the
	 * 0-99 grid*/
	public void  getMove(){
		int direction = 0;
		int move = 1;
		direction = (int) (Math.random() * 4);
		if(direction == 0){
			//left == -x
			super.setX((super.getX()-move));
			super.wrap();
		}
		else if(direction == 1){
			//right == x
			super.setX((super.getX()+move));
			super.wrap();
		}
		else if(direction == 2){
			//up
			super.setY((super.getY()+move));
			
		}
		else if(direction == 3){
			super.setY((super.getY()-move));
		}
		super.wrap();
	}
}
