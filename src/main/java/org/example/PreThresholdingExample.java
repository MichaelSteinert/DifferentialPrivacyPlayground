package org.example;

import com.google.privacy.differentialprivacy.Count;
import com.google.privacy.differentialprivacy.LaplaceNoise;

import java.util.HashMap;
import java.util.Map;

// re-thresholding limits the number of contributions per user before applying differential privacy mechanisms.
public class PreThresholdingExample {
    public static void main(String[] args) {
        // Max contributions per user
        int maxContributionsPerUser = 1;

        // Simulated data with user IDs
        int[] userIds = {1, 1, 2, 2, 2, 3};
        int[] data = {5, 7, 9, 10, 6, 8};

        // Pre-thresholding: limit contributions per user
        Map<Integer, Integer> userContributions = new HashMap<>();
        Map<Integer, Integer> preprocessedData = new HashMap<>();

        for (int i = 0; i < userIds.length; i++) {
            int userId = userIds[i];
            int contribution = data[i];
            int contributionsSoFar = userContributions.getOrDefault(userId, 0);

            if (contributionsSoFar < maxContributionsPerUser) {
                userContributions.put(userId, contributionsSoFar + 1);
                preprocessedData.put(userId, contribution);
            }
        }

        // Create a Count instance
        Count dpCount = Count.builder()
                .epsilon(1.0)
                .maxPartitionsContributed(1)
                .noise(new LaplaceNoise())
                .build();

        // Add preprocessed entries to the count
        for (int entry : preprocessedData.values()) {
            dpCount.increment();
        }

        // Compute the noisy count
        long noisyCount = dpCount.computeResult();

        System.out.println("Noisy Count after Pre-thresholding: " + noisyCount);
    }
}
