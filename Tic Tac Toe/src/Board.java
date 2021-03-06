import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Board<booelan> extends JFrame {

	private JPanel contentPane;

	/// booleans 
	String test = "hi";
	static ArrayList<JBoardT> board = new ArrayList<JBoardT>();
	static ArrayList<JBoardT> pBoard = new ArrayList<JBoardT>();
	static Computer ai = new Computer();
	
	final static JBoardT p1 = new JBoardT();
	
	final static JBoardT p2 = new JBoardT();
	
	final static JBoardT p3 = new JBoardT();
	
	final static JBoardT p4 = new JBoardT();
	
	final static JBoardT p5 = new JBoardT();
	
	final static JBoardT p6 = new JBoardT();
	
	final static JBoardT p7 = new JBoardT();
	
	final static JBoardT p8 = new JBoardT();
	
	final static JBoardT p9 = new JBoardT();
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					intializeBoard();
					Board frame = new Board();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static private void intializeBoard()
	{
		
	}
	/**
	 * 
	 * Create the frame.
	 */
	public Board() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("50dlu"),}));
		
		
		contentPane.add(p1, "2, 2, fill, fill");
		
		contentPane.add(p2, "4, 2, fill, fill");
		
		contentPane.add(p3, "6, 2, fill, fill");
		
		contentPane.add(p4, "2, 4, fill, fill");
		
		contentPane.add(p5, "4, 4, fill, fill");
		
		contentPane.add(p6, "6, 4, fill, fill");
		
		contentPane.add(p7, "2, 6, fill, fill");
		
		contentPane.add(p8, "4, 6, fill, fill");
		
		contentPane.add(p9, "6, 6, fill, fill");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, "1, 8, 7, 1, fill, fill");
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnResetButton = new JButton("Reset");
		btnResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1.reset();
				p2.reset();
				p3.reset();
				p4.reset();
				p5.reset();
				p6.reset();
				p7.reset();
				p8.reset();
				p9.reset();
				
				board.clear();
				pBoard.clear();
				
				board.add(p1);
				board.add(p2);
				board.add(p3);
				board.add(p4);
				board.add(p5);
				board.add(p6);
				board.add(p7);
				board.add(p8);
				board.add(p9);
				
				System.out.println("reset board size " + board.size() );
				
				ai.clear();
			}
		});
		panel.add(btnResetButton);
		
		board.add(p1);
		board.add(p2);
		board.add(p3);
		board.add(p4);
		board.add(p5);
		board.add(p6);
		board.add(p7);
		board.add(p8);
		board.add(p9);
		
		aiMove(null);
	}
	
	public void test()
	{
		/*
		p1.pClick();
		pBoard.add(p1);
		ai.updateAi(p1);
		board.remove(p1);
		p7.pClick();
		pBoard.add(p7);
		ai.updateAi(p7);
		board.remove(p7);
		
		ai.test(p4, p2);*/
	}
	
	public static void updateBoard(JBoardT a)
	{
		
		boolean click = false;
		for(int i = 0; i<board.size(); i++)
		{
			//System.out.println("i value " + board.get(i).getXC() + ", " + board.get(i).getYC());
			if(a==board.get(i))
			{
				board.get(i).click();
				//System.out.println("found");
				click=true;
			}
			
		}
		if(click==false)
		{
			System.out.println("error");
		}
		board.remove(a);
	}

	public static void aiMove(JBoardT a)
	{
		if(a!=null)
		{
			pBoard.add(a);
			board.remove(a);
			ai.updateAi(a);	
		}
		
		if(pBoard.size()>=3)
		{
			if(true==MainFrame.victory(pBoard))
			{
				System.out.println("won");
				win("player");
			}
			
		}
		ai.startMove(board);
	}
	
	public static void win(String p)
	{
		System.out.println("won");
		p1.victory();
		p2.victory();
		p3.victory();
		p4.victory();
		p5.victory();
		p6.victory();
		p7.victory();
		p8.victory();
		p9.victory();
	}
	
	public static double slope(JBoardT a, JBoardT b )
	{
		double slope = -(a.getYC() - b.getYC())/(a.getXC() - b.getXC());
		if(slope == (Double.POSITIVE_INFINITY)|| slope == Double.NEGATIVE_INFINITY)
		{
			slope = Double.POSITIVE_INFINITY;
		}
		//System.out.println("c1: " + a.getXC() + ", " + a.getYC() + " c2: " + b.getXC() + ", " + b.getYC() + " slope: " + slope);
		return slope; 
	}
	
}
