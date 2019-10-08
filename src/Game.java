import java.util.*;
abstract class Game 
{
	private boolean source_snake[];
	
	private boolean source_Ladder[];
	
	private Random a=new Random();
	Game()
	{
		
		source_Ladder=new boolean[100];
		source_snake=new boolean[100];
		
	
	}
	public void setSnakes() {
		// TODO Auto-generated method stub
		int temp=a.nextInt(20)+1;
		for(int i=0;i<temp;i++)
		{
			int num=a.nextInt(98)+2;
			if(!source_snake[num])
			source_snake[num]=true;
		}
	}
	public boolean isSnake(int num)
	{
	if(source_snake[num])
		return true ;
	else
		return false;
	}
	public void setLadders() {
		// TODO Auto-generated method stub
		int temp=a.nextInt(20)+1;
		for(int i=0;i<temp;i++)
		{
			int num=a.nextInt(98)+2;
			if(!source_Ladder[num])
			source_Ladder[num]=true;
		}
	}
	public boolean isLadder(int num)
	{
	if(source_snake[num])
		return true ;
	else
		return false;
	}
	public int get_destinationLadder(int num) {
		return a.nextInt(100-num)+num;
	}
	public int get_destinationSnake(int num) {
		return a.nextInt(num)+1;
	}
	

}
