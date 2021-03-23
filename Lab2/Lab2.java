import java.util.Scanner;
public class Lab2
{
  private static int maxWidth = 51;
  private static int maxHeight = 40;
  private static int h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12;

  public static void main(String args[])
  {
    Scanner kb = new Scanner(System.in);

    System.out.println("Enter sales for January: ");
    h1 = kb.nextInt();
    System.out.println("Enter sales for February: ");
    h2 = kb.nextInt();
    System.out.println("Enter sales for March: ");
    h3 = kb.nextInt();
    System.out.println("Enter sales for April: ");
    h4 = kb.nextInt();
    System.out.println("Enter sales for May: ");
    h5 = kb.nextInt();
    System.out.println("Enter sales for June: ");
    h6 = kb.nextInt();
    System.out.println("Enter sales for July: ");
    h7 = kb.nextInt();
    System.out.println("Enter sales for August: ");
    h8 = kb.nextInt();
    System.out.println("Enter sales for September: ");
    h9 = kb.nextInt();
    System.out.println("Enter sales for October: ");
    h10 = kb.nextInt();
    System.out.println("Enter sales for November: ");
    h11 = kb.nextInt();
    System.out.println("Enter sales for December: ");
    h12 = kb.nextInt();

    Screen screen = new Screen(maxWidth, maxHeight+3, '.');

    screen.setPixel(1, maxHeight-5, '5');
    screen.setPixel(0, maxHeight-10, '1');
    screen.setPixel(1, maxHeight-10, '0');
    screen.setPixel(0, maxHeight-15, '1');
    screen.setPixel(1, maxHeight-15, '5');
    screen.setPixel(0, maxHeight-20, '2');
    screen.setPixel(1, maxHeight-20, '0');
    screen.setPixel(0, maxHeight-25, '2');
    screen.setPixel(1, maxHeight-25, '5');
    screen.setPixel(0, maxHeight-30, '3');
    screen.setPixel(1, maxHeight-30, '0');
    screen.setPixel(0, maxHeight-35, '3');
    screen.setPixel(1, maxHeight-35, '5');
    screen.setPixel(0, maxHeight-40, '4');
    screen.setPixel(1, maxHeight-40, '0');

    screen.fillRect(3, maxHeight-h1, 5, maxHeight, '*');
    screen.fillRect(7, maxHeight-h2, 9, maxHeight, '*');
    screen.fillRect(11, maxHeight-h3, 13, maxHeight, '*');
    screen.fillRect(15, maxHeight-h4, 17, maxHeight, '*');
    screen.fillRect(19, maxHeight-h5, 21, maxHeight, '*');
    screen.fillRect(23, maxHeight-h6, 25, maxHeight, '*');
    screen.fillRect(27, maxHeight-h7, 29, maxHeight, '*');
    screen.fillRect(31, maxHeight-h8, 33, maxHeight, '*');
    screen.fillRect(35, maxHeight-h9, 37, maxHeight, '*');
    screen.fillRect(39, maxHeight-h10, 41, maxHeight, '*');
    screen.fillRect(43, maxHeight-h11, 45, maxHeight, '*');
    screen.fillRect(47, maxHeight-h12, 49, maxHeight, '*');

    screen.hLine(0, maxWidth, maxHeight, '_');
    screen.vLine(2, 0, maxHeight+1, '|');

    screen.drawText(3, maxHeight+1, "Jan");
    screen.drawText(7, maxHeight+1, "Feb");
    screen.drawText(11, maxHeight+1, "Mar");
    screen.drawText(15, maxHeight+1, "Apr");
    screen.drawText(19, maxHeight+1, "May");
    screen.drawText(23, maxHeight+1, "Jun");
    screen.drawText(27, maxHeight+1, "Jul");
    screen.drawText(31, maxHeight+1, "Aug");
    screen.drawText(35, maxHeight+1, "Sep");
    screen.drawText(39, maxHeight+1, "Oct");
    screen.drawText(43, maxHeight+1, "Nov");
    screen.drawText(47, maxHeight+1, "Dec");
    screen.drawText(12, maxHeight+2, "Monthly Sales in Thousands");

    System.out.println(screen);
  }
}
