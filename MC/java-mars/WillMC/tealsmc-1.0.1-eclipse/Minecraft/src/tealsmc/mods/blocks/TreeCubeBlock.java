package tealsmc.mods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class TreeCubeBlock extends Block{
	private int size;
	private int baseHeight;
	public TreeCubeBlock(Material x, int baseHeight, int size){
		super(x);
		this.size = size;
		this.baseHeight = baseHeight;
		setCreativeTab(CreativeTabs.tabBlock);
	}
	public void onBlockAdded(World world,int locX, int locY, int locZ){
		for(int i = baseHeight; i < (2*baseHeight); i++){
			//for(int j = 0; j < baseHeight/2; j++){
			for(int j = 0; j < size; j++){
				for(int k = 0; k < size; k++){
					//if(world.getBlock(locX+j, locY + i, locZ+k).equals(Blocks.air)){
						world.setBlock(locX+j, locY + i, locZ+k, Blocks.leaves);
						world.setBlock(locX-j, locY + i, locZ-k, Blocks.leaves);
						world.setBlock(locX-j, locY + i, locZ+k, Blocks.leaves);
						world.setBlock(locX+j, locY + i, locZ-k, Blocks.leaves);
					//}
				}
				/*
				world.setBlock(locX, locY + i, locZ+j, Blocks.leaves);
				world.setBlock(locX+j, locY + i, locZ, Blocks.leaves);
				
				world.setBlock(locX-j, locY + i, locZ-j, Blocks.leaves);
				world.setBlock(locX, locY + i, locZ-j, Blocks.leaves);
				world.setBlock(locX-j, locY + i, locZ, Blocks.leaves);
				*/
			}
		}
		for(int k = 0; k <baseHeight + (baseHeight/2); k++){
			world.setBlock(locX, locY + k, locZ, Blocks.log);
		}
	}
}
