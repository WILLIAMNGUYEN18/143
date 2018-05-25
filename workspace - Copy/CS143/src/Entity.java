
public class Entity {
private Inventory myInventory;
private int currentSection;
private Weapon myWeapon;
private String name;
private int Maxhealth;
private int health;
private int intelligence;
private int agility;
private int strength;
private int level;
	public Entity(Inventory inventory, int section, Weapon wep, String nam, int hp, int intel, int agi, int str, int lvl){
		this.myInventory = inventory;
		this.currentSection = section;
		this.myWeapon = wep;
		this.Maxhealth = hp;
		this.health = this.Maxhealth;
		this.intelligence = intel;
		this.agility = agi;
		this.strength = str;
		this.level = lvl;
	}
	
	public Inventory getInventory(){
		return this.myInventory;
	}
	public void addInventory(Item x){
		this.myInventory.addItem(x);
	}
	public int getSection(){
		return this.currentSection;
	}
	public Weapon getWeap(){
		return this.myWeapon;
	}
	public String getName(){
		return this.name;
	}
	public int health(){
		return this.health;
	}
	public int getMaxHealth(){
		return this.Maxhealth;
	}
	public int getAgi(){
		return this.agility;
	}
	public int getStr(){
		return this.strength;
	}
	public int getIntel(){
		return this.intelligence;
	}
	public int getLevel(){
		return this.level;
	}
	
	public void setWeap(Weapon x){
		this.myWeapon = x;
	}
	public void setHealth(int x){
		this.health = x;
	}
	public void setMaxHealth(int x){
		this.Maxhealth = x;
	}
	public void setAgi(int x){
		this.agility = x;
	}
	public void setStr(int x){
		this.strength = x;
	}
	public void setIntel(int x){
		this.intelligence =x;
	}
	public void addLevel(){
		this.level++;
	}
	public void setSection(int x){
		this.currentSection = x;
	}
	
}
