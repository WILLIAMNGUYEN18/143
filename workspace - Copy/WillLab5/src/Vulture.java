import java.awt.Color;
/*project name: WillLab5
filename: Vulture
authors names: William Nguyen. Brandon Thompson
last modification date: 5/4/2016
program description:
subclass of Critter that changes toString and getMove
eat, and fight.
 * constructor that doesn't take in anything.
 * 
 * */
public class Vulture extends Critter{
	private boolean hunger = true;
	private Direction currentDirection = Direction.NORTH;
	private int move = 0;
	public Vulture(){
		
	}
	/*
	 * Color returns the color, which is black
	 */
	public Color getColor(){
		return Color.BLACK;
	}
	/*
	 * eat returns if it will eat a food
	 * which vultures are hungry until they eat once, or they fight.
	 */
	public boolean eat(){
		if(hunger){
			return true;
		}
		return false;
		
	}
	/*
	 * fight returns the attack enum of critter
	 * which is then used in main. It roars at ants in any
	 * direction, and otherwise scratches. If it fights, its hunger
	 * becomes false again, so it needs to eat again.
	 */
	public Attack fight(String x){
		hunger = false;
		if(getNeighbor(Direction.EAST).equals("%")){
			return Attack.ROAR;
		}
		else if(getNeighbor(Direction.NORTH).equals("%")){
			return Attack.ROAR;
		}
		else if(getNeighbor(Direction.SOUTH).equals("%")){
			return Attack.ROAR;
		}
		else if(getNeighbor(Direction.WEST).equals("%")){
			return Attack.ROAR;
		}
		return Attack.POUNCE;
	}
	/*
	 * getMove returns a Direction enum,
	 * It moves in a 3 by 3 square, incrementing move and
	 * circling over and over for the duration of the sim.
	 * */
	public Direction getMove(){
		if(currentDirection== Direction.NORTH){
			if(move != 3 ){
				move++;
				return currentDirection;
			}
			else if(move == 3){
				move = 0;
				currentDirection = Direction.EAST;
			}
		}
		if(currentDirection == Direction.EAST){
			if(move !=3){
				move++;
				return currentDirection;
			}
			else if(move == 3){
				move = 0;
				currentDirection = Direction.SOUTH;
			}
		}
		if(currentDirection == Direction.SOUTH){
			if(move !=3){
				move++;
				return currentDirection;
			}
			else if(move == 3){
				move = 0;
				currentDirection = Direction.WEST;
			}
		}
		if(currentDirection == Direction.WEST){
			if(move != 3){
				move++;
				return currentDirection;
			}
			else if(move == 3){
				move = 1;
				currentDirection = Direction.NORTH;
				return currentDirection;
			}
		}
		return Direction.CENTER;
	}
	/*toString is the character representation
	 * of the animal which varies on a different v or arrow
	 * depending on which direction it is going.
	 */
	public String toString(){
		if(currentDirection == Direction.NORTH){
			return "^";
		}
		else if(currentDirection == Direction.EAST){
			return ">";
		}
		else if(currentDirection == Direction.SOUTH){
			return "V";
		}
		else if(currentDirection == Direction.WEST){
			return "<";
		}
		return "^";
	}

}
