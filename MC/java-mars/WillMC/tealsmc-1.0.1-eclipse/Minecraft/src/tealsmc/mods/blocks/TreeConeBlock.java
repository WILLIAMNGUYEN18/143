package tealsmc.mods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class TreeConeBlock extends Block{
private int baseHeight;
private int height;
private int baseRadius;
	public TreeConeBlock (Material material, int baseHeight, int height, int baseRadius){
		super(material);
		setCreativeTab(CreativeTabs.tabBlock);
		this.baseHeight = baseHeight;
		this.baseRadius = baseRadius;
		this.height =height;
		// TODO Auto-generated constructor stub
	}
	/**/
	public void onBlockAdded(World world,int locX, int locY, int locZ){
		//for the height of the cylinder
		int rad = baseRadius;
		for(int i = baseHeight; i < (baseHeight +height); i++){
			/*
			for()
			*/
			for(int j = 0; j < baseRadius; j++){
				for(int k = 0; k < baseRadius; k++){
					
					rad = baseRadius -(i - baseHeight);
					if((j*j + k*k) < rad*rad){ 
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
