package net.darktree.fungible.mixin;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.DataFixer;
import com.mojang.serialization.Dynamic;
import net.minecraft.world.level.storage.LevelStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LevelStorage.class)
public class LevelStorageMixin {

	/**
	 * Denied
	 */
	@Redirect(method="readGeneratorProperties", at = @At(value="INVOKE", target="Lcom/mojang/datafixers/DataFixer;update(Lcom/mojang/datafixers/DSL$TypeReference;Lcom/mojang/serialization/Dynamic;II)Lcom/mojang/serialization/Dynamic;", remap=false))
	private static <T> Dynamic<T> readGeneratorProperties_update(DataFixer instance, DSL.TypeReference typeReference, Dynamic<T> input, int v1, int v2) {
		return input;
	}

	/**
	 * Yeeted
	 */
	@Redirect(method="readDataPackSettings", at=@At(value="INVOKE", target="Lcom/mojang/datafixers/DataFixer;update(Lcom/mojang/datafixers/DSL$TypeReference;Lcom/mojang/serialization/Dynamic;II)Lcom/mojang/serialization/Dynamic;", remap=false))
	private static <T> Dynamic<T> readDataPackSettings_update(DataFixer instance, DSL.TypeReference typeReference, Dynamic<T> input, int v1, int v2) {
		return input;
	}

	/**
	 * Destroyed
	 */
	@Redirect(method="method_29582", at=@At(value="INVOKE", target="Lcom/mojang/datafixers/DataFixer;update(Lcom/mojang/datafixers/DSL$TypeReference;Lcom/mojang/serialization/Dynamic;II)Lcom/mojang/serialization/Dynamic;", remap=false))
	private static <T> Dynamic<T> lambda_method_29582_update(DataFixer instance, DSL.TypeReference typeReference, Dynamic<T> input, int v1, int v2) {
		return input;
	}

	/**
	 * Bricked
	 */
	@Redirect(method="method_29015", at=@At(value="INVOKE", target="Lcom/mojang/datafixers/DataFixer;update(Lcom/mojang/datafixers/DSL$TypeReference;Lcom/mojang/serialization/Dynamic;II)Lcom/mojang/serialization/Dynamic;", remap=false))
	private <T> Dynamic<T> lambda_method_29015_update(DataFixer instance, DSL.TypeReference typeReference, Dynamic<T> input, int v1, int v2) {
		return input;
	}

}
