package net.darktree.fungible.mixin;

import com.mojang.text2speech.Narrator;
import com.mojang.text2speech.NarratorDummy;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = Narrator.class, remap = false)
public interface NarratorMixin {

	/**
	 * @author magistermaks
	 * @reason Narratorn't
	 */
	@Overwrite
	static Narrator getNarrator() {
		return new NarratorDummy();
	}

}
