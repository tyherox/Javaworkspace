import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;


public class JBoardT extends JPanel {
	
	boolean pressed = false;
	String n;
	public JBoardT(){
		setBackground(Color.white);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(pressed==false)
				{
					setBackground(Color.GRAY);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(pressed==false)
				{
					setBackground(Color.white);
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(pressed==false)
				{
					setBackground(Color.BLUE);
					Action();
				}
				pressed=true;                                                                                                                                                                                                                                                                              
			}
		});
		
		//n = name;
	}
	
	public String name()
	{
		return n;
	}
	
	public void pClick()
	{
		pressed = true;
		setBackground(Color.BLUE);
	}
	
	public void reset()
	{
		setBackground(Color.white);
		pressed = false;
	}
	
	public void click()
	{
		pressed = true;
		setBackground(Color.RED);
	}
	
	public boolean pressed()
	{
		if(pressed==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void victory()
	{
		pressed  = true;
	}
	
	public double getXC()
	{
		double x = this.getX();
		return x;
	}
	
	public double getYC()
	{
		double y = this.getY();
		return y;
	}
	
	private JBoardT Action()
	{
		Board.aiMove(this);
		return this;
	}
}
