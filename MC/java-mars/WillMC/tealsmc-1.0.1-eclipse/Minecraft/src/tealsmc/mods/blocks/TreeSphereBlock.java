package tealsmc.mods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class TreeSphereBlock extends Block{
	private int radius;
	private int baseHeight;
	public TreeSphereBlock (Material material, int baseHeight, int radius){
		super(material);
		setCreativeTab(CreativeTabs.tabBlock);
		this.radius = radius;
		this.baseHeight = baseHeight;
	}
	public void onBlockAdded(World world,int locX, int locY, int locZ){
		//for the height of the cylinder
		
		for(int i = -radius; i < radius; i++){
			/*
			for()
			*/
			for(int j = 0; j < radius; j++){
				for(int k = 0; k < radius; k++){
					if((j*j + k*k) < radius*radius){ 
						//i * i is atleast baseHeight * baseHeight
						if(i*i + k*k < radius * radius){
							if(i*i + j*j < radius * radius){
					world.setBlock(locX+j, locY + i + baseHeight, locZ+k, Blocks.leaves);
					world.setBlock(locX-j, locY + i+baseHeight, locZ-k, Blocks.leaves);
					world.setBlock(locX-j, locY + i+baseHeight, locZ+k, Blocks.leaves);
					world.setBlock(locX+j, locY + i+baseHeight, locZ-k, Blocks.leaves);
							}
						}
					}
				}
			}
		}
		
		//for the tree stump
		for(int k = 0; k <(baseHeight + radius -1); k++){
			world.setBlock(locX, locY + k, locZ, Blocks.log);
		}
	}
}
