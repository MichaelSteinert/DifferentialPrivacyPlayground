package org.example;

import com.google.privacy.differentialprivacy.LaplaceNoise;
import com.google.privacy.differentialprivacy.BoundedQuantiles;

// Compute differentially private quantiles.
public class QuantilesExample {
    public static void main(String[] args) {
        // Create a Quantiles instance
        BoundedQuantiles dpQuantiles = BoundedQuantiles.builder()
                .epsilon(1.0)
                .lower(0.0)
                .upper(100.0)
                .maxPartitionsContributed(1)
                .maxContributionsPerPartition(1)
                .treeHeight(4)
                .branchingFactor(10)
                .noise(new LaplaceNoise())
                .build();

        // Simulated data
        double[] data = {5.0, 15.0, 25.0, 35.0, 45.0, 55.0, 65.0, 75.0, 85.0, 95.0};

        // Add entries to the quantiles
        for (double entry : data) {
            dpQuantiles.addEntry(entry);
        }

        // Compute the noisy quantiles
        double noisyQuantiles = dpQuantiles.computeResult(0.5);

        System.out.println("Noisy Quantiles:" + noisyQuantiles);
    }
}
