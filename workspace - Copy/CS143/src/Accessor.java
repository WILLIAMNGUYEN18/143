import java.util.*;

public class Accessor extends Item{
private Map<String,Boolean> unlock;

	public Accessor(String nam, int bon, String desc, boolean eq, Map<String,Boolean> unlock) {
		super(nam, bon, desc, eq);
		this.unlock = unlock;
		// TODO Auto-generated constructor stub
	}
	
	public boolean getUnlock(String target){
		boolean open = false;
		for(String x: unlock.keySet()){
			if(target.equals(x)){
				open = true;
			}
		}
	return open;
	}
}
