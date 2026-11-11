package com.example.zorix;

import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ZorixMenuScreen extends Screen {

    private static final Identifier PREVIEW_SUNRISE = Identifier.of("zorix", "textures/gui/preview_sunrise_sky.png");
    private static final Identifier PREVIEW_GALAXY = Identifier.of("zorix", "textures/gui/preview_galaxy_sky.png");

    public ZorixMenuScreen() {
        super(Text.literal("Zorix Client"));
    }

    @Override
    protected void init() {
        int x = this.width / 2 - 170;
        int y = 30;
        int step = 22;
        int w = 150;

        addDrawableChild(ButtonWidget.builder(Text.literal("Sky: " + ZorixSettings.SKY_NAMES[ZorixSettings.skyIndex]), b -> {
            ZorixSettings.skyIndex = (ZorixSettings.skyIndex + 1) % ZorixSettings.SKY_NAMES.length;
            b.setMessage(Text.literal("Sky: " + ZorixSettings.SKY_NAMES[ZorixSettings.skyIndex]));
        }).dimensions(x, y, w, 20).build());

        addDrawableChild(ButtonWidget.builder(onOff("Shooting Stars", ZorixSettings.shootingStars), b -> {
            ZorixSettings.shootingStars = !ZorixSettings.shootingStars;
            b.setMessage(onOff("Shooting Stars", ZorixSettings.shootingStars));
        }).dimensions(x, y + step, w, 20).build());

        addDrawableChild(ButtonWidget.builder(onOff("Aura", ZorixSettings.aura), b -> {
            ZorixSettings.aura = !ZorixSettings.aura;
            b.setMessage(onOff("Aura", ZorixSettings.aura));
        }).dimensions(x, y + step * 2, w, 20).build());

        addDrawableChild(ButtonWidget.builder(onOff("Spotify HUD", ZorixSettings.spotifyHud), b -> {
            ZorixSettings.spotifyHud = !ZorixSettings.spotifyHud;
            b.setMessage(onOff("Spotify HUD", ZorixSettings.spotifyHud));
        }).dimensions(x, y + step * 3, w, 20).build());

        addDrawableChild(ButtonWidget.builder(onOff("Lyrics in Sky", ZorixSettings.lyricsInSky), b -> {
            ZorixSettings.lyricsInSky = !ZorixSettings.lyricsInSky;
            b.setMessage(onOff("Lyrics in Sky", ZorixSettings.lyricsInSky));
        }).dimensions(x, y + step * 4, w, 20).build());

        addDrawableChild(ButtonWidget.builder(onOff("Payment Effect", ZorixSettings.paymentEffect), b -> {
            ZorixSettings.paymentEffect = !ZorixSettings.paymentEffect;
            b.setMessage(onOff("Payment Effect", ZorixSettings.paymentEffect));
        }).dimensions(x, y + step * 5, w, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.literal("Skin: " + ZorixSettings.SKINS[ZorixSettings.skinIndex]), b -> {
            ZorixSettings.skinIndex = (ZorixSettings.skinIndex + 1) % ZorixSettings.SKINS.length;
            b.setMessage(Text.literal("Skin: " + ZorixSettings.SKINS[ZorixSettings.skinIndex]));
        }).dimensions(x, y + step * 6, w, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.literal("Sword: " + ZorixSettings.SWORD_STYLES[ZorixSettings.swordStyle]), b -> {
            ZorixSettings.swordStyle = (ZorixSettings.swordStyle + 1) % ZorixSettings.SWORD_STYLES.length;
            b.setMessage(Text.literal("Sword: " + ZorixSettings.SWORD_STYLES[ZorixSettings.swordStyle]));
        }).dimensions(x, y + step * 7, w, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.literal("Done"), b -> close())
            .dimensions(x, this.height - 28, w, 20).build());
    }

    private Text onOff(String name, boolean on) {
        return Text.literal(name + ": " + (on ? "ON" : "OFF"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 12, 0xFFFFFFFF);

        int px = this.width / 2 + 10;
        int py = 40;
        context.fill(px - 4, py - 4, px + 164, py + 94, 0xAA000000);

        Identifier preview = null;
        if (ZorixSettings.skyIndex == 1) preview = PREVIEW_SUNRISE;
        if (ZorixSettings.skyIndex == 2) preview = PREVIEW_GALAXY;

        if (preview != null) {
            context.drawTexture(RenderPipelines.GUI_TEXTURED, preview, px, py, 0f, 0f, 160, 90, 160, 90);
        } else {
            context.drawCenteredTextWithShadow(this.textRenderer, Text.literal("Normal sky"), px + 80, py + 40, 0xFFAAAAAA);
        }

        context.drawCenteredTextWithShadow(this.textRenderer,
            Text.literal("Preview: " + ZorixSettings.SKY_NAMES[ZorixSettings.skyIndex]), px + 80, py + 100, 0xFFFFFFFF);
        context.drawCenteredTextWithShadow(this.textRenderer,
            Text.literal("Turn a sky on in Options > Resource Packs"), px + 80, py + 114, 0xFFAAAAAA);
    }
}
