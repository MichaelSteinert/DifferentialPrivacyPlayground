package org.example;

import org.example.utils.DataUtils;
import org.example.utils.LaplaceNoiseGenerator;

public class BasicDifferentialPrivacy {
    public static void main(String[] args) {
        // Example dataset
        double[] data = {5, 7, 9, 10, 6, 8, 7, 5, 9, 6};

        // Calculate original mean
        double originalMean = DataUtils.calculateMean(data);
        System.out.println("Original Mean: " + originalMean);

        // Privacy parameter (epsilon)
        double epsilon = 1.0;

        // Calculate sensitivity
        double sensitivity = DataUtils.calculateSensitivity(data);

        // Generate Laplace noise
        double noise = LaplaceNoiseGenerator.generateNoise(sensitivity / epsilon);

        // Calculate noisy mean
        double noisyMean = originalMean + noise;
        System.out.println("Noisy Mean: " + noisyMean);
    }
}

