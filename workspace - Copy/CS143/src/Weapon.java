
public class Weapon extends Item{
private int damage;
private boolean ranged;

	public Weapon(String nam, int bon, String desc, boolean eq, int damage, boolean range) {
		super(nam, bon, desc, eq);
		this.damage = damage;
		this.ranged = range;
		// TODO Auto-generated constructor stub
	}
	
	public int getDamage(){
		return this.damage;
	}
	public boolean ranged(){
		return this.ranged;
	}
	

}
