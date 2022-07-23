package net.darktree.fungible.mixin;

import com.mojang.authlib.minecraft.OfflineSocialInteractions;
import com.mojang.authlib.minecraft.SocialInteractionsService;
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
	private SocialInteractionsService createSocialInteractionsService(YggdrasilAuthenticationService yggdrasilAuthenticationService, RunArgs runArgs) {
		return new OfflineSocialInteractions();
	}

}
