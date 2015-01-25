import java.util.ArrayList;


public class MainFrame {

	public static boolean victory(ArrayList<JBoardT> board)
	{
		JBoardT a,b,c;
		
		if(board.size()<3)
		{
			return false; 
		}
		
		for(int i = 0; i<board.size(); i++)
		{
			a = board.get(i);
			for(int t = 1; t<board.size(); t++)
			{
				if(i!=t)
				{
					b = board.get(t);
					double s1 = Board.slope(a,b);
					for(int z = 2; z<board.size(); z++)
					{
						if(t!=z&&i!=z)
						{
							c = board.get(z);
							double s2 = Board.slope(b,c);
							if(s1==s2)
							{
								/*
								System.out.println("i value" + a.getXC() + ", " + a.getYC());
								System.out.println("i value" + b.getXC() + ", " + b.getYC());
								System.out.println("i value" + c.getXC() + ", " + c.getYC());
								System.out.println("Victory!");*/
								return true;
							}
						}
					}	
				}
			}
		}
		
		return false;
	}
	
}
