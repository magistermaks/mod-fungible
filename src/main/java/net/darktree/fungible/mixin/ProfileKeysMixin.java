package net.darktree.fungible.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Coerce;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Pseudo
@Mixin(targets="net.minecraft.client.util.ProfileKeys")
public abstract class ProfileKeysMixin {

    @Shadow
    protected abstract void saveKeyPairToFile(@Nullable @Coerce Object keyPair);

    /**
     * @author jacg311
     * @reason distracting message we don't care about in the dev env
     */
    @Overwrite
    private CompletableFuture<Optional<Object>> getKeyPair(@Coerce Object userApiService) {
        this.saveKeyPairToFile(null);
        return CompletableFuture.completedFuture(Optional.empty());
    }

}
