package net.darktree.fungible;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.util.Locale;

public class Fungible implements ModInitializer {

	private static final String NAME = "Fungible";

	private void spooky(String message) {
		System.err.println(NAME.toUpperCase(Locale.ROOT) + " IS LOADING! " + message);
	}

	@Override
	public void onInitialize() {
		System.out.println("Applying horrific hacks...");

		// just don't distribute it to users, ok?
		if (!FabricLoader.getInstance().isDevelopmentEnvironment()) {
			spooky("I REALLY HOPE YOU KNOW WHAT YOU ARE DOING!");
			spooky("YOUR SAVE DATA IS AT RISK!");
			spooky("THIS MOD SHOULD ONLY BE USED BY MOD DEVELOPERS!");
		}
	}

}
