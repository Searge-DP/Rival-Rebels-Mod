package assets.rivalrebels.client.renderentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelBlastSphere;
import assets.rivalrebels.client.objfileloader.ModelFromObj;
import assets.rivalrebels.common.entity.EntityB2Spirit;
import assets.rivalrebels.common.entity.EntityRhodes;
import assets.rivalrebels.common.entity.EntityRhodesHead;
import assets.rivalrebels.common.entity.EntityRhodesLeftUpperArm;
import assets.rivalrebels.common.entity.EntityRhodesRightUpperArm;
import assets.rivalrebels.common.entity.EntityRhodesRightUpperLeg;
import assets.rivalrebels.common.entity.EntityRhodesTorso;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRhodesRightUpperLeg extends Render
{
	public RenderRhodesRightUpperLeg()
	{
	}
	
	public void renderRhodes(EntityRhodesRightUpperLeg rhodes, double x, double y, double z, float par8, float ptt)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		Minecraft.getMinecraft().renderEngine.bindTexture(RenderRhodes.texture);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glRotatef(rhodes.rotationYaw, 0, 1, 0);
		GL11.glRotatef(rhodes.rotationPitch, 1, 0, 0);
		GL11.glTranslatef(-3, 5f, 0);
		RenderRhodes.thigh.renderAll();
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
		renderRhodes((EntityRhodesRightUpperLeg) par1Entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return null;
	}
}