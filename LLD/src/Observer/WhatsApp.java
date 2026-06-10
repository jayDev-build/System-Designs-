package Observer;

public class WhatsApp implements Observer{
    private String temperature;
    @Override
    public String getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
