package net.darktree.fungible.mixin.dfu;

import com.mojang.datafixers.DataFixer;
import com.mojang.serialization.Dynamic;
import net.minecraft.datafixer.DataFixTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DataFixTypes.class)
public class DatafixTypesMixin {

    /**
     * @author jacg311
     * @reason dont try to datafix
     */
    @Overwrite
    public <T> Dynamic<T> update(DataFixer dataFixer, Dynamic<T> dynamic, int oldVersion, int newVersion) {
        return dynamic;
    }
}
