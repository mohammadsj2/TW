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
    public int numberOfElements()
    {
        int cntElement=0;
        for(Element element:elements)
        {
            if(element==null)continue;
            cntElement++;
        }
        return cntElement;
    }
    public int getIncome()
    {
        int income=0;
        for(Element element:elements)
        {
            if(element==null)continue;
            income+=element.getIncome();
        }
        return 0;
    }
    public double getScore()
    {
        double score=0;
        for(Element element:elements)
        {
            if(element==null)continue;
            if(element instanceof Home)
                score+=((Home) element).score(getScoreOfPerson());
            else
                score+=element.score();

        }
        return score;
    }
    public double getScoreOfPerson()
    {
        double score=1.;
        for(Element element:elements)
        {
            if(element==null)continue;
            score*=element.getScoreOfPerson();
        }
        return score;
    }
    public int numberOfUnusedPeople()
    {
        int unusedPeople=0;
        for(Element element:elements)
        {
            if(element==null)continue;

            if(element instanceof Home)
            {
                unusedPeople+=((Home) element).numberOfPeople();
            }
            else
            {
                unusedPeople+=element.numberOfPeople();
            }
        }
        return unusedPeople;
    }
    public int addElement(Element element)// age nmishod -1 mide vgrna 1
    {
        int buildCost;
        if(element instanceof Home)
            buildCost=((Home) element).getBuildCost(((Home) element).getNumberOfFloors(),((Home) element).getNumberOfUnits());
        else buildCost=element.getBuildCost();
        if(buildCost>Main.getCity().getMoney())
        {
            return -1;
        }
        elements.add(element);
        if(elements.size()>numberOfMaxElements())return -1;
        if(element instanceof Defence)
        {
            defenceId= elements.size()-1;
        }
        Main.getCity().subtractMoney(buildCost);
        return 1;
    }
    public int removeElement(int elementId)// age ghbln remove shode bod -1 age army bod 2 vgrna 1
    {
        if(elementId>=elements.size() || elements.get(elementId)==null)return -1;
        if(elementId==defenceId)defenceId=-1;
        int returnValue=1;
        Element element=elements.get(elementId);
        if(element instanceof Army)returnValue=2;
        int removeCost;
        if(element instanceof Home)
        {
            return -1;
        }
        removeCost=element.getRemoveCost();
        if(removeCost>=0)
        {
            if(Main.getCity().subtractMoney(removeCost)==-1)
                return -1;
        }
        else
        {
            Main.getCity().addMoney(-removeCost);
        }
        elements.set(elementId, null);
        return returnValue;
    }
    public int upgradeElement(int elementId)
    {
        if(elementId>=elements.size() || elements.get(elementId)==null)return -1;
        Element element=elements.get(elementId);
        int upgradeCost=element.getUpgradeCost();
        if(upgradeCost>=0)
        {
            if(Main.getCity().subtractMoney(upgradeCost)==-1)
                return -1;
        }
        else
        {
            Main.getCity().addMoney(-upgradeCost);
        }
        elements.get(elementId).levelUp();
        return 1;
    }
    public int getDefenceId()
    {
        return defenceId;
    }
    public int upgrade()// age az 3 bishtr shod -1 vrgna 1
    {
        level++;
        if(level>3)
        {
            level=3;
            return -1;
        }
        return 1;
    }
    public int upgradeMoney()
    {
        if(level==1)return 500;
        return 500*500;
    }

}
