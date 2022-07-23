package net.darktree.fungible.mixin;

import com.mojang.authlib.minecraft.UserApiService;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.util.ProfileKeys;
import net.minecraft.network.encryption.PlayerKeyPair;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Mixin(ProfileKeys.class)
public abstract class ProfileKeysMixin {
    @Shadow protected abstract void saveKeyPairToFile(@Nullable PlayerKeyPair keyPair);

    /**
     * @author jacg311
     * @reason distracting message we dont care about in the dev env
     */
    @Inject(method = "getKeyPair", at = @At("HEAD"), cancellable = true)
    private void getKeyPair(UserApiService userApiService, CallbackInfoReturnable<CompletableFuture<Optional<PlayerKeyPair>>> cir) {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            this.saveKeyPairToFile(null);
            cir.setReturnValue(CompletableFuture.completedFuture(Optional.empty()));
        }
    }
}
