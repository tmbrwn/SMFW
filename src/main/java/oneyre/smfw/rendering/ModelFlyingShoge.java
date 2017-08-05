package oneyre.smfw.rendering;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oneyre.smfw.entity.EntityFlyingShoge;

@SideOnly(Side.CLIENT)
public class ModelFlyingShoge extends ModelBase {
	public ModelRenderer shogeModel;
	
	public ModelFlyingShoge() {
		shogeModel = new ModelRenderer(this, 0, 0);
		shogeModel.addBox(0, 0, 0, 8, 5, 2);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scale) {
		EntityFlyingShoge shoge = (EntityFlyingShoge) entityIn;
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, 1F, shoge);
		GL11.glPushMatrix();
		shogeModel.render(scale);
		GL11.glPopMatrix();
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity entityIn) {
		// TODO Auto-generated method stub
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	}
	
	
}
