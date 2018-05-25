package tealsmc.mods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class TreeCylinderBlock extends Block{
	private int height;
	private int baseHeight;
	public int radius;
	public TreeCylinderBlock (Material material, int baseHeight, int height, int radius){
		super(material);
		setCreativeTab(CreativeTabs.tabBlock);
		this.height = height;
		this.baseHeight = baseHeight;
		this.radius = radius;
		
	}
	public void onBlockAdded(World world,int locX, int locY, int locZ){
		//for the height of the cylinder
		
		for(int i = baseHeight; i < (baseHeight +height); i++){
			/*
			for()
			*/
			for(int j = 0; j < radius; j++){
				for(int k = 0; k < radius; k++){
					//pyth theorem a^2 + b^2 == c^2
					if((j*j + k*k) < (radius*radius)){ 
					world.setBlock(locX+j, locY + i, locZ+k, Blocks.leaves);
					world.setBlock(locX-j, locY + i, locZ-k, Blocks.leaves);
					world.setBlock(locX-j, locY + i, locZ+k, Blocks.leaves);
					world.setBlock(locX+j, locY + i, locZ-k, Blocks.leaves);
					}
				}
			}
		}
		
		//for the tree stump
		for(int k = 0; k <baseHeight + (baseHeight/2); k++){
			world.setBlock(locX, locY + k, locZ, Blocks.log);
		}
	}
}
