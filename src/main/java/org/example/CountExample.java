package org.example;

import com.google.privacy.differentialprivacy.Count;
import com.google.privacy.differentialprivacy.LaplaceNoise;

// Compute a differentially private count of elements
public class CountExample {
    public static void main(String[] args) {
        // Create a Count instance
        Count dpCount = Count.builder()
                .epsilon(1.0)
                .maxPartitionsContributed(1)
                .noise(new LaplaceNoise())
                .build();

        // Simulated data
        int[] data = {1, 1, 1, 1, 1}; // Each '1' represents an individual's contribution

        // Add entries to the count
        for (int entry : data) {
            dpCount.increment();
        }

        // Compute the noisy count
        long noisyCount = dpCount.computeResult();

        System.out.println("Noisy Count: " + noisyCount);
    }
}
