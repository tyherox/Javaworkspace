package Main;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GUI extends JFrame {

	private volatile int draggedAtX, draggedAtY;
	private JPanel contentPane;
	ArrayList<JButton> components = new ArrayList<JButton>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DragableC one = new DragableC("1");
		DragableC two = new DragableC("2");
		DragableC three = new DragableC("3");
		contentPane.add(one);
		contentPane.add(two);
		contentPane.add(three);
		components.add(one);
		components.add(two);
		components.add(three);
		
		JButton btnNewButton = new JButton("Organize");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i<components.size(); i++)
				{
					JButton test = components.get(i);
					int x = test.getLocation().x;	
					int y = test.getLocation().y;	
					
					components.get(i).setLocation((((x + 99) / 100 ) * 50), (((y + 99) / 100 ) * 50));
				}
				
			}
		});
		btnNewButton.setBounds(327, 243, 117, 29);
		contentPane.add(btnNewButton);
	}
}
