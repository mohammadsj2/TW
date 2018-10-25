public class Element {
    private int level, income, blockId;
    private int dayBuilt;
    static int LEVEL_LIMIT = 3;
    static int CONST_COEFF = 0;
    static int BUILD_COST = 0;
    static int REMOVE_COST = 0;
    static int UPGRADE_COST = 0;

    static int NEEDED_UNITS = 0;
    static int NEEDED_UNITS_STEP = 0;

    static int getConstCoeff() { return CONST_COEFF; }
    static int getBuildCost() { return BUILD_COST; }
    static int getRemoveCost() { return REMOVE_COST; }
    public int getUpgradeCost() { return UPGRADE_COST; }
    static int getLevelLimit() { return LEVEL_LIMIT; }
    Element() {
        this.setIncome(0);
        this.setLevel(1);
        this.dayBuilt = Main.getDay();
    }
    public void setIncome(int newIncome) {
        this.income = newIncome;
    }
    public int getIncome() { return this.income; }
    public int setLevel(int newLevel) {
        if (newLevel >= 1 && newLevel <= getLevelLimit()) {
            this.income = newLevel;
            return 0;
        } else {
            // error
            return -1;
        }
    }
    public int getLevel() { return this.level; }
    public int levelUp() { return setLevel(getLevel() + 1); }
    public void setBlockId(int newBlockId) {
        this.blockId = newBlockId;
    }
    public int getBlockId() { return this.blockId; }
    public int getDayBuilt() { return this.dayBuilt; }
    public double score() {
        return Math.pow(this.getConstCoeff(), Main.getDay() - getDayBuilt());
    }
    public double score(double aCoeff) { return 0; }

    public void updateIncome() {
        setIncome(getIncome() + numberOfPeople() * 100);
    }
    public int numberOfPeople() {
        return NEEDED_UNITS_STEP * (this.getLevel() - 1) + NEEDED_UNITS;
    }
    public double getScoreOfPerson() {
        return 1.;
    }
}