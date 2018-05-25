package tealsmc.mods.entities;

import org.tealsk12.tealsmodloader.builtin.entity.Robot;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import net.minecraft.*;
import java.util.*;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityAICollectionLoot extends EntityAIBase{
	private float dist;
	private float suspendEnd =0;
	private int index;
	private EntityItem targetLoot = null;
	private CollectorBot collBot;
	private float search;
	
	public EntityAICollectionLoot(CollectorBot collbot, float searchRadius){
		collBot = collbot;
		search = searchRadius;
	}
	public void suspend(float s){
		suspendEnd = s+ System.currentTimeMillis();
	}
	public boolean shouldExecute(){
		if(System.currentTimeMillis() > suspendEnd){
			suspendEnd = 0;
			return true;
		}
		return false;
	}
	public boolean continueExecuting(){
		if(suspendEnd ==0){
			return true;
		}
		return false;
	}
	private EntityItem selectNewTarget(){
		index = -1;
		List<Entity> entityList = (List<Entity>) collBot.worldObj.getLoadedEntityList();
		float min=entityList.get(0).getDistanceToEntity(collBot);//may break if the entity is closer than the item
		for(int i=0;i<entityList.size();i++){
			if(entityList.get(i).getClass().equals(EntityItem.class)){
				if(!entityList.get(i).isDead){
					dist= entityList.get(i).getDistanceToEntity(collBot);
					if(dist <= min && dist <search){
						min = dist;
						index =i;
					}
				}
			}
		}
		
		if(index != -1){
			targetLoot = (EntityItem) entityList.get(index);
		}
	
		return targetLoot;
		}
	public void updateTask(){
		if(targetLoot == null){
			selectNewTarget();
		}

		if(targetLoot==null){
			return;
		}
		if(targetLoot.isDead){
			targetLoot = null;
			return;
		}
		collBot.getNavigator().tryMoveToEntityLiving(targetLoot, collBot.SPEED_SLOW);
		if(collBot.getDistanceSqToEntity(targetLoot)<1.5){
			collBot.worldObj.removeEntity(targetLoot);
			collBot.addItem(targetLoot);
			targetLoot = null;
		}
	}
	
	

}










