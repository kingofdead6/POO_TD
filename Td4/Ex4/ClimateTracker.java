import java.util.*;

public class ClimateTracker {
    private Map<String, Wilaya> wilayasByName; // Case 1: Alphabetical order by name
    private Map<Double, List<Wilaya>> wilayasByRainfall; // Case 2: Ascending order by average rainfall
    private WeatherOrder order;

    public ClimateTracker(WeatherOrder order) {
        this.order = order;
        if (order == WeatherOrder.CHRONOLOGICAL) {
            this.wilayasByName = new TreeMap<>();
            this.wilayasByRainfall = null;
        } else {
            this.wilayasByRainfall = new TreeMap<>();
            this.wilayasByName = null;
        }
    }

    public void addWilaya(Wilaya wilaya) {
        if (order == WeatherOrder.CHRONOLOGICAL) {
            wilayasByName.put(wilaya.getName(), wilaya);
        } else {
            double avgRainfall = wilaya.getAverageRainfall();
            wilayasByRainfall.putIfAbsent(avgRainfall, new ArrayList<>());
            wilayasByRainfall.get(avgRainfall).add(wilaya);
        }
    }

    public void printWilaya(String name) {
        if (order == WeatherOrder.CHRONOLOGICAL) {
            Wilaya wilaya = wilayasByName.get(name);
            if (wilaya != null) {
                wilaya.print();
            } else {
                System.out.println("Wilaya not found.");
            }
        } else {
            for (List<Wilaya> wilayas : wilayasByRainfall.values()) {
                for (Wilaya w : wilayas) {
                    if (w.getName().equals(name)) {
                        w.print();
                        return;
                    }
                }
            }
            System.out.println("Wilaya not found.");
        }
    }

    public void printAllWilayas() {
        if (order == WeatherOrder.CHRONOLOGICAL) {
            for (Wilaya w : wilayasByName.values()) {
                w.print();
            }
        } else {
            for (List<Wilaya> wilayas : wilayasByRainfall.values()) {
                for (Wilaya w : wilayas) {
                    w.print();
                }
            }
        }
    }
}