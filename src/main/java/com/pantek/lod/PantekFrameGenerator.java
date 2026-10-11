package com.pantek.lod;

public class PantekFrameGenerator {
    private static boolean enabled = true;
    private static int targetFpsMultiplier = 2; // Generator 2x Frame (Misal 30 FPS -> 60 FPS)
    private static long lastFrameTime = System.nanoTime();
    private static float interpolatedAlpha = 0.5f;

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean state) {
        enabled = state;
    }

    // Fungsi menghitung interval frame untuk nyisipin PFG Frame
    public static boolean shouldGenerateExtraFrame(long currentNanoTime, int currentFps) {
        if (!enabled || currentFps >= 120) return false; // Stop PFG kalau FPS asli udah ketinggian
        
        long frameInterval = currentNanoTime - lastFrameTime;
        lastFrameTime = currentNanoTime;

        // Jika interval antar frame panjang (patah-patah/lagging), PFG aktif nyisipin frame
        return frameInterval > (1_000_000_000L / (currentFps * targetFpsMultiplier));
    }

    public static float getInterpolatedAlpha() {
        return interpolatedAlpha;
    }
}
