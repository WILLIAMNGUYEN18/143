package tealsmc.mods.entities;

import org.tealsk12.tealsmodloader.builtin.entity.Robot;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIInfect extends EntityAIBase{
	private Robot virusbot;
	private EntityLivingBase target;
	EntityAIInfect(Robot bot){
		this.virusbot = bot;
		
	}

	@Override
	public boolean shouldExecute() {
		if(virusbot.getAttackTarget() != null){
		return true;
		}
		else{
			return false;
		}
	}
	public void startExecuting(){
		this.target = virusbot.getAttackTarget();
	}
	public boolean continueExecuting(){
		if(target.isDead || target == null){
		return false;
		}
		return true;
	}
	public void updateTask(){
		if(!target.isDead){
			virusbot.getNavigator().tryMoveToEntityLiving(target, Robot.SPEED_FAST);
			float distanceInBlocks = virusbot.getDistanceToEntity(target);
			if(distanceInBlocks <=2){
				VirusRobot newbert = new VirusRobot(virusbot.worldObj);
				newbert.setLocationAndAngles(target.posX, target.posY+1, target.posZ, 0, 0);
				virusbot.worldObj.spawnEntityInWorld(newbert);
				target.setDead();
			}
		}
	}
}
