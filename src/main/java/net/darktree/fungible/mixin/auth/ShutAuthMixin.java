package net.darktree.fungible.mixin.auth;

import com.mojang.authlib.minecraft.UserApiService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MinecraftClient.class)
public class ShutAuthMixin {

	/**
	 * @author magistermaks
	 * @reason STOP TAKING THE FOCUS AWAY FORM THE GAME LOG!
	 */
	@Overwrite
	private UserApiService createUserApiService(YggdrasilAuthenticationService authService, RunArgs runArgs) {
		return UserApiService.OFFLINE;
	}

}
