package AbstractFactory;
public class Client {
    public static void main(String[] args) {
        CarFactory marutiFactory = new MarutiFactory();
        CarFactory hyundaiFactory = new HyundaiFactory();

        Engine marutiEngine = marutiFactory.createEngine();
        Engine hyundaiEngine = hyundaiFactory.createEngine();

        DashBoard marutiDashBoard = marutiFactory.createDashBoard();
        DashBoard hyundaiDashBoard = hyundaiFactory.createDashBoard();

        Tyres marutiTyres = marutiFactory.createTyres();
        Tyres hyundaiTyres = hyundaiFactory.createTyres();

        marutiEngine.engineInfo();
        hyundaiEngine.engineInfo();

        marutiDashBoard.displayDashBoard();
        hyundaiDashBoard.displayDashBoard();

        marutiTyres.tyresInfo();
        hyundaiTyres.tyresInfo();
    }

}
