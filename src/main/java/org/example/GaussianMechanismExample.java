package org.example;

import com.google.privacy.differentialprivacy.GaussianNoise;

// The Gaussian mechanism adds Gaussian-distributed noise to a numeric value
public class GaussianMechanismExample {
    public static void main(String[] args) {
        // The true value you want to privatize
        double trueValue = 42.0;

        // Privacy parameters
        double epsilon = 1.0; // Privacy budget
        int l0Sensitivity = 1; // Max number of partitions contributed to by a single user
        double lInfSensitivity = 1.0; // Max contribution of a single user to a partition
        double delta = 1e-5; // Small value for delta (required for GaussianNoise)
        // Create a Gaussian noise instance
        GaussianNoise gaussianNoise = new GaussianNoise();

        // Generate noise
        double noise = gaussianNoise.addNoise(0.0,l0Sensitivity, lInfSensitivity, epsilon, delta);

        // Compute the noisy value
        double noisyValue = trueValue + noise;

        System.out.println("True Value: " + trueValue);
        System.out.println("Noisy Value: " + noisyValue);
    }
}
