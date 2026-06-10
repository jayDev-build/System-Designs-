package Observer;

public class Client{

    public static void main(String[] args) {
        Weather weather = new Weather();
        Observer email = new Email();
        weather.addObserver(email);
        Observer webSite = new WebSite();
        weather.addObserver(webSite);
        Observer whatsApp = new WhatsApp();
        weather.addObserver(whatsApp);


        System.out.println("Temperature set to 32C");
        weather.updateTemperature("32C");

        System.out.println("Temperature Receive on email: " + email.getTemperature());
        System.out.println("Temperature Receive on webSite: " + webSite.getTemperature());
        System.out.println("Temperature Receive on whatsApp: " + whatsApp.getTemperature());

        System.out.println("\nTemperature set to 45C");
        weather.updateTemperature("45C");

        System.out.println("Temperature Receive on email: " + email.getTemperature());
        System.out.println("Temperature Receive on webSite: " + webSite.getTemperature());
        System.out.println("Temperature Receive on whatsApp: " + whatsApp.getTemperature());
    }

}
