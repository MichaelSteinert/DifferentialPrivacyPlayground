package org.example;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.utils.DataUtils;
import com.example.utils.LaplaceNoiseGenerator;

public class DifferentialPrivacyExample {

    @Test
    public void testCalculateMean() {
        double[] data = {1, 2, 3, 4, 5};
        double expectedMean = 3.0;
        double calculatedMean = DataUtils.calculateMean(data);
        assertEquals(expectedMean, calculatedMean, 0.0001);
    }

    @Test
    public void testCalculateSensitivity() {
        double[] data = {1, 2, 3, 4, 5};
        double expectedSensitivity = (5 - 1) / 5.0;
        double calculatedSensitivity = DataUtils.calculateSensitivity(data);
        assertEquals(expectedSensitivity, calculatedSensitivity, 0.0001);
    }

    @Test
    public void testGenerateLaplaceNoise() {
        double scale = 1.0;
        double noise = LaplaceNoiseGenerator.generateNoise(scale);
        // Since noise is random, check that it's a finite number
        assertTrue(Double.isFinite(noise));
    }

    @Test
    public void testNoisyMean() {
        double[] data = {5, 7, 9, 10, 6};
        double originalMean = DataUtils.calculateMean(data);

        double epsilon = 1.0;
        double sensitivity = DataUtils.calculateSensitivity(data);
        double scale = sensitivity / epsilon;

        double noise = LaplaceNoiseGenerator.generateNoise(scale);
        double noisyMean = originalMean + noise;

        // Check that the noisy mean is finite
        assertTrue(Double.isFinite(noisyMean));
    }
}
