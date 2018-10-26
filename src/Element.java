class Element {
    private int level, income, blockId;
    private int dayBuilt;
    static int LEVEL_LIMIT = 3;
    static int CONST_COEFF = 0;
    static int BUILD_COST = 0;
    static int REMOVE_COST = 0;
    static int UPGRADE_COST = 0;

    public int NEEDED_UNITS = 0;
    public int NEEDED_UNITS_STEP = 0;
    public int getConstCoeff() { return CONST_COEFF; }
    public int getBuildCost() {  return BUILD_COST; }
    public int getRemoveCost() {  return REMOVE_COST; }
    public int getUpgradeCost() {  return UPGRADE_COST; }
    public int getLevelLimit() {  return LEVEL_LIMIT; }
    public int getNeededUnits() { return 0;}
    public int getNeededUnitsStep() { return 0;}
    Element() {
        this.setIncome(0);
        this.setLevel(1);
        this.dayBuilt = Main.getDay();
    }
    public void setIncome(int newIncome) {
        this.income = newIncome;
    }
    public int getIncome() {
        return this.income;
    }
    public int setLevel(int newLevel) {
        if (newLevel >= 1 && newLevel <= getLevelLimit()) {
            this.level = newLevel;

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
    public double score(boolean nowCity) {
        //   System.out.println(this.getConstCoeff());
       /* if(this instanceof Defence)
        {
            System.out.println("RIDI "+this.getConstCoeff());
        }*/
        //   Defence.CONST_COEFF=15;
        int tmp=(Main.getDay()/2 - getDayBuilt()/2)+1;
        return Math.pow(this.getConstCoeff(), tmp);
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