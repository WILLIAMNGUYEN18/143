package tealsmc.mods.entities;

import org.tealsk12.tealsmodloader.builtin.entity.Robot;

import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import tealsmc.mods.items.ItemsModule;

public class OverwatchBot  extends Robot{
	public OverwatchBot(World world){
	super(world);
	EntityAIWander x = new EntityAIWander(this, SPEED_SLOW);
	EntityAILeap z = new EntityAILeap(this);
	tasks.addTask(1, x);
	tasks.addTask(2, z);
	//this.onDea
	}
	
	public void onDeath(DamageSource arg0){
		super.onDeath(arg0);
		this.dropItem(ItemsModule.teslaCannon, 1);
	}
}
