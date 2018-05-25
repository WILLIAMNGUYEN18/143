
public class Person extends Entity{
private Armor helmet = new Armor("Straw hat", 0, "Makes you feel like a pirate for some reason.", "helmet", 1);
private Armor torso = new Armor("Cloth Bag", 0, "Wow. thinking back, you realize you're really poor", "torso", 1);
private Armor pants = new Armor("Pre-war Designer Jeans", 0, "Some call it bad clothes, but you call them designer", "pants", 1);
private Armor boots = new Armor("Footwraps", 0, "They cut the circulation and numb the pain", "boots" ,1);
private Armor gloves = new Armor("Tape", 0, "Good for grip", "gloves", 1);
//Change so that every person starts with default armor and then change it via choices.
	public Person(Inventory inventory, int section, Weapon wep, String nam, int hp, int intel, int agi, int str,
			int lvl) {
		super(inventory, section, wep, nam, hp, intel, agi, str, lvl);
		// TODO Auto-generated constructor stub
	}
	public Armor getHelm(){
		return this.helmet;
	}
	public Armor getTorso(){
		return this.torso;
	}
	public Armor getPants(){
		return this.pants;
	}
	public Armor getBoots(){
		return this.boots;
	}
	public Armor getGloves(){
		return this.gloves;
		
	}
	public void setGloves(Armor x){
		this.gloves = x;
	}
	public void setBoots(Armor x){
		this.boots = x;
	}
	public void setPants(Armor x){
		this.pants = x;
	}
	public void setTorso(Armor x){
		this.torso = x;
	}
	public void setHelm(Armor x){
		this.helmet =x;
	}

}
