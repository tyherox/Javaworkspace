package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class wGUI extends JFrame {

	private JLayeredPane contentPane;
	//Image background = ImageIO.read(getClass().getResource("Images/lotr.jpg"));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wGUI frame = new wGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public wGUI() throws IOException {
		
		//--- frame settings ---//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1200);
		setBackground(Color.WHITE);
		
		//--- screen variables ---//
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension SIZE = new Dimension((int) (screenSize.width/2.5), screenSize.height/2);
		
		//--- main panel ---//
		contentPane = new JLayeredPane();
		contentPane.setBackground(Color.PINK);
		contentPane.setBounds(0, 0, screenSize.width, screenSize.height);
		contentPane.setLayout(null);
		contentPane.setOpaque(false);
		setContentPane(contentPane);
		
		//--- window panel ---//
		JScrollPane window = new JScrollPane();
		window.setBounds(30, 0, screenSize.width-30, screenSize.height);
		window.setBackground(Color.YELLOW);
		window.setBorder(null);
		window.setHorizontalScrollBar(null);
		window.setViewportBorder(null);
		window.getViewport().setOpaque(false);
		window.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		window.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		window.setOpaque(false);
		contentPane.add(window,1,0);

		//--- scrollbar optimization ---//
		JScrollBar sb = window.getVerticalScrollBar();
		sb.setUI(new MyScrollbarUI());
		sb.setBounds(30, 0, 26, 226);
		sb.setPreferredSize(new Dimension(100, 0));
		sb.setUnitIncrement(30);
	
		//--- tool panel ---//
		JPanel toolBox = new JPanel();
		toolBox.setBackground(Color.PINK);
		toolBox.setBounds(screenSize.width-240, 100, 70, 564);
		toolBox.setFocusable(true);
		toolBox.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		toolBox.setOpaque(false);
		contentPane.add(toolBox,2,0);
		
		//--- tools ---//
		JButton btn1 = new JButton("1");
		toolBox.add(btn1);
		
		JButton btn2 = new JButton("2");
		toolBox.add(btn2);
		
		//--- writing area ---//
		JTextPane writeArea = new JTextPane();
		writeArea.setBackground(Color.BLACK);
		writeArea.setFont(new Font("Monospaced", Font.PLAIN, 21));
		writeArea.setMargin( new Insets(100,300,100,300) );
		writeArea.setPreferredSize(new Dimension(SIZE.width, SIZE.height));
		writeArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println(e.getKeyCode());
				if(e.getKeyCode()==27)
				{
					System.exit(0);
				}
			}
		});
		writeArea.setOpaque(false);
		window.setViewportView(writeArea);
		
		//// full screen mode code ////
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