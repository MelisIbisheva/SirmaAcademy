package DIP.WeatherReporter;

public class Thermometer implements TemperatureSensor{
    private double temperature;

    public Thermometer(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double getTemperature() {
        return this.temperature;
    }

    public void increaseTemperature(double amount) {
        this.temperature += amount;
    }

    public void decreaseTemperature(double amount) {
        this.temperature -= amount;
    }
}
