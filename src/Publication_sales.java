import java.util.Scanner;

class publication
{
    public
        String title;
        int price;
        int copies;
        int total_sell;

    publication()
    {
        title = "";
        price = 0;
        copies = 0;
        total_sell = 0;
    }

    public int getcopies()
    {
        return this.copies;
    }

    public void setcopies(int qty)
    {
        this.copies += qty;
    }

    public int sell(int sell)
    {
        total_sell += sell;
        return total_sell;
    }
};

class book extends publication
{
    String author;
    int BookQty;
    
    public void orderCopies(int BookQty)
    {
        this.BookQty = BookQty;
        super.setcopies(BookQty);
    }

    public int sell(int p)
    {
        super.sell(BookQty*p);
        // super.total_sell += book_sell;  //this also works but fevering method overriding
        return BookQty*p;
    }
};

class magazine extends publication
{
    int OrderQty;
    String currissue;

    public
        String recvNewIssue(String pNewIssue, int q)
        {
            q = OrderQty;
            super.setcopies(OrderQty);
            currissue = pNewIssue;
            return currissue;
        }

        int sell(int MagazineQty, int p)
        {
            super.sell(MagazineQty*p);
            return MagazineQty*p;
        }

};


public class Publication_sales
{
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        book b = new book();
        publication p = new book();
        magazine m = new magazine();
        System.out.print("---------------------- Welcome to Shop ----------------------");
        while (true)
        {
            System.out.print("\n\n What you want to buy :\n\t>1. Book\t>2. Magazine\t\t>3. Display Total Sell\t\t>4. Exit\n\t\t\t\tEnter Choice (1/2/3/4) : ");
            int choice;
            choice = input.nextInt();
            input.nextLine();  //for consuming the leftover new line using the nextLine() method
            switch(choice)
            {
                case 1:
                    System.out.print("\nEnter book Name : ");
                    b.title = input.nextLine();
                    System.out.print("\nEnter book price : ");
                    int bprice = input.nextInt();
                    System.out.print("\nEnter no. of copies : ");
                    b.copies = input.nextInt();
                    input.nextLine();  //for consuming the leftover new line using the nextLine() method
                    System.out.print("\nEnter author name : ");
                    b.author = input.nextLine();
                    System.out.print("\nEnter Order Quantity : ");
                    int q = input.nextInt();
                    b.orderCopies(q);
                    b.sell(b.price);
                    System.out.print("\nTotal Sell of Books : Rs."+b.sell(bprice));
                    break;
                    
                case 2:
                    System.out.print("\nEnter magazine name : ");
                    m.title = input.nextLine();
                    System.out.print("\nEnter magazine price : ");
                    int mprice = input.nextInt();
                    System.out.print("\nEnter Order Quantity : ");
                    int Qty = input.nextInt();
                    input.nextLine();  //for consuming the leftover new line using the nextLine() method
                    System.out.print("\nEnter Issue Name : ");
                    String issue = input.nextLine();
                    System.out.print("\nTotal Sell of Magazine issue "+m.recvNewIssue(issue, Qty)+" : Rs."+m.sell(mprice, Qty));
                    break;

                case 3:
                    System.out.print("\nTotal Sell of Publication : Rs."+p.total_sell);
                    break;

                default :
                    System.out.println("\nError : Invalid Choice !");
            }
            System.out.print("\n\nDo you want to continue (Y/N) ? : ");
            String stopApp;
            // input.nextLine();
            stopApp = input.nextLine();
            if ( stopApp == "N" | stopApp == "n")
            {
                System.out.println("\nProgram Terminated");
                break;
            }
        }
    }
}