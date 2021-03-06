package assets.rivalrebels.client.itemrenders;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import assets.rivalrebels.RivalRebels;
import assets.rivalrebels.client.model.ModelRocket;
import assets.rivalrebels.client.model.ModelRocketLauncherBody;
import assets.rivalrebels.client.model.ModelRocketLauncherHandle;
import assets.rivalrebels.client.model.ModelRocketLauncherTube;
import assets.rivalrebels.client.renderentity.RenderB83;
import assets.rivalrebels.client.renderentity.RenderRocket;
import assets.rivalrebels.client.renderentity.RenderSeeker;

public class SeekRocketLauncherRenderer implements IItemRenderer
{
	ModelRocketLauncherHandle	md2;
	ModelRocketLauncherBody		md3;
	ModelRocketLauncherTube		md4;
	
	public SeekRocketLauncherRenderer()
	{
		md2 = new ModelRocketLauncherHandle();
		md3 = new ModelRocketLauncherBody();
		md4 = new ModelRocketLauncherTube();
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
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslatef(0.4f, 0.35f, -0.03f);
		GL11.glRotatef(-55, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(0f, 0.05f, 0.05f);
		if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) GL11.glScalef(1, 1, -1);
		GL11.glPushMatrix();
		GL11.glTranslatef(0.22f, -0.025f, 0f);
		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(0.03125f, 0.03125f, 0.03125f);
		Minecraft.getMinecraft().renderEngine.bindTexture(RivalRebels.etrocketseekhandle202);
		md2.render();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.07f, 0.31f, 0f);
		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(0.4f, 0.4f, 0.4f);
		Minecraft.getMinecraft().renderEngine.bindTexture(RivalRebels.etseek202);
		md3.render();
		GL11.glPopMatrix();
		
		float s = 0.0812f;
		
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.07f + s, 0.71f, s);
		GL11.glScalef(0.15f, 0.1f, 0.15f);
		Minecraft.getMinecraft().renderEngine.bindTexture(RivalRebels.etrocketseektube202);
		md4.render();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.07f - s, 0.71f, s);
		GL11.glScalef(0.15f, 0.1f, 0.15f);
		md4.render();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.07f + s, 0.71f, -s);
		GL11.glScalef(0.15f, 0.1f, 0.15f);
		md4.render();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.07f - s, 0.71f, -s);
		GL11.glScalef(0.15f, 0.1f, 0.15f);
		md4.render();
		GL11.glPopMatrix();
		
		// ---
		 
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.07f + s, -0.285f, s);
		GL11.glScalef(0.15f, -0.1f, 0.15f);
		md4.render();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.07f - s, -0.285f, s);
		GL11.glScalef(0.15f, -0.1f, 0.15f);
		md4.render();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.07f + s, -0.285f, -s);
		GL11.glScalef(0.15f, -0.1f, 0.15f);
		md4.render();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.07f - s, -0.285f, -s);
		GL11.glScalef(0.15f, -0.1f, 0.15f);
		md4.render();
		GL11.glPopMatrix();
		
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}
}
