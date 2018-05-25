import java.awt.Color;
/*project name: WillLab5
filename: Hippo
authors names: William Nguyen. Brandon Thompson
last modification date: 5/4/2016
program description:
subclass of Critter that changes toString and getMove
eat, and fight.
 * constructor that takes in a number and
 * sets the hunger level of the hippo.
 * The hippo moves randomly in sets of 5 per direction.
 * */
public class Hippo extends Critter{
	private int hungry;
	private int move = 5;
	private Direction currentDirection = Direction.NORTH;
	public Hippo(int hunger){
		this.hungry = hunger;
	}


	/*
	 * Color returns the color, which is gray until hunger is empty,
	 * then white.
	 */
	public Color getColor(){
		if(hungry > 0){
			return Color.GRAY;
		}
		else{
			return Color.WHITE;
		}
	}
	/*
	 * eat returns if it will eat a food
	 * it's on until the hunger number is empty, decrementing
	 * with each eaten food.
	 *
	 * 
	 */
	public boolean eat(){
		if(this.hungry > 0 ){
			this.hungry--;
			return true;
		}
		return false;
	}
	/*
	 * fight returns the attack enum of critter
	 * which is then used in main. It scratches until hunger is empty,
	 * then pouncing.
	 */
	public Attack fight(String x){
		if(this.hungry > 0){
			return Attack.SCRATCH;
		}
		return Attack.POUNCE;
	}
	/*
	 * getMove returns a Direction enum,
	 * It randomly chooses a direction and goes in it for 5 moves.
	 * The moves is decremented and then reset to control the number
	 * of moves in a given direction.
	 * */
	public Direction getMove(){
		int r = 0;
		r = (int) ((Math.random() * 4) + 1);
		if(move == 1){
			move = 5;
			if(r == 1){
			currentDirection = Direction.NORTH;
			}
			else if(r == 2){
			currentDirection = Direction.SOUTH;
			}
			else if(r == 3){
			currentDirection = Direction.EAST;
			}
			else if(r == 4){
			currentDirection = Direction.WEST;
			}
		}
		else if(move != 1){
			move--;
			return currentDirection;
		}
		return currentDirection;
		
	}
	/*toString is the character representation
	 * of the animal which is the number of hunger
	 */
	public String toString(){
		return hungry + "";
	}

}
