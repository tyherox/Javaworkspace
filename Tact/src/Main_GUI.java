import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Main_GUI extends JFrame {

	private JPanel gameWindow;
	
	public static final Color CITY = new Color(214,217,223);
    public static final Color DESERT = new Color(255,204,102);
    public static final Color DIRT_ROAD = new Color(153,102,0);
    public static final Color FOREST = new Color(0,102,0);
    public static final Color HILLS = new Color(51,153,0);
    public static final Color LAKE = new Color(0,153,153);
    public static final Color MOUNTAINS = new Color(102,102,255);
    public static final Color OCEAN = new Color(0,0,153);
    public static final Color PAVED_ROAD = new Color(51,51,0);
    public static final Color PLAINS = new Color(102,153,0);
    
    public static final int NUM_ROWS = 25;
    public static final int NUM_COLS = 30;
    
    public static final int PREFERRED_GRID_SIZE_PIXELS = 10;

    public static final Color[] TERRAIN = {
        CITY,
        DESERT,
        DIRT_ROAD,
        FOREST,
        HILLS,
        LAKE,
        MOUNTAINS,
        OCEAN,
        PAVED_ROAD,
        PLAINS
    };
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_GUI frame = new Main_GUI();
					frame.setVisible(true);
					Terrain();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static void Terrain()
	{
	
	}
	
	Main_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		gameWindow = new JPanel();
		gameWindow.setBackground(Color.GRAY);
		gameWindow.setBorder(null);
		setContentPane(gameWindow);
		gameWindow.setLayout(new BorderLayout(0, 0));
		
		JPanel gameBoard = new JPanel();
		gameWindow.add(gameBoard, BorderLayout.CENTER);
		gameBoard.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow(3)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		Map gameMap= new Map();
		gameMap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if(e.getKeyCode()==50)
				{
					
				}
			}
		});
		gameMap.setBackground(Color.PINK);
		gameMap.setBounds(100, 100, 1000, 1000);
		//gameMap.setPreferredSize(new Dimension(1000,1000));
		gameMap.setFocusable(true);
		gameMap.requestFocusInWindow();
		
		JScrollPane gameView = new JScrollPane(gameMap);
		gameBoard.add(gameView, "2, 2, fill, fill");
		gameView.setViewportView(gameMap);
		gameMap.setLayout(null);
		
		
		gameView.getVerticalScrollBar().setUnitIncrement(50);
		gameView.getHorizontalScrollBar().setUnitIncrement(50);
		//gameView.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		//gameView.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		
		JPanel gameGUI = new JPanel();
		gameGUI.setBackground(Color.LIGHT_GRAY);
		gameBoard.add(gameGUI, "1, 4, 3, 1, fill, fill");
	}

}
