package org.example.utils;

import java.util.Random;

public class LaplaceNoiseGenerator {
    private static final Random RANDOM = new Random();

    // Generates Laplace noise with a given scale
    public static double generateNoise(double scale) {
        double u = RANDOM.nextDouble() - 0.5;
        return -scale * Math.signum(u) * Math.log(1 - 2 * Math.abs(u));
    }
}
