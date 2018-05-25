import java.awt.Color;
/*project name: WillLab5
filename: Ant
authors names: William Nguyen. Brandon Thompson
last modification date: 5/4/2016
program description:
subclass of Critter that changes toString and getMove
eat, and fight.
 * constructor that takes in boolean
 * and sets another boolean to true.
 * These help define the movement of the ants
 * which go east and north/south
 * */
public class Ant extends Critter{
	private boolean wallSouth;
	private boolean alternate = true;
	
	public Ant(boolean wallSouth){
		this.wallSouth = wallSouth;
	}
	
	/*toString is the character representation
	 * of the animal which is the % sign
	 */

	public String toString(){
		return "%";
	}
	/*
	 * Color returns the color, which is red
	 */
	public Color getColor(){
		return Color.RED;
	}
	/*
	 * fight returns the attack enum of critter
	 * which is then used in main. It always scratches
	 * */
	public Attack fight(String x){
		return Attack.SCRATCH;
	}
	
	/*
	 * eat returns if it will eat a food
	 * it's on.
	 * */
	public boolean eat(){
		return true;
	}

	 
	/*
	 * getMove returns a Direction enum,
	 * the wallSouth boolean determining whether it goes north or south
	 * and the alternate varying whether it goes north or east for
	 * that turn.
	 * */
	public Direction getMove(){
		if(this.wallSouth){
			//s e s e
			if(alternate){
				alternate = false;
			return Direction.SOUTH;
			}
			else if(!alternate){
				alternate = true;
				return Direction.EAST;
			}
		}
		else{
			if(alternate){
				alternate = false;
				return Direction.NORTH;
			}
			else if(!alternate){
				alternate = true;
				return Direction.EAST;
			}
		}
		return Direction.CENTER;
		
	}
}










