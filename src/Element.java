public class Element {
    private int level, income, blockId;
    private int dayBuilt;
    Element(int dayBuilt) {
        income = 0;
        this.setLevel(1);
        this.dayBuilt = dayBuilt;
    }
    public void setIncome(int newIncome) {
        this.income = newIncome;
    }
    public int getIncome() { return this.income; }
    public void setLevel(int newLevel) {
        if (newLevel >= 1 && newLevel <= 3) {
            this.income = newLevel;
        }
    }
    public int getLevel() { return this.level; }
    public void levelUp() { setLevel(getLevel() + 1); }
    public void setBlockId(int newBlockId) {
        this.blockId = newBlockId;
    }
    public int getBlockId() { return this.blockId; }
    public int getDayBuilt() { return this.dayBuilt; }
    public double score() {
        return 0;
    }
    public void updateIncome() {

    }
    public int numberOfPeople() {
        return 0;
    }
    public double getScoreOfPerson() {
        return 1.;
    }
}