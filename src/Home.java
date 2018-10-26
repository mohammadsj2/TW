

class Home extends Element {
    private int numberOfFloors, numberOfUnits;
    public final int PEOPLE_PER_UNIT = 5;
    public final double CONST_PERSON = 1;
    public final double CONST_UNIT = 2;
    public final double CONST_FLOOR = 3;
    public final double CONST_HOME = 10;

    Home(int numberOfFloors, int numberOfUnits) {
        super();
        this.setIncome(0);
        this.setNumberOfFloors(numberOfFloors);
        this.setNumberOfUnits(numberOfUnits);
        CONST_COEFF = 10;
    }

    static int getBuildCost(int floors, int units) {
        return floors * units * 100 + floors * 300 + 700;
    }
    public int getUpgradeCost(int floor, int unit) {
        return ((floor + getNumberOfFloors()) * (unit + getNumberOfUnits()) - getNumberOfUnits() * getNumberOfFloors()) * 50 + floor * 300;
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
    @Override
    public void updateIncome() {
        return;
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

    public int levelUp(int floor, int unit) {
        if (getNumberOfFloors() + floor > 6) return -1;
        if (getNumberOfUnits() + unit > 4) return -1;

        setNumberOfFloors(getNumberOfFloors() + floor);
        setNumberOfUnits(getNumberOfUnits() + unit);
        return 0;
    }
    public double scorePerson(double aCoeff) {
        return aCoeff * CONST_PERSON;
    }
    public double scoreUnit(double aCoeff) {
        return CONST_UNIT + PEOPLE_PER_UNIT * scorePerson(aCoeff);
    }
    public double scoreFloor(double aCoeff) {
        return CONST_FLOOR + getNumberOfUnits() * scoreUnit(aCoeff) + 2 * getNumberOfUnits() * PEOPLE_PER_UNIT
                * scorePerson(aCoeff);
    }
    public double scoreHome(double aCoeff) {
        return CONST_HOME + getNumberOfFloors() * scoreFloor(aCoeff) + getNumberOfFloors() * getNumberOfUnits() * 2
                * scoreUnit(aCoeff) + numberOfPeople() * 3 * scorePerson(aCoeff);
    }
    @Override
    public double score(double aCoeff) {
        //   System.out.println(getNumberOfUnits());
        return
                scoreHome(aCoeff) +
                        getNumberOfFloors() * scoreFloor(aCoeff)
                        + getNumberOfFloors() * getNumberOfUnits() * scoreUnit(aCoeff) +
                        numberOfPeople() * scorePerson(aCoeff);
    }

    @Override
    public int getConstCoeff() {
        return 0;
    }
    @Override
    public int numberOfPeople() {
        return PEOPLE_PER_UNIT * getNumberOfUnits() * getNumberOfFloors();
    }


}