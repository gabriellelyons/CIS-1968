import java.util.Scanner;

public class Roman
{
  private int theValue;

  public Roman()
  {
    theValue = 0;
  }

  public Roman(int v)
  {
    theValue = v;
  }

  public Roman(String s)
  {
    theValue = romanToInt(s);
  }

  public static int romanToInt(String s)
  {
    int val = 0;

    for (int i = 0; i < s.length(); i++)
    {    
      if ((i+1 < s.length()) && letterVal(s.charAt(i)) < letterVal(s.charAt(i+1)))
      {
        val -= letterVal(s.charAt(i));
      }
      else
      {
        val += letterVal(s.charAt(i));
      }
    }
    return val;
  }

  public static int letterVal(char c) throws IllegalArgumentException
  {
    switch(c)
    {
      case 'i':
      case 'I': 
        return 1;
      case 'v':
      case 'V': 
        return 5;
      case 'x':
      case 'X': 
        return 10;
      case 'l':
      case 'L':
        return 50;
      case 'c':
      case 'C': 
        return 100;
      case 'd':
      case 'D': 
        return 500;
      case 'm':
      case 'M': 
        return 1000;
      default:
        throw new IllegalArgumentException("Undefined Roman numeral " + c);
    }
  }

  public String toString()
  {
    String retval = "";
    int val = this.theValue;

    if (val < 0)
    {
      retval += "-";
      val = -val;
    }
    while (val >= 1000)
    {
      retval += "M";
      val -= 1000;
    }
    if (val >= 900)
    {
      retval += "CM";
      val -= 900;
    }
    if (val >= 500)
    {
      retval += "D";
      val -= 500;
    }
    if (val >= 400)
    {
      retval += "CD";
      val -= 400;
    }
    while (val >= 100)
    {
      retval += "C";
      val -= 100;
    }
    if (val >= 90)
    {
      retval += "XC";
      val -= 90;
    }
    if (val >= 50)
    {
      retval += "L";
      val -= 50;
    }
    if (val >= 40)
    {
      retval += "XL";
      val -= 40;
    }
    while (val >= 10)
    {
      retval += "X";
      val -= 10;
    }
    if (val >= 9)
    {
      retval += "IX";
      val -= 9;
    }
    if (val >= 5)
    {
      retval += "V";
      val -= 5;
    }
    if (val >= 4)
    {
      retval += "IV";
      val -= 4;
    }
    while (val >= 1)
    {
      retval += "I";
      val -= 1;
    }
    return retval;
  }

  public static String intToString(int val)
  {
    String retval = "";

    if (val < 0)
    {
      retval += "-";
      val = -val;
    }
    while (val >= 1000)
    {
      retval += "M";
      val -= 1000;
    }
    if (val >= 900)
    {
      retval += "CM";
      val -= 900;
    }
    if (val >= 500)
    {
      retval += "D";
      val -= 500;
    }
    if (val >= 400)
    {
      retval += "CD";
      val -= 400;
    }
    while (val >= 100)
    {
      retval += "C";
      val -= 100;
    }
    if (val >= 90)
    {
      retval += "XC";
      val -= 90;
    }
    if (val >= 50)
    {
      retval += "L";
      val -= 50;
    }
    if (val >= 40)
    {
      retval += "XL";
      val -= 40;
    }
    while (val >= 10)
    {
      retval += "X";
      val -= 10;
    }
    if (val >= 9)
    {
      retval += "IX";
      val -= 9;
    }
    if (val >= 5)
    {
      retval += "V";
      val -= 5;
    }
    if (val >= 4)
    {
      retval += "IV";
      val -= 4;
    }
    while (val >= 1)
    {
      retval += "I";
      val -= 1;
    }
    return retval;
  }

  public Roman add(Roman rhs)
  {
    Roman val = new Roman (this.theValue + rhs.theValue);
    System.out.println(val.toString());
    return val;
  }

  public Roman subtract(Roman rhs)
  {
    Roman val = new Roman (this.theValue - rhs.theValue);
    System.out.println(val.toString());
    return val;
  }

  public Roman multiply(Roman rhs)
  {
    Roman val = new Roman (this.theValue * rhs.theValue);
    System.out.println(val.toString());
    return val;
  }

  public Roman divideBy(Roman rhs)
  {
    Roman val = new Roman (this.theValue / rhs.theValue);
    System.out.println(val.toString());
    return val;
  }

  public int compareTo(Roman rhs)
  {
    int val = this.theValue - rhs.theValue;
    System.out.println(intToString(val)); 
    return val;
  }

  public static void printMenuOne()
  {
    System.out.println("Enter R to convert a Roman numeral: ");
    System.out.println("Enter I to convert an integer: ");
    System.out.println("Enter C to calculate a value: ");
  }

  public static void printMenuTwo()
  {
    System.out.println("Enter A to add: ");
    System.out.println("Enter S to subtract: ");
    System.out.println("Enter M to multiply: ");
    System.out.println("Enter D to divide: ");
    System.out.println("Enter C to compare: ");
  }

  public static void main(String args[]) throws IllegalArgumentException
  {
    printMenuOne();      
    Scanner kb = new Scanner(System.in);
    String c = kb.nextLine();

    switch(c)
    {
      case "r": 
      case "R":
        System.out.print("Enter a Roman numeral: ");
        String s = kb.nextLine();
        System.out.println(romanToInt(s));
        break;
      case "i":
      case "I":
        System.out.print("Enter an integer: ");
        int num = kb.nextInt();
        System.out.println(intToString(num)); 
        break;
      case "c":
      case "C":
      {
        System.out.print("Enter the left-hand Roman numeral: ");
        String left = kb.nextLine();
        Roman lhs = new Roman(left);
        System.out.print("Enter the right-hand Roman numeral: ");
        String right = kb.nextLine();
        Roman rhs = new Roman(right);

        printMenuTwo();
        String choice = kb.nextLine();

        switch(choice)
        {
          case "a":
          case "A":
            lhs.add(rhs);
            break;
          case "s":
          case "S":
            lhs.subtract(rhs);
            break;
          case "m":
          case "M":
            lhs.multiply(rhs);
            break;
          case "d":
          case "D":
            lhs.divideBy(rhs);
            break;
          case "c":
          case "C":
            lhs.compareTo(rhs);
            break;
          default:
            throw new IllegalArgumentException("Undefined operator.");
        }
      }
    }
  }
}
