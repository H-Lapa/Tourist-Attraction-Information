//importing scanner to be able take inputs
import java.util.Scanner;

//record created to store all the attractions and their info
class attraction 
{
  String name;
  int openingTime;
  int closingTime;
  boolean bankholiday; 

}//END of attraction class
class Main {

  public static void main(String[] args) {
    //main executing method
    records();
  } // END of main method

  public static attraction create(String name, int open, int close, boolean holiday)
  {
    attraction record = new attraction(); 
    record.name = name;
    record.openingTime = open;
    record.closingTime = close;
    record.bankholiday = holiday;

    return record;

  }

  public static void records () 
  {
    //setting the record attractions
    attraction eden = create("The Eden project", 9, 18, true);
    attraction tate = create("Tate Modern", 10, 19, false);
    attraction zoo = create("London Zoo", 10, 19, true);

    //function asks and returns the amount of attractions the user wants to know about
    int quant = askQuantity();

    // gap to see the next question more easily
    System.out.println(""); 

    //getInfoLoop function takes all arguments to getInfoLoop through asking questions
    getInfoLoop(quant, eden, tate, zoo);

    return;
  }// END of records method

  //asks questions about attractions and returns input
  public static int askQuantity ()
  {
    int quant = 0;
    boolean isNumber;
    Scanner scanner = new Scanner(System.in);

    do
    {
      System.out.print("How many attractions do you need to know about? ");
      if (scanner.hasNextInt())
      {
        quant = scanner.nextInt();
        isNumber = true;
      }
      else
      {
        System.out.println("Wrong input: integer required!\n");
        isNumber = false;
        scanner.next();
      }

    } while (!(isNumber));

    return quant;
  }//END of askQuantity

  //makes a for getInfoLoop which lasts the amount of times of quant
  public static void getInfoLoop (int quant, attraction a1, attraction a2, attraction a3) {

    for (int i=1; i<= quant; i++)
    {
      //functions which gets getInfoLooped through
      getInfo(i, a1, a2, a3);
    }

  }//END of getInfoLoop

  //get info gets the users input and returns info about the attraction
  public static void getInfo (int i, attraction a1, attraction a2, attraction a3)
  {
    //retreives the users input
    String response;
    Scanner scanner = new Scanner(System.in);
    System.out.print("Name attraction " + i + " ? ");
    response = scanner.nextLine();

    //if the input is equal to an attraction name
    if (response.equalsIgnoreCase(a1.name)) {
      System.out.println(message(a1)); 
      //message functions is then println to the screen
    } else if (response.equalsIgnoreCase(a2.name)) {
      System.out.println(message(a2));
    } else if (response.equalsIgnoreCase(a3.name)) {
      System.out.println(message(a3));
    } else {
      System.out.println("I have no information about that attraction");
    }
    // gap to see the next question more easily
    System.out.println(""); 

  }//END of getInfo

  //returns string with info about bank holidays and opening times
  public static String message (attraction a) 
  {
    String str1;
    //if bank holiday is true then it says open else it is closed
    if (a.bankholiday) {
        str1 = (a.name + " opens on bank holidays.");
      } else {
        str1 = (a.name + " does not open on bank holidays");
      }  
      //sentence using the attractions opening time
      String str2 = ("It opens at " + a.openingTime + "am");
      return str1 + "\n" + str2;
  }//END of message


}
