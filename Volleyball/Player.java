//Gabrielle Lyons - CIS 1968, Spring 2020

public class Player implements PlayerActions {

	String playerName;
	
	public Player(String playerName)
	{
		this.playerName = playerName;
	}
	
	public void pass()
	{
		System.out.println(this.playerName + " passed the ball.");
	}
	
	public void set()
	{
		System.out.println(this.playerName + " set the ball.");
	}
	
	public void hit()
	{
		System.out.println(this.playerName + " hit the ball.");
	}

	public void serve()	
	{
		System.out.println(this.playerName + " served the ball.");
	}
	
	public void doubleTouch()
	{
		System.out.println(this.playerName + " touched the ball again. \nEnd of point.\n");
	}
	
	public void miss()
	{
		System.out.println(this.playerName + " missed the ball.");
	}
	
	public static void main(String args[])
	{
		Player player1 = new Player("Player 1");
		player1.pass();
		player1.set();
		player1.hit();
		player1.serve();
		player1.doubleTouch();
		player1.miss();
	}
}
