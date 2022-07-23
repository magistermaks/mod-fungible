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
	/**
	 * @author magistermaks
	 * @reason STOP TAKING THE FOCUS AWAY FORM THE GAME LOG!
	 */
	@Inject(method = "createUserApiService", at = @At("HEAD"), cancellable = true)
	private void fungible$supressAuthError(YggdrasilAuthenticationService authService, RunArgs runArgs, CallbackInfoReturnable<UserApiService> cir) {
		cir.setReturnValue(UserApiService.OFFLINE);
	}
}
