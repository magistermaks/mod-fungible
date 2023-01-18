package net.darktree.fungible.mixin.screen_fade;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.SplashOverlay;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.ResourceReload;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SplashOverlay.class)
public class SplashOverlayMixin {

	@Shadow @Final private ResourceReload reload;

	/**
	 * Let's not waste time on fancy animations shall we?
	 */
	@Inject(method="render", at=@At("HEAD"), cancellable=true)
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo info) {
		if (reload.isComplete()) {
			MinecraftClient.getInstance().setOverlay(null);
			info.cancel();
		}
	}

}
