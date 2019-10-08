import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;



class PlayGame extends Game {
	 int noOfPlayers;
	 private Player[] player;
	 private boolean game=false;
	public PlayGame(int N) {
		// TODO Auto-generated constructor stub
		System.out.println("Welcome to Snake and Ladder(Virtual)");
		noOfPlayers=N;
		player=new Player[noOfPlayers];
	}
void StartGame()
{
	
	Scanner s =new Scanner(System.in);
	for(int i=0;i<player.length;i++)
	{
	System.out.println("Enter your name here");
	
	String name=s.nextLine();
	player[i]=new Player(name,0);
	}
	
	setLadders();
	setSnakes();
	
}
void Play()
{
int i=0;
while(i<player.length)
{
Scanner s=new Scanner(System.in);
System.out.println("Press S to take your turn ");
char a=s.next().charAt(0);
if(a=='S')
{
	chance(player[i]);
	if(isGameOver())
		break;
	i++; 
}
else
{
	System.out.println("Wrong input try again ");
}

}
if(!isGameOver())
Play();
else 
	return;
}
void chance(Player p)
{
	if(p.getPosition()==0)
	{
		p.setPosition(Roll());
	}
	else if(isLadder(p.getPosition()))
		p.setPosition(get_destinationLadder(p.getPosition()));
	else if(isSnake(p.getPosition()))
		p.setPosition(get_destinationSnake(p.getPosition()));
	else if(p.getPosition()==100)
		GameOver(p);
	else
	{
		p.setPosition(p.getPosition()+Roll());
	}
}
void GameOver(Player p)
{
	System.out.println("The game has ended and "+p.getName()+" is the winner");
	game=true;
}
boolean isGameOver()
{
	return game;
}

int Roll()
{
Random a=new Random();
 return a.nextInt(6)+1;
 
}

	
}


