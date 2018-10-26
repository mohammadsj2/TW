import java.util.ArrayList;



enum City {
    city1,city2;
    public static final int INIT_BLOCK_COST = 1000;
    public static final int REMOVE_BLOCK_COST = 500;
    public static final int INIT_MONEY= 30*1000;
    private Block armyBlock=null;
    private ArrayList<Block> blocks = new ArrayList<Block>();
    private int money=0;
    {
        money = INIT_MONEY;
    }
    public Block getArmyBlock(){
        return armyBlock;
    }
    Block getBlock(int blockId){
        if(blockId>=blocks.size())return null;
        return blocks.get(blockId);
    }
    public double getScore(boolean nowCity){
        double sum=0.0;
        for(int i=0;i<blocks.size();i++){
            if (blocks.get(i) != null) {
                double tmp = blocks.get(i).getScore(nowCity);
                sum += tmp;
            }
        }
        return sum;
    }
    public void updateMoney(){
        for(int i=0;i<blocks.size();i++){
            Block x=blocks.get(i);
            if (x != null)
                money+=x.getIncome();
        }
    }
    public void addMoney(int val){
        money+=val;
    }
    public int subtractMoney(int val){
        if(getMoney()<val){
            return -1;
        }
        money-=val;
        return 1;
    }
    public int addBlock(){
        if(subtractMoney(INIT_BLOCK_COST) == -1){
            return -1;
        }
        Block newBlock=new Block();
        blocks.add(newBlock);
        return blocks.size();
    }
    public int removeBlock(int blockId){
        Block block=getBlock(blockId);
        if(block==null)return -1;
        if(armyBlock==block){
            armyBlock=null;
        }
        addMoney(REMOVE_BLOCK_COST);
        blocks.set(blockId,null);
        return 1;
    }

    public int upgradeBlock(int blockId){
        Block block=getBlock(blockId);
        if(block==null)return -1;
        int cost=block.upgradeMoney();
        if(getMoney()<cost){
            return -1;
        }
        if(block.upgrade()==-1)return -1;
        subtractMoney(cost);
        return 1;
    }
    public int addElement(int blockId,Element element){ //IMPOSSIBLE == -1
        Block block=blocks.get(blockId);

        if(block==null)return -1;;
        if(element instanceof Army){
            if(armyBlock!=null)return -1;
        }
        int answer=block.addElement(element);
        if(answer==-1)return -1;
        if(element instanceof Army){
            armyBlock=block;
        }
        return answer;
    }
    public int removeElement(int blockId,int elementId) { //Impossible == -1 else 1
        Block block=getBlock(blockId);
        if(block==null)return -1;
        int answer=block.removeElement(elementId);//khodesh money ro ok mikone
        if(answer==-1)return -1;
        if(answer==2){//element is_A Army.
            armyBlock=null;
        }
        return 1;
    }

    public int upgradeElement(int blockId,int elementId, int floor, int unit){
        Block block=getBlock(blockId);
        if(block==null){
            return -1;
        }
        return block.upgradeElement(elementId, floor, unit); // saberi upgrade elementesh age element id nabood -1 bede
    }
    public int getMoney(){
        return money;
    }

}