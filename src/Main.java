import java.util.Scanner;
public class Main {
    private static City[] player;

    {
        player=new City[2];
        player[0]=City.city1;
        player[1]=City.city2;
    }
    static int day=0;

    static int getDay()
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
    public static int attack(int blockId)// age nmishod -1 mide vgrna 1
    {
        return 1;
    }
    public static int loot(int blockId)// age nmishod -1 mide vgrna 1
    {
        City myCity=player[getTurn()],enemyCity=player[1-getTurn()];
        if(enemyCity.getBlock(blockId)==null || enemyCity.getBlock(blockId).getDefenceId()!=-1)return -1;
        myCity.addMoney(enemyCity.getBlock(blockId).numberOfElements()*500);
        return 1;
    }
    public void yield(City city)
    {

    }
    public static void endDay()
    {

        for(int i=0;i<2;i++) {
            player[i].updateMoney();
        }
        day++;
    }
    public static void check(int x, int give) {
        if (x == -1) {
            System.out.println("not possible");
        } else {
            if (give == 1)
                System.out.println(x);
        }
    }
    public static void main()
    {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            String[] queries = line.split(" ");
            for (int j = 0; j < (int) queries.length; ++j) {
                if (queries[j].matches("[a-zA-Z]+")) {
                    queries[j] = queries[j].toLowerCase();
                }
            }
            if (queries[0].equals("yield")) {
                System.out.format("%.2f %.2f", player[0].getScore(), player[1].getScore());
                return;
            }
            if (queries[0].equals("done")) {
                endDay();
                continue;
            }
            if (queries[0].equals("attack")) {
                if (player[getTurn()].getMoney() < 5000) {
                    check(-1, 0);
                } else {
                    check(attack(Integer.parseInt(queries[1])), 0);
                }
                continue;
            }
            if (queries[0].equals("loot")) {

                check(loot(Integer.parseInt(queries[1])), 0);
                continue;
            }
            if (queries[0].equals("see")) {
                if (queries[1].equals("score")) {
                    System.out.format("%2.f", player[getTurn()].getScore());
                } else {
                    System.out.println(player[getTurn()].getMoney());
                }
                continue;
            }
            if (queries[0].equals("add")) {
                if (queries[1].equals("block")) {
                    check(player[getTurn()].addBlock(), 1);
                } else if (queries[1].equals("home")) {
                    int blockId = Integer.parseInt(queries[2]);
                    --blockId;
                    int numFloor = Integer.parseInt(queries[3]);
                    int numUnit = Integer.parseInt(queries[4]);
                    int use = Home.getBuildCost(numFloor, numUnit);
                    check(use > player[getTurn()].getMoney() ? -1 : player[getTurn()].addElement(blockId, (Element) new Home(numFloor, numUnit)), 1);

                } else {
                    int blockId = Integer.parseInt(queries[2]);
                    --blockId;
                    if (queries[1].equals("bazaar")) {
                        int use = (new Bazaar()).getBuildCost();
                        check(use > player[getTurn()].getMoney() ? -1 : player[getTurn()].addElement(blockId, (Element) new Bazaar()), 1);
                    } else if (queries[1].equals("army")) {
                        int use = (new Army()).getBuildCost();
                        check(use > player[getTurn()].getMoney() ? -1 : player[getTurn()].addElement(blockId, (Element) new Army()), 1);
                    } else if (queries[1].equals("defense")) {
                        int use = (new Defence()).getBuildCost();
                        check(use > player[getTurn()].getMoney() ? -1 : player[getTurn()].addElement(blockId, (Element) new Defence()), 1);
                    }
                }
                continue;
            }
            if (queries[0].equals("upgrade")) {
                int blockId = Integer.parseInt(queries[1]);
                --blockId;
                if (queries.length < 3) {
                    check(player[getTurn()].upgradeBlock(blockId), 1);
                } else {
                    int unitId = Integer.parseInt(queries[2]);
                    --unitId;
                    check(player[getTurn()].upgradeElement(blockId, unitId), 1);
                }
                continue;
            }
            if (queries[0].equals("remove")) {
                int blockId = Integer.parseInt(queries[1]);
                --blockId;
                if (queries.length < 3) {
                    check(player[getTurn()].removeBlock(blockId), 1);
                } else {
                    int unitId = Integer.parseInt(queries[2]);
                    --unitId;
                    check(player[getTurn()].removeElement(blockId, unitId), 1);
                }
                continue;
            }
        }

    }

}
