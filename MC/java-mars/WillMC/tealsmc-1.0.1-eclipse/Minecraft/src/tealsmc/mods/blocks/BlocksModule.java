package tealsmc.mods.blocks;

import org.tealsk12.tealsmodloader.module.Module;

import net.minecraft.block.material.Material;

/**
 * All TEALS mod blocks are registered here in order to be displayed in game.
 * All of the custom blocks you will create in the future should be registered
 * here.
 */
public class BlocksModule extends Module {

    public static final AmethystOre amethystOre = new AmethystOre();
    public static final BatteryBlock batteryBlock = new BatteryBlock();
    public static final CheckeredBlock checkeredBlock = new CheckeredBlock();
    public static final CrystalGrowingBlock crystalGrowingBlock = new CrystalGrowingBlock(Material.glass);
    public static final InfectedBlock infectedBlock = new InfectedBlock(Material.glass);
    public static final TreeCubeBlock treeCubeBlock = new TreeCubeBlock(Material.wood, 10, 5);
    public static final TreeCylinderBlock treeCylinderBlock = new TreeCylinderBlock(Material.wood,10,10,5);
    public static final TreeSphereBlock treeSphereBlock = new TreeSphereBlock(Material.wood, 10, 5);
    public static final TreeConeBlock treeConeBlock = new TreeConeBlock(Material.wood,10,10,10);
    public static final ShieldBlock shieldBlock = new ShieldBlock(Material.glass, 10);
    public static final UnbreakingIce unbreakingIce = new UnbreakingIce();
    public void onLoad() {
        parentMod.blockRegistry.newInstance("amethyst_ore", amethystOre, "Amethyst Ore");
        parentMod.blockRegistry.newInstance("battery_block", batteryBlock, "Battery Block");
        parentMod.blockRegistry.newInstance("checkered_block", checkeredBlock, "Checkered Block");
        parentMod.blockRegistry.newInstance("crystal_growing_block", crystalGrowingBlock, "Crystal Growing Block");
        parentMod.blockRegistry.newInstance("infected_block", infectedBlock, "Infected Block");
        parentMod.blockRegistry.newInstance("tree_cube_block", treeCubeBlock, "Tree Cube Block");
        parentMod.blockRegistry.newInstance("tree_cylinder_block", treeCylinderBlock, "Tree Cylinder Block");
        parentMod.blockRegistry.newInstance("tree_sphere_block", treeSphereBlock, "Tree Sphere Block");
        parentMod.blockRegistry.newInstance("tree_cone_block", treeConeBlock, "Tree Cone Block");
        parentMod.blockRegistry.newInstance("white", shieldBlock, "Shield Block");
        parentMod.blockRegistry.newInstance("unbreaking_ice", unbreakingIce, "Unbreaking Ice");
    }
    
}











