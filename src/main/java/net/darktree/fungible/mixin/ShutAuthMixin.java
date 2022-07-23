package net.darktree.fungible.mixin;

import com.mojang.authlib.minecraft.UserApiService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import net.darktree.fungible.Fungible;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class ShutAuthMixin {
	@Inject(method = "createUserApiService", at = @At("HEAD"), cancellable = true)
	private void fungible$supressAuthError(YggdrasilAuthenticationService authService, RunArgs runArgs, CallbackInfoReturnable<UserApiService> cir) {
		if(FabricLoader.getInstance().isDevelopmentEnvironment()) {
			Fungible.LOGGER.info("Suppressing Auth Error in dev env");
			cir.setReturnValue(UserApiService.OFFLINE);
		}
	}
}
