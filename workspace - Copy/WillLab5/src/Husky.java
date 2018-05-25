import java.awt.Color;


/*project name: WillLab5
filename: Husky
authors names: William Nguyen. Brandon Thompson
last modification date: 5/4/2016
program description:
subclass of Critter that changes toString and getMove
eat, and fight.
 * constructor that doesn't take in anything. but does
 * randomly set the left boolean for the movement
 * */
public class Husky extends Critter{
	public int moveCount = 0;
	public int increment = 100;
	public int move;
	public boolean left;
	public Husky(){
		int x = (int)(Math.random()*2);
		if(x == 0){
			left = true;
		}
		else{
			left = false;
		}
	}
	/*toString is the character representation
	 * of the animal which is the letter H
	 */
	public String toString(){
		return "H";
	}
	/*
	 * Color returns the color, which I chose magenta
	 */
	public Color getColor(){
		return Color.MAGENTA;
	}
	
	/*Returns attack enum. We have it randomized after
	 * a number of moves to deal with all animals as
	 * we can't predict what other huskies will try.
	 * We use Scratch for the first 300 moves which works
	 * against hippos, a big threat, and the birds we may
	 * run into. Ants don't seem to be an issue as they
	 * get eliminated too early in.
	 * */
	public Attack fight(String x){
		if(moveCount <300){
			return Attack.SCRATCH;
		}
		int rand = (int)(Math.random() * 3) + 1;
		if(rand == 1){
			return Attack.ROAR;
		}
		else if(rand == 2){
		return Attack.POUNCE;
		}
		else if(rand == 3){
			return Attack.SCRATCH;
		}
		return Attack.SCRATCH;
	}

	/*
	 * eat returns if it will eat a food
	 * it's on false permanently so that it doesn't
	 * get caught off guard while eating since 
	 * it would automatically lose
	 */
	public boolean eat(){
		return false;
	}
	
	/*
	 * getMove returns a Direction enum,
	 * It moves either north or south very progressively,
	 * moving east or west a hundred units. It's either
	 * east and north or south and west
	 * which eventually leads to them meeting up
	 * An interesting find is that if they don't move for the early phase
	 * the likelihood of dying is greatly decreased.
	 * So for the first 300 moves, we keep it still.
	 * */
	public Direction getMove(){
		
		moveCount++;
		if (moveCount < 300) {
			return Direction.CENTER;
		}
		Direction currentDirection = Direction.CENTER;
		if(left){
			currentDirection = Direction.EAST;
		}
		else{
			currentDirection = Direction.WEST;
		}
		
		if(move >0){
			move--;
			return currentDirection;
		}
		if(move <= 0){
			move = 100;
			if(left){
				return Direction.NORTH;
			}
			else{
				return Direction.SOUTH;
			}
		}
		return currentDirection;
	}
}
