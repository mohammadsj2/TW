public enum City {
    city1,city2;
    private Block armyBlock=null;
    private ArrayList<Block> blocks;
    private int money=0;

    Block getBlock(int blockId){
        if(blockId>=blocks.size())return null;
        return blocks.get(blockId);
    }
    public double getScore(){
        double sum=0.0;
        for(int i=0;i<blocks.size();i++){
            sum+=blocks.get(i).getScore();
        }
        return sum;
    }
    public void updateMoney(){
        for(int i=0;i<blocks.size();i++){
            Block x=blocks.get(i);
            m+=x.getIncome();
        }
    }
    public int addBlock(){
        Block newBlock=new Block();
        blocks.add(newBlock);
        return blocks.size();
    }
    public int removeBlock(int blockId){
        Block block=getBlock(blockId);
        if(block==null)return -1;
        if(armyBlock==blocks.get(blockId)){
            armyBlock=null;
        }
        blocks.set(blockId,null);
        return 1;
    }
    public void upgradeBlock(int blockId){
        Block block=getBlock(blockId);
        if(block==null)return -1;
        return block.upgrade();
    }
    public int removeElement(int BlockId,Element element) { //Impossible == -1 else 1
        Block block=getBlock(blockId);
        if(block==null)return -1;
        int answer=block.removeElement(element);
        if(answer==-1)return -1;
        if(element instanceof Army){
            armyBlock=null;
        }
        return 1;
    }
    public int addElement(int BlockId,Element element){ //IMPOSSIBLE == -1
        Block block=blocks.get(blockId);
        if(block==null)return -1;
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
    public int getMoney(){
        updateMoney();
        return money;
    }

}
