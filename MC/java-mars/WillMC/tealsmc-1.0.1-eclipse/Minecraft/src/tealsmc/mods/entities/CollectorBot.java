package tealsmc.mods.entities;
import java.util.HashMap;

import org.tealsk12.tealsmodloader.builtin.entity.Robot;

import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class CollectorBot extends Robot{
	private float searchSize;
	private int amount;
	private ItemStack itemStack;
	private Item item;
	private EntityAICollectionLoot z;
	//private int mapAmount;
	private HashMap<Item,Integer> inventory= new HashMap<Item,Integer>();

	public CollectorBot(World world) {
		super(world);
		searchSize = 10;
		
		String itemName;
		EntityAIWander x=  new EntityAIWander(this,SPEED_SLOW);
		z = new EntityAICollectionLoot(this, searchSize);
		tasks.addTask(1, x);
		tasks.addTask(2,z);
		
		// TODO Auto-generated constructor stub
	}
	public void addItem(EntityItem x){
		itemStack=x.getEntityItem();
		item = itemStack.getItem();
		if(inventory.containsKey(x)){
			
			//mapItem = 
			amount = itemStack.stackSize + inventory.get(x);
			inventory.put(item, amount);
		}
		else{
			inventory.put(item, itemStack.stackSize);
		}
	}
	public void onEntityDamage(DamageSource source, float amount){
		z.suspend(20);
		this.dropInventory();
		
		
	}
	private void dropInventory() {
		// TODO Auto-generated method stub
		for(Item i: inventory.keySet()){
			dropItem(i,inventory.get(i));
			//dropItem(pizaa, 1);
		}
		inventory.clear();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
