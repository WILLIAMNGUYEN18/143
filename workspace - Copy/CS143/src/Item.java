
public class Item {
private String name;
private int bonus;
private String description;
private boolean equip;

	public Item(String nam, int bon, String desc, boolean eq){
		this.name = nam;
		this.bonus = bon;
		this.description = desc;
		this.equip = eq;
	}
	public String getName(){
		return this.name;
	}
	public int getBonus(){
		return this.bonus;
	}
	public String getDescription(){
		return this.description;
	}
	public boolean getEquip(){
		return this.equip;
	}
}
