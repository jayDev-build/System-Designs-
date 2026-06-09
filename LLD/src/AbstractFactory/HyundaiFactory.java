package AbstractFactory;

public class HyundaiFactory implements CarFactory{
    @Override
    public Engine createEngine() {
        return new HyundaiEngine();
    }

    @Override
    public DashBoard createDashBoard() {
        return new HyundaiDashBoard();
    }

    @Override
    public Tyres createTyres() {
        return new HyundaiTyres();
    }
}
