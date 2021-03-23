import java.util.Scanner;
public class Lab1
{
  public static void main(String args[])
  {
    final int maxNames = 100;
    Scanner kb = new Scanner(System.in);
    String names[] = new String[maxNames];
    int count = 0;
    boolean done = false;
    String target;
    
    count = getData(names, maxNames); //fills the array names and returns how many
    sort(names, count); //any kind of sort you know how to write
    while (!done)
    {
      System.out.println("What name are you looking for: ");
      target = kb.nextLine();
      if(target.equals(""))
      {
        done = true;
      }
      else
      {
        boolean target2 = lookup(names, target, count); //returns true if found, false otherwise
        if(target2)
        {
          System.out.println("PRESENT");
        }
        else
        {
          System.out.println("ABSENT"); 
        }
      }
    }
  } 

  public static int getData(String s[], int size)
  {
//read names into the array s which has been declared to hold at most
//size strings.  Return when an empty string ("") is entered, or when
//size names have been entered.  The return value should be the number 
//of names actually entered

    Scanner kb = new Scanner(System.in);
    int i;

    for (i = 0; i < size; i++)
    {
      System.out.println("Enter a student's name: ");
      s[i] = kb.nextLine();

      if (s[i].compareTo("") == 0)
      {
	break;
      }
    }
    int count = i++;
    
    return count;
  }

  public static void sort(String s[], int count)
  {
// alphabetize the array of Strings.  Count tells how many names
// are in the array.

    int pass, i;
    String temp;

    for (pass = 0; pass < count-1; pass++)
    {
      for (i = 0; i < count-1 - pass; i++)
      {
        if (s[i].compareTo(s[i+1]) > 0)
        {
          temp = s[i];
	  s[i] = s[i+1];
	  s[i+1] = temp;
        }
      }
    }
  }

  public static boolean lookup(String s[], String target, int size)
  {
//determine whether the String in target is found in the array.  Return
//true if it is present, false otherwise
    
    int i;
    boolean found = true;

    for (i = 0; i < size; i++)
    {
      if( target.compareTo(s[i]) == 0 )
      {
	return found;
      }
    }
    return !found;
  }
}
