package tealsmc.mods.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class SoundBarrier extends Item{
	//true audio = speed
	//false audio = healing
	private boolean Audio;
	//private PotionEffect speedBoost = new PotionEffect();
	private World world;
	private EntityPlayer player;
	private float dist;
	private static final float SEARCH_RANGE = 12;
	private ArrayList<Integer> otherPlayers = new ArrayList<Integer>();
	private EntityPlayer store;
	private float current = 0;
	public SoundBarrier(){
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabTools);
		
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		float temp = System.currentTimeMillis();
		if(temp - current < 10000){
			return stack;
		}
		current =temp;
		this.Audio = !this.Audio;
		this.world = world;
		this.player = player;
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	if(Audio){
		        			//SoundBarrier.this.player.heal(5);
		            		if(SoundBarrier.this.player.isPotionActive(Potion.regeneration)){
		            		SoundBarrier.this.player.clearActivePotions();
		            		}
		            		
		            		SoundBarrier.this.player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 3));
		            		
		            		
		        		}
		        		else{
		        			if(SoundBarrier.this.player.isPotionActive(Potion.regeneration)){
			            		SoundBarrier.this.player.clearActivePotions();
			            	}
		        			SoundBarrier.this.player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,100,3));
		        		}
		        		
		        		List<Entity> entityList = (List<Entity>) world.getLoadedEntityList();
		        		//float min=entityList.get(0).getDistanceToEntity(player);//may break if the entity is closer than the item
		        		for(int i=0;i<entityList.size();i++){
		        			if(entityList.get(i).getClass().equals(EntityPlayer.class)){
		        				
		        				
		        				store = (EntityPlayer) entityList.get(i);
		        				dist= store.getDistanceToEntity(player);
		        				//otherPlayers.add(i);
		        				if(dist < SEARCH_RANGE){
		        					if(SoundBarrier.this.Audio){
		        						if(SoundBarrier.this.store.isPotionActive(Potion.regeneration)){
		        		            		SoundBarrier.this.store.clearActivePotions();
		        		            		}
		        						store.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 3));
		        					
		        					}
		        					else{
		        						if(SoundBarrier.this.store.isPotionActive(Potion.regeneration)){
		        		            		SoundBarrier.this.store.clearActivePotions();
		        		            		}
		        					store.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,5,0));
		        					}
		        				}
		        			}
		        		}
		            }
		        }, 
		        1000 
		);
		
		return stack;
	}
	/*
	public void onUpdateTick(){
		//int index = 0;
		if(Audio){
			this.player.heal(5);
		}
		else{
			this.player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,12*20,100));
		}
		
		List<Entity> entityList = (List<Entity>) world.getLoadedEntityList();
		//float min=entityList.get(0).getDistanceToEntity(player);//may break if the entity is closer than the item
		for(int i=0;i<entityList.size();i++){
			if(entityList.get(i).getClass().equals(EntityPlayer.class)){
				
				
				store = (EntityPlayer) entityList.get(i);
				dist= store.getDistanceToEntity(player);
				//otherPlayers.add(i);
				if(dist < SEARCH_RANGE){
					if(this.Audio){
						
						store.heal(5);
					
					}
					else{
					
					store.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,12*20,0));
					}
				}
			}
		}
	}
	*/
}


/*				if(!entityList.get(i).isDead){
					dist= entityList.get(i).getDistanceToEntity(player);
					if(dist <= min && dist <search){
						min = dist;
						index =i;
					}
				}
 * */
