package net.darktree.fungible.mixin;

import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.InvocationTargetException;

/**
 * STOP TAKING THE FOCUS AWAY FORM THE GAME LOG!
 */
@Mixin(MinecraftClient.class)
public class ShutAuthMixin {

	/**
	 * Minecraft >=1.19
	 */
	@Inject(method="createUserApiService", at=@At("HEAD"), cancellable=true, require=0)
	private void createUserApiService(YggdrasilAuthenticationService service, RunArgs args, CallbackInfoReturnable<Object> info) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
		info.setReturnValue(Class.forName("com.mojang.authlib.minecraft.UserApiService").getField("OFFLINE").get(null));
	}

	/**
	 * Minecraft <=1.18
	 */
	@Inject(method="createSocialInteractionsService", at=@At("HEAD"), cancellable=true, require=0)
	private void createSocialInteractionsService(YggdrasilAuthenticationService service, RunArgs args, CallbackInfoReturnable<Object> info) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		info.setReturnValue(Class.forName("com.mojang.authlib.minecraft.OfflineSocialInteractions").getConstructor().newInstance());
	}

}
