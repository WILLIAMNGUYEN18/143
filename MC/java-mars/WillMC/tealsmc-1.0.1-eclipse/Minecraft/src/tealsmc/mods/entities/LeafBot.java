package tealsmc.mods.entities;

import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.world.World;
import org.tealsk12.tealsmodloader.builtin.entity.Robot;

public class LeafBot extends Robot {

    public LeafBot (World world) {
        super(world);
        EntityAIWander x = new EntityAIWander(this,SPEED_NORMAL);
        EntityAIConvertLeaves z = new EntityAIConvertLeaves(this,world);
        //tasks.addTask(3, new EntityAIWander(this,SPEED_NORMAL));
        tasks.addTask(1, x);
        tasks.addTask(2, z);
    }
}
