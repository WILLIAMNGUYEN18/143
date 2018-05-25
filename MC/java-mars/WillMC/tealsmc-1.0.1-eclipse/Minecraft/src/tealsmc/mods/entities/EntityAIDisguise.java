package tealsmc.mods.entities;

import java.util.Random;

import org.tealsk12.tealsmodloader.builtin.entity.Robot;

import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import tealsmc.mods.blocks.BlocksModule;

public class EntityAIDisguise extends EntityAIBase{
	private boolean loop = false;
	private Block store;
	private int data;
	private Block storetwo;
	private int datatwo;
	private long end;
	private int x;
	private int y;
	private int z;
	private static final long MILLIS_PER_SECOND = 1000;
	private ChameleonBot robot;
	public EntityAIDisguise(ChameleonBot cham){
		robot = cham;
		
	}
	public void startExecuting(){
		end = System.currentTimeMillis() + (5*MILLIS_PER_SECOND);
			

			/*
			r = new Random();
			int hideX = (r.nextInt(3)-1) +x;
			int hideY = (r.nextInt(3)-1) +y;
			int hideZ = (r.nextInt(3)-1)+ z;
			while(robot.worldObj.getBlock(hideX,hideY,hideZ) == Blocks.air){
				hideX = (r.nextInt(3)-1) +x;
				hideY = (r.nextInt(3)-1) +y;
				hideZ = (r.nextInt(3)-1)+ z;
			}
			*/
			for(int i = -1; i <2; i++){
				for(int j = -1; j<2;j++){
					for(int k =-1;k<2;k++){
						x = round(robot.posX);
						y = round(robot.posY);
						z = round(robot.posZ);
						if(robot.worldObj.getBlock(x+i, y+j, z+k) != Blocks.air){
							loop = true;
							store =robot.worldObj.getBlock(x+i, y+j, z+k);
							data =robot.worldObj.getBlockMetadata(x+i, y+j, z+k);

							robot.setInvisible(true);
							storetwo = robot.worldObj.getBlock(x, y+ 1, z);
							datatwo = robot.worldObj.getBlockMetadata(x, y +1, z);
							System.out.println(storetwo.getUnlocalizedName());
							System.out.println(x + "," + y +"," + "z");
							robot.worldObj.setBlock(x, y, z, store);
							robot.worldObj.setBlockMetadataWithNotify(x, y, z, data,0);
						//robot.worldObj.setBlock(x,y,z, Blocks.log);
						}
					}
				}
			}
			if(loop == false){
				end = System.currentTimeMillis();
				store = null;
				//data = null;
			}
			
	}
	public boolean shouldExecute(){
		return robot.hasFreshDamage();
		
	}
	public int round(double n){
		return (int) Math.round(n);
	}
	public void resetTask(){
		if(store != null){
	
			System.out.println(storetwo.getUnlocalizedName());
			System.out.println(x + "," + y +"," + z);
		robot.worldObj.setBlock(x,y,z, storetwo);
		robot.worldObj.setBlockMetadataWithNotify(x, y, z, datatwo, 0);
		robot.setInvisible(false);
		robot.setLocationAndAngles(x, y +1, z, 0, 0);
		}
		
	}
	public boolean continueExecuting(){
		if(System.currentTimeMillis()<= end){
		return true;
		}
		return false;
	}

}
