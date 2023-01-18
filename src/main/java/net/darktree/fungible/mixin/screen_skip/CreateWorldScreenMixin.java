package net.darktree.fungible.mixin.screen_skip;

import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.resource.featuretoggle.FeatureSet;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Debug(export = true)
@Mixin(CreateWorldScreen.class)
public class CreateWorldScreenMixin {
    @Redirect(method = "applyDataPacks", at = @At(value = "INVOKE", target = "Lnet/minecraft/resource/featuretoggle/FeatureFlags;isNotVanilla(Lnet/minecraft/resource/featuretoggle/FeatureSet;)Z"))
    private boolean fungible$skipExperimentalWarningScreen(FeatureSet features) {
        return false;
    }
}
