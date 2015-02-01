import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;

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
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 62, 588, 410);
		contentPane.add(scrollPane);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		textField = new JTextField();
		textField.setBounds(6, 6, 287, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    warn();
			  }
			  public void removeUpdate(DocumentEvent e) {
			    warn();
			  }
			  public void insertUpdate(DocumentEvent e) {
			    warn();
			  }

			  public void warn() {
			    if(textField.getText().equals(""))
			    {
			    	System.out.println("empty");
			    	textPane.setText("");
			    }
			    else
			    {
			    	System.out.println("typing");
			    	textPane.setText(Mainframe.find(textField.getText()));
			    }
			  }
			});
		
		JLabel wordCount = new JLabel("Total Words: ");
		wordCount.setBounds(340, 6, 212, 16);
		contentPane.add(wordCount);
		
		JLabel timeCount = new JLabel("Time:");
		timeCount.setBounds(340, 34, 212, 16);
		contentPane.add(timeCount);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(291, 22, 303, 16);
		contentPane.add(separator);
		
		try {
			wordCount.setText("Total Words: " + Mainframe.intialize());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}