package DIP.WeatherReporter;

public class WeatherReporter {
    private TemperatureSensor temperatureSensor;

    public WeatherReporter(TemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

    public String report(){
        return "Current temperature is: " + temperatureSensor.getTemperature();
    }
}
