package org.example.utils;

public class DataUtils {
    // Calculates the mean of an array
    public static double calculateMean(double[] data) {
        double sum = 0.0;
        for (double d : data) {
            sum += d;
        }
        return sum / data.length;
    }

    // Calculates the sensitivity for the mean function
    public static double calculateSensitivity(double[] data) {
        double max = getMax(data);
        double min = getMin(data);
        return (max - min) / data.length;
    }

    // Finds the maximum value in the array
    public static double getMax(double[] data) {
        double max = data[0];
        for (double d : data) {
            if (d > max) {
                max = d;
            }
        }
        return max;
    }

    // Finds the minimum value in the array
    public static double getMin(double[] data) {
        double min = data[0];
        for (double d : data) {
            if (d < min) {
                min = d;
            }
        }
        return min;
    }
}
