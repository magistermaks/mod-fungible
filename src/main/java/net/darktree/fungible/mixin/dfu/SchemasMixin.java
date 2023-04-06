package net.darktree.fungible.mixin.dfu;

import com.mojang.datafixers.DataFixerBuilder;
import net.minecraft.datafixer.Schemas;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Schemas.class)
public class SchemasMixin {

	/**
	 * @author magistermaks
	 * @reason DataBreaker 2: Electric Boogaloo
	 */
	@Overwrite
	private static void build(DataFixerBuilder builder) {
		// oh, no!
	}

}

