import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import com.jgoodies.forms.layout.Sizes;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;


public class Main_GUI extends JFrame {

	private JPanel gameWindow;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_GUI frame = new Main_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("100dlu", false), Sizes.constant("200dlu", false)), 0),}));
		
		final Map gameMap= new Map(5000);
		gameMap.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				
				int notches = e.getWheelRotation();
		        if (notches < 0) {
		            System.out.println("zoom in)");
					gameMap.zoom("in");
		        } else {
		            System.out.println("zoom out");
					gameMap.zoom("out");
		        }
				
			}
		});
		gameMap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println(e.getKeyCode());
				if(e.getKeyCode()==27)
				{
					System.exit(0);
				}
				if(e.getKeyCode()==90)
				{
					System.out.println("zoom in");
					gameMap.zoom("in");
				}
				if(e.getKeyCode()==88)
				{
					System.out.println("zoom out");
					gameMap.zoom("out");
				}
			}
		});
		gameMap.setBackground(Color.PINK);
		gameMap.setBounds(100, 100, 1000, 1000);
		gameMap.setFocusable(true);
		gameMap.requestFocusInWindow();
		
		JScrollPane gameView = new JScrollPane(gameMap);
		gameView.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println(e.getX() + ", " + e.getY());
			}
		});
		gameBoard.add(gameView, "2, 2, fill, fill");
		gameView.setViewportView(gameMap);
		gameMap.setLayout(null);
		
		
		gameView.getVerticalScrollBar().setUnitIncrement(50);
		gameView.getHorizontalScrollBar().setUnitIncrement(50);
		gameView.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		gameView.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		
		JPanel gameGUI = new JPanel();
		gameGUI.setBackground(Color.LIGHT_GRAY);
		gameBoard.add(gameGUI, "1, 4, 3, 1, fill, fill");
		
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    	
    	if (gd.isFullScreenSupported()) {
            setUndecorated(true);
            gd.setFullScreenWindow(this);
        } else {
            System.err.println("Full screen not supported");
            setSize(100, 100); // just something to let you see the window
            setVisible(true);
        }
		
		
		
	}

}
