package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class Wpad extends JFrame {

	private JPanel contentPane;
	private JPanel toolBox;
	private JTextPane writeArea;
	private CustomScroll scrollbar;
	private JScrollBar sb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wpad frame = new Wpad();
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
	public Wpad() throws IOException {
		//--- frame settings ---//
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 1920, 1200);
				setBackground(Color.WHITE);
				
				//--- screen variables ---//
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				Dimension SIZE = new Dimension((int) (screenSize.width/2), (int) (screenSize.height/1.5));
				
				//--- main panel ---//
				contentPane = new JPanel();
				contentPane.setBackground(Color.PINK);
				contentPane.setBounds(0, 0, screenSize.width, screenSize.height);
				contentPane.setLayout(null);
				contentPane.setOpaque(false);
				setContentPane(contentPane);
				
				//--- window panel ---//
				JScrollPane window = new JScrollPane();
				window.setBounds((screenSize.width/2)-(SIZE.width/2), (screenSize.height/2)-(SIZE.height/2), SIZE.width, SIZE.height);
				window.setBackground(Color.YELLOW);
				window.setBorder(null);
				window.setHorizontalScrollBar(null);
				window.setViewportBorder(null);
				window.getViewport().setOpaque(false);
				window.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				window.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				window.setOpaque(false);
				contentPane.add(window);
				
			
				//--- tool panel ---//
				toolBox = new JPanel();
				toolBox.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						System.out.println("entered");
						toolBox.setOpaque(true); 
						writeArea.setOpaque(true);
						revalidate();
						repaint();
					}
					@Override
					public void mouseExited(MouseEvent e) {
						System.out.println("exited");
						toolBox.setOpaque(false);
						writeArea.setOpaque(false);
						revalidate();
						repaint();
					}
				});
				toolBox.setBackground(Color.GRAY);
				toolBox.setBounds((int) ((screenSize.width/2)+(SIZE.width/2)), (screenSize.height/2)-(SIZE.height/2), 70, 564);
				toolBox.setFocusable(true);
				toolBox.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				toolBox.setOpaque(false);
				contentPane.add(toolBox);
				
				//--- tools ---//
				JButton btn1 = new JButton("1");
				toolBox.add(btn1);
				
				JButton btn2 = new JButton("2");
				toolBox.add(btn2);
				
				//--- writing area ---//
				writeArea = new JTextPane();
				writeArea.setBackground(Color.LIGHT_GRAY);
				writeArea.setFont(new Font("Monospaced", Font.PLAIN, 21));
				writeArea.setMargin( new Insets(50,100,50,100) );
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
				
				//--- scrollbar implementation ---//
				scrollbar = new CustomScroll(screenSize.width/20,screenSize.height+10);
				scrollbar.setBounds(0, 0, screenSize.width/20, screenSize.height+10);
				scrollbar.setBackground(Color.WHITE);
				contentPane.add(scrollbar);
				
				//--- scrollbar optimization ---//
				sb = window.getVerticalScrollBar();
				sb.addAdjustmentListener( new AdjustmentListener(){
					@Override
					public void adjustmentValueChanged(AdjustmentEvent e) {
						System.out.println(" ");
						System.out.println("e: " + e.getValue());
						System.out.println("writeArea height: " + writeArea.getHeight());
						if(writeArea.getHeight()!=0)
						{
							scrollbar.updateGraphic((double)e.getValue()/(double)(writeArea.getHeight()),800.000/writeArea.getHeight());
						}
					}
				});
				sb.setPreferredSize(new Dimension(0, 0));
				sb.setUnitIncrement(30);
				
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


