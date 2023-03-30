package net.darktree.fungible.mixin.screen_skip;

import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Mixin(value = AccessibilityOnboardingScreen.class, remap = false)
public class AccessibilityScreenMixin {
    @Shadow
    public void close() {
        throw new IllegalStateException("This should never be called from within mixin");
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void fungible$forceCloseAccessibilityScreen(CallbackInfo ci) {
        this.close();
    }
}
