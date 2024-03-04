public class player {
    String name;
    int symbol;
    int count;
    public player(String name, int symbol){
        setName(name);
        setSymbol(symbol);
        count = 2;
    }
    private void setName(String name){
        this.name = name;
    }
    private void setSymbol(int symbol){
        this.symbol = symbol;
    }
    public String getName(){
        return name;
    }
    public int getSymbol(){
        return symbol;
    }
    public int getCount(){
        return this.count;
    }
}
