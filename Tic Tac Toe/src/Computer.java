import java.util.ArrayList;


public class Computer {

	static ArrayList<JBoardT> temp = new ArrayList<JBoardT>();
	static ArrayList<JBoardT> cBoard = new ArrayList<JBoardT>();
	static ArrayList<JBoardT> pBoard = new ArrayList<JBoardT>();
	static ArrayList<String> report = new ArrayList<String>();
	static JBoardT place;
	
	static int depth = 0;
	boolean aiTurn = false;
	int sa=-1000;
	int za;
	int sp=1000;
	int zp;
	JBoardT pc;
	JBoardT ac; 
	int victories = 0;
	
	public static void test(JBoardT a)
	{
		cBoard.add(a);
		Board.updateBoard(a);
	}
	
	public static void updateAi(JBoardT a)
	{
		pBoard.add(a);
	}
	
	public void clear()
	{
		temp.clear();
		cBoard.clear();
	}
	public void startMove(ArrayList<JBoardT> board){
		int score=-10000;
		int ts;
		report.clear();
		System.out.println("at ai: " + board.size() + "///////////////////////////////////////////////");
		temp = board;
		for(int i = 0; i<temp.size();i++)
		{
			
			JBoardT t = temp.get(i);
			temp.remove(i);
			cBoard.add(t);
			System.out.println("at ai process: " + i);
			System.out.println("i value " + t.getXC() + ", " + t.getYC());
			if(cBoard.size()>=3)
			{
				if(MainFrame.victory(cBoard)==true)
				{
					System.out.println("preVictory "+ t.getXC() + ", " + t.getYC());
					place = t;
					temp.add(i,t);
					cBoard.remove(t);
					Board.win("AI");
					break;
				}
				
			}
			aiTurn=false;
			 depth = 0;
			 sa=-1000;
			 za = 0;
			 sp=1000;
			 zp = 0;
			ts = miniMax();
			report.add("score for minimax at " + "i value " + t.getXC() + ", " + t.getYC() + " is "+ ts);
			System.out.println(" ");
			System.out.println(" ");
			if(ts>score){
				System.out.println("changed score");
				System.out.println(" ");
				score = ts;
				place = t;
			}
			temp.add(i,t);
			cBoard.remove(t);
		}
		for(int i = 0; i<report.size();i++)
		{
			System.out.println(" ");
			System.out.println(report.get(i));
		}
		System.out.println("vicotry number " + victories );
		
		System.out.println("final i value " + place.getXC() + ", " + place.getYC());
		Board.updateBoard(place);
		cBoard.add(place);
	}
	
	////// miniMax/////
	
	private int miniMax(){
		int sa = -1000;
		int sp = 1000;
		
		depth++;
		if(aiTurn==true)
		{
			for(int i = 0; i<temp.size();i++)
			{
				JBoardT t = temp.get(i);
				temp.remove(i);
				cBoard.add(t);
				//System.out.print("At minimax processing: ai depth of " + depth + " i value " + t.getXC() + ", " + t.getYC() +" that resulted in a ");
				
				if(MainFrame.victory(cBoard)==true)
				{
					//System.out.println(" victory ");
					temp.add(i,t);
					cBoard.remove(t);
					victories++;
					return 10 - depth;
				}
				else
				{
					if(temp.size()==0)
					{
						temp.add(i,t);
						cBoard.remove(t);
						//System.out.println(" tie of branch at ai branch " + depth);
						return 0;
					}
					//System.out.println(" further minimax ");
					aiTurn=false;
					za = miniMax();
					depth--;
					if(za>sa==true)
					{
						//System.out.println(" changing ai score ");
						sa=za;
					}
					//System.out.println(" done minimax currently at ai");
					temp.add(i,t);
					cBoard.remove(t);
				}
			}
			
			//System.out.println(" closing ai branch " + depth + " with a score of " + sa);
			return sa;
		} 
		
		else
		{
			for(int i = 0; i<temp.size();i++)
			{	
				JBoardT t = temp.get(i);
				temp.remove(i);
				pBoard.add(t);
				//System.out.print("At minimax processing: player depth of " + depth + " i value " + t.getXC() + ", " + t.getYC() +" that resulted in a ");
				
				if(MainFrame.victory(pBoard)==true)
				{
					System.out.println(" victory ");
					temp.add(i,t);
					pBoard.remove(t);
					aiTurn=true;
					victories++;
					return -10 + depth;
				}
				else
				{
					if(temp.size()==0)
					{
						temp.add(i,t);
						pBoard.remove(t);
						//System.out.println(" tie of a branch at player branch " + depth);
						return 0;
					}
					//System.out.println(" further minimax ");
					aiTurn=true;
					zp = miniMax();
					depth--;
					if(zp<sp==true)
					{
						//System.out.println(" changing player score ");
						sp=zp;
					}
					//System.out.println(" done minimax currently at player");
					temp.add(i,t);
					pBoard.remove(t);
				}
			}
			//System.out.println(" closing player branch " + depth + " with a score of " + sp);
			return sp;
		}
	}
	
	/////////
	
	private int[] coordinate(){
		return null;
	}
}
