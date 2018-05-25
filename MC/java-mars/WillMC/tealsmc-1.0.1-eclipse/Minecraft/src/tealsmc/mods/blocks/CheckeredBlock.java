package tealsmc.mods.blocks;

import org.tealsk12.tealsmodloader.Common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class CheckeredBlock extends Block{
	private IIcon[] tex = new IIcon[2];
	public static final CheckeredBlock checkeredBlock = new CheckeredBlock();
	//private static prox
	protected CheckeredBlock() {
		super(Material.rock);
		// TODO Auto-generated constructor stubCommon.MOD_ID +
		setCreativeTab(CreativeTabs.tabBlock);
	}
	public void registerBlockIcons(IIconRegister iconRegister){
		tex[1]=iconRegister.registerIcon(Common.MOD_ID +":black");
		tex[0]=iconRegister.registerIcon(Common.MOD_ID +":white");
	}
	public IIcon getIcon(int side, int meta){
		
		return tex[0];
		
	}
	public IIcon getIcon(IBlockAccess worldAccess,int x, int y, int z, int meta){
		//e
		/*
		for(int i = -1; i <2; i++){
			for(int j = -1; j<2;j++){
				for(int k =-1;k<2;k++){
					if((k != i && i!=j)){
						if(worldAccess.getBlock(x+i+j+k, y+i+j+k, z+i+j+k).getBlockTextureFromSide(1).equals(tex[0])){
							return tex[1];
						}
						
						else if ((worldAccess.getBlock(x+i+j+k, y+i+j+k, z+i+j+k).getBlockTextureFromSide(1).equals(tex[1]))){
							return tex[0];
						}
						
					}
				}
			}
		}
		*/
		/*
		if(worldAccess.getBlock(x, y, z)){
			
		}
		*/
		//if(worldAccess.getBlock(x, y, z).equals(){}
		
		//if we look at how the xyz, we see that if 2 or 0 out of xyz is 1, we'll get white, if 3 or 1 of xyz is 1, we'll get black
		//for the alternating checker look.
		if((x+y+z)%2==0){
			return tex[0];
		}
		return tex[1];
	}

}












