package net.darktree.fungible.mixin.screen_fade;

import net.minecraft.client.gui.LogoDrawer;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

	@Mutable @Shadow @Final private boolean doBackgroundFade;

	/**
	 * Let's not waste time on fancy animations shall we?
	 */
	@Inject(method="<init>(ZLnet/minecraft/client/gui/LogoDrawer;)V", at=@At("TAIL"))
	private void init(boolean doBackgroundFade, LogoDrawer logoDrawer, CallbackInfo ci) {
		this.doBackgroundFade = false;
	}
}
