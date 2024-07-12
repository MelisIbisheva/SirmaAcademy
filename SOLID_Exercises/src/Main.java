import DIP.SwitchLights.Bulb;
import DIP.SwitchLights.LightSwitch;
import DIP.SwitchLights.Switchable;
import DIP.WeatherReporter.TemperatureSensor;
import DIP.WeatherReporter.Thermometer;
import DIP.WeatherReporter.WeatherReporter;
import OCP.Discount;
import OCP.DiscountCalculator;
import OCP.SeniorDiscount;
import OCP.StudentDiscount;

public class Main {
    public static void main(String[] args) {

        // Discounts
        Discount studentDiscount = new StudentDiscount();
        Discount seniorDiscount = new SeniorDiscount();
        DiscountCalculator calculator = new DiscountCalculator();
        calculator.getDiscounts().put("STUDENT", studentDiscount);
        calculator.getDiscounts().put("SENIOR", seniorDiscount);
        System.out.println(calculator.calculateDiscount("STUDENT", 20.0));

        //LightSwitch
        Switchable switchable = new Bulb();
        LightSwitch lightSwitch = new LightSwitch(switchable);
        lightSwitch.operate(); // Bulb is on
        lightSwitch.operate(); // Bulb is off

        //Temperature sensor
        TemperatureSensor temperatureSensor = new Thermometer(20.5);
        WeatherReporter weatherReporter = new WeatherReporter(temperatureSensor);
        System.out.println(weatherReporter.report());
        Thermometer thermometer = (Thermometer) temperatureSensor;
        thermometer.increaseTemperature(5.0);
        System.out.println(weatherReporter.report());

    }
}