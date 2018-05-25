package tealsmc.mods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockIce;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class UnbreakingIce extends BlockIce{
	private IIcon ice;
	public UnbreakingIce(){
		//super(x);
		setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(40);
		//this.
		
	}
	//public void registerBlockIcons(){
		//ice = Blocks.ice.getBlockTextureFromSide(1);
	//}
	
	//public IIcon getIcon(int side, int meta){
		//return ice;
	//	return Blocks.ice.getBlockTextureFromSide(1);
	//}



}
