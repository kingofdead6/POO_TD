public class CoastalWilaya extends Wilaya {
    private double humidityRate;
    private double waveHeight;

    public CoastalWilaya(String name, WeatherOrder order) {
        super(name, order);
    }

    public void setHumidityRate(double humidityRate) {
        this.humidityRate = humidityRate;
    }

    public void setWaveHeight(double waveHeight) {
        this.waveHeight = waveHeight;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Humidity Rate: " + humidityRate);
        System.out.println("Wave Height: " + waveHeight);
    }
}