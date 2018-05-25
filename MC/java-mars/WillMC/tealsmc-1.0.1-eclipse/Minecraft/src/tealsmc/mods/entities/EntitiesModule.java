package tealsmc.mods.entities;

import org.tealsk12.tealsmodloader.module.Module;

public class EntitiesModule extends Module {

	
    public void onLoad() {
        // Register custom TealsMC Mod Entities.
    	parentMod.entityRegistry.newInstance("leafbot", LeafBot.class, "gray_robot");
    	parentMod.entityRegistry.newInstance("virus_robot", VirusRobot.class, "red_robot");
    	parentMod.entityRegistry.newInstance("chameleon", ChameleonBot.class, "rainbow_robot");
    	parentMod.entityRegistry.newInstance("collector", CollectorBot.class, "gold_robot");
    	parentMod.entityRegistry.newInstance("overwatch", OverwatchBot.class, "overwatch_robot.fw");
    }
}
