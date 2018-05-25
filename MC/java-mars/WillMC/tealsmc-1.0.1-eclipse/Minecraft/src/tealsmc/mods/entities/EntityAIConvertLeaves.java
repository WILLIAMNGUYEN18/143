package tealsmc.mods.entities;

import java.util.Random;

import org.tealsk12.tealsmodloader.builtin.entity.Robot;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class EntityAIConvertLeaves extends EntityAIBase{
	private Random r = new Random();
	private Robot store;
	private World world;
	public EntityAIConvertLeaves(Robot x, World world){
		store = x;
		this.world = world;
	}
	@Override
	public boolean shouldExecute() {
		// TODO Auto-generated method stub
		
		int rand =(int) r.nextDouble();
		if(rand <=.04){
			return true;
		}
		return false;
	}
	public void startExecuting(){
		int x, y, z;
		x = (int)(r.nextInt(3) + store.posX);
		y = (int)(r.nextInt(3) + store.posY);
		z = (int)(r.nextInt(3) + store.posZ);
		if(!(store.worldObj.getBlock(x, y, z).equals (Blocks.air)) && !(store.worldObj.getBlock(x, y, z).equals(Blocks.leaves))){
			store.worldObj.setBlock(x, y, z, Blocks.leaves);
		}
		/*
		if(!(store.worldObj.getBlock(x, y, z).equals (Blocks.air)) || !(store.worldObj.getBlock(x, y, z).equals(Blocks.leaves))){
			store.worldObj.setBlock(x, y, z, Blocks.leaves);
		}
		//this.store.
		//world.
		//if(Entity)
		 * 
		 */
	}
	public boolean continueExecuting(){
		return false;
	}
	
	
	

}
