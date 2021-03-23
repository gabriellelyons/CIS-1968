//Gabrielle Lyons - CIS 1968, Spring 2020

import java.lang.Math;
import java.util.Random;

public class Volleyball {
	
	private Random ran = new Random();
	private int fail = 0;
	private int inPlay = 1;
	private int overTheNet = 2;
	private int receiveServe = 3;
	private int serving = 4;
	private int winPoint;
	private int point1 = 11;
	private int point2 = 22;
	private final static int winPointMin = 25;
	
	public int firstTouch(Player touch)
	{
		int num = ran.nextInt(100);
		if(num <= 10)
		{
			touch.hit();
			return inPlay;
		}	
		else if(num <= 25)
		{
			touch.miss(); 
			System.out.println("End of point.\n");
			return fail;
		}	
		else if(num <= 50)
		{
			touch.set();
			return inPlay;
		}	
		else
		{
			touch.pass();
			return inPlay;
		}
	}
	
	public int secondTouch(Player touch)
	{
		int num = ran.nextInt(100);
		if(num <= 10)
		{
			touch.hit();
			System.out.println("Change of possession.\n");
			return overTheNet;
		}	
		else if(num <= 20)
		{
			touch.miss(); 
			System.out.println("End of point.\n");
			return fail;
		}	
		else if(num <= 80)
		{
			touch.set();
			return inPlay;
		}	
		else
		{
			touch.pass();
			return inPlay;
		}
	}
	
	public int thirdTouch(Player touch)
	{
		int num = ran.nextInt(100);
		if(num <= 10)
		{
			touch.miss(); 
			System.out.println("End of point.\n");
			return fail;
		}	
		else if(num <= 40)
		{
			touch.pass();
			System.out.println("Change of possession.\n");
			return overTheNet;
		}	
		else if(num <= 65)
		{
			touch.set();
			System.out.println("Change of possession.\n");
			return overTheNet;
		}	
		else
		{
			touch.hit();
			System.out.println("Change of possession.\n");
			return overTheNet;
		}
	}
	
	public void initializePlayers(Player team1[], Player team2[])
	{
		for(int i = 0; i < 6; i++)
		{
			team1[i] = new Player("Team 1 #" + (i+1));
			team2[i] = new Player("Team 2 #" + (i+1));
		}
	}
	
	public int playPoint(int touchT1, int touchT2, Player team1[], Player team2[])
	{	
		winPoint = 0;
		boolean done = false;
		while(!done)
		{	
			if(touchT1 == receiveServe || touchT2 == overTheNet)
			{
				if(winPoint != point1)
				{
					int playerTouch1 = ran.nextInt(6);
					touchT1 = firstTouch(team1[playerTouch1]);		//first touch
					if(touchT1 != overTheNet && touchT1 != fail)	//checks for end of poss
					{
						int playerTouch2 = ran.nextInt(6);
						if(playerTouch1 == playerTouch2)			//checks for a double touch
						{
							team1[playerTouch2].doubleTouch();		
							touchT1 = fail;
						}
						else
							touchT1 = secondTouch(team1[playerTouch2]);	//second touch
						if(touchT1 != overTheNet && touchT1 != fail)	//checks for end of poss
						{
							int playerTouch3 = ran.nextInt(6);
							if(playerTouch2 == playerTouch3)			//checks for a double touch
							{
								team1[playerTouch3].doubleTouch();		
								touchT1 = fail;
							}
							else
								touchT1 = thirdTouch(team1[playerTouch3]);	//third touch
						}
					}
				}
				if(touchT1 == fail)			//if point ends, the winning team is returned
				{
					done = true;
					winPoint = point2;
					continue;
				}
			}
			
			if(touchT2 == receiveServe || touchT1 == overTheNet)
			{
				if(winPoint != point2)
				{
					int playerTouch1 = ran.nextInt(6);
					touchT2 = firstTouch(team2[playerTouch1]);		//first touch
					if(touchT2 != overTheNet && touchT2 != fail)	//checks for end of poss
					{
						int playerTouch2 = ran.nextInt(6);
						if(playerTouch1 == playerTouch2)			//checks for a double touch
						{
							team2[playerTouch2].doubleTouch();
							touchT2 = fail;
						}
						else
							touchT2 = secondTouch(team2[playerTouch2]);	//second touch
						if(touchT2 != overTheNet && touchT2 != fail)	//checks for end of poss
						{
							int playerTouch3 = ran.nextInt(6);
							if(playerTouch2 == playerTouch3)			//checks for a double touch
							{
								team2[playerTouch3].doubleTouch();
								touchT2 = fail;
							}
							else
								touchT2 = thirdTouch(team2[playerTouch3]);	//third touch
						}
					}
				}
				if(touchT2 == fail)
				{
					done = true;
					winPoint = point1;
					continue;
				}
			}
		}
		return winPoint;
	}
	
	public static boolean gameOver(int team1, int team2)
	{
		if((team1 >= winPointMin || team2 >= winPointMin) && (Math.abs(team1-team2) >= 2))
			return true;
		else
			return false;
	}
	
	public static void main(String args[])
	{
		int count1 = 0, count2 = 0;
		int i = 1, j = 0;
		Volleyball game = new Volleyball();
		
		Player team1[] = new Player[6];
		Player team2[] = new Player[6];
		game.initializePlayers(team1, team2);

		int touchT1 = game.serving, touchT2 = game.receiveServe;
		team1[0].serve();
		while(!gameOver(count1, count2))	
		{	
			int win = game.playPoint(touchT1, touchT2, team1, team2);
			if(win == game.point1)	
			{
				count1++;
				System.out.println("The score is Team 1: " + count1 + " - Team 2: " + count2 + ".\n");
				if(gameOver(count1, count2))
					break;
				team1[i].serve();
				touchT1 = game.serving;
				touchT2 = game.receiveServe;
				i++;
				if(i == 6)
					i = 0;
			}
			if(win == game.point2)			
			{
				count2++;
				System.out.println("The score is Team 1: " + count1 + " - Team 2: " + count2 + ".\n");
				if(gameOver(count1, count2))
					break;
				team2[j].serve();
				touchT1 = game.receiveServe;
				touchT2 = game.serving;
				i++;
				if(i == 6)
					i = 0;
			}
		}  
		
		if(gameOver(count1, count2) && count1 > count2)
			System.out.println("Team 1 wins!");
		if(gameOver(count1, count2) && count1 < count2)
			System.out.println("Team 2 wins!");
	}
}
