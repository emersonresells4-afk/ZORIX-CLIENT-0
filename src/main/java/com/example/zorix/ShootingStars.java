package com.example.zorix;

import net.minecraft.client.MinecraftClient;
import net.minecraft.particle.ParticleTypes;

import java.util.Random;

public class ShootingStars {

    private static final Random RANDOM = new Random();

    public static void tick(MinecraftClient client) {
        if (!ZorixSettings.shootingStars) return;
        if (client.player == null || client.world == null) return;

        long time = client.world.getTimeOfDay() % 24000L;
        boolean night = time > 13000L && time < 23000L;
        if (!night) return;

        if (RANDOM.nextInt(25) != 0) return;

        double angle = RANDOM.nextDouble() * Math.PI * 2;
        double distance = 25 + RANDOM.nextDouble() * 20;
        double x = client.player.getX() + Math.cos(angle) * distance;
        double z = client.player.getZ() + Math.sin(angle) * distance;
        double y = client.player.getY() + 40 + RANDOM.nextDouble() * 20;

        double dx = (RANDOM.nextDouble() - 0.5) * 1.2;
        double dz = (RANDOM.nextDouble() - 0.5) * 1.2;

        for (int i = 0; i < 12; i++) {
            client.world.addParticleClient(
                ParticleTypes.END_ROD,
                x + dx * i * 0.6, y - i * 0.6, z + dz * i * 0.6,
                dx * 0.4, -0.5, dz * 0.4
            );
        }
    }
}
