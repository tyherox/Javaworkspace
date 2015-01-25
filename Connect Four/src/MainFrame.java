import java.util.ArrayList;


public class MainFrame {

	public static boolean victory(ArrayList<JBoardT> board)
	{
		JBoardT a,b,c,d,e;
		
		if(board.size()<5)
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
								for(int r = 2; r<board.size(); r++)
								{
									if(t!=r&&i!=r&&r!=z)
									{
										d = board.get(r);
										double s3 = Board.slope(c,d);
										if(s2==s3)
										{
											for(int k = 2; k<board.size(); k++)
											{
												if(t!=k&&i!=k&&r!=k&&r!=k)
												{
													e = board.get(k);
													double s4 = Board.slope(d,e);
													if(s3==s4)
													{
														return true;
													}
													
												}
											}
										}
										
									}
								}
							}
						}
					}	
				}
			}
		}
		return false;
	}
	
}

