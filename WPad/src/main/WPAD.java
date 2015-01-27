package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class wGUI extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1200);
		//Image background = ImageIO.read(getClass().getResource("Images/lotr.jpg"));
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension SIZE = new Dimension((int) (screenSize.width/2.5), screenSize.height/2);
		
		JScrollPane ScrollPanel = new JScrollPane();
		ScrollPanel.setBounds(screenSize.width/2-SIZE.width/2, screenSize.height/2-SIZE.height/2, SIZE.width, SIZE.height);
		ScrollPanel.setHorizontalScrollBar(null);
		ScrollPanel.setViewportBorder(null);
		ScrollPanel.getViewport().setOpaque(false);
		ScrollPanel.setBorder(null);
		ScrollPanel.setBackground(Color.RED);
		ScrollPanel.setOpaque(false);
		JScrollBar sb = ScrollPanel.getVerticalScrollBar();
		sb.setUI(new MyScrollbarUI());
		sb.setBounds(30, 0, 26, 226);
		sb.setPreferredSize(new Dimension(100, 0));
		ScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		ScrollPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		contentPane.add(ScrollPanel);
		
		//Image background = ImageIO.read(getClass().getResource("Images/panel.jpg"));
		
		Image panel = ImageIO.read(getClass().getResource("Images/panel.png"));
		JPanel WritePanel = new JPanel();
		WritePanel.setBackground(Color.WHITE);
		//WritePanel.setOpaque(false);
		WritePanel.setBorder(new EmptyBorder(20, 40, 20, 40));
		ScrollPanel.setViewportView(WritePanel);
		WritePanel.setLayout(new BorderLayout(0, 0));
		
		JTextArea writeArea = new JTextArea();
		writeArea.setFont(new Font("Monospaced", Font.PLAIN, 21));
		writeArea.setMargin( new Insets(30,30,30,10) );
		writeArea.setOpaque(false);
		writeArea.setWrapStyleWord(true);
		writeArea.setLineWrap(true);
		WritePanel.add(writeArea);
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
		
		//ScrollPanel.getVerticalScrollBar().setUnitIncrement(30);
		
		
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