public class Defence extends Element {
    Defence() {
        super();
    }
    static {
        LEVEL_LIMIT = 5;
        CONST_COEFF = 15;
        BUILD_COST = 10000;
        REMOVE_COST = -10000;
        UPGRADE_COST = 5000;
        NEEDED_UNITS = 30;
        NEEDED_UNITS_STEP = 0;
    }
    public double defenseLevel() {
        return this.getLevel() * 0.2;
    }

}
