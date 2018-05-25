package tealsmc.mods.entities;



import org.tealsk12.tealsmodloader.builtin.entity.Robot;

import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class VirusRobot extends Robot{
public static final long LIFE_TIME = 20000;
public long expirationTime;
	public VirusRobot(World world){
		super(world);
		EntityAIWander x = new EntityAIWander(this,SPEED_FAST);
		EntityAIInfect z = new EntityAIInfect(this);
		 tasks.addTask(1,x);
		 tasks.addTask(2,z);
		 expirationTime = System.currentTimeMillis() +LIFE_TIME;
		 
	}
	public void onUpdate(){
		super.onUpdate();
		if(System.currentTimeMillis() > expirationTime){
			damageEntity(new DamageSource("Was not ready for this level of beat droppage"), this.getMaxHealth());
			
		}
		
	}

}
