package assets.rivalrebels.common.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.rivalrebels.client.gui.GuiLaptop;
import assets.rivalrebels.client.gui.GuiLoader;
import assets.rivalrebels.client.gui.GuiNuclearBomb;
import assets.rivalrebels.client.gui.GuiOptiFineWarning;
import assets.rivalrebels.client.gui.GuiReactor;
import assets.rivalrebels.client.gui.GuiTesla;
import assets.rivalrebels.client.gui.GuiTray;
import assets.rivalrebels.client.gui.GuiTsar;
import assets.rivalrebels.common.container.ContainerLaptop;
import assets.rivalrebels.common.container.ContainerLoader;
import assets.rivalrebels.common.container.ContainerNuclearBomb;
import assets.rivalrebels.common.container.ContainerReactor;
import assets.rivalrebels.common.container.ContainerReciever;
import assets.rivalrebels.common.container.ContainerTsar;
import assets.rivalrebels.common.tileentity.TileEntityLaptop;
import assets.rivalrebels.common.tileentity.TileEntityLoader;
import assets.rivalrebels.common.tileentity.TileEntityNuclearBomb;
import assets.rivalrebels.common.tileentity.TileEntityReactor;
import assets.rivalrebels.common.tileentity.TileEntityReciever;
import assets.rivalrebels.common.tileentity.TileEntityTsarBomba;
import cpw.mods.fml.common.network.IGuiHandler;

public class RivalRebelsGuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileEntityTsarBomba)
		{
			return new ContainerTsar(player.inventory, (TileEntityTsarBomba) tileEntity);
		}
		if (tileEntity instanceof TileEntityNuclearBomb)
		{
			return new ContainerNuclearBomb(player.inventory, (TileEntityNuclearBomb) tileEntity);
		}
		if (tileEntity instanceof TileEntityLoader)
		{
			return new ContainerLoader(player.inventory, (TileEntityLoader) tileEntity);
		}
		if (tileEntity instanceof TileEntityReactor)
		{
			return new ContainerReactor(player.inventory, (TileEntityReactor) tileEntity);
		}
		if (tileEntity instanceof TileEntityLaptop)
		{
			return new ContainerLaptop(player.inventory, (TileEntityLaptop) tileEntity);
		}
		if (tileEntity instanceof TileEntityReciever)
		{
			return new ContainerReciever(player.inventory, (TileEntityReciever) tileEntity);
		} 
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileEntityTsarBomba)
		{
			return new GuiTsar(player.inventory, (TileEntityTsarBomba) tileEntity);
		}
		if (tileEntity instanceof TileEntityNuclearBomb)
		{
			return new GuiNuclearBomb(player.inventory, (TileEntityNuclearBomb) tileEntity);
		}
		if (tileEntity instanceof TileEntityLoader)
		{
			return new GuiLoader(player.inventory, (TileEntityLoader) tileEntity);
		}
		if (tileEntity instanceof TileEntityReactor)
		{
			return new GuiReactor(player.inventory, (TileEntityReactor) tileEntity);
		}
		if (tileEntity instanceof TileEntityLaptop)
		{
			return new GuiLaptop(player.inventory, (TileEntityLaptop) tileEntity);
		}
		if (tileEntity instanceof TileEntityReciever)
		{
			return new GuiTray(player.inventory, (TileEntityReciever) tileEntity);
		}
		return null;
	}
}
