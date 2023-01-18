package net.darktree.fungible.mixin.dfu;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.types.Type;
import net.minecraft.util.Util;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Util.class)
public class UtilMixin {

	/**
	 * @author magistermaks
	 * @reason DataBreaker 2: Electric Boogaloo
	 */
	@Overwrite
	@Nullable
	public static Type<?> getChoiceType(DSL.TypeReference typeReference, String id) {
		return null;
	}

	/**
	 * @author magistermaks
	 * @reason DataBreaker 2: Electric Boogaloo
	 */
	@Overwrite
	@Nullable
	private static Type<?> getChoiceTypeInternal(DSL.TypeReference typeReference, String id) {
		return null;
	}

}
