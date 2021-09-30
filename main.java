import java.util.Scanner;

class attraction 
{
  String name;
  int openingTime;
  int closingTime;
  boolean bankholiday; 

}
class Main {
  public static void main(String[] args) {
    records();
  }

    public static void records () 
  {
    attraction eden = new attraction(); 
    eden.name = "The Eden Project";
    eden.openingTime = 9;
    eden.closingTime = 18;
    eden.bankholiday = true;

    attraction tate = new attraction();
    tate.name = "Tate Modern";
    tate.openingTime = 10;
    tate.closingTime = 19;
    tate.bankholiday = false;

    attraction zoo = new attraction();
    zoo.name = "London zoo";
    zoo.openingTime = 10;
    zoo.closingTime = 19;
    zoo.bankholiday = true;

    int quant = askQuantity();
    loop(quant, eden, tate, zoo);

    return;
  }

  public static int askQuantity ()
  {
    int quant;
    Scanner scanner = new Scanner(System.in);

    System.out.println("How many attractions do you need to know about?");
    quant = scanner.nextInt();

    return quant;
  }

  public static void loop (int quant, attraction a1, attraction a2, attraction a3) {

    for (int i=1; i<= quant; i++)
    {
      getInfo(i, a1, a2, a3);
    }

  }


  public static void getInfo (int i, attraction a1, attraction a2, attraction a3)//so how would i fix this?
  {
    String response;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Name attraction " + i + " ?");
    response = scanner.nextLine();

    if (response.equalsIgnoreCase(a1.name)) {
      message(a1);
    } else if (response.equalsIgnoreCase(a2.name)) {
      message(a2);
    } else if (response.equalsIgnoreCase(a3.name)) {
      message(a3);
    } else {
      System.out.println("I have no information about that attraction");
      System.out.println("");
    }

  }

  public static void message (attraction a) 
  {
    if (a.bankholiday == true) {
        System.out.println(a.name + " opens on bank holidays. ");
      } else {
        System.out.println(a.name + " does not open on bank holidays");
      }  
      System.out.println("It opens at " + a.openingTime + "am");
      System.out.println("");
  }


}
