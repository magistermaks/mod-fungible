package net.darktree.fungible.mixin;

import com.mojang.datafixers.DataFixer;
import net.minecraft.datafixer.DataFixTypes;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(NbtHelper.class)
public class NbtHelperMixin {

	/**
	 * @author magistermaks
	 * @reason Avoid using the fixer (this time for real)
	 */
	@Overwrite
	public static NbtCompound update(DataFixer fixer, DataFixTypes fixTypes, NbtCompound tag, int oldVersion, int currentVersion) {
		return tag;
	}

}
