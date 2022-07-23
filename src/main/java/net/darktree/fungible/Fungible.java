package net.darktree.fungible;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class Fungible implements ModInitializer {

	public static final String NAME = "Fungible";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	private void spooky(String message) {
		LOGGER.error(NAME.toUpperCase(Locale.ROOT) + " IS LOADING! " + message);
	}

	@Override
	public void onInitialize() {
		LOGGER.warn("Applying horrific hacks...");

		// just don't distribute it to users, ok?
		if (!FabricLoader.getInstance().isDevelopmentEnvironment()) {
			spooky("I REALLY HOPE YOU KNOW WHAT YOU ARE DOING!");
			spooky("YOUR SAVE DATA IS AT RISK!");
			spooky("THIS MOD SHOULD ONLY BE USED BY MOD DEVELOPERS!");
		}
	}

}
