package net.darktree.fungible;

import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FungibleMixinPlugin implements IMixinConfigPlugin {
    Map<String, String> mixinCategories = new HashMap<>();
    Properties mixinProperties = new Properties();
    @Override
    public void onLoad(String mixinPackage) {
        mixinCategories.put("DatafixTypesMixin", "dfu");
        mixinCategories.put("LevelStorageMixin", "dfu");
        mixinCategories.put("MinecraftServerMixin", "dfu");
        mixinCategories.put("NbtHelperMixin", "dfu");
        mixinCategories.put("SchemasMixin", "dfu");
        mixinCategories.put("UtilMixin", "dfu");

        mixinCategories.put("NarratorMixin", "narrator");

        mixinCategories.put("ProfileKeysImplMixin", "auth");
        mixinCategories.put("ShutAuthMixin", "auth");

        mixinCategories.put("SplashOverlayMixin", "screen_fade");
        mixinCategories.put("TitleScreenMixin", "screen_fade");

        mixinCategories.put("AccessibilityScreenMixin", "screen_skip");
        mixinCategories.put("CreateWorldScreenMixin", "screen_skip");

        Path configFile = FabricLoader.getInstance().getConfigDir().resolve("fungible.properties");
        if (Files.exists(configFile)) {
            try {
                mixinProperties.load(Files.newBufferedReader(configFile));
            }
            catch (IOException e) {
                Fungible.LOGGER.error("Reading the config file failed. ", e);
            }
        }
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        String className = mixinClassName.substring(mixinClassName.lastIndexOf(".") + 1);
        return Boolean.parseBoolean(
                mixinProperties.getProperty(
                        mixinCategories.get(className),
                        "true"
                )
        );
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
