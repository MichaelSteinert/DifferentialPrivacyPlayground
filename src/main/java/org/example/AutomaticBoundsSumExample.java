package org.example;

import com.google.privacy.differentialprivacy.BoundedSum;
import com.google.privacy.differentialprivacy.BoundedMean;
import com.google.privacy.differentialprivacy.LaplaceNoise;

// Compute differentially private sum and mean with explicit bounds using Laplace noise.
public class AutomaticBoundsSumExample {
    public static void main(String[] args) {
        // Simulated data
        double[] data = {5.0, 7.0, 9.0, 10.0, 6.0};

        // Create a BoundedSum instance with approximate bounds
        BoundedSum dpSum = BoundedSum.builder()
                .epsilon(1.0)
                .maxPartitionsContributed(1)
                .noise(new LaplaceNoise())
                .lower(0.0) // Explicit lower bound
                .upper(10.0) // Explicit upper bound
                .build();

        // Add entries to the sum
        for (double entry : data) {
            dpSum.addEntry(entry);
        }

        // Compute the noisy sum
        double noisySum = dpSum.computeResult();
        System.out.println("Noisy Sum with Automatic Bounds: " + noisySum);

        // Calculate BoundedMean as an example of extending functionalities
        BoundedMean dpMean = BoundedMean.builder()
                .epsilon(1.0)
                .lower(0.0)
                .upper(10.0)
                .maxPartitionsContributed(1)
                .maxContributionsPerPartition(1)
                .noise(new LaplaceNoise())
                .build();

        // Add entries to the mean calculation
        for (double entry : data) {
            dpMean.addEntry(entry);
        }

        // Compute the noisy mean
        double noisyMean = dpMean.computeResult();
        System.out.println("Noisy Mean: " + noisyMean);
    }
}
