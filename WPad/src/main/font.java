package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class font extends JFrame {

	private JPanel contentPane;
	private JEditorPane editorPane;
	
	Font fontText;
	Font fontA;
	Font fontB;
	
	float currentSize = 0;

	float small = 15;
	float medium = 20;
	float large = 25;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					font frame = new font();
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
	public font() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 479);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 242, 445);
		contentPane.add(scrollPane);
		fontA = new Font("Lucida Grande", Font.PLAIN, (int)medium);
		fontB = new Font("Kokonor", Font.PLAIN, (int)medium);
		currentSize=medium;
		editorPane = new JEditorPane();
		fontText = fontA;
		editorPane.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		editorPane.setText(" ");
		scrollPane.setViewportView(editorPane);
		
		JButton btnNewButton = new JButton("font 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font font = fontA.deriveFont(currentSize);
				editorPane.setFont(font);
				fontText = fontA;
			}
		});
		
		btnNewButton.setBounds(260, 6, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("font 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font font = fontB.deriveFont(currentSize);
				editorPane.setFont(font);
				fontText = fontB;
			}
		});
		btnNewButton_1.setBounds(260, 47, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnSize = new JButton("size 1");
		btnSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Font sizeA = fontText.deriveFont(small);	
				editorPane.setFont(sizeA);
				currentSize=small;
			}
		});
		btnSize.setBounds(400, 6, 117, 29);
		contentPane.add(btnSize);
		
		JButton btnSize_1 = new JButton("size 2");
		btnSize_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font sizeB = fontText.deriveFont(medium);	
				editorPane.setFont(sizeB);
				currentSize=medium;
			}
		});
		btnSize_1.setBounds(400, 47, 117, 29);
		contentPane.add(btnSize_1);
		
		JButton btnSize_2 = new JButton("size 3");
		btnSize_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font sizeC = fontText.deriveFont(large);	
				editorPane.setFont(sizeC);
				currentSize=large;
			}
		});
		btnSize_2.setBounds(400, 88, 117, 29);
		contentPane.add(btnSize_2);
	}
}
