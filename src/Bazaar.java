public class Bazaar extends Element {
    Bazaar() {
        super();
    }
    static {
        CONST_COEFF = 5;
        BUILD_COST = 6000;
        REMOVE_COST = 500;
        NEEDED_UNITS = 50;
        NEEDED_UNITS_STEP = 20;
    }

    @Override
    public int getUpgradeCost() { return (this.getLevel() + 1) * 5000; }


    @Override
    public double getScoreOfPerson(){
        return 1. + this.getLevel() * 0.2;
    }


}
