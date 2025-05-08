import java.time.LocalDate;

public class Weather {
    private LocalDate date;
    private double temp, wind, rainfall;

    public Weather(LocalDate date, double temp, double wind, double rainfall) {
        this.date = date;
        this.temp = temp;
        this.wind = wind;
        this.rainfall = rainfall;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTemp() {
        return temp;
    }

    public double getWind() {
        return wind;
    }

    public double getRainfall() {
        return rainfall;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Temp: " + temp + ", Wind: " + wind + ", Rainfall: " + rainfall;
    }
}