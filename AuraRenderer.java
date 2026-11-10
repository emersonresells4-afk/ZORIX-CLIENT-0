package com.example.zorix;

import net.minecraft.client.MinecraftClient;
import net.minecraft.particle.ParticleTypes;

public class AuraRenderer {

    private static int tick = 0;

    public static void tick(MinecraftClient client) {
        if (!ZorixSettings.aura) return;
        if (client.player == null || client.world == null) return;

        tick++;
        if (tick % 2 != 0) return;

        double angle = tick * 0.3;
        double x = client.player.getX() + Math.cos(angle) * 0.8;
        double z = client.player.getZ() + Math.sin(angle) * 0.8;
        double y = client.player.getY() + 1.0 + Math.sin(tick * 0.1) * 0.5;

        client.world.addParticleClient(ParticleTypes.END_ROD, x, y, z, 0, 0.02, 0);
    }
}
