import java.util.*;

public class Wilaya {
    private String name;
    private Collection<Weather> dailyWeather;

    public Wilaya(String name, WeatherOrder order) {
        this.name = name;
        if (order == WeatherOrder.CHRONOLOGICAL) {
            this.dailyWeather = new TreeSet<>(Comparator.comparing(Weather::getDate));
        } else {
            this.dailyWeather = new PriorityQueue<>((w1, w2) -> Double.compare(w2.getRainfall(), w1.getRainfall()));
        }
    }

    public void addWeather(Weather weather) {
        dailyWeather.add(weather);
    }

    public void print() {
        System.out.println("Wilaya: " + name);
        if (dailyWeather instanceof PriorityQueue) {
            List<Weather> sortedWeather = new ArrayList<>(dailyWeather);
            sortedWeather.sort((w1, w2) -> Double.compare(w2.getRainfall(), w1.getRainfall()));
            for (Weather w : sortedWeather) {
                System.out.println(w);
            }
        } else {
            for (Weather w : dailyWeather) {
                System.out.println(w);
            }
        }
    }

    public String getName() {
        return name;
    }

    public double getAverageRainfall() {
        if (dailyWeather.isEmpty()) return 0.0;
        double totalRainfall = 0;
        for (Weather w : dailyWeather) {
            totalRainfall += w.getRainfall();
        }
        return totalRainfall / dailyWeather.size();
    }
}