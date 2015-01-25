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
		setBounds(100, 100, 550, 600);
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
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		final JBoardT p1 = new JBoardT();
		contentPane.add(p1, "2, 2, fill, fill");
		
		final JBoardT p2 = new JBoardT();
		contentPane.add(p2, "4, 2, fill, fill");
		
		final JBoardT p3 = new JBoardT();
		contentPane.add(p3, "6, 2, fill, fill");
		
		final JBoardT p4 = new JBoardT();
		contentPane.add(p4, "8, 2, fill, fill");
		
		final JBoardT p5 = new JBoardT();
		contentPane.add(p5, "10, 2, fill, fill");
		
		final JBoardT p6 = new JBoardT();
		contentPane.add(p6, "12, 2, fill, fill");
		
		final JBoardT p7 = new JBoardT();
		contentPane.add(p7, "14, 2, fill, fill");
		
		final JBoardT p8 = new JBoardT();
		contentPane.add(p8, "2, 4, fill, fill");
		
		final JBoardT p9 = new JBoardT();
		contentPane.add(p9, "4, 4, fill, fill");
		
		final JBoardT p10 = new JBoardT();
		contentPane.add(p10, "6, 4, fill, fill");
		
		final JBoardT p11 = new JBoardT();
		contentPane.add(p11, "8, 4, fill, fill");
		
		final JBoardT p12 = new JBoardT();
		contentPane.add(p12, "10, 4, fill, fill");
		
		final JBoardT p13 = new JBoardT();
		contentPane.add(p13, "12, 4, fill, fill");
		
		final JBoardT p14 = new JBoardT();
		contentPane.add(p14, "14, 4, fill, fill");
		
		final JBoardT p15 = new JBoardT();
		contentPane.add(p15, "2, 6, fill, fill");
		
		final JBoardT p16 = new JBoardT();
		contentPane.add(p16, "4, 6, fill, fill");
		
		final JBoardT p17 = new JBoardT();
		contentPane.add(p17, "6, 6, fill, fill");
		
		final JBoardT p18 = new JBoardT();
		contentPane.add(p18, "8, 6, fill, fill");
		
		final JBoardT p19 = new JBoardT();
		contentPane.add(p19, "10, 6, fill, fill");
		
		final JBoardT p20 = new JBoardT();
		contentPane.add(p20, "12, 6, fill, fill");
		
		final JBoardT p21 = new JBoardT();
		contentPane.add(p21, "14, 6, fill, fill");
		
		final JBoardT p22 = new JBoardT();
		contentPane.add(p22, "2, 8, fill, fill");
		
		final JBoardT p23 = new JBoardT();
		contentPane.add(p23, "4, 8, fill, fill");
		
		final JBoardT p24 = new JBoardT();
		contentPane.add(p24, "6, 8, fill, fill");
		
		final JBoardT p25 = new JBoardT();
		contentPane.add(p25, "8, 8, fill, fill");
		
		final JBoardT p26 = new JBoardT();
		contentPane.add(p26, "10, 8, fill, fill");
		
		final JBoardT p27 = new JBoardT();
		contentPane.add(p27, "12, 8, fill, fill");
		
		final JBoardT p28 = new JBoardT();
		contentPane.add(p28, "14, 8, fill, fill");
		
		final JBoardT p29 = new JBoardT();
		contentPane.add(p29, "2, 10, fill, fill");
		
		final JBoardT p30 = new JBoardT();
		contentPane.add(p30, "4, 10, fill, fill");
		
		final JBoardT p31 = new JBoardT();
		contentPane.add(p31, "6, 10, fill, fill");
		
		final JBoardT p32 = new JBoardT();
		contentPane.add(p32, "8, 10, fill, fill");
		
		final JBoardT p33 = new JBoardT();
		contentPane.add(p33, "10, 10, fill, fill");
		
		final JBoardT p34 = new JBoardT();
		contentPane.add(p34, "12, 10, fill, fill");
		
		final JBoardT p35 = new JBoardT();
		contentPane.add(p35, "14, 10, fill, fill");
		
		final JBoardT p36 = new JBoardT();
		contentPane.add(p36, "2, 12, fill, fill");
		
		final JBoardT p37 = new JBoardT();
		contentPane.add(p37, "4, 12, fill, fill");
		
		final JBoardT p38 = new JBoardT();
		contentPane.add(p38, "6, 12, fill, fill");
		
		final JBoardT p39 = new JBoardT();
		contentPane.add(p39, "8, 12, fill, fill");
		
		final JBoardT p40 = new JBoardT();
		contentPane.add(p40, "10, 12, fill, fill");
		
		final JBoardT p41 = new JBoardT();
		contentPane.add(p41, "12, 12, fill, fill");
		
		final JBoardT p42 = new JBoardT();
		contentPane.add(p42, "14, 12, fill, fill");
		
		board.add(p1);
		board.add(p2);
		board.add(p3);
		board.add(p4);
		board.add(p5);
		board.add(p6);
		board.add(p7);
		board.add(p8);
		board.add(p9);
		board.add(p10);
		board.add(p11);
		board.add(p12);
		board.add(p13);
		board.add(p14);
		board.add(p15);
		board.add(p16);
		board.add(p17);
		board.add(p18);
		board.add(p19);
		board.add(p20);
		board.add(p21);
		board.add(p22);
		board.add(p23);
		board.add(p24);
		board.add(p25);
		board.add(p26);
		board.add(p27);
		board.add(p28);
		board.add(p29);
		board.add(p30);
		board.add(p31);
		board.add(p32);
		board.add(p33);
		board.add(p34);
		board.add(p35);
		board.add(p36);
		board.add(p37);
		board.add(p38);
		board.add(p39);
		board.add(p40);
		board.add(p41);
		board.add(p42);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, "1, 14, 15, 1, fill, fill");
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnResetButton = new JButton("Reset");
		panel.add(btnResetButton, BorderLayout.CENTER);
		btnResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1.reset();
				p2.reset();
				p3.reset();
				p8.reset();
				p9.reset();
				p10.reset();
				p15.reset();
				p16.reset();
				p17.reset();
				
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
		
		//aiMove(null);
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
		
		if(pBoard.size()>=5)
		{
			MainFrame.victory(pBoard);
		}
		ai.startMove(board);
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
