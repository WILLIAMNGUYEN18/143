import java.util.*;
public class Armor extends Item{
//map could just be a string
private Map<String,Boolean> bodyPart;
private int armorValue;
	public Armor(String nam, int bon, String desc, String part, int armor) {
		super(nam, bon, desc, true);
		bodyPart = new HashMap<String, Boolean>();
		bodyPart.put(part, true);
		armorValue = armor;
		// TODO Auto-generated constructor stub
	}
	
	public int getArmorValue(){
		return this.armorValue;
	}
	
	
}

