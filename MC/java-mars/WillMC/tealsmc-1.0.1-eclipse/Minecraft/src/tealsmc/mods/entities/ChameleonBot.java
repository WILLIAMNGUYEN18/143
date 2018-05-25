package tealsmc.mods.entities;

import org.tealsk12.tealsmodloader.builtin.entity.Robot;

import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ChameleonBot extends Robot{
private boolean damage = false;
//private boolean first = true;
private EntityAIDisguise z;
	public ChameleonBot(World world) {
		super(world);
		EntityAIWander x = new EntityAIWander(this, SPEED_SLOW);
		z = new EntityAIDisguise(this);
		tasks.addTask(1, x);
		tasks.addTask(2, z);
		// TODO Auto-generated constructor stub
	}
	public boolean hasFreshDamage(){
		if(damage){
			//first = false;
			damage = false;
		return true;
		}
		return false;
		
	}
	public void onEntityDamage(DamageSource source, float amount){
		this.damage = true;
		super.onEntityDamage(source, amount);
		
		
	}

}
