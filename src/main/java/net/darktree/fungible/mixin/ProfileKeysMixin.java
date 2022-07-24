package net.darktree.fungible.mixin;

import com.mojang.authlib.minecraft.UserApiService;
import net.minecraft.client.util.ProfileKeys;
import net.minecraft.network.encryption.PlayerKeyPair;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Mixin(ProfileKeys.class)
public abstract class ProfileKeysMixin {
    @Shadow protected abstract void saveKeyPairToFile(@Nullable PlayerKeyPair keyPair);

    /**
     * @author jacg311
     * @reason distracting message we dont care about in the dev env
     */
    @Overwrite
    private CompletableFuture<Optional<PlayerKeyPair>> getKeyPair(UserApiService userApiService) {
        this.saveKeyPairToFile(null);
        return CompletableFuture.completedFuture(Optional.empty());
    }
}
