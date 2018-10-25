

public class Home extends Element {
    private int numberOfFloors, numberOfUnits;
    public final int PEOPLE_PER_UNIT = 5;
    public final double CONST_PERSON = 1;
    public final double CONST_UNIT = 2;
    public final double CONST_FLOOR = 3;
    public final double CONST_HOME = 10;
    public int getNumberOfFloors() { return this.numberOfFloors; }
    public void setNumberOfFloors(int newNumberOfFloors) {
        if (newNumberOfFloors >= 3 && newNumberOfFloors <= 6) {
            this.numberOfFloors = newNumberOfFloors;
        } else {
            // not possible
        }
    }

    public int getNumberOfUnits() { return this.numberOfUnits; }
    public void setNumberOfUnits(int newNumberOfUnits) {
        if (newNumberOfUnits >= 1 && newNumberOfUnits <= 4) {
            this.numberOfUnits = newNumberOfUnits;
        } else {
            // not possible
        }
    }
    Home(int dayBuilt, int numberOfFloors, int numberOfUnits) {
        super(dayBuilt);
        this.setNumberOfFloors(numberOfFloors);
        this.setNumberOfUnits(numberOfUnits);
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
    public int numberOfPeople() {
        return PEOPLE_PER_UNIT * getNumberOfUnits() * getNumberOfFloors();
    }


}
