
public class Grasshopper extends Critter{
	/*We use increment to count the number of steps for it's getmove
	 * and we use scale to increase the scale of it's overall getmove
	 * since after each fight, it goes one more for north and south.
	 * We check for it's previous fighting tendencies with the fighter boolean
	 * and control directions while keeping that info for fight and move with
	 * the currentDirection Direction enum.
	 * */
	private int increment = 0;
	private int scale =0;
	int direction = 0;
	private boolean fighter = false;
	private Direction currentDirection = Direction.CENTER;
	/*blank constructor, no need to take in or set any info*/
	public Grasshopper(){
	
	}
	
	/*
	 * */
	public Attack fight(String opponent){
		this.fighter = true;
		if(currentDirection == Direction.CENTER){
			return Attack.ROAR;
		}
		else{
			return Attack.FORFEIT;
		}
		
	}
	/*Checks if the 
	 * 
	 * */
	public Direction getMove(){
		if(fighter){
			scale++;
			increment = scale;
			fighter = false;
		}
		if(increment > 0){
			if(direction == 0){
				if(increment - 1 == 0){
					increment = scale;
					direction++;
				}
				else if(increment > 1){
					increment--;
				}
				currentDirection = Direction.NORTH;
				
			}
			else if(direction == 1){
				if(increment - 1 == 0){
					increment = scale;
					direction++;
				}
				else if(increment > 1){
					increment--;
				}
				currentDirection = Direction.SOUTH;
			}
			else if(direction == 2){
				increment = 0;
				direction = 0;
				currentDirection = Direction.WEST;
			}
		}
		else{
			currentDirection = Direction.CENTER;
		}
	return currentDirection;
	}
	

}
