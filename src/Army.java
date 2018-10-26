
class Army extends Element {
    Army() {
        super();
        CONST_COEFF = 10;
        BUILD_COST = 15000;
        UPGRADE_COST = 20000;
        REMOVE_COST = -10000;
        LEVEL_LIMIT = 5;
        NEEDED_UNITS = 100;
        NEEDED_UNITS_STEP = 10;
    }
    @Override
    public int getConstCoeff() {
        return 10;
    }
    public double getAttackLevel() {
        return 0.2 * this.getLevel();
    }

}
