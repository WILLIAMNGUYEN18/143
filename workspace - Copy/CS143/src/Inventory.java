import java.util.*;

public class Inventory {
//private ArrayList<Item> currentEquip;
private ArrayList<Item> inventory;
private ArrayList<Stack<Item>> consumables;

	public Inventory(ArrayList<Item> i, ArrayList<Stack<Item>> c){
		this.inventory = i;
		this.consumables = c;
		
	}
	
	//int count parameter?
	//for(int i = 0; i < count; i++){
	//z.push(x);
	//}
	public void addItem(Item x){
		if(x.getEquip()){
			inventory.add(x);
		}
		else{
			if(consumables.contains(x)){
				Stack<Item> z = consumables.get(consumables.indexOf(x));
				z.push(x);
				consumables.set(consumables.indexOf(x), z);
			}
			else{
				Stack<Item> z = new Stack<Item>();
				z.push(x);
				consumables.add(z);
			}
		}
	}
	public Item getItem(int index){
		if(index <0 || index > inventory.size()){
			throw new IndexOutOfBoundsException();
		}
		return this.inventory.get(index);	
		
		//else if(consumables.)
	}
	public Item getConsumable(int index){
		if(index <0 || index > inventory.size()){
			throw new IndexOutOfBoundsException();
		}
		return this.consumables.get(index).peek();
	}
	public void removeInventory(int index){
		if(index <0 || index > inventory.size()){
			throw new IndexOutOfBoundsException();
		}
		this.inventory.remove(index);
	}
	public void removeConsumable(int index){
		if(index <0 || index > consumables.size()){
			throw new IndexOutOfBoundsException();
		}
		if(consumables.get(index).size() >=1){
		this.consumables.get(index).pop();
		}
		else{
			consumables.remove(index);
		}
	}
}
