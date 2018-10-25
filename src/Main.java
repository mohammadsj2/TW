
// Arash
public class Main {
    private City player[2];
    {
        player[0]=City.city1;
        player[1]=City.city2;
    }
    private int day=0;

    public int getTurn()
    {
       return (day%2);
    }
    public void attack(City city,Block block)
    {

    }
    public void loot(City city,Block block)
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
