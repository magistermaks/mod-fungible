package net.darktree.fungible.mixin.dfu;

import com.mojang.datafixers.DataFixer;
import com.mojang.serialization.Dynamic;
import net.minecraft.datafixer.DataFixTypes;
import net.minecraft.world.level.storage.LevelStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LevelStorage.class)
public class LevelStorageMixin {

	/**
	 * Denied
	 */
	@Redirect(method="readGeneratorProperties", at=@At(value="INVOKE", target="Lnet/minecraft/datafixer/DataFixTypes;update(Lcom/mojang/datafixers/DataFixer;Lcom/mojang/serialization/Dynamic;I)Lcom/mojang/serialization/Dynamic;"))
	private static <T> Dynamic<T> readGeneratorProperties_update(DataFixTypes instance, DataFixer dataFixer, Dynamic<T> dynamic, int i) {
		return dynamic;
	}

	/**
	 * Yeeted
	 */
	@Redirect(method="readDataPackSettings", at=@At(value="INVOKE", target="Lnet/minecraft/datafixer/DataFixTypes;update(Lcom/mojang/datafixers/DataFixer;Lcom/mojang/serialization/Dynamic;I)Lcom/mojang/serialization/Dynamic;"))
	private static <T> Dynamic<T> readDataPackSettings_update(DataFixTypes instance, DataFixer dataFixer, Dynamic<T> dynamic, int i) {
		return dynamic;
	}

	/**
	 * Destroyed
	 */
	@Redirect(method="method_29582", at=@At(value="INVOKE", target="Lnet/minecraft/datafixer/DataFixTypes;update(Lcom/mojang/datafixers/DataFixer;Lcom/mojang/serialization/Dynamic;I)Lcom/mojang/serialization/Dynamic;", remap=false))
	private static <T> Dynamic<T> lambda_method_29582_update(DataFixTypes instance, DataFixer dataFixer, Dynamic<T> dynamic, int i) {
		return dynamic;
	}

	/**
	 * Bricked
	 */
	@Redirect(method="method_29015", at=@At(value="INVOKE", target="Lnet/minecraft/datafixer/DataFixTypes;update(Lcom/mojang/datafixers/DataFixer;Lcom/mojang/serialization/Dynamic;I)Lcom/mojang/serialization/Dynamic;", remap=false))
	private <T> Dynamic<T> lambda_method_29015_update(DataFixTypes instance, DataFixer dataFixer, Dynamic<T> dynamic, int i) {
		return dynamic;
	}

}
