package tealsmc.mods.entities;

import org.tealsk12.tealsmodloader.builtin.entity.Robot;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import tealsmc.mods.blocks.BlocksModule;

public class EntityAILeap extends EntityAIBase{
	private Robot overBot;
	private EntityLivingBase target;

	public EntityAILeap(Robot rob){
		this.overBot = rob;
	}
	


	public boolean shouldExecute() {
		if(overBot.getAttackTarget() != null){
		return true;
		}
		else{
			return false;
		}
	}
	public void startExecuting(){
		this.target = overBot.getAttackTarget();
	}
	public boolean continueExecuting(){
		if(target.isDead || target == null){
		return false;
		}
		return true;
	}
	public void updateTask(){
		if(!target.isDead){
			overBot.getNavigator().tryMoveToEntityLiving(target, Robot.SPEED_SLOW);
			//overBot.getNavigator().
			float distanceInBlocks = overBot.getDistanceToEntity(target);
			//leap
			if(distanceInBlocks >5 && distanceInBlocks < 10){
				int side = (int)(Math.random()*4);
				if(side == 0){
					target.knockBack(overBot, 10, 10, 10);
					overBot.setPosition(target.posX + 3, target.posY+3, target.posZ);
					overBot.worldObj.setBlock((int)target.posX+3,(int) target.posY,(int) target.posZ, BlocksModule.shieldBlock);
				}
				else if(side == 1){
					target.knockBack(overBot, 10, 10, 10);
					overBot.setPosition(target.posX -3, target.posY+3, target.posZ);
					overBot.worldObj.setBlock((int)target.posX-3,(int) target.posY,(int) target.posZ, BlocksModule.shieldBlock);
				}
				else if(side == 2){
					target.knockBack(overBot, 10, 10, 10);
					overBot.setPosition(target.posX, target.posY+3, target.posZ +3);
					overBot.worldObj.setBlock((int)target.posX,(int) target.posY,(int) target.posZ +3, BlocksModule.shieldBlock);
				}
				else if(side == 3){
					target.knockBack(overBot, 10, 10, 10);
					overBot.setPosition(target.posX, target.posY+3, target.posZ -3);
					overBot.worldObj.setBlock((int)target.posX,(int) target.posY,(int) target.posZ -3, BlocksModule.shieldBlock);
				}
				/*
				VirusRobot newbert = new VirusRobot(overBot.worldObj);
				newbert.setLocationAndAngles(target.posX, target.posY+1, target.posZ, 0, 0);
				overBot.worldObj.spawnEntityInWorld(newbert);
				target.setDead();
				*/
				//overBot.att
				//overBot.getNavigator().tryMoveToEntityLiving(target, Robot.SPEED_SLOW);
				
				//overBot.setPosition(target.posX, target.posY, target.posZ);
				//overBot.knockBack(target, 100, 100, 100);
				
				
				
			}
			distanceInBlocks = overBot.getDistanceToEntity(target);
			//tesla
			if(distanceInBlocks <=2){
				
				target.setHealth((float) (target.getHealth() -0.25));
			}
		}
	}

}
