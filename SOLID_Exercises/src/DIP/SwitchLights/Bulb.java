package DIP.SwitchLights;

public class Bulb implements Switchable{
    private boolean isOn;

    public boolean isOn() {
        return isOn;
    }
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Bulb is on!");
    }

    @Override
    public void turnOf() {
        isOn = false;
        System.out.println("Bulb is off!");

    }

}
