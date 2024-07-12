package DIP.SwitchLights;

public class LightSwitch {
    private Switchable switchable;

    public LightSwitch(Switchable switchable) {
        this.switchable = switchable;
    }

    public void operate() {
        if(switchable instanceof Bulb){
            Bulb bulb = (Bulb) this.switchable;
            if (bulb.isOn()){
                switchable.turnOf();

            }else {
                switchable.turnOn();
            }
        }

    }
}
