
public class Main {
    private City[] player;
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
    public int getTurn()
    {
       return (day%2);
    }
    public static City getCity()
    {
        return player[getTurn()];
    }
    public void attack(City city,Block block)
    {

    }
    public int loot(City city,Block block)
    {

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
