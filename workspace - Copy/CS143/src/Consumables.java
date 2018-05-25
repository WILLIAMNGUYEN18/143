
public class Consumables extends Item{
	private int value;

	public Consumables(String nam, int bon, String desc, int val) {
		super(nam, bon, desc, true);
		this.value = val;
		// TODO Auto-generated constructor stub
	}
	public int getValue(){
		return this.value;
	}

}
