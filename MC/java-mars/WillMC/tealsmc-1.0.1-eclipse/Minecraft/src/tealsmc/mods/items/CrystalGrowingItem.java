package tealsmc.mods.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tealsmc.mods.blocks.BlocksModule;
import tealsmc.mods.blocks.CrystalGrowingBlock;

public class CrystalGrowingItem extends Item{
	//public static final CrystalGrowingBlock crystalGrowingBlock = new CrystalGrowingBlock(Material.glass);
	public CrystalGrowingItem(){
		setCreativeTab(CreativeTabs.tabTools);
	}
	public boolean onItemUse(
			ItemStack item,                 // Items in the player's inventory
			EntityPlayer player,
			World world,
			int x, int y, int z,            // Location of the block (can be air) the player clicked.
			int side,                       // Cube face the player clicked
			float px, float py, float pz    // Player's location in the world
			)	{
		if(world.getBlock(x, y, z) != null){
			if(world.getBlock(x, y, z).equals(BlocksModule.crystalGrowingBlock)){
			//world.setBlock(x, y, z, Block.getBlockFromName(getUnlocalizedName()));
				
				int rand = (int)((Math.random()*10)+10);
				for(int i = y+1; i < y + rand; i++){
					world.setBlock(x,i,z,Blocks.gold_block);
				}
				world.setBlock(x, y, z, Blocks.coal_block);
			}
		}
		
		
				return true;
	}

}
