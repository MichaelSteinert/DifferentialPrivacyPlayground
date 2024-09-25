package org.example;

import com.google.privacy.differentialprivacy.BoundedSum;
import com.google.privacy.differentialprivacy.LaplaceNoise;

// Compute a differentially private sum of numeric data
public class SumExample {
    public static void main(String[] args) {
        // Create a Sum instance
        BoundedSum dpSum = BoundedSum.builder()
                .epsilon(1.0)
                .lower(0.0) // Lower bound of input values
                .upper(10.0) // Upper bound of input values
                .maxPartitionsContributed(1)
                .noise(new LaplaceNoise())
                .build();

        // Simulated data
        double[] data = {5.0, 7.0, 9.0, 10.0, 6.0};

        // Add entries to the sum
        for (double entry : data) {
            dpSum.addEntry(entry);
        }

        // Compute the noisy sum
        double noisySum = dpSum.computeResult();

        System.out.println("Noisy Sum: " + noisySum);
    }
}
