package org.example;

import com.google.privacy.differentialprivacy.BoundedMean;
import com.google.privacy.differentialprivacy.LaplaceNoise;

// Compute a differentially private mean
public class MeanExample {
    public static void main(String[] args) {
        // Create a BoundedMean instance
        BoundedMean dpMean = BoundedMean.builder()
                .epsilon(1.0)
                .lower(0.0) // Lower bound of input values
                .upper(10.0) // Upper bound of input values
                .maxPartitionsContributed(1)
                .maxContributionsPerPartition(1)
                .noise(new LaplaceNoise())
                .build();

        // Simulated data
        double[] data = {5.0, 7.0, 9.0, 10.0, 6.0};

        // Add entries to the mean
        for (double entry : data) {
            dpMean.addEntry(entry);
        }

        // Compute the noisy mean
        double noisyMean = dpMean.computeResult();

        System.out.println("Noisy Mean: " + noisyMean);
    }
}
