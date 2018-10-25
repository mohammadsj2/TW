
public class Main {
    private static City[] player;
    {
        player=new City[2];
        player[0]=City.city1;
        player[1]=City.city2;
    }
    private static int day=0;

    public static int getDay()
    {
        return day;
    }
    public static int getTurn()
    {
       return (day%2);
    }
    public static City getCity()
    {
        return player[getTurn()];
    }
    public int attack(int blockId)// age nmishod -1 mide vgrna 1
    {
        return 1;
    }
    public int loot(int blockId)// age nmishod -1 mide vgrna 1
    {
        City myCity=player[getTurn()],enemyCity=player[1-getTurn()];
        if(enemyCity.getBlock(blockId)==null || enemyCity.getBlock(blockId).getDefenceId()!=-1)return -1;
        myCity.addMoney(enemyCity.getBlock(blockId).numberOfElements()*500);
        return 1;
    }
    public void yield(City city)
    {

    }
    public void endDay()
    {

        for(int i=0;i<2;i++) {
            player[i].updateMoney();
        }
    }
    public static void main()
    {

    }

}
