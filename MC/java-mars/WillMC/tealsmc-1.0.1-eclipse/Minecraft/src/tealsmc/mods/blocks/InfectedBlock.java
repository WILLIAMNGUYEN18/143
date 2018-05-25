package tealsmc.mods.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class InfectedBlock extends Block{
	public InfectedBlock(Material x){
		super(x);
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(Block.soundTypeCloth);
	}
	public void randomDisplayTick(World world, int x, int y, int z, Random random){
		//if(world.getBlock){}
		int num = random.nextInt(27);
		if(num ==0){
			for(int i = -1; i <2; i++){
				for(int j = -1; j<2;j++){
					for(int k =-1;k<2;k++){
						if(world.getBlock(x+i, y+j, z+k) != null && !(world.getBlock(x+i, y+j, z+k).equals(Blocks.air)) && world.getBlock(x+i, y+j, z+k).getBlockHardness(world,x+i, y+j, z+k) < 10){
								world.setBlock(x+i, y+j, z+k, BlocksModule.infectedBlock);
						}
					}
				}
			}
		}
	}

}
