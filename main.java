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

    public static void records () 
  {
    //setting the record attractions
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

    //function asks and returns the amount of attractions the user wants to know about
    int quant = askQuantity();

    // gap to see the next question more easily
    System.out.println(""); 

    //loop function takes all arguments to loop through asking questions
    loop(quant, eden, tate, zoo);

    return;
  }// END of records method

  //asks questions about attractions and returns input
  public static int askQuantity ()
  {
    int quant;
    try
    {
      Scanner scanner = new Scanner(System.in);
      System.out.print("How many attractions do you need to know about? ");
      quant = scanner.nextInt();
    }
    catch (Exception e)
    {
      System.out.println("Wrong input type; integer required... \n");
      quant = askQuantity();
    }
    return quant;
  }//END of askQuantity

  //makes a for loop which lasts the amount of times of quant
  public static void loop (int quant, attraction a1, attraction a2, attraction a3) {

    for (int i=1; i<= quant; i++)
    {
      //functions which gets looped through
      getInfo(i, a1, a2, a3);
    }

  }//END of loop

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
