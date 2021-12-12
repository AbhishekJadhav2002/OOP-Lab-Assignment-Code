package strategyclass;

public class Item
{
    String upcCode;
    private int price;
    public Item(String upc, int cost)
    {
        this.upcCode=upc;
        this.price=cost;
    }

    public String getUpcCode()
    {
        return upcCode;
    }

    public int getPrice()
    {
        return price;
    }
}