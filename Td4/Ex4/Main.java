import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== Case 1: Chronological Order, Alphabetical Wilayas ===");
        ClimateTracker tracker1 = new ClimateTracker(WeatherOrder.CHRONOLOGICAL);
        
        Wilaya algiers = new Wilaya("Algiers", WeatherOrder.CHRONOLOGICAL);
        algiers.addWeather(new Weather(LocalDate.of(2025, 5, 1), 20.5, 10.0, 5.0));
        algiers.addWeather(new Weather(LocalDate.of(2025, 5, 2), 22.0, 12.0, 3.0));
        
        CoastalWilaya oran = new CoastalWilaya("Oran", WeatherOrder.CHRONOLOGICAL);
        oran.addWeather(new Weather(LocalDate.of(2025, 5, 1), 21.0, 15.0, 7.0));
        oran.addWeather(new Weather(LocalDate.of(2025, 5, 2), 23.0, 14.0, 4.0));
        oran.setHumidityRate(75.5);
        oran.setWaveHeight(1.2);
        
        tracker1.addWilaya(algiers);
        tracker1.addWilaya(oran);
        
        tracker1.printWilaya("Algiers");
        System.out.println();
        tracker1.printWilaya("Oran");
        
        // Case 2: Rainfall order, average rainfall sorting
        System.out.println("\n=== Case 2: Rainfall Order, Average Rainfall Sorting ===");
        ClimateTracker tracker2 = new ClimateTracker(WeatherOrder.RAINFALL);
        
        Wilaya constantine = new Wilaya("Constantine", WeatherOrder.RAINFALL);
        constantine.addWeather(new Weather(LocalDate.of(2025, 5, 1), 19.0, 8.0, 10.0));
        constantine.addWeather(new Weather(LocalDate.of(2025, 5, 2), 20.0, 9.0, 2.0));
        
        CoastalWilaya bejaia = new CoastalWilaya("Bejaia", WeatherOrder.RAINFALL);
        bejaia.addWeather(new Weather(LocalDate.of(2025, 5, 1), 22.5, 11.0, 6.0));
        bejaia.addWeather(new Weather(LocalDate.of(2025, 5, 2), 24.0, 13.0, 8.0));
        bejaia.setHumidityRate(80.0);
        bejaia.setWaveHeight(1.5);
        
        tracker2.addWilaya(constantine);
        tracker2.addWilaya(bejaia);
        
        tracker2.printAllWilayas();
    }
}