package tealsmc.mods.blocks;

import org.tealsk12.tealsmodloader.Common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.*;

public class BatteryBlock extends Block{
private IIcon[] tex = new IIcon[3];
	public BatteryBlock() {
		super(Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
		
	}
	public void registerBlockIcons(IIconRegister iconRegister){
		tex[1]=iconRegister.registerIcon(Common.MOD_ID +":battery_top");
		tex[0]=iconRegister.registerIcon(Common.MOD_ID +":battery_bottom");
		tex[2]=iconRegister.registerIcon(Common.MOD_ID +":battery_side");
	}
	public IIcon getIcon(int side, int meta){
		if(side ==0){
			return tex[0];
		}
		else if(side ==1){
			return tex[1];
		}
		else{
			return tex[2];
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
