import java.util.ArrayList;

public class Block
{
    private final int INITIAL_MAX_ELEMENTS=15,UPGRADE_MAX_ELEMENTS=5;
    private ArrayList<Element> elements;
    private int level,defenceId;
    Block()
    {
        level=1;
        defenceId=-1;
    }
    int numberOfMaxElements()
    {
        return INITIAL_MAX_ELEMENTS+(level-1)*UPGRADE_MAX_ELEMENTS;
    }
    int getIncome()
    {
        return 0;
    }
    int getScoreOfPerson()
    {
        return 0;
    }
    int numberOfUnusedPeople()
    {
        return 0;
    }
    void AddElement(Element element)
    {

    }
    void removeElement(int elementId)
    {
    //    elements.add(new Element());
    //    return elements.size()-1;
    }
    void upgradeElement(int elementId)
    {

    }
    int getDefenceId()
    {
        return defenceId;
    }

}
