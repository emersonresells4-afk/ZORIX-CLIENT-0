package com.example.zorix;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ZorixMenuScreen extends Screen {

    public ZorixMenuScreen() {
        super(Text.literal("Zorix Client"));
    }

    @Override
    protected void init() {
        int x = this.width / 2 - 100;
        int y = 40;
        int step = 24;

        addDrawableChild(ButtonWidget.builder(onOff("Galaxy Sky", ZorixSettings.galaxySky), b -> {
            ZorixSettings.galaxySky = !ZorixSettings.galaxySky;
            b.setMessage(onOff("Galaxy Sky", ZorixSettings.galaxySky));
        }).dimensions(x, y, 200, 20).build());

        addDrawableChild(ButtonWidget.builder(onOff("Aura", ZorixSettings.aura), b -> {
            ZorixSettings.aura = !ZorixSettings.aura;
            b.setMessage(onOff("Aura", ZorixSettings.aura));
        }).dimensions(x, y + step, 200, 20).build());

        addDrawableChild(ButtonWidget.builder(onOff("Spotify HUD", ZorixSettings.spotifyHud), b -> {
            ZorixSettings.spotifyHud = !ZorixSettings.spotifyHud;
            b.setMessage(onOff("Spotify HUD", ZorixSettings.spotifyHud));
        }).dimensions(x, y + step * 2, 200, 20).build());

        addDrawableChild(ButtonWidget.builder(onOff("Lyrics in Sky", ZorixSettings.lyricsInSky), b -> {
            ZorixSettings.lyricsInSky = !ZorixSettings.lyricsInSky;
            b.setMessage(onOff("Lyrics in Sky", ZorixSettings.lyricsInSky));
        }).dimensions(x, y + step * 3, 200, 20).build());

        addDrawableChild(ButtonWidget.builder(onOff("Payment Effect", ZorixSettings.paymentEffect), b -> {
            ZorixSettings.paymentEffect = !ZorixSettings.paymentEffect;
            b.setMessage(onOff("Payment Effect", ZorixSettings.paymentEffect));
        }).dimensions(x, y + step * 4, 200, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.literal("Skin: " + ZorixSettings.SKINS[ZorixSettings.skinIndex]), b -> {
            ZorixSettings.skinIndex = (ZorixSettings.skinIndex + 1) % ZorixSettings.SKINS.length;
            b.setMessage(Text.literal("Skin: " + ZorixSettings.SKINS[ZorixSettings.skinIndex]));
        }).dimensions(x, y + step * 5, 200, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.literal("Sword: " + ZorixSettings.SWORD_STYLES[ZorixSettings.swordStyle]), b -> {
            ZorixSettings.swordStyle = (ZorixSettings.swordStyle + 1) % ZorixSettings.SWORD_STYLES.length;
            b.setMessage(Text.literal("Sword: " + ZorixSettings.SWORD_STYLES[ZorixSettings.swordStyle]));
        }).dimensions(x, y + step * 6, 200, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.literal("Done"), b -> close())
            .dimensions(x, y + step * 7 + 8, 200, 20).build());
    }

    private Text onOff(String name, boolean on) {
        return Text.literal(name + ": " + (on ? "ON" : "OFF"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 15, 0xFFFFFFFF);
    }
}
