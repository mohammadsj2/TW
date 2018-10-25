

public class Home extends Element {
    private int numberOfFloors, numberOfUnits;
    public final int PEOPLE_PER_UNIT = 5;
    public final double CONST_PERSON = 1;
    public final double CONST_UNIT = 2;
    public final double CONST_FLOOR = 3;
    public final double CONST_HOME = 10;
    static {
        CONST_COEFF = 10;

    }
    static int getBuildCost(int floors, int units) {
        return units * 100 + floors * 300 + 700;
    }
    public int getUpgradeCost(int floor, int unit) {
        return unit * 50 + floor * 300;
    }
    public int getNumberOfFloors() { return this.numberOfFloors; }
    public int setNumberOfFloors(int newNumberOfFloors) {
        if (newNumberOfFloors >= 3 && newNumberOfFloors <= 6) {
            this.numberOfFloors = newNumberOfFloors;
            return 0;
        } else {
            return -1;
            // not possible
        }
    }

    public int getNumberOfUnits() { return this.numberOfUnits; }
    public int setNumberOfUnits(int newNumberOfUnits) {
        if (newNumberOfUnits >= 1 && newNumberOfUnits <= 4) {
            this.numberOfUnits = newNumberOfUnits;
            return 0;
        } else {
            return -1;
            // not possible
        }
    }
    Home(int numberOfFloors, int numberOfUnits) {
        super();
        this.setNumberOfFloors(numberOfFloors);
        this.setNumberOfUnits(numberOfUnits);
    }
    public int levelUp(int floor, int unit) {
        if (setNumberOfFloors(getNumberOfFloors() + floor) == -1) return -1;
        if (setNumberOfUnits(getNumberOfUnits() + unit) == -1) return -1;
        return 0;
    }
    public double scorePerson(double aCoeff) {
        return aCoeff * CONST_PERSON;
    }
    public double scoreUnit(double aCoeff) {
        return CONST_UNIT + PEOPLE_PER_UNIT * scorePerson(aCoeff);
    }
    public double scoreFloor(double aCoeff) {
        return CONST_FLOOR + getNumberOfUnits() * scoreUnit(aCoeff) + 2 * getNumberOfUnits() * PEOPLE_PER_UNIT * scorePerson(aCoeff);
    }
    public double scoreHome(double aCoeff) {
        return CONST_HOME + getNumberOfFloors() * scoreFloor(aCoeff) + getNumberOfFloors() * getNumberOfUnits() * 2 * scoreUnit(aCoeff) + getNumberOfFloors() * getNumberOfUnits() * PEOPLE_PER_UNIT * 3 * scorePerson(aCoeff);
    }
    @Override
    public double score(double aCoeff) { return scoreHome(aCoeff); }
    @Override
    public int numberOfPeople() {
        return PEOPLE_PER_UNIT * getNumberOfUnits() * getNumberOfFloors();
    }


}
