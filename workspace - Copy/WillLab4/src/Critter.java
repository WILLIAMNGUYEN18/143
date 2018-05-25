import java.util.*;

public class Critter {
	/*
	project name: WillLab4
	filename: Critter
	authors' last name: William Nguyen
	last modification date: 4/25/2016
	program description:
		Critter class
	 * Has 2 fields, x and y locations
	 * default constructor randomly places
	 * Critter on grid (x,y values)
	 * a basic implementation of toString()
	 * and a basic implementation of getMove()
	 * have a class invariant on the x,y so that
	 * they wrap around if they're over 99 or under 0
	 * */
	//0<= locations <= 99
	private int increment;
	private int x_location;
	private int y_location;
	/*default constructor, sets the x and y to random between 0 & 99
	 * also wraps unnecessarily to force class invariants
	 * */
	public Critter(){
	this.x_location = (int) (Math.random()*99);
	this.y_location = (int) (Math.random()*99);
	this.wrap();
	}
	/*Takes in two different positions (integers)
	 *sets x and y to the positions
	 * forces class invariants with wrap method.
	 * */
	public Critter(int x, int y){
		this.x_location = x;
		this.y_location = y;
		this.wrap();
	}
	//
	/*class invariant
	 *if the two locations (integer fields)
	 *are greater than 99 or less than 0,
	 *reset the value to the remainder (modulo)
	 *of that value divided by 99 to effectively
	 *wrap it around the other side of the map. If less than 0
	 *make it 99 - the remainder 
	 * */
	public void wrap(){
		if(this.y_location >=99){
			this.y_location = this.y_location%99;
		}
		else if(this.y_location <=0){
			this.y_location = 99 - (this.y_location%99);
		}
		if(this.x_location >= 99){
			this.x_location = this.x_location%99;
		}
		else if(this.x_location <=0){
			this.x_location = 99-(this.x_location%99);
		}
	}
	
	/*default toString to be overridden
	 * return "?" at this point.
	 * */
	public String toString(){
		return "?";
	}
	/*getters
	 * getting the x field and y field
	 * (integers)
	 * */
	public int getX(){
		return this.x_location;
	}
	public int getY(){
		return this.y_location;
	}
	
	public int getInc(){
		return this.increment;
	}
	/*sets the x and y value to the corresponding int
	 *parameter of each set method
	 *
	 * */
	public void setY(int y){
		this.y_location = y;
	}
	public void setX(int x){
		this.x_location = x;
	}
	
	public void setInc(int inc){
		this.increment = inc;
	}
	/*unimplemented getMove that will be overriden in the
	 * subclasses.
	 * */
	public void getMove(){
		
	}
	
		
		
		
}


