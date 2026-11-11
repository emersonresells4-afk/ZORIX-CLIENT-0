package com.example.zorix;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ZorixPacks {

    public static void register() {
        FabricLoader.getInstance().getModContainer("zorix").ifPresent(container -> {
            ResourceManagerHelper.registerBuiltinResourcePack(
                Identifier.of("zorix", "sunrise_sky"),
                container,
                Text.literal("Zorix Sunrise Sky"),
                ResourcePackActivationType.NORMAL
            );
            ResourceManagerHelper.registerBuiltinResourcePack(
                Identifier.of("zorix", "galaxy_sky"),
                container,
                Text.literal("Zorix Galaxy Sky"),
                ResourcePackActivationType.NORMAL
            );
        });
    }
}
