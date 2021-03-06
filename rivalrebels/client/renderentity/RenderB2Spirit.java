package assets.rivalrebels.client.renderentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.objfileloader.ModelFromObj;
import assets.rivalrebels.common.entity.EntityB2Spirit;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderB2Spirit extends Render
{
	ModelFromObj	md;
	
	public RenderB2Spirit()
	{
		try
		{
			md = ModelFromObj.readObjFile("d.obj");
			md.scale(3, 3, 3);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void renderB2Spirit(EntityB2Spirit b2spirit, double x, double y, double z, float par8, float par9)
	{
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(b2spirit.rotationYaw, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(b2spirit.rotationPitch, 0.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(RivalRebels.etb2spirit);
		GL11.glDisable(GL11.GL_CULL_FACE);
		md.render();
		GL11.glPopMatrix();
	}
	
	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then handing it off to a worker function which does the actual work. In all
	 * probabilty, the class Render is generic (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1, double d2, float f, float f1). But JAD is pre
	 * 1.5 so doesn't do that.
	 */
	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		renderB2Spirit((EntityB2Spirit) par1Entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return null;
	}
}