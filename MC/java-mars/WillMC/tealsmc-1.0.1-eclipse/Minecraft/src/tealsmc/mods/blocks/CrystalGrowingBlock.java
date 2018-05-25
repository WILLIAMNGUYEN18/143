package tealsmc.mods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CrystalGrowingBlock extends Block{
	public CrystalGrowingBlock(Material x){
		super(x);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness((float) 40.0);
	}
	
}
