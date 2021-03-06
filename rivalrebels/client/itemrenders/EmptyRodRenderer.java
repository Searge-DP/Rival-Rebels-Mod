package assets.rivalrebels.client.itemrenders;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelRod;

public class EmptyRodRenderer implements IItemRenderer
{
	ModelRod	md;
	
	public EmptyRodRenderer()
	{
		md = new ModelRod();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		if (type == ItemRenderType.FIRST_PERSON_MAP || type == ItemRenderType.EQUIPPED || type == ItemRenderType.ENTITY || type == ItemRenderType.EQUIPPED_FIRST_PERSON) return true;
		return false;
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(RivalRebels.etemptyrod);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslatef(0.5f, 0.5f, -0.03f);
		GL11.glRotatef(35, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(0.5f, 1.25f, 0.5f);
		GL11.glPushMatrix();
		
		md.render();
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
