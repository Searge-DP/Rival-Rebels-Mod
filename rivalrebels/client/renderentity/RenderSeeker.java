package assets.rivalrebels.client.renderentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelRocket;
import assets.rivalrebels.common.entity.EntityRocket;
import assets.rivalrebels.common.entity.EntitySeekB83;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSeeker extends Render
{
	ModelRocket	md;
	
	public RenderSeeker()
	{
		md = new ModelRocket();
	}
	
	public void renderRocket(EntitySeekB83 rocket, double par2, double par4, double par6, float par8, float par9)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float) par2, (float) par4, (float) par6);
		GL11.glRotatef(rocket.rotationYaw - 90.0f, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(rocket.rotationPitch - 90.0f, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(2.0f, 2.0f, 2.0f);
		Minecraft.getMinecraft().renderEngine.bindTexture(RivalRebels.etrocketseek202);
		md.render(true);
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
		renderRocket((EntitySeekB83) par1Entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return null;
	}
}