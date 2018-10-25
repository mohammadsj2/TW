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
                score+=element.score(getScoreOfPerson());
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
                unusedPeople+=element.numberOfPeople();
            }
            else
            {
                unusedPeople+=element.numberOfPeople();
            }
        }
        return unusedPeople;
    }
    public int AddElement(Element element)// age nmishod -1 mide
    {
        elements.add(element);
        int id=elements.size()-1;
        if(element instanceof Defence)
        {
            defenceId=id;
        }
        return id;
    }
    public int removeElement(int elementId)// age ghbln remove shode bod -1 vgrna 1
    {
        if(elementId>=elements.size() || elements.get(elementId)==null)return -1;
        elements.set(elementId, null);
        if(elementId==defenceId)defenceId=-1;
        return 1;
    }
    public void upgradeElement(int elementId)
    {
        elements.get(elementId).levelUp();
        return ;
    }
    public int getDefenceId()
    {
        return defenceId;
    }

}
