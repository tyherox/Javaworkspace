package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JTextPane;
import javax.swing.JSeparator;

public class FileExplore extends JFrame {

	private int displaceY;
	private int displaceX;
	public JLayeredPane panel;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileExplore frame = new FileExplore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FileExplore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 58, 263, 314);
		scrollPane.setBorder(null);
		contentPane.add(scrollPane);
		
		panel = new JLayeredPane();
		panel.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
	
		Movable one = new Movable("one");
		one.setBounds(6, 10, 251, 40);
		panel.add(one,1);
		
		Movable two = new Movable("two");
		two.setBounds(6, 60, 251, 40);
		panel.add(two,2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 0, 251, 12);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 50, 251, 12);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 100, 251, 12);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 150, 251, 12);
		panel.add(separator_3);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(17, 6, 263, 41);
		contentPane.add(lblTitle);
		lblTitle.setBackground(Color.BLACK);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setOpaque(true);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
	}
	public class Movable extends JPanel{
		JLabel tag;
		public Movable(String name) {
			final JPanel test = this;
			setLayout(new BorderLayout(0, 0));
			addMouseListener(new MouseAdapter() {
	            @Override
	            public void mousePressed(MouseEvent e) {
	            	displaceX = e.getX();
	                displaceY = e.getY();
	                panel.setLayer(test,2);
	            }
	            
	            public void mouseReleased(MouseEvent e) {
	            	int rx = getX();
	            	//rx = (rx + 40) / 50 * 50;
	            	
	            	int ry = getY();
	            	double k = (ry + 40) / 50;
	            	double l = k-1;
	            	k = Math.round(k);
	            	if(k<0)k=0;
	            	if(Math.abs(k*50-ry)<Math.abs(l*50-ry)){
	            		ry = (int) (k * 50);
	            	}
	            	else
	            	{
	            		ry = (int) l*50;
	            	}
	            	if(ry<0)ry=0;
	            	panel.setLayer(test,1);
	            	setLocation(rx,ry+10);
	            }

	        });
			addMouseMotionListener(new MouseMotionAdapter() {

	            public void mouseDragged(MouseEvent evt) {
	                evt.translatePoint(evt.getComponent().getLocation().x, evt.getComponent().getLocation().y);
	                if(evt.getY()-displaceY+40<=panel.getHeight()&&evt.getY()-displaceY>0)
	                {
	                	setLocation(getX(), evt.getY()-displaceY);
	                }
	            }
	        });
			
			tag = new JLabel(name);
			tag.setHorizontalAlignment(SwingConstants.CENTER);
			add(tag);
		}
	}
}