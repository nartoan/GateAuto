package utils;

import entity.Station;

public class IUtil {
    public static double calculateActualFare(Station startStation, Station endStation) {
        double fare = 0;
        double distance = Math.abs(startStation.getPosition() - endStation.getPosition());
        fare = 1.9 + Math.round((distance - 5) / 2) * 0.4;

        return fare;
    }
}
