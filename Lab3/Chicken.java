public class Chicken
{
  private String name;
  private int age;
  private char gender;

  public Chicken(String name, int age, char gender) throws IllegalArgumentException
  {
    this.name = name;

    if(age < 0)
    {
      throw new IllegalArgumentException("Invalid age.");
    }
    this.age = age;

    if((gender != 'M') && (gender != 'F'))
    { 
      throw new IllegalArgumentException("Unknown gender.");
    }
    this.gender = gender;
  }

  public static void main(String args[])
  {
    Chicken c1 = new Chicken("Amy", 3, 'F');
    c1.fly();
    c1.cluck();
    c1.layEgg();
    c1.sleep();
    c1.scratch();
    c1.toString();
  }

  public void fly()
  {
    System.out.println(this.name + " attempts to fly.");
  }

  public void cluck()
  {
    System.out.println(this.name + " makes clucking sounds.");
  }

  public void layEgg()
  {
    if (this.gender == 'F')
    {
      System.out.println(this.name + " lays an egg.");
    }
    if (this.gender == 'M')
    {
      System.out.println(this.name + " attempts to lay an egg, but finds he is unable.");
    }
  }

  public void sleep()
  {
    System.out.println(this.name + " falls asleep.");
  }

  public void scratch()
  {
    System.out.println(this.name + " scratches in the dirt.");
  }

  public void eat()
  {
    System.out.println(this.name + " eats a beetle.");
  }

  public String toString()
  {
    String retval = "";

    if (this.gender == 'F')
    {
      retval = this.name + " is a " + this.age + " year old hen.";    
    }
    if (this.gender == 'M')
    {
      retval = this.name + " is a " + this.age + " year old rooster.";    
    }

    return retval;
  }
}
