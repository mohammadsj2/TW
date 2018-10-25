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
    public int numberOfMaxElements()
    {
        return INITIAL_MAX_ELEMENTS+(level-1)*UPGRADE_MAX_ELEMENTS;
    }
    public int getIncome()
    {
        return 0;
    }
    public int getScoreOfPerson()
    {
        return 0;
    }
    public int numberOfUnusedPeople()
    {
        return 0;
    }
    public void AddElement(Element element)
    {

    }
    public void removeElement(int elementId)
    {
    //    elements.add(new Element());
    //    return elements.size()-1;
    }
    public void upgradeElement(int elementId)
    {

    }
    public int getDefenceId()
    {
        return defenceId;
    }

}
