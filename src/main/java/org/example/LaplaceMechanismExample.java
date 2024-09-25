package org.example;

import com.google.privacy.differentialprivacy.LaplaceNoise;

// The Laplace mechanism adds Laplace-distributed noise to a numeric value to achieve differential privacy
public class LaplaceMechanismExample {
    public static void main(String[] args) {
        // The true value you want to privatize
        double trueValue = 42.0;

        // Privacy parameters
        double epsilon = 1.0; // Privacy budget
        int l0Sensitivity = 1; // Max number of partitions contributed to by a single user
        double lInfSensitivity = 1.0; // Max contribution of a single user to a partition
        Double delta = null; // For Laplace noise, delta can be null

        // Create a LaplaceNoise instance
        LaplaceNoise laplaceNoise = new LaplaceNoise();

        // Generate noise
        double noise = laplaceNoise.addNoise(
                /* x= */ 0.0,
                l0Sensitivity,
                lInfSensitivity,
                epsilon,
                delta
        );

        // Compute the noisy value
        double noisyValue = trueValue + noise;

        System.out.println("True Value: " + trueValue);
        System.out.println("Noisy Value: " + noisyValue);
    }
}
