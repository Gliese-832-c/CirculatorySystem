package gliese832c.circulatorySystem.util;

import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTracker;
import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTrackers;

public class StringProcessing {

    public static String determineDoubleColor(double value) {
        if (value < 0.1666666) {
            return "§2";
        } else if (value >= 0.1666666 & value < 0.3333333) {
            return "§a";
        } else if (value >= 0.3333333 & value < 0.5) {
            return "§e";
        } else if (value >= 0.5 & value < 0.6666666) {
            return "§6";
        } else if (value >= 0.6666666 & value < 0.8333333) {
            return "§C";
        } else if (value >= 0.8333333) {
            return "§4";
        }
        return "§d";
    }

    public static String getValueColorized(double value) {
        return determineDoubleColor(value) + value;
    }

    public static String getValueColorizedPercentage(double value) {
        double percentageValue = Math.round(value * 10000.0d) / 100.0d;
        String[] str = String.valueOf(percentageValue).split("\\.");
        return determineDoubleColor(value) + percentageValue + (str[1].length() == 1 ? "0%" : "%");
    }



    public static boolean checkWhetherSystemTypeIsValid(String type) {
        for (StatusTracker statusTracker : StatusTrackers.statusTrackers) {
            if (type.equals(statusTracker.key)) {
                return true;
            }
        }
        return false;
    }



    public static String determineDoubleColorConsumableEffect(double value) {
        if (value <= -0.03) {
            return "§2";
        } else if (value > -0.03 && value <= -0.003) {
            return "§a";
        } else if (value > -0.003 && value < 0.003) {
            return "§f";
        } else if (value >= 0.003 && value < 0.01) {
            return "§e";
        } else if (value >= 0.01 && value < 0.03) {
            return "§6";
        } else if (value >= 0.03 && value < 0.1) {
            return "§C";
        } else if (value >= 0.1) {
            return "§4";
        }
        return "§d";
    }

    public static String getValueColorizedPercentageConsumable(double value) {

        double percentageValue = Math.round(value * 10000.0d) / 100.0d;

        String[] str = String.valueOf(percentageValue).split("\\.");

        if (value > 0) {
            return determineDoubleColorConsumableEffect(value) + "+" + percentageValue + (str[1].length() == 1 ? "0%" : "%");
        } else {
            return determineDoubleColorConsumableEffect(value) + percentageValue + (str[1].length() == 1 ? "0%" : "%");
        }
    }

    public static String getValuePercentage(double value) {
        double percentageValue = Math.round(value * 10000.0d) / 100.0d;
        String[] str = String.valueOf(percentageValue).split("\\.");
        return percentageValue + (str[1].length() == 1 ? "0%" : "%");
    }
}
