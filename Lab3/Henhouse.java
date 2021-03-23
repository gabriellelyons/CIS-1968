import java.util.Random;

public class Henhouse
{
  public static void main(String args[]) throws InterruptedException
  {
    Random ran = new Random();
    Chicken chickens[] = new Chicken[10];
    boolean done = false;

    for(int i = 0; i < 10; i++)
    {
      char g;
      if(ran.nextBoolean())
      {
        g = 'F';
      }
      else
      {
        g = 'M';
      }
      chickens[i] = new Chicken("Chicken"+(i+1), ran.nextInt(5) + 1, g);
      System.out.println(chickens[i]);
    }
  
    while(!done)
    {
      switch(ran.nextInt(6)) 
      {
        case 0: chickens[ran.nextInt(10)].fly();
        case 1: chickens[ran.nextInt(10)].cluck(); 
        case 2: chickens[ran.nextInt(10)].layEgg(); 
        case 3: chickens[ran.nextInt(10)].sleep();
        case 4: chickens[ran.nextInt(10)].scratch(); 
        case 5: chickens[ran.nextInt(10)].eat();
      }
      Thread.sleep(1000);
    }
  }
}
